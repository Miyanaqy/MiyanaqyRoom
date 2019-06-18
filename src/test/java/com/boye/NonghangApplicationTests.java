package com.boye;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.miyanaqy.common.utils.RabbitSendUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NonghangApplicationTests {
    @Autowired
    private RabbitSendUtil sender;

    @Test
    public void contextLoads() {
        sender.sendToQueue("hello","这是一个自定义的消息");
//       QrCodeResponse qrCodeResponse = new QrCodeResponse("1000", "abc123", null,1);
//       sender.sendToQueueObject("roberto.order.100",qrCodeResponse);


    }

}
