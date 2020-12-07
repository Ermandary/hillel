package files_program;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class FileHandler {

    public File fileCombiner(File pathToSave, File... files) throws IOException {
        if(!pathToSave.isDirectory() || files == null) {
            throw new IllegalArgumentException();
        }
        int count = 1;
        File newFile = createFile((count + "CombineFile.bin"), pathToSave);
        try (OutputStream writer = new FileOutputStream(newFile, true)) {
            for (File file : files) {
                try (FileInputStream reader = new FileInputStream(file)) {
                    byte[] nameBytes = file.getName().getBytes();
                    byte[] countNameBytes = ByteBuffer.allocate(4).putInt(file.getName().length()).array();
                    byte[] countFileBytes = ByteBuffer.allocate(4).putInt(reader.available()).array();

                    writer.write(countNameBytes);
                    writer.write(nameBytes);
                    writer.write(countFileBytes);

                    while (reader.available() > 0) {
                        byte[] buffer;
                        buffer = reader.available() < 1024 ? new byte[reader.available()] : new byte[1024];
                        reader.read(buffer);
                        writer.write(buffer);
                    }
                }
            }
            return newFile;
        }
    }

    public void fileSplitter(File file, File pathToSave) throws IOException {
        if(!file.isFile() || !pathToSave.isDirectory()) {
            throw new IllegalArgumentException();
        }
        try (InputStream reader = new FileInputStream(file)) {
            while (reader.available() > 0) {
                int countNameBytes = ByteBuffer.wrap(reader.readNBytes(4)).getInt();
                byte[] nameBytes = reader.readNBytes(countNameBytes);
                String name = new String(nameBytes);
                File newFile = createFile(("Splitted" + name), pathToSave);

                int countFileBytes = ByteBuffer.wrap(reader.readNBytes(4)).getInt();

                try (OutputStream writer = new FileOutputStream(newFile)) {
                    int readedFileBytes = 0;
                    byte[] buffer;
                    while (readedFileBytes < countFileBytes) {
                        int remainingBytes = countFileBytes - readedFileBytes;
                        buffer = remainingBytes < 1024 ? new byte[remainingBytes] : new byte[1024];
                        readedFileBytes += reader.read(buffer);
                        writer.write(buffer);
                    }
                }
            }
        }
    }

    private File createFile(String name, File pathToSave) throws IOException {
        File newFile = new File(pathToSave + File.separator + name);
        newFile.createNewFile();
        return newFile;
    }
}


//1. получаем список файлов
//2. склеиваем их
//3. при склеивании в конечный файл добавляем информацию в виде [Количество байт имени][Байты имени][Количество байт файла][Байты файла]
//4. считываем по такой же логике
//5. после получения имени создаём файл

//    Написать программу, которая умеет:
//        Склеивать несколько файлов в один
//        Разделять ранее склеенный файл на несколько
//        В Файле должна храниться информация о том, какое имя было у файлов (используется для разделения файла)