package interfaces.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * author: zijiezhou
 * Date:   2020/10/17 15:30
 * Description:
 */
public class TalkingClock {

    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class TimerPrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is" + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

}
