package at.gepardec.cditraining.decorators;

import org.slf4j.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class MyPriorityDecorator implements ServiceApi {

    @Inject
    private Logger log;

    @Inject
    @Delegate
    private ServiceApi delegate;



    @Override
    public void doSomething() {
        log.info("DECORATED SOMETHING VERY IMPORTANT AT THE VERY BEGINNING");
        delegate.doSomething();
        log.info("DECORATED SOMETHING VERY IMPORTANT AT THE VERY END");

    }

}
