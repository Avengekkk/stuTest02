package packages.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import packages.proj.stu;

import java.util.ArrayList;
import java.util.Collection;


@SpringBootTest
public class serviceTest {

    @Autowired
    private  stuService ss;


    @Test
    void searchALL(){
        ArrayList<stu> stus = ss.searchAll();
        for(stu s:stus)
            System.out.println(s);
    }


    @Test
    void searchByName(){
        String name="汪昊";
        ArrayList<stu> stu = ss.searchByName(name);
        System.out.println(stu);
    }

    @Test
    void save(){

        stu s=new stu(null,"男","猪八戒",0,"zhu@qq.com");
        if(ss.save(s))
            System.out.println("success");
        else
            System.out.println("fault");
        //System.out.println(s);
    }



}
