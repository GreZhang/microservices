package com.gre.world.jpa.entity.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * @author 风骚的GRE
 * @Descriptions 图书监听
 * @date 2018/8/26.
 */
public class BookListener {
    private static final Logger LOG = LoggerFactory.getLogger(BookListener.class);

    @PrePersist
    public void prePersist(Object source){
        LOG.info("@PrePersist:{}",source);
    }

    @PostPersist
    public void postPersist(Object source){
        LOG.info("@PostPersist:{}",source);
    }

    @PreRemove
    public void preRemove(Object source){
        LOG.info("@PreRemove:{}",source);
    }

    @PreUpdate
    public void preUpdate(Object source){
        LOG.info("@PreUpdate:{}",source);
    }

    @PostUpdate
    public void postUpdate(Object source){
        LOG.info("@PostUpdate:{}",source);
    }

    @PostLoad
    public void postLoad(Object source){
        LOG.info("@PostLoad:{}",source);
    }
}
