package com.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by esahcorp on 2017/9/20.
 */
@RestController
public class NewConsumerController {
    private ComputeClient computeClient;

    @Autowired
    public void setComputeClient( ComputeClient computeClient) {
        this.computeClient = computeClient;
    }

    @GetMapping("/add")
    public String add() {
        return computeClient.add(11, 22);
    }
}
