package Inherit.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * author: zijiezhou
 * Date:   2020/10/9 14:49
 * Description:
 */
public class ReflectionTest {
    public static void main(String[] args) {

        String name;
        //Args[ ]  数组的作用是接受命令行的参数，然后在程序运行的时候进行参数的传递。在使用是可以直接像用数组那样来用。如果不传递参数，则参数为空。
        //即在使用命令行java运行java程序时可以在class后面带上需要输入的参数
        //例如  java Reflection 123 456 789  这样args[]数组中的数值即为 123 456 789
        if(args.length > 0){
            name = args[0];
        }
        else{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Data):");
            name = in.next();
        }

        try {
            Class cl = Class.forName(name);
            //获取该类的父类
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if(modifiers.length() > 0 ){
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name );
            if(supercl != null && supercl != Object.class){
                System.out.print("extends " + supercl.getName());
            }

            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");

        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * print all constructors of a class
     * @param cl
     */
    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();

        for(Constructor c : constructors){

            String name = c.getName();
            System.out.print("    ");
            //做 getModifiers 的方法， 它将返回一个整型数值，用不同的位开关描述 public 和 static 这样 的修饰符使用状况
            //getModifiers()会返回特定的字节码，接着使用Modifier.toString（int mod）来解释此字节码吗mod，会返回修饰符的字符串形式。
            String modifiers = Modifier.toString(c.getModifiers());
            /*针对数组提供了length属性来获取数组的长度
              针对字符串提供了length()方法来获取字符串的长度*/
            if(modifiers.length() > 0){
                System.out.print(modifiers + "  ");
            }
            System.out.print(name + "(");
            //getParameterTypes()方法是用来获取方法形参类型的
            Class[] paramTypes = c.getParameterTypes();
            for(int j = 0; j < paramTypes.length; j++ ){
                if (j > 0){
                    System.out.print(", ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * prints all methods of a class
     * @param cl
     */
    public static void printMethods(Class cl){
        Method[] methods = cl.getDeclaredMethods();

        for(Method m : methods){
            //获取方法返回类型--m.getReturnType()
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }

            System.out.print(retType.getName() + " " + name + "(");
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length ; i++) {
                if(i > 0){
                    System.out.print(", ");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Prints all fields of a class
     * @param cl
     */
    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();

        for(Field f : fields){

            Class type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0){
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
