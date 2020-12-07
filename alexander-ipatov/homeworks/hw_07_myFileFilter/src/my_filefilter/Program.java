package my_filefilter;

import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        FilesProcess filesProcess = new FilesProcess();

        File filesDir = new File("d:/Neftyanik/Java/Sourses/Files");
        filesProcess.createFiles(filesDir,
                "Hello.txt",
                "diplom-9321-last_version.doc",
                "qw.jpg",
                "qwe.xml",
                "message.txt",
                "porgram.html",
                "ranetki.mp3",
                "Оно.mp4"
                );
        File[] files = filesDir.listFiles();
        File renameFile = files[0];
        if(renameFile.renameTo(new File(renameFile + File.separator + "newName.txt"))) {
            System.out.println("Файл переименован");
        } else System.out.println("Не удалось переименовать файл");

        MyFileFilter filter = new MyFileFilter("txt", "jpg", "DOC");
        File[] filteredfiles = filesDir.listFiles(filter);
        for(File f : filteredfiles) {
            System.out.println(f);
        }
        filesProcess.deleteFiles(filesDir);

        File tempFilesDir = new File("d:/Neftyanik/Java/Sourses/Temp");
        filesProcess.createTempFiles(4, "myTempFile", null, tempFilesDir);
        File[] tempFiles = tempFilesDir.listFiles();
        for(File t : tempFiles) {
            System.out.println(t);
        }
        filesProcess.deleteTempFiles(tempFilesDir);
    }
}
