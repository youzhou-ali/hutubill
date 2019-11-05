package guilistener;

import guipanel.BackupPanel;
import guipanel.ConfigPanel;
import guipanel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * @program: hutubill
 * @description: 备份监听器
 * @author: youzhou
 * @create: 2019-11-03 20:42
 **/
public class BackupListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        BackupPanel p  =BackupPanel.instance;
        String mysqlPath= new ConfigService().get(ConfigService.mysqlPath);
        if(0==mysqlPath.length()){
            JOptionPane.showMessageDialog(p, "备份前请事先配置mysql的路径");
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            ConfigPanel.instance.tfMysqlPath.grabFocus();
            return;
        }
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.getName().toLowerCase().endsWith(".sql");
            }

            @Override
            public String getDescription() {
                return ".sql";
            }
        });

        int returnVal =  fc.showSaveDialog(p);
        File file = fc.getSelectedFile();
        System.out.println(file);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //如果保存的文件名没有以.sql结尾，自动加上.sql
            System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(),file.getName()+".sql");
            System.out.println(file);

            try {
                MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(p, "备份成功,备份文件位于:\r\n"+file.getAbsolutePath());
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(p, "备份失败\r\n,错误:\r\n"+e1.getMessage());
            }

        }
    }
}
