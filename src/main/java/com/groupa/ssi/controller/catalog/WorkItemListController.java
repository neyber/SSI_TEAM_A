package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.ListRestResponse;
import com.groupa.ssi.response.catalog.WorkItemResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;

/**
 * @author Miguel Rojas
 */
@Api(
        tags = WorkItemAbstractController.TAG_NAME,
        description = WorkItemAbstractController.DESCRIPTION
)
@RestController
@RequestScope
public class WorkItemListController extends WorkItemAbstractController {

    @ApiOperation(value = "List of work items")
    @RequestMapping(
            method = RequestMethod.GET
    )
    public ListRestResponse<WorkItemResponse> getWorkItemList(@RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... getWorkItemList" );
        return new ListRestResponse<>(new ArrayList<>());
    }

}
