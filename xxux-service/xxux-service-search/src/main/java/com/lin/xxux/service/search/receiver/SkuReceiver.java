package com.lin.xxux.service.search.receiver;

import com.lin.xxux.common.rabbitmq.constant.MQConst;
import com.lin.xxux.service.search.service.SkuService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 22:37
 */
@Component
public class SkuReceiver {

    @Autowired
    private SkuService skuService;

    /**
     * 上架商品
     * @param skuId
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.QUEUE_GOODS_UPPER,durable = "true"),
            exchange = @Exchange(value = MQConst.EXCHANGE_GOODS_DIRECT),
            key = {MQConst.ROUTING_GOODS_UPPER}
    ))
    public void upperSku(Long skuId, Message message, Channel channel) throws IOException {
        if (skuId != null) {
            skuService.upperSku(skuId);
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

    }

    /**
     * 下架商品
     * @param skuId
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.QUEUE_GOODS_LOWER,durable = "true"),
            exchange = @Exchange(value = MQConst.EXCHANGE_GOODS_DIRECT),
            key = {MQConst.ROUTING_GOODS_LOWER}
    ))
    public void lowerSku(Long skuId, Message message, Channel channel) throws IOException {
        if (skuId != null) {
            skuService.lowerSku(skuId);
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);

    }



}
