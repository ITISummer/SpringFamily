package com.ITIS.utils.utils;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
public class CRModel {
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
    private CRModel() {}

    //静态方法 - 成功
    public static CRModel ok() {
        CRModel r = new CRModel();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    //静态方法 - 失败
    public static CRModel error() {
        CRModel r = new CRModel();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("失败");
        return r;
    }

    public CRModel success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public CRModel message(String message){
        this.setMessage(message);
        return this;
    }

    public CRModel code(Integer code){
        this.setCode(code);
        return this;
    }

    public CRModel data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public CRModel data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
