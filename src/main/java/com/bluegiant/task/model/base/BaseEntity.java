package com.bluegiant.task.model.base;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@Audited
public abstract class BaseEntity {

    @CreatedBy
    @Column(name = "save_user_id")
    private Long saveUserId;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "save_time")
    private Date saveTime;

    @LastModifiedBy
    @Column(name = "update_user_id")
    private Long updateUserId;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

    public abstract Object getId();

    public Long getSaveUserId() {
        return saveUserId;
    }

    public void setSaveUserId(Long saveUserId) {
        this.saveUserId = saveUserId;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
