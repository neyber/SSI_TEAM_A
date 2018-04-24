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
public class WorkItemCreateController extends WorkItemAbstractController {


    @RequestMapping(
            method = RequestMethod.POST
    )
    public SuccessRestResponse createWorkItem(@RequestBody WorkItemRequest workItemRequest,
                                              @RequestParam(value = "userId") Integer userId) {
        System.out.println(" Implementation pending... createWorkItem" );
        return new SuccessRestResponse();
    }

}
