package com.gupaoedu.vip.pattern.factory.factory;

import com.gupaoedu.vip.pattern.factory.pay.AliPay;
import com.gupaoedu.vip.pattern.factory.pay.Pay;


/**
 * Created by vason.
 */
public class AlipayPayFactory implements IPayFactory {

    public Pay createFactory() {
        return new AliPay();
    }
}
