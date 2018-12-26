package package1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public static Circle circle() {
        return new Circle("circle", 5);
    }

    @Bean
    public static Rectangle rectangle() {
        return new Rectangle("rectangle", 5, 5);
    }
}
