import java.io.IOException;

public class CreateImage implements ICreateDocument{
    @Override
    public IDocument createDocument() throws IOException {
        return new ImageDocument();
    }
}
