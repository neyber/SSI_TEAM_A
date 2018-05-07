package com.groupa.ssi.cmd.common;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.common.FileDocument;
import com.groupa.ssi.services.common.FileDocumentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miguel Rojas
 */
@CommandScoped
public class FileDocumentDownloadCmd extends AbstractCommand {
    private Integer fileDocumentId;

    @Autowired
    private FileDocumentService service;

    private FileDocument fileDocument;

    @Override
    protected void run() {
        fileDocument = service.findById(fileDocumentId);
    }

    public void setFileDocumentId(Integer fileDocumentId) {
        this.fileDocumentId = fileDocumentId;
    }

    public FileDocument getFileDocument() {
        return fileDocument;
    }
}
