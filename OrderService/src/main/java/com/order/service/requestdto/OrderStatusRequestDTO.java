package com.order.service.requestdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusRequestDTO {
    private Long orderId;
    private String currentStatus;
    private String statusHistory;
    private boolean orderActive;
    private LocalDateTime timestamp;
}
