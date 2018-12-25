package Task1_8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.io.FileUtils.writeLines;

public class CacheFileLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeLines(file, cache, true);
            cache.clear();
        }
    }

    public void destroy() throws IOException {
        if (!cache.isEmpty()) {
            writeLines(file, cache, true);
        }
    }
}
