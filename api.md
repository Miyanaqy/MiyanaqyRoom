# api
## 实体
所有实体传输都是 JSON
### 二维码
```java
public class QrCodeResponse {
    public String amount;// 金额
    public String platOrderNo;// 系统订单号，后端自己生成唯一标识
    public String url;// 生成成功的二维码对应的url
    public int type;// 1为支付宝，2为微信
}
```
### 账单条目
```java
public class BillItem {
    public String tradeNo;// 支付宝或微信的订单号
    public String dateKey; // 时间
    public String tradeTransAmount;// 金额
    public String info;// 后端订单号，即 QrCodeResponse.platOrderNo
    public String appId;// 每个客户端需要手动输入唯一 appId
}
```
## RabbitMQ
账号：admin
密码：xBVHoqVVk3rI7JTA
### 二维码生成请求
服务端将生成二维码请求给客户端
QUEUE_NAME："roberto.order." + appId
bean：QrCodeResponse

## HTTP
### 回调二维码
将生成成功的二维码传给服务端
POST: /cashier/order/platformOrder/saveOrderList
BODY: QrCodeResponse
### 回调账单条目
将新账单回调给服务端
POST: /cashier/order/platformOrder/saveOrderList
BODY: BillItem