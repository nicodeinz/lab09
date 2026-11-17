package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;
    private static final String home = System.getProperty("user.home");

    public Controller() {
        this.currentFile = new File(home, "output.txt");
    }

    public void setFile(File file){
        this.currentFile = Objects.requireNonNull(file, "file cannot be null");
    }

    public File getFile() {
        return this.currentFile;
    }

    public String getPathString() {
        return currentFile.getAbsolutePath();
    }

    public void write(String content)throws IOException {
        Files.writeString(currentFile.toPath(),content);
    }
}
