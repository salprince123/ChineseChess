
package giaoDien;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.function.Consumer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DangNhap implements ActionListener
{
    private JLabel nameLabel, disPlayNameLabel; 
    private JTextField nameT;
    private JButton saveButton;
    private JFrame f;
    public String name="";
    private JComboBox userList;
    private Consumer<String> consumerName;
    private Consumer<String> consumerDisplayName;
    public Boolean allow_ = true;
    public String getName()
    {
        return name;
    }
    public DangNhap()
    {
        //setUp(name);
        f = new JFrame("Login");
        f.setSize(400, 500);
        f.setLocation(300, 200);
        f.setResizable(false);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p= new JPanel();
        p.setLayout(null); 
        p.setBounds(0,0,400,500);
        nameLabel= new JLabel("Name");
        nameT= new JTextField();
        nameLabel.setBounds(30,100,250,30);
        nameT.setBounds(100,100,250,40);
        nameLabel.setFont(new Font("Times New Roman", Font.ITALIC,25));
        saveButton= new JButton("Save");
        saveButton.setBounds(130, 380, 120, 40);
        saveButton.setBackground(Color.GREEN);
        JLabel makeAccountLabel= new JLabel ("Make your own account!");
        makeAccountLabel.setBounds(30,30,400,40);
        makeAccountLabel.setFont(new Font("Times New Roman", Font.BOLD,31));
        
        JLabel chooseAccountLabel= new JLabel ("Already have account?");
        chooseAccountLabel.setBounds(50,200,400,40);
        chooseAccountLabel.setFont(new Font("Times New Roman", Font.BOLD,31));
        JLabel chooseAccountLabel1= new JLabel ("Choosing it!");
        chooseAccountLabel1.setBounds(120,240,400,40);
        chooseAccountLabel1.setFont(new Font("Times New Roman", Font.BOLD,31));
        
        Vector <String >v = new Vector();
        loadUser(v);
        userList= new JComboBox(v);
        userList.setBounds(70, 300, 250, 30);
        p.add(nameLabel);
        p.add(nameT);
        p.add(saveButton);
        p.add(userList);
        p.add(makeAccountLabel);
        p.add(chooseAccountLabel);
        p.add(chooseAccountLabel1);
        f.add(p);
        f.setVisible(true);
        saveButton.addActionListener(this);
        nameT.addActionListener(this);
    }
    public static void main(String[] args)throws Exception
    {
        String s = null;
        new DangNhap();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==nameT)
        {
            if(nameT.getText().length()>10)
            {
                JOptionPane.showMessageDialog(f,"Tên có tối đa 10 kí tự, xin nhập lại");
            }
            else
            {
                inputUser(nameT.getText());
                name=nameT.getText();
                JOptionPane.showMessageDialog(f,"Tạo tài khoản thành công");
                JOptionPane.showMessageDialog(f,"Chào mừng " + name);
                consumerName.accept(this.name);
                consumerDisplayName.accept(this.name);
                f.dispose();
            }
        }
        if(e.getSource()==saveButton)
        {
            name=userList.getSelectedItem().toString();
            JOptionPane.showMessageDialog(f,"Chào mừng "+name);
            this.allow_=false;
            consumerName.accept(this.name);
            consumerDisplayName.accept(this.name);
            f.dispose();
        }
        
    }
    public void setUpConsumer(Consumer<String> consumer1,Consumer<String> consumer2)
    {
        consumerName=consumer1;
        consumerDisplayName=consumer2;
    }
    public void inputUser(String s)
    {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/"; 
        String dbName = "piece"; 
        String strUnicode = "?useUnicode=true&characterEncoding=utf8";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root"; 
        String password = "";
        
        try {
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(url+dbName+strUnicode,userName,password); 
            String SQL = "insert into nameuser values ('00000','"+s+"')";         
            Statement statements =  (Statement) conn.createStatement();
            statements.executeUpdate(SQL);   
            /*while (rs.next()) 
            {
                String ms=rs.getString(1);
            }          
            rs.close();*/
            statements.close();
            conn.close();
        }catch(SQLException se)
            {
               se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                        try{
                                if(conn!=null)
                                    conn.close();
                            }catch(SQLException se){
                                    se.printStackTrace();
                            }
               }
        
    }
    public void loadUser(Vector <String> v)
    {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/"; 
        String dbName = "piece"; 
        String strUnicode = "?useUnicode=true&characterEncoding=utf8";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root"; 
        String password = "";
        
        try {
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(url+dbName+strUnicode,userName,password); 
            String SQL = "select * from nameuser ";         
            Statement statements =  (Statement) conn.createStatement();
            statements.executeQuery(SQL);  
            ResultSet rs = statements.executeQuery(SQL); 
            while (rs.next()) 
            {
                v.add(rs.getString(2));              
            }          
            rs.close();
            statements.close();
            conn.close();
        }catch(SQLException se)
            {
               se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                        try{
                                if(conn!=null)
                                    conn.close();
                            }catch(SQLException se){
                                    se.printStackTrace();
                            }
               }
    }
}
