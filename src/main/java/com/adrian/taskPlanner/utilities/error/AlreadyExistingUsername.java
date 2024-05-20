package com.adrian.taskPlanner.utilities.error;

public class AlreadyExistingUsername extends Error {
    public AlreadyExistingUsername() {
    }

    public AlreadyExistingUsername(String message) {
        super(message);
    }

    public AlreadyExistingUsername(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistingUsername(Throwable cause) {
        super(cause);
    }

    public AlreadyExistingUsername(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
