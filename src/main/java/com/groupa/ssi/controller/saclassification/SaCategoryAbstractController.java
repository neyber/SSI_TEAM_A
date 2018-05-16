package com.groupa.ssi.controller.saclassification;

import com.groupa.ssi.common.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

/*
Created on 13/5/18
@author: HENRYBC
*/
@RequestMapping(value = SaCategoryAbstractController.PATH)
public class SaCategoryAbstractController {
    public static final String PATH = Constants.SSI_BASE_PATH + "/saCategories";

    public static final String TAG_NAME = "saCategories";

    public static final String DESCRIPTION = "Available operations over saCategories";
}
