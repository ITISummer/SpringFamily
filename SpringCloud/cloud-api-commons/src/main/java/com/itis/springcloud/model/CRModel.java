package com.itis.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CRModel
 * @Author LCX
 * @Date 2021 2021-06-12 8:47 p.m.
 * @Version 1.0
 * 公共返回对象，与前端通信，json 格式
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CRModel<T> {
    private Integer code;
    private String message;
    private T data;

    public CRModel(Integer code, String message){
        this(code, message,null);
    }
}
