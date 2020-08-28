//package com.gw.rabbitmqDemo;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author: guo wei
// * 2020-07-06
// */
//public class Consumer implements RabbitTemplate.ReturnCallback {
//     private static final Logger log = LoggerFactory.getLogger(Consumer.class);
//    @Autowired
////    private AmqpTemplate amqpTemplate;
//    private RabbitTemplate rabbitTemplate;
//    @Override
//    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
//        log.info(">>>>>>>>>接收到消费端回应，消息已被退回，未正常消费,当前时间为:"+ LocalDateTime.now() +"<<<<<<");
//    }
//
//    public ResponseEntity send() {
//        try {
//            String msg = "你好，jklove ！" ;
//            //参数====》 交换机 routingKey  信息
////            amqpTemplate.convertAndSend("TEST.EXCHANGE", "myKey", msg);
//            log.info(">>>>>>>开始发送信息: 当前时间为: " + LocalDateTime.now() + "<<<<<<<");
//
//            //设置手动ack
//            rabbitTemplate.setReturnCallback(this);
//            rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//                if (!ack) {
//                    log.info(">>>>>>消息发送失败,原因:" + cause + correlationData.toString());
//                } else {
//                    log.info(">>>>>>>消息发送成功，当前时间为:"+ LocalDateTime.now());
//                }
//            });
//
//            // 交换机 routingKey 信息
//            rabbitTemplate.convertAndSend("TEST.EXCHANGE", "myKey",msg );
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//    //延迟订单
//    public ResponseEntity createOrder(String message) {
//        Map<String, Object> msg = new HashMap<>();
//        msg.put("order", "我是订单信息");
//        msg.put("reject", message);
//        try {
//            //设置手动ack
//            rabbitTemplate.setReturnCallback(this);
//            rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//                if (!ack) {
//                    log.info(">>>>>>消息发送失败,原因:" + cause + correlationData.toString());
//                } else {
//                    log.info(">>>>>>>消息发送成功，当前时间为:"+ LocalDateTime.now());
//                }
//            });
//            //发送给延迟交换机
//            rabbitTemplate.convertAndSend("X-Exchange-ttl","ttl",msg);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//
//    }
//}
