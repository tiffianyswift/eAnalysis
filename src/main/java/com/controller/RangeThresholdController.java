package com.controller;

import com.pojo.RangeThreshold;
import com.service.RangeThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/re")
public class RangeThresholdController {
    @Autowired
    private RangeThresholdService rangeThresholdService;

    //删除点
    @RequestMapping("/ge")
    public String deletePoint(RangeThreshold rangeThreshold) {
        //System.out.println("123");
       //int res = rangeThresholdService.deletePoint(rangeThreshold);

        return "rangeThreshold";
    }
    @RequestMapping("/do")
    public String deleePoint(RangeThreshold rangeThreshold) {
        //System.out.println("123");
        //int res = rangeThresholdService.deletePoint(rangeThreshold);

        return "hotmap";
    }
}
