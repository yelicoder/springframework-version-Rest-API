package com.aiconsulting.swagger4.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface scheduleService {
    @RequestMapping(value="/schedule", method= RequestMethod.GET)
    String getSchedule1();
    String getSchedule2();
}
