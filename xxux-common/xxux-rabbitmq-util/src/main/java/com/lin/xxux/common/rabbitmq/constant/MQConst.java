package com.lin.xxux.common.rabbitmq.constant;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 22:24
 */
public class MQConst {
    /**
     * 消息补偿
     */
    public static final String MQ_KEY_PREFIX = "xxux.mq:list";
    public static final int RETRY_COUNT = 3;

    /**
     * 商品上下架
     */
    public static final String EXCHANGE_GOODS_DIRECT = "xxux.goods.direct";
    public static final String ROUTING_GOODS_UPPER = "xxux.goods.upper";
    public static final String ROUTING_GOODS_LOWER = "xxux.goods.lower";
    //队列
    public static final String QUEUE_GOODS_UPPER  = "xxux.goods.upper";
    public static final String QUEUE_GOODS_LOWER  = "xxux.goods.lower";

    /**
     * 团长上下线
     */
    public static final String EXCHANGE_LEADER_DIRECT = "xxux.leader.direct";
    public static final String ROUTING_LEADER_UPPER = "xxux.leader.upper";
    public static final String ROUTING_LEADER_LOWER = "xxux.leader.lower";
    //队列
    public static final String QUEUE_LEADER_UPPER  = "xxux.leader.upper";
    public static final String QUEUE_LEADER_LOWER  = "xxux.leader.lower";

    //订单
    public static final String EXCHANGE_ORDER_DIRECT = "xxux.order.direct";
    public static final String ROUTING_ROLLBACK_STOCK = "xxux.rollback.stock";
    public static final String ROUTING_MINUS_STOCK = "xxux.minus.stock";

    public static final String ROUTING_DELETE_CART = "xxux.delete.cart";
    //解锁普通商品库存
    public static final String QUEUE_ROLLBACK_STOCK = "xxux.rollback.stock";
    public static final String QUEUE_SECKILL_ROLLBACK_STOCK = "xxux.seckill.rollback.stock";
    public static final String QUEUE_MINUS_STOCK = "xxux.minus.stock";
    public static final String QUEUE_DELETE_CART = "xxux.delete.cart";

    //支付
    public static final String EXCHANGE_PAY_DIRECT = "xxux.pay.direct";
    public static final String ROUTING_PAY_SUCCESS = "xxux.pay.success";
    public static final String QUEUE_ORDER_PAY  = "xxux.order.pay";
    public static final String QUEUE_LEADER_BILL  = "xxux.leader.bill";

    //取消订单
    public static final String EXCHANGE_CANCEL_ORDER_DIRECT = "xxux.cancel.order.direct";
    public static final String ROUTING_CANCEL_ORDER = "xxux.cancel.order";
    //延迟取消订单队列
    public static final String QUEUE_CANCEL_ORDER  = "xxux.cancel.order";

    /**
     * 定时任务
     */
    public static final String EXCHANGE_DIRECT_TASK = "xxux.exchange.direct.task";
    public static final String ROUTING_TASK_23 = "xxux.task.23";
    //队列
    public static final String QUEUE_TASK_23  = "xxux.queue.task.23";
}
