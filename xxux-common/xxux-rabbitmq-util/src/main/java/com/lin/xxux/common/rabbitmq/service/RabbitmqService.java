package com.lin.xxux.common.rabbitmq.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 22:11
 */
@Service
public class RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param exchange
     * @param routingKey
     * @param message
     */
    public boolean sendMessage(String exchange,String routingKey,Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        return true;
    }

    /**
     * 发送延迟消息
     * @param exchange
     * @param routingKey
     * @param message
     * @param delayTime
     */
    public boolean sendDelayMessage(String exchange,String routingKey,Object message,int delayTime) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message, msg -> {
                msg.getMessageProperties().setDelay(delayTime * 1000);
                return msg;
        });
        return true;
    }
}
