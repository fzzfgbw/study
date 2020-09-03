package com.gw.kafkaDemo;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kfk")
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @GetMapping("/send")
    public void sendMessage(){

        for (int i = 0; i <1 ; i++) {
            kafkaProducer.producerTest();
        }

    }
}

