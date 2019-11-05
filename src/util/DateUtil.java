package util;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: hutubill
 * @description: 日期工具类
 * @author: youzhou
 * @create: 2019-10-30 21:23
 **/
public class DateUtil {
    static long millisecondsOfOneDay = 1000 * 60 * 60 * 24;

    /**
     * @Description: 日期类型转换
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/30
     * @Time: 21:24
     */
    public static java.sql.Date util2sql(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

    /**
     * @Description: 通过日期控件获取到日期
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/30
     * @Time: 21:26
     */
    public static Date today() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * @Description: 获取月初
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/30
     * @Time: 21:30
     */
    public static Date monthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    /**
     * @Description: 获取月末
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/30
     * @Time: 21:29
     */
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    /**
     * @Description: 获取本月的总天数
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/30
     * @Time: 21:32
     */
    public static int thisMonthTotalDay() {

        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();

        return (int) ((lastDayMilliSeconds - firstDayMilliSeconds) / millisecondsOfOneDay) + 1;
    }

    /**
     * @Description: 获取本月的剩余天数
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/10/30
     * @Time: 21:33
     */
    public static int thisMonthLeftDay() {
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        return (int) ((lastDayMilliSeconds - toDayMilliSeconds) / millisecondsOfOneDay) + 1;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.monthEnd());
    }
}
