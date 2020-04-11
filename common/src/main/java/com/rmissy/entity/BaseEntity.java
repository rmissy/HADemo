package com.rmissy.entity;

import com.rmissy.utils.DateUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@Slf4j
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long createUserId;
    private String createTime;
    private Long updateUserId;
    private String updateTime = DateUtils.dateFormat(System.currentTimeMillis());

}