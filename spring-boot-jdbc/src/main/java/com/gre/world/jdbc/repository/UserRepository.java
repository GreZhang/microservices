package com.gre.world.jdbc.repository;

import com.gre.world.jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * @author 风骚的GRE
 * @Descriptions User Repository ${@link User}
 * @date 2018/8/19.
 */
@Repository
public class UserRepository {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager platformTransactionManager;

    @Autowired
    public UserRepository(DataSource dataSource, JdbcTemplate jdbcTemplate, PlatformTransactionManager platformTransactionManager) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.platformTransactionManager = platformTransactionManager;
    }

    public boolean jdbcSave(User user) {
        boolean success = false;
        System.out.printf("[Thread : %s ] save user :%s\n",
                Thread.currentThread().getName(), user);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            // 设置手动提交,默认是自动提交模式
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO user(name) VALUES (?) ");
            preparedStatement.setString(1, user.getName());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    /**
     * 使用Annotation方式来管理事务，该方式使用Spring AOP的方式来处理，在进行方法调用前，开启事务，设置保护点，获取连接
     * 当方法调用完成后，再去调用Connection.commit()去提交事务。ccccc
     * @param user
     * @return
     */
    @Transactional
    public boolean transactionalSave(User user){
        boolean success = false;
        success = jdbcTemplate.execute("INSERT INTO user(name) VALUES (?) ", new PreparedStatementCallback<Boolean>() {
            @Nullable
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, user.getName());
                return preparedStatement.executeUpdate()>0;
            }
        });
        return success;
    }
    // 使用API的方式来管理事务
    public boolean save(User user) {
        boolean success = false;
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        // 开始事务
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);

        success = jdbcTemplate.execute("INSERT INTO user(name) VALUES (?)", new PreparedStatementCallback<Boolean>() {
            @Nullable
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, user.getName());
                return preparedStatement.executeUpdate() > 0;
            }
        });
        platformTransactionManager.commit(transactionStatus);
        return success;
    }

    public Collection<User> findAll() {
        Collection<User> users = new ArrayList<>();
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList("SELECT id,name FROM user");
        for (Map<String, Object> resultMap : resultList) {
            User user = new User();
            for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if ("id".equals(key)) {
                    user.setId(Integer.valueOf(value.toString()));
                    continue;
                }
                if ("name".equals(key)) {
                    user.setName(value.toString());
                    continue;
                }
            }
            users.add(user);
        }
        return users;
    }


}
