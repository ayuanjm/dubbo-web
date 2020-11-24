package com.sunyur;

import com.sunyur.common.pagination.ModelResult;
import com.sunyur.purchaser.model.PurchaseApplyClassModel;
import com.sunyur.purchaser.service.PurchaseApplyClassQueryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoWebStartApplicationTests {

    @Autowired
    private ApplicationContext ioc;

    @Test
    void contextLoads() {
        PurchaseApplyClassQueryService o = ioc.getBean(PurchaseApplyClassQueryService.class);
        PurchaseApplyClassModel purchaseApplyClassModel = new PurchaseApplyClassModel();
        purchaseApplyClassModel.setId(20L);
        ModelResult<PurchaseApplyClassModel> byParam = o.getByParam(purchaseApplyClassModel);
        System.out.println(byParam.getContent().toString());
    }

}
