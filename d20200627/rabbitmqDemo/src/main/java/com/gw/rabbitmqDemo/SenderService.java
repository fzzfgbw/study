package com.gw.rabbitmqDemo;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: guo wei
 * 2020-07-15
 */
@Service
public class SenderService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sender(String msg) {
        System.out.println("sender" + msg);
        amqpTemplate.convertAndSend("direct0715","0715", msg);
    }

    public void senderFanout(String msg) {
        System.out.println("senderFanout" + msg);
        amqpTemplate.convertAndSend("fanout0715", "0715",msg);
    }

    public void senderTopic(String msg) {
        System.out.println("senderTopic" + msg);
        amqpTemplate.convertAndSend("topic0715", "topic.a",msg);
    }
//     * >=1  # ==1
    @RabbitListener(queues = "GW0715")
    public void process(String msg,Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println("receiver " + msg);
        try {
            channel.basicAck(tag,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "GW10715")
    public void process1(String msg, Channel channel, @Headers Map<String,Object> map) {
        System.out.println("receiver1 " + msg);
        if (map.get("error")!= null){
            System.out.println("错误的消息");
            try {
                //拒绝消息
//               channel.basicReject((Long)map.get(AmqpHeaders.DELIVERY_TAG),false);
                //否认消息,重新入队，一直消费报错
                channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,false);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            //确认消息
            channel.basicAck((Long)map.get(AmqpHeaders.DELIVERY_TAG),false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
