package packages.dao;


import org.apache.ibatis.annotations.*;
import packages.proj.stu;

import java.util.ArrayList;


//@mapper注解将Java与MySQL语言联系起来,相互映射
@Mapper
public interface stuMapper {

    String str1="select * from stu";

    String str2="select * from stu where id=#{id}";

    String str3="select * from stu where name=#{name}";

    String str4="INSERT INTO stu (gender, name, score, email) VALUES (#{s.gender}, #{s.name}, #{s.score}, #{s.email})";

    String str5="delete from stu where name=#{name}";

    String str6="UPDATE stu SET score = #{score} WHERE name = #{name}";

    String str7="SELECT * FROM stu LIMIT #{start},#{size}";

    String str8="select * from stu order by score desc";
    String str9="select * from stu order by score asc";

    String str10="select count(*) from stu";


    @Select(str1)
    ArrayList<stu> selectAll();

    @Select(str2)
    stu selectById(int id);

    @Select(str3)
    ArrayList<stu> selectByName(String name);

    //返回表中受影响的行数
    @Insert(str4)
    int insertStu(@Param("s") stu s);


    @Delete(str5)
    int deleteByName(String name);

    @Update(str6)
    int updateByName(String name,int score);


    @Select(str7)
    ArrayList<stu> selectByPage(int start,int size);


    @Select(str8)
    ArrayList<stu> orderByDesc();

    @Select(str9)
    ArrayList<stu> orderByAsc();

    @Select(str10)
    int Count();


}
