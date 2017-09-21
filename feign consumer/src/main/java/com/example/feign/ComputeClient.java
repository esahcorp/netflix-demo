package com.example.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by esahcorp on 2017/9/20.
 */

@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @GetMapping("/add")
    String add(@RequestParam(name = "a") Integer a, @RequestParam(name = "b") Integer b);
}
