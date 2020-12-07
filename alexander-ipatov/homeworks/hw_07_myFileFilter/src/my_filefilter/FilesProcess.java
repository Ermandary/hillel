package my_filefilter;

import java.io.File;
import java.io.IOException;

public class FilesProcess {
    public void createFiles(File directory, String... fileNames) throws IOException {
        if (directory != null && directory.isDirectory() && fileNames != null) {
            for (String fileName : fileNames) {
                File file = new File(directory + File.separator + fileName);
                file.createNewFile();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void createTempFiles(int quantity, String prefix, String suffix, File directory) throws IOException {
        if (quantity > 0 && prefix != null && prefix.length() >= 3) {
            if (directory != null && directory.isDirectory()) {
                for (int i = 0; i < quantity; i++) {
                    File.createTempFile(prefix, suffix, directory);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void createTempFiles(int quantity, String prefix, String suffix) throws IOException {
        createTempFiles(quantity, prefix, suffix, null);
    }

    public void deleteFiles(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
            file.delete();
        }
    }

    public void deleteTempFiles(File directory) {
        File[] tempFiles = directory.listFiles();
        for (File file : tempFiles) {
            file.deleteOnExit();
        }
    }
}
