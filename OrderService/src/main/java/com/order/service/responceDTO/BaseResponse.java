package com.order.service.responceDTO;


import lombok.Data;

@Data
public class BaseResponse {
//    private Integer status;
    private Object data;
    private Result result;


    public void setMessage(String orderCreatedSuccessfully) {
    }
}
