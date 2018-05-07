package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.cmd.workitem.ExistingWorkItemUpdateCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.workitem.ExistingWorkItemRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@Api(
        tags = ExistingWorkItemAbstractController.TAG_NAME,
        description = ExistingWorkItemAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class ExistingWorkItemUpdateController extends ExistingWorkItemAbstractController {

    @Autowired
    private ExistingWorkItemUpdateCmd cmd;

    @ApiOperation(value = "Update existing work item")
    @RequestMapping(
            value = "/{existingWorkItemId}",
            method = RequestMethod.PUT
    )
    public SuccessRestResponse updateExistingWorkItem(@PathVariable Integer existingWorkItemId,
                                              @RequestBody ExistingWorkItemRequest existingWorkItemRequest,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setExistingWorkItemId(existingWorkItemId);
        cmd.setExistingWorkItemRequest(existingWorkItemRequest);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
