package com.atguigu.order.model;


/**
 *  <p> 响应码枚举 - 可参考HTTP状态码的语义 </p>
 * @author moli
 * @since 2023-05-05
 */
public enum ResultCode {
    /**
     * 操作成功
     */
    SUCCESS( 200, "操作成功!" ),
    /**
     * 操作失败
     */
    FAILURE( 400, "操作失败!" );

    public int code;
    public String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


