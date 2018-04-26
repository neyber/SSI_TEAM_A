package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.catalog.PpeClassificationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

/**
 * Created on April 25, 2018
 * @author Walker Colina
 */
@Api(
        tags = PpeClassificationAbstractController.TAG_NAME,
        description = PpeClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class PpeClassificationListController extends PpeClassificationAbstractController {

    @ApiOperation(value = "List of personal protection equipment classifications")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<PpeClassificationResponse> getPpeClassificationList(@RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... getPpeClassificationList" );
        return new ListRestResponse<>(new ArrayList<>());
    }

}
