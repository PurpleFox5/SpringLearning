package package1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Rectangle extends Figure {

    private int length;
    private int width;

    @Autowired
    public Rectangle(String name, int length, int width) {
        super(name);

        this.length = length;
        this.width = width;
    }

    public double square() {
        return this.length * this.width;
    }
}
