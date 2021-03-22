package at.gepardec.cditraining.producers;

import at.gepardec.cditraining.qualifiers.Circle;
import at.gepardec.cditraining.qualifiers.Rectangle;
import at.gepardec.cditraining.qualifiers.RectangleShape;
import at.gepardec.cditraining.qualifiers.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class BeanProducer {

    @Inject
    private Shape circle;

    @Inject
    @RectangleShape
    private Shape rectangle;

    /**
     * This is a producer field.
     * If no scope is provided then the bean is produced for the @Dependent scope
     * If no qualifier is provided then the @Default is used
     */
    @Produces
    String producedString = "Hello, I got produced";

    /**
     * This is a producer field.
     * If no scope is provided then the bean is produced for the @Dependent scope
     * If no qualifier is provided then the @Default is used
     */
    @Produces
    ProducedBean producedBean = new ProducedBean();

    @Produces
    @RequestScoped
    List<Shape> getCircles(){
        return List.of(new Circle(), new Circle());
    }

    @Produces
    @ApplicationScoped
    @RectangleShape
    List<Shape>  getRectangles(){
        return List.of(new Rectangle(), new Rectangle());
    }

    /**
     * This is a producer method.
     * If no scope is provided then the bean is produced for the @Dependent scope
     * If no qualifier is provided then the @Default is used
     *
     * @param injectionPoint the injectionPoint only available for @Dependent scoped beans
     * @return the produced logger
     */
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        // There are some cases when this can be null, for instance with EJBs
        if (injectionPoint.getBean() != null) {
            return LoggerFactory.getLogger(injectionPoint.getBean().getBeanClass());
        }
        // Should not be null, but we want to be safe
        else if (injectionPoint.getMember() != null) {
            return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
        }
        // In case we cannot determine declaring class
        else {
            return LoggerFactory.getLogger("default");
        }
    }
}
