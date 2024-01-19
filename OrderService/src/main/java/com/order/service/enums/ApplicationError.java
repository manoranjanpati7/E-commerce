package com.order.service.enums;

import com.order.service.constant.CommonValidationConstant;
import com.order.service.globalException.GlobalApplicationError;
import org.springframework.lang.Nullable;

public enum   ApplicationError implements GlobalApplicationError {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    INVALID_ORDER_ID(100002, CommonValidationConstant.INVALID_ORDER_ID),
    INVALID_CUSTOMER_ID(100003, CommonValidationConstant.INVALID_CUSTOMER_ID),
    EXITING_ORDER_ID(100004, CommonValidationConstant.EXITING_ORDER_ID);

    private final int code;
    private final String reason;

    ApplicationError(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    public int getCodeByReason(String reason) {
        for (ApplicationError status : values()) {
            if (status.reason.equals(reason)) {
                return status.code;
            }
        }
        return 0;
    }

    public ApplicationError getApplicationErrorByReason(String reason) {
        for (ApplicationError status : values()) {
            if (status.reason.equals(reason)) {
                return status;
            }
        }
        return null;
    }

    public String getCodeString() {
        return String.valueOf(code);
    }

    @Nullable
    public ApplicationError resolve(int statusCode) {
        for (ApplicationError status : values()) {
            if (status.code == statusCode) {
                return status;
            }
        }
        return null;
    }

    }
