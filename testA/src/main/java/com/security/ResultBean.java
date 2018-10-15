package com.security;

/**
 * @描述 : rest接口返回bean
 * @创建人 zyh
 * @创建时间 2018/4/19
 */
public class ResultBean {

    private Boolean status = true;  //为true表示是正常返回
    private int code = 200; //状态码，小于等于200的都是正确状态
    private String msg = "succcess";    //状态描述
    private Object data;    //返回的结果集

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
