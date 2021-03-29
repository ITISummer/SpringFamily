# 前言
[根据尚硅谷 spring-security 课程学习](https://www.bilibili.com/video/BV15a411A7kP)

[更完整源码资料领取 提取码: 8op3](https://pan.baidu.com/s/1Kg7UUpO3wwALX6x28cWA7A#list/path=%2F)

# 项目环境说明
项目 springboot 版本应该为 2.2.1

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

