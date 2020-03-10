package design.adapter.demo.passport.adapterv2;


import design.adapter.demo.passport.ResultMsg;
import design.adapter.demo.passport.adapterv2.adapters.*;

/**
 * Created by Tom.
 */
public class PassportForThirdAdapter implements IPassportForThird {

//    public ResultMsg loginForQQ(String openId) {
//        return processLogin(openId, LoginForQQAdapter.class);
//    }
//
//    public ResultMsg loginForWechat(String openId) {
//
//        return processLogin(openId, LoginForWechatAdapter.class);
//
//    }
//
//    public ResultMsg loginForToken(String token) {
//
//        return processLogin(token, LoginForTokenAdapter.class);
//    }
//
//    public ResultMsg loginForTelphone(String phone, String code) {
//        return processLogin(phone, LoginForTelAdapter.class);
//    }


    public ResultMsg processLogin(Object[] obs,Class<? extends ILoginAdapter> clazz){
        try {
            ILoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)){
                return  adapter.login(obs,adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
