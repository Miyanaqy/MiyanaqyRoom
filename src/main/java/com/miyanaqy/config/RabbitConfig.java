package com.miyanaqy.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private  String uhost;
    @Value("${spring.rabbitmq.port}")
    private  int port;
    @Value("${spring.rabbitmq.username}")
    private  String username;
    @Value("${spring.rabbitmq.password}")
    private  String password;

    @Value("${params.Rabbitmq.ExchangeName}")
    private String exchangeName;

    @Value("${params.Rabbitmq.QueueName}")
    private String queueName;

    private AmqpAdmin amqpAdmin;
    @Autowired
    public void setAmqpAdmin(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    /**
     *  项目启动即能创建的Exchange
     *  可以创建各种类型的Exchange，父类都是 AbstractExchange
     *  这里举例Topic类型
     *  如果需要创建多个同类型可以用@Bean(name="beanName")，引用时用@Qualifier("beanName" )
     */
    @Bean
    public TopicExchange exchange(){
        TopicExchange dataExchange = new TopicExchange(exchangeName,true,false);
        amqpAdmin.declareExchange(dataExchange);
        return dataExchange;
    }

    /**
     * 项目创建就生成的Queue
     * @return
     */
    @Bean
    public Queue queue(){
        Queue queue = new Queue(queueName,true,false,false);
        amqpAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    public Queue test(){
        Queue queue = new Queue("lcTest",true,false,false);
        amqpAdmin.declareQueue(queue);
        return queue;
    }


}
