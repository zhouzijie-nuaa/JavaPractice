package Inherit.objectAnalyzer;

import java.util.ArrayList;

/**
 * author: zijiezhou
 * Date:   2020/10/10 17:23
 * Description:
 */
public class ObjextAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5 ; i++) {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
