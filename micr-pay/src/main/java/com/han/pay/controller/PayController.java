package com.han.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * han
 * 2021/10/25
 */
@Controller
public class PayController {
    //跳转快钱支付页面
    @GetMapping("/kq/receive")
    public String KqReceive(){
        return "kqForm";
    }
}
