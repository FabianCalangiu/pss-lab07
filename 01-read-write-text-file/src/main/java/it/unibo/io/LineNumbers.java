package it.unibo.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Simple utility class that adds line numbers to files.
 */
public final class LineNumbers {

    private LineNumbers() { }

    /**
     * Processes the provided file produces a new file where each line is prefixed with its line number
     * (starting from 1).
     * The new file must have the same name of the original one, prefixed with {@code numbered-}.
     * For instance,
     * <ul>
     *     <li>{@code myfile.txt} should become {@code numbered-myfile.txt}</li>
     *     <li>{@code pluto.dat} should become {@code numbered-pluto.dat}</li>
     * </ul>
     *
     * @param file the file on which the function should operate
     * @throws IOException if something very bad happens to the file system while operating
     */
    public static void addLineNumbersToTextFile(final File file) throws IOException {
        /* 
        readAllLines() returns a List of strings, every elemented represents a line,
        the separator being '\n'
        */
        final var lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        /*
        This list will contain each line, but numbered
        */
        final var numberedLines = new ArrayList<String>();

        /*
        Self explicative
        */
        for (int i = 0; i < lines.size(); i++){
            numberedLines.add((i + 1) + " - " + lines.get(i));
        }

        /*
        Creates a new file
        */
        final File newFile = new File(file.getParent(), "numberedLines_" + file.getName());

        /*
        Writes the new numbered lines on the file
        */
        Files.write(newFile.toPath(), numberedLines, StandardCharsets.UTF_8);
    }
}
