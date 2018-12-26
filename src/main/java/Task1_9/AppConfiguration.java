package Task1_9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static Task1_9.LoggerConfig.cacheFileLogger;
import static Task1_9.LoggerConfig.fileEventLogger;
import static java.text.DateFormat.getDateTimeInstance;

@Configuration
public class AppConfiguration {

    @Bean
    @Scope("prototype")
    public Event event() {
        return new Event(new Date(), getDateTimeInstance());
    }

    @Bean
    public static Client client() {
        return new Client("1", "John Smith");
    }

    @Bean
    public Map<EventType, EventLogger> loggers() {
        Map<EventType, EventLogger> logger = new LinkedHashMap<>();
        logger.put(EventType.ERROR, cacheFileLogger());
        logger.put(EventType.INFO, fileEventLogger());
        return logger;
    }
}
