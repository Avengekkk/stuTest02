package packages.proj;


import lombok.Data;

//这个实体类是用来统一返回给前端对象的格式的
@Data
public class responseData {
    private boolean flag;
    private Object data;
    private String msg;



}
