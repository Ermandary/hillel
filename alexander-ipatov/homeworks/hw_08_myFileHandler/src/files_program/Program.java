package files_program;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        File path = new File("aleksander-ipatov/homework/hw_10_files_program/src/files");
        File[] files = path.listFiles();

        FileHandler handler = new FileHandler();
        File combine = handler.fileCombiner(path, files);
        handler.fileSplitter(combine,path);
    }
}
