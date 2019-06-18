package com.miyanaqy.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

@Component
public class AsynTask {

    @Autowired
    private RedisTemplate<String, String> template;

    @Async
    public void responsetask(String order) throws InterruptedException{
        ValueOperations<String, String> opsForValue = template.opsForValue();
        for(int i =0 ;i<10 ;i++)
        {
            String qr = opsForValue.get(order);
            if(qr != null){
                JSONObject jsonObject=JSONObject.fromObject(qr);
            }
            Thread.sleep(300);
        }
    }
}
