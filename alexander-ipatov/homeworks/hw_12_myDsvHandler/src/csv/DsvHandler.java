package csv;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DsvHandler<T> {
    private final Class<? extends T> clazz;
    private final String separator;

    public DsvHandler(Class<? extends T> clazz, String separator) {
        this.clazz = clazz;
        this.separator = separator;
    }

    public List<T> load(File dsvFile) {
        if (!dsvFile.isFile()) {
            throw new IllegalArgumentException();
        }
        final List<T> result = new ArrayList<>();
        try {
            List<String> strings = Files.readAllLines(Paths.get(dsvFile.toURI()));
            String[] head = strings.get(0).split(separator);

            for (int i = 1; i < strings.size(); i++) {
                String[] values = strings.get(i).split(separator);
                T obj = clazz.getConstructor().newInstance();
                for (int x = 0; x < head.length; x++) {
                    Field field = clazz.getDeclaredField(head[x]);
                    field.setAccessible(true);
                    if (field.getType().toString().equals("int")) {
                        field.set(obj, Integer.parseInt(values[x]));
                    } else {
                        field.set(obj, values[x]);
                    }
                }
                result.add(obj);
            }
        } catch (IOException
                | NoSuchMethodException
                | NoSuchFieldException
                | InstantiationException
                | InvocationTargetException
                | IllegalAccessException e) {
            throw new DsvException(e.toString());
        }
        return result;
    }

    public void save(List<T> objectList, File fileToSave) {
        if (objectList == null || fileToSave == null) {
            throw new IllegalArgumentException();
        }
        try {
            Writer writer = new BufferedWriter(new FileWriter(fileToSave));
            writer.write(getHead() + "\n");

            for (int i = 0; i < objectList.size(); i++) {
                writer.write(objToDsv(objectList.get(i)) + "\n");
            }
            writer.close();
        } catch (IOException | IllegalAccessException e) {
            throw new DsvException(e.toString());
        }
    }

    private String objToDsv(T obj) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            result.append(field.get(obj) + separator);
        }
        return result.toString();
    }

    private String getHead() {
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder head = new StringBuilder();
        for (Field field : fields) {
            head.append(field.getName() + separator);
        }
        return head.toString();
    }
}
