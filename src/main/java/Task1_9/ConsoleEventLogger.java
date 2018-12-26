package Task1_9;

import org.springframework.stereotype.Component;

@Component("defaultLogger")
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }

}
