package br.com.informatica.exception;

public class DAOException extends RuntimeException {

    private static final long serialVersionUID = -8827810940927570762L;

    public DAOException() {}

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) { super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(String message, Throwable cause,
                        boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
