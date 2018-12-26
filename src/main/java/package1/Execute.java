package package1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Execute {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("package1");
        Print print = (Print) context.getBean("print");
        print.showSquare();
    }
}