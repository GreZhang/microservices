package com.gre.world.jpa.exception;

/**
 * @author 风骚的GRE
 * @Descriptions 客户操作异常
 * @date 2018/8/26.
 */
public class CustomerException extends RuntimeException {
    private static final long serialVersionUID = 7410133594058212712L;

    public CustomerException(String message){
        super(message);
    }

    public CustomerException(Throwable cause){
        super(cause);
    }

    public CustomerException(String message, Throwable cause){
        super(message,cause);
    }
}
