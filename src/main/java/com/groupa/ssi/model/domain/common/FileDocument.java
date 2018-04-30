package com.groupa.ssi.model.domain.common;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * @author Miguel Rojas
 */
@Entity
public class FileDocument extends ModelBase {
    @Column
    private String fileName;

    @Column
    private String contentType;

    @Column
    private Long size;

    @Lob
    @Column
    private byte[] data;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}



