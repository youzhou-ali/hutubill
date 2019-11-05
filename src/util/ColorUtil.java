package util;

import java.awt.*;

/**
 * @program: hutubill
 * @description: 颜色工具类
 * @author: youzhou
 * @create: 2019-10-29 21:22
 **/
public class ColorUtil {

    public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");

    /**
    * @Description: 根据进度显示不同的颜色
    * @Param:
    * @return:
    * @Author: youzhou
    * @Date: 2019/10/29
    * @Time: 21:27
    */
    public static Color getByPercentage(int per) {
        if (per > 100)
            per = 100;
        int r = 51;
        int g = 255;
        int b = 51;
        float rate = per / 100f;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;
        Color color = new Color(r, g, b);
        return color;
    }
}
