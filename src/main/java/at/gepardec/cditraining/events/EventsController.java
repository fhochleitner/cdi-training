package at.gepardec.cditraining.events;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/events")
@Controller
@RequestScoped
public class EventsController {

    @Inject
    private Event<String> event;

    @Inject
    private Event<EventData> eventData;

    @GET
    @Path("/")
    public String get() {
        event.fire("THIS IS A EVENT MESSENGE");
        event.fireAsync("THIS IS AN ASYNC EVENT MESSENGE");
        eventData.fire(new EventDataTwo());
        eventData.fire(new EventDataOne());
        return "events/events.html";
    }
}
