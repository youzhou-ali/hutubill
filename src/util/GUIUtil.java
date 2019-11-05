package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUIUtil {

    private static String imageFolder = "G:/code/hutubill/img";

    /**
     * @Description: 检验输入框内容是否为空
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/29
     * @Time: 16:55
     */
    public static boolean checkEmpty(JTextField tf, String input) {
        String text = tf.getText().trim();
        if (0 == text.length()) {
            JOptionPane.showMessageDialog(null, input + "不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * @Description: 校验一个组件内容是否是数字格式
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/29
     * @Time: 17:00
     */
    public static boolean checkNumber(JTextField tf, String input) {
        if (!checkEmpty(tf, input))
            return false;
        String text = tf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, input + "需要是整数");
            tf.grabFocus();
            return false;
        }
    }

    /**
     * @Description: 校验一个组件的内容是否是零
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/29
     * @Time: 17:02
     */
    public static boolean checkZero(JTextField tf, String input) {
        if (!checkNumber(tf, input))
            return false;
        String text = tf.getText().trim();

        if (0 == Integer.parseInt(text)) {
            JOptionPane.showMessageDialog(null, input + " 不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * @Description: 给多个组件设置前景色
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/29
     * @Time: 17:07
     */
    public static void setColor(Color color, JComponent... cs) {
        for (JComponent c : cs) {
            c.setForeground(color);
        }
    }

    /**
     * @Description: 给按钮设置图标和文本以及提示文字
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/29
     * @Time: 17:11
     */
    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    /**
     * @Description: 使用水晶皮肤
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/29
     * @Time: 17:21
     */
    public static void useLNF() {
        try {
            //原版水晶皮肤
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @Description: 快速显示一个面板的内容
     * @Param: strech 拉伸比例1表示满屏幕
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/29
     * @Time: 17:22
     */
    public static void showPanel(JPanel p, double strech) {
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(600, 600);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strech);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }

    public static void showPanel(JPanel p) {
        showPanel(p, 0.85);
    }
}
