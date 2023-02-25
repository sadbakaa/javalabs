package com.company;
import java.io.File;

public class DirectoryLister {

    public static void listDirectory()
    {
        String directory = System.getProperty("user.dir");
        System.out.println(String.format("current dir = %s", directory));

        File files = new File(directory);

        listFiles(files,"->");
    }

    private static void listFiles(File fileList, String separator)
    {
        File file[] = fileList.listFiles();
        for(int i = 0 ; i < file.length ; i++)
        {
            if(file[i].isDirectory())
            {
                printDirectory(separator, file[i]);
            }
            else
            {
                printFile(separator, file[i]);
            }
        }
    }

    private static void printDirectory(String separator, File file) {
        printFile(separator, file);
        listFiles(file,"--"+ separator);
    }
    private static void printFile(String separator, File value) {
        System.out.println(separator + value.getName());
    }


}
