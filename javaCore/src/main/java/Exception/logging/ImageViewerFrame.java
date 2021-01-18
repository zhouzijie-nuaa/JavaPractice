package Exception.logging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Logger;

/**
 * author: zijiezhou
 * Date:   2020/10/20 15:49
 * Description:
 */
public class ImageViewerFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("Exception.loggging");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.entering("ImageViewerFrame", "actionPerformed", e);

                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("."));
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(e -> {logger.fine("Exiting.");System.exit(0);});

        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame","<init>");
    }

}


