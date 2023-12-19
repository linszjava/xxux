package com.lin.xxux.service.user.entity;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/31 23:01
 */
@Component
public class WeChatProperties implements InitializingBean {

    @Value("${wx.open.app_id}")
    private String appId;

    @Value("${wx.open.app_secret}")
    private String appSecret;

    public static String WX_OPEN_APP_ID;

    public static String WE_OPEN_APP_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        WX_OPEN_APP_ID = appId;
        WE_OPEN_APP_SECRET = appSecret;
    }
}
