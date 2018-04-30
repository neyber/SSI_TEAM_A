package com.groupa.ssi.services.common;

import com.groupa.ssi.model.domain.common.FileDocument;
import com.groupa.ssi.model.repository.common.FileDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Miguel Rojas
 */
@Service
public class FileDocumentService extends GenericService<FileDocument> {
    @Autowired
    private FileDocumentRepository repository;

    @Override
    protected JpaRepository<FileDocument, Integer> getRepository() {
        return repository;
    }
}
