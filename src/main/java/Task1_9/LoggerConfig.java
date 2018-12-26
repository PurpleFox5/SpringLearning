package Task1_9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class LoggerConfig {

    @Bean
    public static CacheFileLogger cacheFileLogger() {
        return new CacheFileLogger(fileEventLogger().getFilename(), 10);
    }

    @Bean
    public static FileEventLogger fileEventLogger() {
        return new FileEventLogger("logFile.txt");
    }

    @Bean
    public ConsoleEventLogger consoleEventLogger() {
        return new ConsoleEventLogger();
    }

    @Bean
    public CombinedEventLogger combinedEventLogger() {
        return new CombinedEventLogger(Arrays.asList(consoleEventLogger(), fileEventLogger()));
    }
}
