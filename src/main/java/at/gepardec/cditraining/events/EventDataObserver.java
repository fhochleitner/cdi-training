package at.gepardec.cditraining.events;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class EventDataObserver {
    @Inject
    Logger logger;

    /**
     * The method which observes a event of type String
     *
     * @param eventData the event this method observes
     * @throws Exception If the sleep fails
     */
    void observe(@Observes EventData eventData) throws Exception {
        Thread.sleep(3000);
        logger.info("Message received. Message: '{}'", eventData.message());
    }
}
