package Task1_9;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static java.lang.System.lineSeparator;
import static org.apache.commons.io.FileUtils.writeStringToFile;

@Component("fileEventLogger")
public class FileEventLogger implements EventLogger {

    private String filename;
    File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void logEvent(Event event) throws IOException {
        writeStringToFile(file, event.toString() + lineSeparator(), true);
    }

    @PostConstruct
    public void init() throws IOException {
        this.file = new File(filename);
        if (!file.canWrite()) {
            throw new IOException();
        }
    }

    public String getFilename() {
        return filename;
    }
}
