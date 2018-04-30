package com.groupa.ssi.response.common;

import com.groupa.ssi.model.domain.common.FileDocument;

/**
 * @author Miguel Rojas
 */
public final class FileDocumentResponseBuilder {

    private Integer fileDocumentId;
    private String fileName;

    private FileDocumentResponseBuilder() {
    }

    public FileDocumentResponse build() {
        FileDocumentResponse response = new FileDocumentResponse();
        response.setFileDocumentId(fileDocumentId);
        response.setFileName(fileName);
        return response;
    }

    public static FileDocumentResponseBuilder getInstance(FileDocument fileDocument ) {
        return new FileDocumentResponseBuilder()
                .setFileDocumentId(fileDocument.getId())
                .setFileName(fileDocument.getFileName());
    }

    public FileDocumentResponseBuilder setFileDocumentId(Integer fileDocumentId) {
        this.fileDocumentId = fileDocumentId;
        return this;
    }

    public FileDocumentResponseBuilder setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
