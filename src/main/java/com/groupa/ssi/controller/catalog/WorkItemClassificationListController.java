package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.cmd.catalog.WorkItemClassificationListCmd;
import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.catalog.WorkItemClassificationResponse;
import com.groupa.ssi.response.catalog.WorkItemClassificationResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on May 1, 2018
 * @author Walker Colina
 */
@Api(
        tags = WorkItemClassificationAbstractController.TAG_NAME,
        description = WorkItemClassificationAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class WorkItemClassificationListController extends WorkItemClassificationAbstractController {

    @Autowired
    private WorkItemClassificationListCmd cmd;

    @ApiOperation(value = "List of work item classifications")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<WorkItemClassificationResponse> getWorkItemClassificationList(@RequestParam(value = "userId", required = false) Integer userId) {

        cmd.execute();

        List<WorkItemClassificationResponse> result = cmd.getWorkItemClassificationList().stream()
                .map(instance -> WorkItemClassificationResponseBuilder.getInstance(instance).build())
                .collect(Collectors.toList());

        return new ListRestResponse<>(result);
    }

}
