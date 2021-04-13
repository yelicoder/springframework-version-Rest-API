package com.aiconsulting.swagger4.service;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@BasePathAwareController
@RestController
public class ScheduleService {

    @ApiOperation(value="Get the default schedule for employee",
            notes="All employees share the same schedule")
    @RequestMapping(value="/schedule", method= RequestMethod.GET)
    public String getSchedule() {
        return "Your v1 schedule is M-F 9-5";
    }

    /*
    @ApiOperation(value="Get the default schedule for employee",
            notes="All employees share the same schedule")
    @RequestMapping(value="/v2/schedule", method= RequestMethod.GET)
    public String getSchedule2() {
        return "You v2 schedule is M-W 9-9";
    }

     */
}
