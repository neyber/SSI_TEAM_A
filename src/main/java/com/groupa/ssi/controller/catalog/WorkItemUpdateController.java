package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import com.groupa.ssi.request.catalog.WorkItemRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Miguel Rojas
 */
@RestController
@RequestScope
public class WorkItemUpdateController extends WorkItemAbstractController {


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
