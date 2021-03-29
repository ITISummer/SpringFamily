package com.ITIS.utils.utils;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
public class R {
    /**
     * 成功还是失败
     */
    private Boolean success;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 封装返回的数据
     */
    private Map<String, Object> data = new HashMap<String, Object>();

    //把构造方法私有
    private R() {}

    //静态方法 - 成功
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    //静态方法 - 失败
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
