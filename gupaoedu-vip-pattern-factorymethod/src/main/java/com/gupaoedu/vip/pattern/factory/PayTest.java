package com.gupaoedu.vip.pattern.factory;

import com.gupaoedu.vip.pattern.factory.factory.*;
import com.gupaoedu.vip.pattern.factory.pay.Pay;

/**
 * Created by vason.
 */
public class PayTest {

    public static void main(String[] args) {

        IPayFactory unionPayFactory = new UnionPayFactory();
        Pay unionPay = unionPayFactory.createFactory();
        unionPay.pay();

        IPayFactory aliPayFactory = new AlipayPayFactory();
        Pay aliPay = aliPayFactory.createFactory();
        aliPay.pay();

        IPayFactory wechatPayFactory = new WechatPayFactory();
        Pay wechatPay = wechatPayFactory.createFactory();
        wechatPay.pay();


        IPayFactory abroadPayFactory = new AbroadPayFactory();
        Pay abroadPay = abroadPayFactory.createFactory();
        abroadPay.pay();

    }

}
