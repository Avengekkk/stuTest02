package packages.proj;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//geter,setter方法用一个注解@Data可以全部概括
//来自依赖lomobok

//所有参数构造
//@AllArgsConstructor
//无参构造
//@NoArgsConstructor

@AllArgsConstructor
@Data
public class stu {

    Integer id;
    String gender;
    String name;
    int score;
    String email;


}
