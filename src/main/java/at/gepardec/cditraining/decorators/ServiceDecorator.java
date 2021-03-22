package at.gepardec.cditraining.decorators;

import org.slf4j.Logger;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public abstract class ServiceDecorator implements ServiceApi {

    @Inject
    private Logger log;

    @Inject
    @Delegate
    private ServiceApi delegate;

    @Override
    public void doSomething() {
        log.info("decorated before. id=" + this.hashCode());
        delegate.doSomething();
        log.info("decorated after. id=" + this.hashCode());
    }
}
