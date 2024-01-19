package com.order.service.dao;


import jakarta.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class AuditEntity {
    @CreatedDate
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "CreatedBy")
    private Long createdBy;

    @LastModifiedBy
    @Column(name = "UpdatedBy")
    private Long updatedBy;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now().plusMinutes(330);
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now().plusMinutes(330);
    }}
