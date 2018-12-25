package Task1_8;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    static {
        ctx.registerShutdownHook();
    }

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

        app.logEvent(EventType.ERROR, "Some event for user 1");
        app.logEvent(EventType.INFO, "Some event for user 2");
        app.logEvent(null, "Some event for user 3");

    }
}
