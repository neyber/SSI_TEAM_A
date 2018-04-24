package com.groupa.ssi.controller.catalog;

import com.groupa.ssi.common.response.rest.SuccessRestResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Miguel Rojas
 */
@RestController
@RequestScope
public class WorkItemDeleteController extends WorkItemAbstractController {


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
