package com.example.compute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/*
                                             __----~~~~~~~~~~~------___
                                  .  .   ~~//====......          __--~ ~~
                  -.            \_|//     |||\\  ~~~~~~::::... /~
               ___-==_       _-~o~  \/    |||  \\            _/~~-
       __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
   _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 .~       .~       |   \\ -_    /  /-   /   ||      \   /
/  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
|~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
         '         ~-|      /|    |-~\~~       __--~~
                     |-~~-_/ |    |   ~\_   _-~            /\
                          /  \     \__   \/~                \__
                      _--~ _/ | .-~~____--~-/                  ~~==.
                     ((->/~   '.|||' -_|    ~~-/ ,              . _||
                                -_     ~\      ~~---l__i__i__i--~~_/
                                _-~-__   ~)  \--______________--~~
                              //.-~~~-~_--~- |-------~~~~~~~~
                                     //.-~~~--\


*/

/**
 * Created by esahcorp on 2017/9/19.
 */
@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    private DiscoveryClient client;

    @Qualifier("discoveryClient")
    @Autowired
    public void setClient(DiscoveryClient client) {
        this.client = client;
    }

//    @Autowired
//    Registration registration;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
//        client.getServices().forEach(id -> client.getInstances(id).forEach(
//                instance -> logger.info("/add, host:" + instance.getHost()
//                        + ", service_id:" + instance.getServiceId()))
//        );

        ServiceInstance instance = client.getLocalServiceInstance();
        Integer sum = a + b;
        logger.info("/add, host:" + instance.getHost()
                + ", serviceId:" + instance.getServiceId()
                + ", result:" + sum);
        return sum;
    }
}
