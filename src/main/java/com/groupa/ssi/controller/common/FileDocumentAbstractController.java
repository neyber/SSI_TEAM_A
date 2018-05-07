package com.groupa.ssi.controller.common;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Miguel Rojas
 */
@RequestMapping(value = FileDocumentAbstractController.PATH)
public abstract class FileDocumentAbstractController {

    public static final String PATH = Constants.SSI_BASE_PATH + "/fileDocuments";

    public static final String TAG_NAME = "File documents";

    public static final String DESCRIPTION = "Available operations over file documents";
}
