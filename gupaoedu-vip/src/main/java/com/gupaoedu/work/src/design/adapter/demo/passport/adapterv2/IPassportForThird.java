package design.adapter.demo.passport.adapterv2;


import design.adapter.demo.passport.ResultMsg;
import design.adapter.demo.passport.adapterv2.adapters.ILoginAdapter;

/**
 * Created by Tom.
 */
public interface IPassportForThird {
//
//    ResultMsg loginForQQ(String openId);
//
//    ResultMsg loginForWechat(String openId);
//
//    ResultMsg loginForToken(String token);
//
//    ResultMsg loginForTelphone(String phone, String code);

    ResultMsg processLogin(Object[] obs,Class<? extends ILoginAdapter> clazz);

}
