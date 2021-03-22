package at.gepardec.cditraining.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;

@Interceptor
@BindingInterceptor(value = "B")
public class BBindingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object proceed(InvocationContext ctx){
        try {
            logger.info("B interceptor");
            ctx.proceed();
        }catch (Exception e){

        }
        return null;
    }
}
