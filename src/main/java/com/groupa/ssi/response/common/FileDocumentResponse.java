package com.groupa.ssi.response.common;

/**
 * @author Miguel Rojas
 */
public class FileDocumentResponse {

    private Integer fileDocumentId;
    private String fileName;

    public Integer getFileDocumentId() {
        return fileDocumentId;
    }

    public void setFileDocumentId(Integer fileDocumentId) {
        this.fileDocumentId = fileDocumentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
