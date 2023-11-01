package packages.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import packages.dao.stuMapper;
import packages.proj.stu;

import java.util.ArrayList;

@SpringBootTest
class StuTestApplicationTests {


    @Autowired
    private stuMapper sm;
    @Test
    void contextLoads() {



    }


    @Test
    void selectByPage(){
        ArrayList<stu> stus = sm.selectByPage(0, 3);
        for(stu s:stus){
            System.out.println(s);
        }
    }

    @Test
    void selectAll(){
        ArrayList<stu> stus = sm.selectAll();
        for (stu stu : stus) {
            System.out.println(stu);
        }
    }


    @Test
    void selectByID(){
        stu stu = sm.selectById(1);
        System.out.println(stu);
    }

    @Test
    void selectByName(){
        String name="汪昊";
        ArrayList<stu> stu = sm.selectByName(name);
        System.out.println(stu);
    }


    @Test
    void insertStu(){
        stu s=new stu(null,"男","唐僧",0, "tang@qq.com");
        int i = sm.insertStu(s);
        if(i>0)
            System.out.println("insert success");
        else
            System.out.println("insert fault");
    }


    @Test
    void deleteByName(){
        String name="孙悟空";
        int i = sm.deleteByName(name);
        if(i>0)
            System.out.println("insert success");
        else
            System.out.println("insert fault");
    }

    @Test
    void updateByName(){
        String name="管维佳";
        int score=66;
        int i = sm.updateByName(name, score);
        if(i>0)
            System.out.println("insert success");
        else
            System.out.println("insert fault");
    }



}
