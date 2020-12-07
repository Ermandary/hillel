package xml_handler;

import exceptions.XmlException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class XmlHandler<T> implements ObjectHandler<T> {
    private final Class<? extends T> clazz;

    public XmlHandler(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> load(File file) {
        if (!file.isFile()) {
            throw new IllegalArgumentException();
        }
        List<T> result = new ArrayList<>();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList nodeList = doc.getElementsByTagName(clazz.getSimpleName());
            for (int i = 0; i < nodeList.getLength(); i++) {
                T object = (T) clazz.getConstructor().newInstance();
                NamedNodeMap attributes = nodeList.item(i).getAttributes();
                for (int x = 0; x < attributes.getLength(); x++) {
                    Field field = clazz.getDeclaredField(attributes.item(x).getNodeName());
                    field.setAccessible(true);
                    if (field.getType().toString().equals("int")) {
                        field.setInt(object, Integer.parseInt(attributes.item(x).getNodeValue()));
                    } else {
                        field.set(object, attributes.item(x).getNodeValue());
                    }
                }
                result.add(object);
            }
        } catch (ParserConfigurationException
                | SAXException
                | IOException
                | NoSuchMethodException
                | NoSuchFieldException
                | InstantiationException
                | InvocationTargetException
                | IllegalAccessException e) {
            throw new XmlException(e.toString());
        }

        return result;
    }

    @Override
    public Document create(List<T> objectList) {
        if(objectList == null) {
            throw new IllegalArgumentException();
        }
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException();
        }
        Document doc = builder.newDocument();

        Element root = doc.createElement(clazz.getCanonicalName());
        doc.appendChild(root);

        try {
            for (T element : objectList) {
                Element parent = doc.createElement(clazz.getSimpleName());
                root.appendChild(parent);
                for (Field field : clazz.getDeclaredFields()) {
                    field.setAccessible(true);
                    parent.setAttribute(field.getName(), String.valueOf(field.get(element)));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return doc;
    }

    @Override
    public void saveToFile(Document doc, File file) {
        if(file == null) {
            throw new IllegalArgumentException();
        }
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            FileOutputStream writer = new FileOutputStream(file);
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            writer.close();
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}
