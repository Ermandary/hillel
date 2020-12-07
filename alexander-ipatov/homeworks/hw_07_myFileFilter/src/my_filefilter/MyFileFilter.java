package my_filefilter;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class MyFileFilter implements FileFilter {
    private final static List<String> EXTENSIONS = new ArrayList<>();

    public MyFileFilter(String... extensions) {
        for (String ext : extensions) {
            EXTENSIONS.add(ext.toLowerCase());
        }
    }

    @Override
    public boolean accept(File pathname) {
        if (pathname != null && pathname.isFile()) {
            String filePath = pathname.getPath();
            if (filePath.contains(".")) {
                int index = filePath.lastIndexOf('.');
                String ext = filePath.substring(index + 1).toLowerCase();
                for (int i = 0; i < EXTENSIONS.size(); i++) {
                    if (EXTENSIONS.get(i).equals(ext)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
