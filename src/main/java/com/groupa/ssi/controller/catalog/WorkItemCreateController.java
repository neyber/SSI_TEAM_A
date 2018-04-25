package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.catalog.WorkItemRequest;
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
public class WorkItemCreateController extends WorkItemAbstractController {


    @ApiOperation(value = "Create work item")
    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createWorkItem(@RequestBody WorkItemRequest workItemRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... createWorkItem" );
        return new SuccessRestResponse();
    }

}
