package design.adapter.demo.passport.adapterv2.adapters;


import design.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForWechatAdapter extends AbstraceAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    public ResultMsg login(Object[] obs,Object adapter) {
        if(obs == null || obs.length<1){ return  null ;}
        return super.loginForRegist( obs[0].toString(), null
        );

    }


}
