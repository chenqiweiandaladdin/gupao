package design.adapter.demo.passport.adapterv2.adapters;


import design.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForTelAdapter extends AbstraceAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    public ResultMsg login(Object[] obs,Object adapter) {
        if(obs == null || obs.length<2){ return  null ;}
        return super.loginForRegist( obs[0].toString(), obs[1].toString()
        );
    }

}
