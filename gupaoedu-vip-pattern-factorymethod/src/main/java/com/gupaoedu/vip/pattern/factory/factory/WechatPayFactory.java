package com.gupaoedu.vip.pattern.factory.factory;


import com.gupaoedu.vip.pattern.factory.pay.Pay;
import com.gupaoedu.vip.pattern.factory.pay.WechatPay;

/**
 * Created by vason.
 */
public class WechatPayFactory implements IPayFactory {

    public Pay createFactory() {
        return new WechatPay();
    }
}
