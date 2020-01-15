package com.macro.mall.portal.component;

public class AlipayConfig {

    // 1.商户appid
    public static String APPID = "20190.......";

    // 2.私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "4HPo2O+dTYVyp2SNZ8xMpwJGBx/Y1hJu1f79GhRsx+9rEpFEiGoty1hMwo7NAXEXeLIP7GjaQQP95+AlizjfqtWil7x/c0vzHY+USn0BTM8Dg28jM6brSZ+k76miqw88uhnNZnenWvrYHRJQu3mm5Sp75CMyn5yZ4banhGxVdXucC2Qv23tYsJbwEPYaARiOAHXtVrsz8vZ0DmGrR2yHIqqmFOVzHsJdYaiiGsE0sKaq3g7LmlXrqdSCvgUaKORWPdCEaWO3hQYtaRoDA3Tmdqwo0cEJtr0rNTLKpt0LAgMBAAECggEAD0RzXDFt8Z6ITs83gsmkEbIYmnvdcXK81SS1gfupSzejGvyKj/oXyL1FCEH6/f2IABxHM5OW2dNTy9dh0HAprpJNGHOpMtfkfLr6M9DcpchGikwPHWMXezJl1+/xj3pThvJ8ZdOYIP8kp/HOSf16RH5i1IUe4N1hPJuWRBRj/+nJ3k7wbfJvG7SMWUOmuTi9iGaSwFBVKnirIubDMrbGjOXW8FU2xz6IWqkTWXiRWkhOhd6lUA21QqjikQxF3LsrmIRV3mieTYbjpmr71nTkh590bEnIBbDQQL10s433HbXTL5PVdYOBZU/j+FQewBbNTpMVDQ+f+tEKTk9MwMOuKQKBgQDqxAawGdLuX8rTJuskc9DcDY1CqXs+jydlgxKNttwIc8BipW00j0JC+y7n+Jw2XqDqS5RZk9qD0AUDdG0BC81H";

    // 3.支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "a6Hd6aeqN7mTAKoZcArHnwWjtaGok312sFyY0tNgXTeG9fVE/2X";

    // 4.服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://xxx/appAlipay/notifyUrl";

    // 5.页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 商户可以自定义同步跳转地址
    public static String return_url = "http://xxx/return_url.do";
    
    // 6.请求支付宝的网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";

    // 7.编码
    public static String CHARSET = "UTF-8";

    // 8.返回格式
    public static String FORMAT = "json";
    
    // 9.加密类型
    public static String SIGNTYPE = "RSA2";

}
