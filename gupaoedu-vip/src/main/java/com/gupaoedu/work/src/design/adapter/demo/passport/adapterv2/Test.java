package design.adapter.demo.passport.adapterv2;

import design.adapter.demo.passport.ResultMsg;
import design.adapter.demo.passport.adapterv2.adapters.ILoginAdapter;
import design.adapter.demo.passport.adapterv2.adapters.LoginForTelAdapter;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        IPassportForThird adapter = new PassportForThirdAdapter();

        Object[] obs = {"123456","123456"};
        ResultMsg resultMsg =  adapter.processLogin(obs, LoginForTelAdapter.class);
        System.out.println(resultMsg);
    }
}
