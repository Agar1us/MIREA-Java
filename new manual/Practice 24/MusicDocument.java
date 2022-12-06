import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MusicDocument implements IDocument{
    public MusicDocument() throws IOException {
        Files.createFile(Path.of("C:\\Users\\kalin\\Desktop\\Java\\Practice 24\\music.mp3"));
        System.out.println("Был создан mp3 файл");
    }
}
