package com.ITIS.SpringSecurityDemo1.controller;

import com.ITIS.SpringSecurityDemo1.entity.Users;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello security";
    }

    @GetMapping("index")
    public String index() {
        return "hello index";
    }
//
//    @GetMapping("update")
//    //@Secured({"ROLE_sale","ROLE_manager"})
//    //@PreAuthorize("hasAnyAuthority('admins')")
//    @PostAuthorize("hasAnyAuthority('admins')")
//    public String update() {
//        System.out.println("update......");
//        return "hello update";
//    }
//
//    @GetMapping("getAll")
////   在方法执行后验证
//    @PostAuthorize("hasAnyAuthority('admins')")
//    //在执行方法前对数据进行过滤
////    @PreFilter("filterObject.username == 'admin1'")
//    //对返回数据进行过滤
//    @PostFilter("filterObject.username == 'admin1'")
////    @Secured({"ROLE_sale","ROLE_manager"})
////    在方法执行前进行验证
////    @PreAuthorize("hasAuthority('admin')")
//    public List<Users> getAllUser(){
//        List<Users> list = new ArrayList<>();
//        list.add(new Users(11,"admin1","6666"));
//        list.add(new Users(21,"admin2","888"));
//        System.out.println(list);
//        return list;
//    }


}
