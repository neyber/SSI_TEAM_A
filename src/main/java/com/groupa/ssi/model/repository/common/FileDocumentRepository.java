package com.groupa.ssi.model.repository.common;

import com.groupa.ssi.model.domain.common.FileDocument;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Miguel Rojas
 */
public interface FileDocumentRepository extends JpaRepository<FileDocument, Integer> {
}
