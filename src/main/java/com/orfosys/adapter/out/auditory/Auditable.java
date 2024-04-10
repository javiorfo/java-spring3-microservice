package com.orfosys.adapter.out.auditory;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Auditable {
    @CreatedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @Column(nullable = false, updatable = false, name = "create_date")
    protected LocalDateTime createDate;
    
    @LastModifiedDate
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    @Column(insertable = false, name = "last_modified")
    protected LocalDateTime lastModified;

    @CreatedBy
    @Column(nullable = false, updatable = false, name = "created_by")
    protected String createdBy;

    @LastModifiedBy
    @Column(insertable = false, name = "last_modified_by")
    protected String lastModifiedBy;
}
