package packages.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packages.dao.stuMapper;
import packages.proj.stu;

import java.util.ArrayList;

@Service
public class stuService {

    @Autowired
    private stuMapper sm;


    public int Count(){
        return sm.Count();
    }

    public ArrayList<stu> searchAll(){
        return sm.selectAll();
    }


    public ArrayList<stu> searchByName(String name){
        if(name==null)
            return  null;
        else
            return sm.selectByName(name);
    }

    public boolean save(stu s){
        return sm.insertStu(s)>0;
    }

    public boolean deleteByName(String name){
        return sm.deleteByName(name)>0;
    }

    public boolean updateByName(String name,int score){
      return sm.updateByName(name,score)>0;
    }
    public ArrayList<stu> searchForPage(int start,int size){
        return sm.selectByPage(start, size);
    }


    public ArrayList<stu> desc(){
        return sm.orderByDesc();
    }

    public ArrayList<stu> asc(){
        return sm.orderByAsc();
    }


}
