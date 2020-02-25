package com.gupaoedu.vip.pattern.factory.factory;

import com.gupaoedu.vip.pattern.factory.pay.AbroadPay;
import com.gupaoedu.vip.pattern.factory.pay.Pay;

/**
 * Created by vason.
 */
public class AbroadPayFactory implements IPayFactory {
    
    public Pay createFactory() {
        return new AbroadPay();
    }
}
