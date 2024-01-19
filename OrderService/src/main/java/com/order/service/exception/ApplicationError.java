package com.order.service.exception;

import com.order.service.globalException.GlobalApplicationError;

public class ApplicationError implements GlobalApplicationError {
    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getReason() {
        return null;
    }

    @Override
    public int getCodeByReason(String reason) {
        for (com.order.service.enums.ApplicationError status : com.order.service.enums.ApplicationError
                .values()) {
            if (status.getReason().equals(reason)) {
                return status.getCode();
            }
        }
        return 0;
    }

    @Override
    public String getCodeString() {
        return null;
    }

    @Override
    public GlobalApplicationError resolve(int statusCode) {
        for (com.order.service.enums.ApplicationError status : com.order.service.enums.ApplicationError
                .values()) {
            if (status.getCode() == statusCode) {
                return status;
            }
        }
        return null;
    }

    @Override
    public GlobalApplicationError getApplicationErrorByReason(String reason) {
        for (com.order.service.enums.ApplicationError status : com.order.service.enums.ApplicationError
                .values()) {
            if (status.getReason().equals(reason)) {
                return status;
            }
        }
        return null;
    }
}
