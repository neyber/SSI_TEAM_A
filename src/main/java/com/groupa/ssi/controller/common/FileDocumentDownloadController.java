package com.groupa.ssi.controller.common;

import com.groupa.ssi.cmd.common.FileDocumentDownloadCmd;
import com.groupa.ssi.model.domain.common.FileDocument;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Miguel Rojas
 */
@Api(
        tags = FileDocumentAbstractController.TAG_NAME,
        description = FileDocumentAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class FileDocumentDownloadController extends FileDocumentAbstractController {
    private static Logger log = LoggerFactory.getLogger(FileDocumentDownloadController.class);

    @Autowired
    private FileDocumentDownloadCmd cmd;

    @ApiOperation(value = "Download file")
    @RequestMapping(
            value = "/{fileDocumentId}/download",
            method = RequestMethod.GET
    )
    public void downloadFile(@PathVariable Integer fileDocumentId, HttpServletResponse response) {
        cmd.setFileDocumentId(fileDocumentId);
        cmd.execute();

        setFileDocumentInResponse(cmd.getFileDocument(), response);
    }

    private void setFileDocumentInResponse(FileDocument fileDocument, HttpServletResponse response) {
        if (fileDocument != null) {
            try {
                // Set the content type and attachment header
                response.addHeader("Content-disposition", "attachment;filename=" + fileDocument.getFileName());
                response.setContentType(fileDocument.getContentType());

                InputStream inputStream = new ByteArrayInputStream(fileDocument.getData());
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
            } catch (IOException e) {
                log.info("Error in set in response file document..", e);
            }
        }
    }
}
