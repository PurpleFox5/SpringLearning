package package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Math.PI;

@Component
public class Circle extends Figure {


    private int radius;

    @Autowired
    public Circle(String name, int radius) {
        super(name);
        this.radius = radius;
    }

    public double square() {
        return PI * radius * radius;
    }
}