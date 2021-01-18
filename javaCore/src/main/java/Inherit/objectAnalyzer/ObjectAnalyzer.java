package Inherit.objectAnalyzer;



import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * author: zijiezhou
 * Date:   2020/10/10 17:26
 * Description:
 */
public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj){
        if(obj == null){
            return "null";
        }
        if(visited.contains(obj)){
            return "...";
        }
        visited.add(obj);
        Class cl = obj.getClass();
        if(cl == String.class){
            return (String)obj;
        }
        //判断该类型是否为数组类型
        if(cl.isArray()){
            //getComponentType:返回数组类型的class类型
            String r = cl.getComponentType() + "[]{";
            //注：这里Array是java.lang.reflect.Array类
            for(int i = 0; i < Array.getLength(obj); i++){
                if(i > 0){
                    r += ",";
                }
                Object val = Array.get(obj, i);
                //isPrimitive():判断该类型是够是8种基本类型
                if(cl.getComponentType().isPrimitive()){
                    r += val;
                }else{
                    //该处的toString()方法即为调用自己！！！递归调用
                    r += toString(val);
                }
            }
            return r + "}";
        }

        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for(Field f : fields)
            {
                if(!Modifier.isStatic(f.getModifiers()))
                {
                    if(!r.endsWith("["))
                    {
                        r += ",";
                    }
                    r += f.getName() + "=";
                    try{
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if(t.isPrimitive())
                        {
                            r += val;
                        }
                        else
                        {
                            r += toString(val);
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);
        return r;
    }
}
