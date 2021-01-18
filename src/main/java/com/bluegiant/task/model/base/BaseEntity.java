package com.bluegiant.task.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "save_user_id")
    private Long saveUserId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "save_time")
    private Date saveTime;

    @Column(name = "update_user_id")
    private Long updateUserId;

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
