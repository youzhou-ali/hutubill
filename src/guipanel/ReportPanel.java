package guipanel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @program: hutubill
 * @description: 报表面板
 * @author: youzhou
 * @create: 2019-10-30 19:19
 **/
public class ReportPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();
    public JLabel l = new JLabel();
    public ReportPanel(){
        this.setLayout(new BorderLayout());
        Image i = ChartUtil.getImage(400,300);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void updateData() {
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }

    @Override
    public void addListener() {

    }
}
