package com.lin.xxux.common.rabbitmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>TODO 配置MQ消息转换</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 22:17
 */
@Configuration
public class MQConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
