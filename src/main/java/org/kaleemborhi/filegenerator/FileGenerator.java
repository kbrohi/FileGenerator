package org.kaleemborhi.filegenerator;

import org.kaleemborhi.filegenerator.utils.Config;
import org.kaleemborhi.filegenerator.utils.FileTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import static org.kaleemborhi.filegenerator.utils.Constants.*;

public class FileGenerator {

    public static void main(String[] args) throws IOException {
        String pathToFile = "NEW_FOLDER";
        String fileName = null;
        String content = null;

        FileTemplate fileTemplate = new FileTemplate(fileName, content);

        generateFile(pathToFile, fileTemplate);
    }

    private static void generateFile(String pathToFile, FileTemplate fileTemplate) throws IOException {
        File filePath = new File(pathToFile);
        createDirectory(filePath);
        createFiles(filePath, fileTemplate);
    }

    public static void createFiles(File filePath, FileTemplate fileTemplate) {
        Timer timer = new Timer();

        String fileName = fileTemplate.getFileName();
        String content = fileTemplate.getFileContent();

        timer.scheduleAtFixedRate(new TimerTask() {
            int i = Config.DURATION.params();
            public void run() {
                    try {
                        createAndWrite(filePath, fileName,content);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                 i-=MIN_VALUE;
                if (i < 0)
                    timer.cancel();
            }
        }, 0, MIN_VALUE);

    }

    private static double getRandomValue() {
        return  (Math.random() *(MAX_VALUE - MIN_VALUE) + 1 ) + MIN_VALUE;
    }

    private static void createAndWrite(File filePath, String fileName, String content) throws IOException {
        File file = new File(filePath, fileName+ getRandomValue() +".txt");

       if(file.createNewFile()){
           BufferedWriter writer = new BufferedWriter(new FileWriter(file));
           writer.write(content);
           writer.close();
       }
    }

    private static void createDirectory(File filePath) throws IOException {
        if(!filePath.exists()){
            if (!filePath.mkdirs()) {
                throw new IOException("Can't create directories in " + filePath.getAbsolutePath());
            }
        }
    }

}
