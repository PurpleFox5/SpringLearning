package Task1_9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component("app")
public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    private static ApplicationContext ctx = new AnnotationConfigApplicationContext("Task1_9");

    @Autowired
    public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType type, String msg) throws IOException {

        EventLogger eventLogger = loggers.get(type);

        if (eventLogger == null) eventLogger = defaultLogger;

        String message = msg.replaceAll(client.getId(), client.getFullName());
        Event event = (Event) ctx.getBean("event");
        event.setMsg(message);

        eventLogger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {

        App app = (App) ctx.getBean("app");

//        app.logEvent(EventType.ERROR, "Some event for user 1");
        app.logEvent(EventType.INFO, "Some event for user 2");
//        app.logEvent(null, "Some event for user 3");

    }
}
