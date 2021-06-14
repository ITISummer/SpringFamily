# 前言
[根据尚硅谷 spring-security 课程学习](https://www.bilibili.com/video/BV15a411A7kP)

[更完整源码资料领取 提取码: 8op3](https://pan.baidu.com/s/1Kg7UUpO3wwALX6x28cWA7A#list/path=%2F)

# 项目环境说明
1. 项目 springboot 版本应该为 2.2.1

2. JDK 1.8
3. maven 3.6.1
4. [项目使用的 nacos 版本和项目前端代码(vue) - 点击下载 提取码：ii8q ](https://pan.baidu.com/s/1gEhWs8qQulm7mVC4cY5fYw)



## 参考文档：

[启动spring-boot出现Error creating bean with name ‘configurationPropertiesBeans‘ defined in class的报错](https://blog.csdn.net/qq_34046046/article/details/109853508)


[bean creation error when starting spring boot application](https://stackoverflow.com/questions/65181495/bean-creation-error-when-starting-spring-boot-application)

[Error creating bean with name ‘configurationPropertiesBeans‘ defined in class path resource异常分析](https://blog.csdn.net/zlbdmm/article/details/111202052)

```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
<!--        <version>2.4.4</version>-->
        <version>2.2.1.RELEASE</version>
<!--        <version>2.2.3</version>-->
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
```

# 项目模块结构

<img src="C:\Users\LCX\AppData\Roaming\Typora\typora-user-images\image-20210329150106586.png" alt="image-20210329150106586" style="zoom: 80%;" />

## acl_parent 模块

为此项目的根模块，其下包含 common, infrastructure, com.itis.springcloud.service 模块

## common 模块

包含 service_base 和 spring_security 模块。

### service_base 模块

主要处理一些公共操作，例如异常处理，公共返回对象，还有一些配置，如redis配置，swagger 配置等

<img src="C:\Users\LCX\AppData\Roaming\Typora\typora-user-images\image-20210330104941686.png" alt="image-20210330104941686" style="zoom:80%;" />

### spring_security 模块

主要配置 security 需要用到的一些内容，例如：jwt token，登录登出请求的处理，将权限存入 redis 等

<img src="C:\Users\LCX\AppData\Roaming\Typora\typora-user-images\image-20210330111912347.png" alt="image-20210330111912347" style="zoom:80%;" />