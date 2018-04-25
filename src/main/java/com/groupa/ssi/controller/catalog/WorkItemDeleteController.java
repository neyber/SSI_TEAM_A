package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Miguel Rojas
 */
@Api(
        tags = WorkItemAbstractController.TAG_NAME,
        description = WorkItemAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class WorkItemDeleteController extends WorkItemAbstractController {


    @ApiOperation(value = "Delete work item")
    @RequestMapping(
            value = "/{workItemId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteWorkItem(@PathVariable Integer workItemId,
                                              @RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... deleteWorkItem" );
        return new SuccessRestResponse();
    }

}
