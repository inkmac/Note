import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        printLines();
    }

    public static void printLines() {
        Path path = Paths.get("D:/JavaProjects/Concurrent");
        long counts = countLinesInJavaFiles(path);
        System.out.println(counts);
    }

    public static long countLinesInJavaFiles(Path folderPath) {
        final long[] totalLines = {0}; // Using an array to hold the mutable count

        try {
            Files.walkFileTree(folderPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // Check if the file is a .java file and resides in the 'src' directory
                    boolean isJavaFile = file.toString().endsWith(".java");
                    boolean isKotlinFile = file.toString().endsWith(".kt");
                    if ((isKotlinFile || isJavaFile) && file.toString().contains("src")) {
                        try {
                            // Count lines in the .java file
                            @SuppressWarnings("resource")
                            long linesInFile = Files.lines(file).count();
                            totalLines[0] += linesInFile;
                        } catch (IOException e) {
                            System.err.println("Error reading file " + file + ": " + e.getMessage());
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error accessing folder " + folderPath + ": " + e.getMessage());
        }

        return totalLines[0];
    }
}
