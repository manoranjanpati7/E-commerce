package com.order.service.globalException;

public interface GlobalApplicationError {
    int getCode();

    String getReason();

    int getCodeByReason(String reason);

    String getCodeString();

    GlobalApplicationError resolve(int statusCode);

    GlobalApplicationError getApplicationErrorByReason(String reason);

}
