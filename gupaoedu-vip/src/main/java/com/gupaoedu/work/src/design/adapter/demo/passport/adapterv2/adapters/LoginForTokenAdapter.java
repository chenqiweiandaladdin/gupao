package design.adapter.demo.passport.adapterv2.adapters;


import design.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForTokenAdapter extends AbstraceAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    public ResultMsg login(Object[] obs,Object adapter) {

        if(obs == null || obs.length<1){ return  null ;}
        return super.loginForRegist( obs[0].toString(),null);
    }

}
