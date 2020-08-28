package com.gw.rabbitmqDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: guo wei
 * 2020-07-06
 */
@RestController
@RequestMapping("/test")
public class Controller {
    @Autowired
    private SenderService service;

    @GetMapping("/send")
    public void send() {
        service.sender("good");
    }

    @GetMapping("/sendFanout")
    public void sendFanout() {
        service.senderFanout("fanout");
    }
    @GetMapping("/sendTopic")
    public void sendTopic() {
        service.senderTopic("topic");
    }


//    @Autowired
//    private Consumer Consumer;
//
//    @GetMapping("/do/send")
//    public ResponseEntity send() {
//        return Consumer.send();
//    }

//    @GetMapping("/order")
//    public ResponseEntity createOrder(@RequestParam("msg")String msg) {
//        return Consumer.createOrder(msg);
//    }
}
