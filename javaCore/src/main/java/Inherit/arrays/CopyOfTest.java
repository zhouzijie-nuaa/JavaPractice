package Inherit.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * author: zijiezhou
 * Date:   2020/10/12 14:50
 * Description:
 */
public class CopyOfTest {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[])goodCopyOf(1, 10);
        System.out.println(Arrays.toString(a));

        String[] b ={"Tom","Dick","Harry"};
        b= (String[])goodCopyOf(b,10);
        //如果不调用Arrays。tostring（）的方法，数组类型的tostring方法将会打印类名和其的散列表
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b = (String[])badCopyOf(b,10);
    }

    /**
     * this method attempts to grow an array by allocating a new array and copying all elements
     * @param a
     * @param newLenth
     * @return
     */
    public static Object[] badCopyOf(Object[] a, int newLenth){
        Object[] newArray = new Object[newLenth];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLenth));
        return newArray;
    }

    /**
     * this method grows an array by allocationg a new array of the same type and copying all elements
     * @param a
     * @param newlenth
     * @return
     */
    public static Object goodCopyOf (Object a, int newlenth){
        Class cl = a.getClass();
        if (!cl.isArray())
        {
            return  null;
        }
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newlenth);
        System.arraycopy(a, 0, newArray, 0, Math.min(length,newlenth));
        return newArray;
    }
}
