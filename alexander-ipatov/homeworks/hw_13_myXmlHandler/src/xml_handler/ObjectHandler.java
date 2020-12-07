package xml_handler;

import org.w3c.dom.Document;

import java.io.File;
import java.util.List;

public interface ObjectHandler<T> {
    List<T> load(File file);

    Document create(List<T> objectList);

    void saveToFile(Document doc, File file);
}
