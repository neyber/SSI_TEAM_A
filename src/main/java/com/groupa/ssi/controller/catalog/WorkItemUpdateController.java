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
public class WorkItemUpdateController extends WorkItemAbstractController {


    @ApiOperation(value = "Update work item")
    @RequestMapping(
            value = "/{workItemId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateWorkItem(@PathVariable Integer workItemId,
                                              @RequestBody WorkItemRequest workItemRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... updateWorkItem" );
        return new SuccessRestResponse();
    }

}
