//package com.gw.rabbitmqDemo;
//
//import com.rabbitmq.client.ConfirmCallback;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//
///**
// * @Author: guo wei
// * 2020-07-15
// * <p>
// * 通过实现 ConfirmCallback 接口，消息发送到 Broker 后触发回调，确认消息是否到达 Broker 服务器，
// * 也就是只确认是否正确到达 Exchange 中
// */
//public class RabbitMqTemplateConfig implements RabbitTemplate.ConfirmCallback {
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @PostConstruct
//    public void init() {
//        //指定 ConfirmCallback
//        rabbitTemplate.setConfirmCallback(this);
//
//    }
//
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println("消息唯一标识：" + correlationData);
//        System.out.println("确认结果：" + ack);
//        System.out.println("失败原因：" + cause);
//    }
//
//
//}
