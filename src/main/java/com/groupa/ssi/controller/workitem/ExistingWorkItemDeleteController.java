package com.groupa.ssi.controller.workitem;

import com.groupa.ssi.cmd.workitem.ExistingWorkItemDeleteCmd;
import com.groupa.ssi.common.response.rest.SuccessRestResponse;
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
public class ExistingWorkItemDeleteController extends ExistingWorkItemAbstractController {

    @Autowired
    private ExistingWorkItemDeleteCmd cmd;

    @ApiOperation(value = "Delete existing work item")
    @RequestMapping(
            value = "/{existingWorkItemId}",
            method = RequestMethod.DELETE
    )
    public SuccessRestResponse deleteExistingWorkItem(@PathVariable Integer existingWorkItemId,
                                              @RequestParam(value = "userId", required = false) Integer userId) {
        cmd.setExistingWorkItemId(existingWorkItemId);
        cmd.execute();

        return new SuccessRestResponse();
    }

}
