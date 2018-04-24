package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SingleRestResponse;
import com.groupa.ssi.response.catalog.WorkItemResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Miguel Rojas
 */
@RestController
@RequestScope
public class WorkItemReadController extends WorkItemAbstractController {


    @RequestMapping(
            value = "/{workItemId}",
            method = RequestMethod.GET
    )
    public SingleRestResponse<WorkItemResponse> readWorkItem(@PathVariable Integer workItemId,
                                                             @RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... readWorkItem" );
        return new SingleRestResponse<>(new WorkItemResponse());
    }

}
