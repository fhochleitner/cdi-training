package at.gepardec.cditraining.qualifiers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@RequestScoped
@RectangleShape
public class Rectangle extends Shape {
}
