package at.gepardec.cditraining.events;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;

@ApplicationScoped
public class EventObserver {

    @Inject
    Logger logger;

    /**
     * The method which observes a event of type String
     *
     * @param messageEvent the event this method observes
     * @throws Exception If the sleep fails
     */
    void observe(@Observes String messageEvent) throws Exception {

        logger.info("Message received. Message: '{}'", messageEvent);
    }

    void observeDuringTransactionPhase(@Observes(during = TransactionPhase.AFTER_SUCCESS) String messageEvent) throws Exception {
        //Würde erst nach erfolgreicher Transaktion durchgeführt.
        logger.info("Message received. Message: '{}'", messageEvent);
    }

    void observeAsync(@ObservesAsync String messageEvent) throws Exception {
        Thread.sleep(3000);
        observe(messageEvent);
    }
}
