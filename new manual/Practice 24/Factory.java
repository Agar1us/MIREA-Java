import java.io.IOException;

public class Factory {
    public static IDocument getDocument(ICreateDocument doc) throws IOException {
        return doc.createDocument();
    }
}
