package com.groupa.ssi.cmd.common;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.exception.FileDocumentException;
import com.groupa.ssi.model.domain.common.FileDocument;
import com.groupa.ssi.services.common.FileDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class FileDocumentUploadCmd extends AbstractCommand {

    private MultipartFile file;

    @Autowired
    private FileDocumentService service;

    private FileDocument newFileDocument;

    @Override
    protected void run() {
        FileDocument fileDocument = null;
        try {
            fileDocument = composeFileDocument(file);
        } catch (IOException e) {
            throw new FileDocumentException("Cannot upload file");
        }
        newFileDocument = service.save(fileDocument);
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private FileDocument composeFileDocument(MultipartFile file) throws IOException {
        FileDocument fileDocument = new FileDocument();
        fileDocument.setFileName(file.getOriginalFilename());
        fileDocument.setContentType(file.getContentType());
        fileDocument.setSize(file.getSize());
        fileDocument.setData(file.getBytes());

        return fileDocument;
    }

    public FileDocument getNewFileDocument() {
        return newFileDocument;
    }
}
