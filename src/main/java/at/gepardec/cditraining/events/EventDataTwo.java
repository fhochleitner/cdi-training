package at.gepardec.cditraining.events;

public class EventDataTwo implements EventData{

    private static final String MESSAGE ="THIS IS EVENT DATA TWO. WE ARE IMPORTANT TOO!";

    @Override
    public String message() {
        return MESSAGE;
    }
}
