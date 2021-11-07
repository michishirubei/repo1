package com.han.pay.service;

import com.han.pay.util.Pkipair;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * han
 * 2021/10/25
 */
public class PayService {
    public Map<String, String> getFormData(String userId, String phone, String ylbOrderId, String yuan) {
        //人民币网关账号，该账号为11位人民币网关商户编号+01,该参数必填。
        String merchantAcctId = "1001214035601";//
        //编码方式，1代表 UTF-8; 2 代表 GBK; 3代表 GB2312 默认为1,该参数必填。
        String inputCharset = "1";
        //接收支付结果的页面地址，该参数一般置为空即可。
        String pageUrl = "";
        //服务器接收支付结果的后台地址，该参数务必填写，不能为空。
        String bgUrl = "http://192.168.46.250:8801/RMBPORT/receive.jsp";
        //网关版本，固定值：v2.0,该参数必填。
        String version = "v2.0";
        //语言种类，1代表中文显示，2代表英文显示。默认为1,该参数必填。
        String language = "1";
        //签名类型,该值为4，代表PKI加密方式,该参数必填。
        String signType = "4";
        //支付人姓名,可以为空。
        String payerName = "";
        //支付人联系类型，1 代表电子邮件方式；2 代表手机联系方式。可以为空。
        String payerContactType = "2";
        //支付人联系方式，与payerContactType设置对应，payerContactType为1，则填写邮箱地址；payerContactType为2，则填写手机号码。可以为空。
        String payerContact = phone;
        //指定付款人，可以为空
        String payerIdType = "3";
        //付款人标识，可以为空
        String payerId = userId;
        //付款人IP，可以为空
        String payerIP = "";
        //商户订单号，以下采用时间来定义订单号，商户可以根据自己订单号的定义规则来定义该值，不能为空。
        String orderId = ylbOrderId;
        //订单金额，金额以“分”为单位，商户测试以1分测试即可，切勿以大金额测试。该参数必填。
        String orderAmount = new BigDecimal(yuan).multiply(new BigDecimal("100")).stripTrailingZeros().toPlainString();
        //订单提交时间，格式：yyyyMMddHHmmss，如：20071117020101，不能为空。
        String orderTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        //快钱时间戳，格式：yyyyMMddHHmmss，如：20071117020101， 可以为空
        String orderTimestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        ;
        //商品名称，可以为空。
        String productName = "Apple";
        //商品数量，可以为空。
        String productNum = "1";
        //商品代码，可以为空。
        String productId = "10000";
        //商品描述，可以为空。
        String productDesc = "Apple";
        //扩展字段1，商户可以传递自己需要的参数，支付完快钱会原值返回，可以为空。
        String ext1 = "扩展1";
        //扩展自段2，商户可以传递自己需要的参数，支付完快钱会原值返回，可以为空。
        String ext2 = "扩展2";
        //支付方式，一般为00，代表所有的支付方式。如果是银行直连商户，该值为10-1或10-2，必填。
        String payType = "00";
        //银行代码，如果payType为00，该值可以为空；如果payType为10-1或10-2，该值必须填写，具体请参考银行列表。
        String bankId = "";
        //同一订单禁止重复提交标志，实物购物车填1，虚拟产品用0。1代表只能提交一次，0代表在支付不成功情况下可以再提交。可为空。
        String redoFlag = "0";
        //快钱合作伙伴的帐户号，即商户编号，可为空。
        String pid = "";

        // signMsg 签名字符串 不可空，生成加密签名串
        String signMsgVal = "";
        Map<String, String> map = new HashMap<>();
        signMsgVal = appendParam(signMsgVal, "inputCharset", inputCharset,map);
        signMsgVal = appendParam(signMsgVal, "pageUrl", pageUrl,map);
        signMsgVal = appendParam(signMsgVal, "bgUrl", bgUrl,map);
        signMsgVal = appendParam(signMsgVal, "version", version,map);
        signMsgVal = appendParam(signMsgVal, "language", language,map);
        signMsgVal = appendParam(signMsgVal, "signType", signType,map);
        signMsgVal = appendParam(signMsgVal, "merchantAcctId", merchantAcctId,map);
        signMsgVal = appendParam(signMsgVal, "payerName", payerName,map);
        signMsgVal = appendParam(signMsgVal, "payerContactType", payerContactType,map);
        signMsgVal = appendParam(signMsgVal, "payerContact", payerContact,map);
        signMsgVal = appendParam(signMsgVal, "payerIdType", payerIdType,map);
        signMsgVal = appendParam(signMsgVal, "payerId", payerId,map);
        signMsgVal = appendParam(signMsgVal, "payerIP", payerIP,map);
        signMsgVal = appendParam(signMsgVal, "orderId", orderId,map);
        signMsgVal = appendParam(signMsgVal, "orderAmount", orderAmount,map);
        signMsgVal = appendParam(signMsgVal, "orderTime", orderTime,map);
        signMsgVal = appendParam(signMsgVal, "orderTimestamp", orderTimestamp,map);
        signMsgVal = appendParam(signMsgVal, "productName", productName,map);
        signMsgVal = appendParam(signMsgVal, "productNum", productNum,map);
        signMsgVal = appendParam(signMsgVal, "productId", productId,map);
        signMsgVal = appendParam(signMsgVal, "productDesc", productDesc,map);
        signMsgVal = appendParam(signMsgVal, "ext1", ext1,map);
        signMsgVal = appendParam(signMsgVal, "ext2", ext2,map);
        signMsgVal = appendParam(signMsgVal, "payType", payType,map);
        signMsgVal = appendParam(signMsgVal, "bankId", bankId,map);
        signMsgVal = appendParam(signMsgVal, "redoFlag", redoFlag,map);
        signMsgVal = appendParam(signMsgVal, "pid", pid,map);



        System.out.println(signMsgVal);

        Pkipair pki = new Pkipair();
        //加入私钥生成签名串
        String signMsg = pki.signMsg(signMsgVal);
        //将签名串放到map中
        map.put("signMsg", signMsg);
        return map;
    }

    public String appendParam(String returns, String paramId, String paramValue,Map<String,String> map) {
        if (returns != "" && returns != null) {
            if (paramValue != "" && paramValue != null) {
                returns += "&" + paramId + "=" + paramValue;
                if (map != null) {
                    map.put(paramId, paramValue);
                }
            }

        } else {
            if (paramValue != "" && paramValue != null) {
                returns = paramId + "=" + paramValue;
                if (map != null) {
                    map.put(paramId, paramValue);
                }
            }
        }

        return returns;
    }
}
