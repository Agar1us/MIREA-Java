import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageDocument implements IDocument {
    public ImageDocument() throws IOException {
        Files.createFile(Path.of("C:\\Users\\kalin\\Desktop\\Java\\Practice 24\\image.jpg"));
        System.out.println("Был создан jpg файл");
    }
}
