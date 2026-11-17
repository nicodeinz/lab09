package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private static final String HOME = System.getProperty("user.home");
    private File currentFile = new File(HOME, "output.txt");

    /**
     * Sets the current file.
     *
     * @param file the new current file
     */
    public void setFile(final File file) {
        this.currentFile = Objects.requireNonNull(file, "file cannot be null");
    }

    /**
     * Gets the current file.
     *
     * @return the current file
     */
    public File getFile() {
        return this.currentFile;
    }

    /**
     * Gets the path of the current file.
     *
     * @return the path of the current file as a String
     */
    public String getPathString() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Saves the given content on the current file.
     *
     * @param content the text to save
     * @throws IOException if an I/O error occurs
     */
    public void write(final String content)throws IOException {
        Files.writeString(this.currentFile.toPath(), content);
    }
}
