一、SpringBoot入门

SpringBoot简介

    简化Spring应用开发的一个框架；
    整个Sring技术站的一个大整合；
    J2EE开发的一站式解决方案；
    
微服务

    是一种架构风格，一个应用应该是一组小型服务；可以通过HTTP的方式进行互通；
    单体应用：All in one
    每一个功能元素最终都是一个可独立替换和独立升级的软件单元
    
spring boot项目

    父项目：
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    	 
    父项目的父项目是
    
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>2.1.4.RELEASE</version>
        <relativePath>../../spring-boot-dependencies</relativePath>
    </parent>
    来真正管理boot应里面的所有依赖版本
    SpringBoot的版本仲裁中心；
    以后我们导入依赖默认是不需要写版本的；（没有在dependency里面管理的依赖自然需要声明版本号)
    
    
    导入的依赖：
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    
    spring-boot-starter-web：
    spring-boot-starter:Spring-boot场景启动器；帮我们导入了web模块正常运行所依赖的组件。
    
    SpringBoot将所有的功能场景都抽取出来，做成一个个的starter（启动器)，只需要在项目里面引入这些starter相场景的所有依赖都会导入进来。要用什么功能就导入什么功场景的启动器
    
主程序类
    @SpringBootApplication 来标注一个主程序类，说明这是一个SpringBoot应用；SpringBoot就应该运行这个类main方法来启动boot应用
    他是一个组合注解：
    @SpringBootConfiguration:SpingBoot的配置类；
    
