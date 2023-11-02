package packages.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import packages.proj.responseData;


//用来告诉前端,后端服务器有可能出现的异常
@RestControllerAdvice
public class exceptionAdvice {

    //可以定义不同类型的异常来分别处理
    @ExceptionHandler(Exception.class)
    public responseData handleException(Exception e){
        responseData ret=new responseData();
        ret.setFlag(false);
        ret.setMsg("您的网络有问题");


        
        //在控制台展示异常便于调试
        e.printStackTrace();


        return ret;
    }


}
