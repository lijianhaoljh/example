package com.accp.controller;
import javax.swing.*;
import java.awt.*;
public class Test extends JFrame {
 
    public Test() {
        this.setSize(300,220);
        this.setLayout(new BorderLayout());
 
        Container con=this.getContentPane();
        JPanel titlePanel = new JPanel();
        con.add(titlePanel);
        JLabel a=new JLabel("欢迎使用德召文车辆维修管理系统");
        a.setFont(new Font("隶书", Font.PLAIN, 22));
        titlePanel.add(a);
        con.add(titlePanel,"North");
 
        JLabel b=new JLabel("用户名:");
        b.setBounds(50, 20, 50, 20);
        JLabel c=new JLabel("密    码:");
        c.setBounds(50, 50, 50, 20);
        JTextField e=new JTextField(20);
        e.setBounds(110, 20, 120, 20);
        JPasswordField txtPwd=new JPasswordField(20);
        txtPwd.setBounds(110, 50, 120, 20); 
 
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        fieldPanel.add(b);
        fieldPanel.add(c);
        fieldPanel.add(e);
        fieldPanel.add(txtPwd);
        con.add(fieldPanel, "Center");
 
        JPanel  as = new JPanel();
        JButton f=new JButton("登录");
        as.add(f);
        JButton g=new JButton("关闭");
        as.add(g);
 
        con.add(as, "South");
 
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Test();
    }
}