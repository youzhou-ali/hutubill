package guilistener;

import guipanel.BackupPanel;
import guipanel.ConfigPanel;
import guipanel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @program: hutubill
 * @description: 恢复监听器
 * @author: youzhou
 * @create: 2019-11-03 20:56
 **/
public class RecoverListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        BackupPanel p  = BackupPanel.instance;
        String mysqlPath= new ConfigService().get(ConfigService.mysqlPath);
        if(0==mysqlPath.length()){
            JOptionPane.showMessageDialog(p, "恢复前请事先配置mysql的路径");
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            ConfigPanel.instance.tfMysqlPath.grabFocus();
            return;
        }
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return ".sql";
            }

            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }
        });

        int returnVal =  fc.showOpenDialog(p);
        File file = fc.getSelectedFile();
        System.out.println(file);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                MysqlUtil.recover(mysqlPath,file.getAbsolutePath());
//              MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(p, "恢复成功");
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(p, "恢复失败\r\n,错误:\r\n"+e1.getMessage());
            }

        }
    }
}
