package packages.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import packages.proj.stu;
import packages.service.stuService;
import packages.proj.responseData;

import java.util.ArrayList;



//这个注解是来配置一个日志类的来记录项目运行的相关状况
//来自于依赖lombok
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/stu")
public class stuController {

    //获得一个日志类
    //private static final Logger log=  LoggerFactory.getLogger(stuController.class);

    @Autowired
    private stuService ss;


    @GetMapping("/count")
    public responseData Count(){
        responseData ret=new responseData();
        ret.setData(ss.Count());
        ret.setFlag(true);
        return ret;
    }


    @GetMapping("/page")
    public responseData page(@RequestParam(name = "start" ,defaultValue = "0") int start, @RequestParam(name = "size",defaultValue = "5") int size) {
        responseData ret = new responseData();
        ArrayList<stu> list = ss.searchForPage(start, size);
        ret.setData(list);
        ret.setFlag(list != null);
        return ret;
    }


    //success
    @PostMapping("/all")
    public responseData all() {
        //使用日志记录程序运行情况
        log.info("info...");
        log.warn("warn...");
        log.error("error...");

        ArrayList<stu> total = ss.searchAll();
        responseData ret = new responseData();
        ret.setData(total);
        ret.setFlag(total != null);
        return ret;
    }


    //success
    @PostMapping("/add")
    public responseData addStu(@RequestBody stu s) {

        responseData ret = new responseData();
        ret.setFlag(ss.save(s));
        ret.setData(null);
        return ret;
    }


    //success
    @GetMapping("/search/{name}")
    public responseData showByName(@PathVariable String name) {
        responseData ret = new responseData();
        ret.setData(ss.searchByName(name));
        ret.setFlag(ss.searchByName(name) != null);
        return ret;
    }

    //success
    @DeleteMapping("/delete/{name}")
    public responseData deleteByName(@PathVariable String name) {
        responseData ret = new responseData();
        ret.setFlag(ss.deleteByName(name));
        ret.setData(null);
        return ret;
    }

    //success
    @PutMapping("/update/{name}")
    public responseData updateByName(@PathVariable String name, @RequestParam int score) {
        responseData ret = new responseData();
        ret.setFlag(ss.updateByName(name, score));
        ret.setData(null);
        return ret;
    }

    @GetMapping("/desc")
    public responseData selectByDesc() {
        responseData ret = new responseData();
        ArrayList<stu> list = ss.desc();
        ret.setData(list);
        ret.setFlag(list != null);
        return ret;
    }



    @GetMapping("/asc")
    public responseData selectByAsc() {
        responseData ret = new responseData();
        ArrayList<stu> list = ss.asc();
        ret.setData(list);
        ret.setFlag(list != null);
        return ret;
    }


}
