package com.miyanaqy.common.utils;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 固定订阅某个Queue,当同时订阅时，因为不是广播，所以会随机消费
 */
@Component
//@RabbitListener(queues = "hello")
public class Receiver {

//    @RabbitHandler
//    public void process(Object message) {
//        System.out.println("接收者 helloReceiver," + message.toString());
//    }

}
