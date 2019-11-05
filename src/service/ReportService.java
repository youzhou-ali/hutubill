package service;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: hutubill
 * @description: 报表业务类
 * @author: youzhou
 * @create: 2019-11-03 18:32
 **/
public class ReportService {

    /**
    * @Description: 获取某一天的消费金额
    * @Param:
    * @return:
    * @Author: youzhou
    * @Date: 2019/11/3
    * @Time: 20:09
    */
    public int getDaySpend(Date d, List<Record> monthRawData){
        int daySpend = 0;
        for (Record record : monthRawData) {
            if(record.getDate().equals(d))
                daySpend+=record.getSpend();
        }
        return daySpend;
    }

    /**
    * @Description: 获取一个月的消费记录集合
    * @Param:
    * @return:
    * @Author: youzhou
    * @Date: 2019/11/3
    * @Time: 20:12
    */
    public List<Record> listThisMonthRecords() {
        RecordDAO dao= new RecordDAO();
        List<Record> monthRawData= dao.listThisMonth();
        List<Record> result= new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            Record r = new Record();
            c.setTime(monthBegin);
            c.add(Calendar.DATE, i);
            Date eachDayOfThisMonth=c.getTime() ;
            int daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
            r.setSpend(daySpend);
            result.add(r);
        }
        return result;

    }
}
