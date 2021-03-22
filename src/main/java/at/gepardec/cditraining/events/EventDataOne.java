package at.gepardec.cditraining.events;

public class EventDataOne implements EventData{

    private static final String MESSAGE ="THIS IS EVENT DATA ONE";

    @Override
    public String message() {
        return MESSAGE;
    }
}
