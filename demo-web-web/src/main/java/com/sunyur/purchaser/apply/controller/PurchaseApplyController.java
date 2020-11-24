package com.sunyur.purchaser.apply.controller;

import com.alibaba.fastjson.JSON;
import com.sunyur.common.pagination.ModelResult;
import com.sunyur.common.utils.ObjectUtil;
import com.sunyur.purchaser.apply.param.PurchaseApplyClassParam;
import com.sunyur.purchaser.apply.vo.PurchaseApplyClassVo;
import com.sunyur.purchaser.model.PurchaseApplyClassModel;
import com.sunyur.purchaser.service.PurchaseApplyClassQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Copyright(c) 2018 Sunyur.com, All Rights Reserved.
 * Project: sy
 * Author: yuanjiamin
 * CreateDate: 2020/11/23 8:58 下午
 */
@RestController
@RequestMapping("/purchaseApply")
public class PurchaseApplyController {

    private final static Logger LOGGER_INFO = LoggerFactory.getLogger(PurchaseApplyController.class);
    private final static Logger LOGGER_ERROR = LoggerFactory.getLogger(PurchaseApplyController.class);

    @Resource
    private PurchaseApplyClassQueryService purchaseApplyClassQueryService;

    /**
     * @param purchaseApplyClassParam:
     * @return
     * @Description: 采购申请查询-单条
     * @author yuanjiamin
     * @date 2020/11/23 7:53 下午
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ModelResult<PurchaseApplyClassVo> query(PurchaseApplyClassParam purchaseApplyClassParam) {
        LOGGER_INFO.info("PurchaseApplyController.query param {}", JSON.toJSONString(purchaseApplyClassParam));
        ModelResult<PurchaseApplyClassVo> result = new ModelResult<>();
        // 校验参数
        if (ObjectUtil.isNull(purchaseApplyClassParam.getId()) || purchaseApplyClassParam.getId() <= 0) {
            result.setErrorMessage("param.isnull", "param.isnull or invalid");
            return result;
        }
        try {
            PurchaseApplyClassModel purchaseApplyClassModel = new PurchaseApplyClassModel();
            //Pa->Mo
            BeanUtils.copyProperties(purchaseApplyClassParam, purchaseApplyClassModel);
            ModelResult<PurchaseApplyClassModel> getResult = purchaseApplyClassQueryService.getByParam(purchaseApplyClassModel);
            if (!getResult.isSuccess()) {
                result.setErrorMessage(getResult.getCode(), getResult.getErrorMessage());
                return result;
            }
            PurchaseApplyClassVo purchaseApplyClassVo = new PurchaseApplyClassVo();
            //Mo-Vo
            BeanUtils.copyProperties(getResult.getContent(), purchaseApplyClassVo);
            result.setContent(purchaseApplyClassVo);
        } catch (Exception e) {
            LOGGER_ERROR.error("PurchaseApplyController.query param:{},err:{}", JSON.toJSONString(purchaseApplyClassParam), e.getMessage());
            result.setErrorMessage("system.exception", e.getMessage());
        }
        return result;
    }

    /**
     * @param purchaseApplyClassParam:
     * @return
     * @Description: 采购申请新增-单条
     * @author yuanjiamin
     * @date 2020/11/23 7:53 下午
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelResult<Boolean> add(@RequestBody PurchaseApplyClassParam purchaseApplyClassParam) {
        LOGGER_INFO.info("PurchaseApplyController.add param {}", JSON.toJSONString(purchaseApplyClassParam));
        ModelResult<Boolean> result = new ModelResult<>();
        try {
            PurchaseApplyClassModel purchaseApplyClassModel = new PurchaseApplyClassModel();
            //Pa->Mo
            BeanUtils.copyProperties(purchaseApplyClassParam, purchaseApplyClassModel);
            ModelResult<Boolean> getResult = purchaseApplyClassQueryService.add(purchaseApplyClassModel);
            if (!getResult.isSuccess()) {
                result.setErrorMessage(getResult.getCode(), getResult.getErrorMessage());
                return result;
            }
            result.setContent(getResult.getContent());
        } catch (Exception e) {
            LOGGER_ERROR.error("PurchaseApplyController.add param:{},err:{}", JSON.toJSONString(purchaseApplyClassParam), e.getMessage());
            result.setErrorMessage("system.exception", e.getMessage());
        }
        return result;
    }

    /**
     * @param purchaseApplyClassParam:
     * @return
     * @Description: 采购申请删除-单条
     * @author yuanjiamin
     * @date 2020/11/23 7:53 下午
     */
    @RequestMapping(value = "/deleteByName", method = RequestMethod.POST)
    public ModelResult<Boolean> delete(@RequestBody PurchaseApplyClassParam purchaseApplyClassParam) {
        LOGGER_INFO.info("PurchaseApplyController.delete param {}", JSON.toJSONString(purchaseApplyClassParam));
        ModelResult<Boolean> result = new ModelResult<>();
        try {
            PurchaseApplyClassModel purchaseApplyClassModel = new PurchaseApplyClassModel();
            //Pa->Mo
            BeanUtils.copyProperties(purchaseApplyClassParam, purchaseApplyClassModel);
            ModelResult<Boolean> getResult = purchaseApplyClassQueryService.deleteByParam(purchaseApplyClassModel);
            if (!getResult.isSuccess()) {
                result.setErrorMessage(getResult.getCode(), getResult.getErrorMessage());
                return result;
            }
            result.setContent(getResult.getContent());
        } catch (Exception e) {
            LOGGER_ERROR.error("PurchaseApplyController.delete param:{},err:{}", JSON.toJSONString(purchaseApplyClassParam), e.getMessage());
            result.setErrorMessage("system.exception", e.getMessage());
        }
        return result;
    }
}
