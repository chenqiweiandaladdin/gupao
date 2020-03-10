package design.adapter.demo.passport.adapterv2.adapters;


import design.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForQQAdapter extends AbstraceAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(Object[] obs,Object adapter) {
        if(!support(adapter)){return null;}
        //accesseToken
        //time
        if(obs == null || obs.length<1){ return  null ;}
        return super.loginForRegist( obs[0].toString(), null
        );

    }

}
