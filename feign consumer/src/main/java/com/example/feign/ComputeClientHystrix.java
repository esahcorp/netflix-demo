package com.example.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by esahcorp on 2017/9/21.
 */

@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return "-9999";
    }
}
