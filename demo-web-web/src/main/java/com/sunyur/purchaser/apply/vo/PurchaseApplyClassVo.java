package com.sunyur.purchaser.apply.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright(c) 2018 Sunyur.com, All Rights Reserved.
 * Project: sy
 * Author: yuanjiamin
 * CreateDate: 2020/11/24 2:54 下午
 * Description:
 */
public class PurchaseApplyClassVo implements Serializable {
    private static final long serialVersionUID = -6942149323887985711L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 公司主体
     */
    private Long purchaseComanyId;
    /**
     * 公司主体名称
     */
    private String purchaseCompanyName;
    /**
     * 公司主体code
     */
    private String purchaseCompanyCode;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseComanyId() {
        return purchaseComanyId;
    }

    public void setPurchaseComanyId(Long purchaseComanyId) {
        this.purchaseComanyId = purchaseComanyId;
    }

    public String getPurchaseCompanyName() {
        return purchaseCompanyName;
    }

    public void setPurchaseCompanyName(String purchaseCompanyName) {
        this.purchaseCompanyName = purchaseCompanyName;
    }

    public String getPurchaseCompanyCode() {
        return purchaseCompanyCode;
    }

    public void setPurchaseCompanyCode(String purchaseCompanyCode) {
        this.purchaseCompanyCode = purchaseCompanyCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PurchaseApplyClassParam{" +
                "id=" + id +
                ", purchaseComanyId=" + purchaseComanyId +
                ", purchaseCompanyName='" + purchaseCompanyName + '\'' +
                ", purchaseCompanyCode='" + purchaseCompanyCode + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
