package at.gepardec.cditraining.scopes;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.Serializable;

@ApplicationScoped
public class MixedApplicationBean implements Serializable {

    @Inject
    private MixedSessionBean mixedSessionBean;

    private int value = 0;

    public int incrementAndGet() {
        return ++value;
    }

    public MixedSessionBean scopeMixSession() {
        return mixedSessionBean;
    }
}
