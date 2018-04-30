package com.groupa.ssi.controller.common;

import com.groupa.ssi.cmd.common.FileDocumentUploadCmd;
import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.common.FileDocumentResponse;
import com.groupa.ssi.response.common.FileDocumentResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Miguel Rojas
 */
@Api(
        tags = FileDocumentAbstractController.TAG_NAME,
        description = FileDocumentAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class FileDocumentUploadController extends FileDocumentAbstractController {

    @Autowired
    private FileDocumentUploadCmd cmd;

    @ApiOperation(value = "Upload file")
    @RequestMapping(
            value = "/upload",
            method = RequestMethod.POST
    )
    public SingleRestResponse<FileDocumentResponse> uploadFile(@RequestParam("file") MultipartFile file) {
        cmd.setFile(file);
        cmd.execute();

        return new SingleRestResponse<>(FileDocumentResponseBuilder.getInstance(cmd.getNewFileDocument()).build());
    }
}
