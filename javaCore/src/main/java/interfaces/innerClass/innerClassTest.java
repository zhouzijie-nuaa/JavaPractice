package interfaces.innerClass;

import javax.swing.*;

/**
 * author: zijiezhou
 * Date:   2020/10/17 15:35
 * Description:
 */
public class innerClassTest {

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }


}
