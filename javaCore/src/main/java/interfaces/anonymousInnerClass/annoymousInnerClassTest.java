package interfaces.anonymousInnerClass;

import javax.swing.*;

/**
 * author: zijiezhou
 * Date:   2020/10/17 16:23
 * Description:
 */
public class annoymousInnerClassTest {

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000,true);
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}
