import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextDocument implements IDocument{
    public TextDocument() throws IOException {
        Files.createFile(Path.of("C:\\Users\\kalin\\Desktop\\Java\\Practice 24\\text.txt"));
        System.out.println("Был создан txt файл");
    }
}
