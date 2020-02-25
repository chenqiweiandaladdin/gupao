package com.gupaoedu.vip.pattern.factory.factory;

import com.gupaoedu.vip.pattern.factory.pay.Pay;
import com.gupaoedu.vip.pattern.factory.pay.UniontPay;

/**
 * Created by vason.
 */
public class UnionPayFactory implements IPayFactory {
    
    public Pay createFactory() {
        return new UniontPay();
    }
}
