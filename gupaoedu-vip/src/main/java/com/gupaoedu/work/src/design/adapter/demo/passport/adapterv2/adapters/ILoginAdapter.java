package design.adapter.demo.passport.adapterv2.adapters;


import design.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public interface ILoginAdapter {
    boolean support(Object object);
    ResultMsg login(Object[] obs,Object adapter);
}
