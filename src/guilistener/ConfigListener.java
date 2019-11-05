package guilistener;

import guipanel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @program: hutubill
 * @description: 配置监听器
 * @author: youzhou
 * @create: 2019-10-31 20:58
 **/
public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ConfigPanel p = ConfigPanel.instance;

        //判断预算是否为整数
        if(!GUIUtil.checkNumber(p.tfBudget, "本月预算"))
            return;
        String mysqlPath =p.tfMysqlPath.getText();

        //检查路径是否正确
        if(0!=mysqlPath.length()){
            File commandFile = new File(mysqlPath,"bin/mysql.exe");
            if(!commandFile.exists()){
                JOptionPane.showMessageDialog(p, "Mysql路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }

        ConfigService cs= new ConfigService();
        cs.update(ConfigService.budget,p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath,mysqlPath);

        JOptionPane.showMessageDialog(p, "设置修改成功");
    }
}
