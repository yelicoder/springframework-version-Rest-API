package com.aiconsulting.swagger4.service;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class scheduleServiceImpl implements scheduleService {

    @Override
    @ApiOperation(value="Get the default schedule for employee",
            notes="All employees share the same schedule")
    @RequestMapping(value="/v1/schedule", method= RequestMethod.GET)
    public String getSchedule1() {
        return "You v1 schedule is M-F 9-5";
    }

    @ApiOperation(value="Get the default schedule for employee",
            notes="All employees share the same schedule")
    @RequestMapping(value="/v2/schedule", method= RequestMethod.GET)
    public String getSchedule2() {
        return "You v2 schedule is M-W 9-9";
    }
}
