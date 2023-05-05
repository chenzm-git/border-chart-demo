package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.service.impl.ChartServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenzm
 * @version V1.0
 * @since 2023-05-05$
 **/
@RestController
@Slf4j
public class ChartController {

    @Autowired
    private ChartServiceImpl chartService;

    @PostMapping(value = "/api/chart")
    public String chart(@RequestBody String input){
        log.info("chart 输入 : " + input);

        String output = chartService.chart(input);

        log.info("chart 输出 : " + output);
        return output;
    }
}
