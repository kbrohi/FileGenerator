package org.kaleemborhi.filegenerator.utils;

import static org.kaleemborhi.filegenerator.utils.Constants.*;

public class FileTemplate {
    private String fileName;
    private String fileContent;

    public FileTemplate(String fileName, String fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public FileTemplate() {
        this(FILE_NAME, FILE_CONTENT);
    }

    public String getFileName() {
        if(fileName == null){
            setFileName();
        }
        return fileName;
    }

    private void setFileName() {
            this.fileName = FILE_NAME;
    }

    public String getFileContent() {
        if(fileContent == null) {
            setFileContent();
        }
        return fileContent;
    }

    private void setFileContent() {
        this.fileContent = FILE_CONTENT;
    }


}
