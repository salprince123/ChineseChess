
package giaoDien;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.function.Consumer;
import javax.swing.*;
public class GiaoDien implements ActionListener
{
    private JFrame f;
    private JButton btNew,btContinue,btExit, btNotyou;
    private JLabel labelHello;
    private DangNhap dn;
    public String name="";
    private Consumer<String> consumerName;
    private Consumer<String> consumerDisplayName;
    private Consumer<String> consumerBanCo;
    public GiaoDien()
    {
        //setup consummer 
        consumerName= i-> this.name=i;        
        consumerDisplayName= i-> this.labelHello.setText("Hello "+i);
    }
    public void HienThiGiaoDien()
    {
        int x=740;
        int y=600;
        f = new JFrame("Chinese Chess");
        f.setSize(x, y);
        f.setLocation(400, 140);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        JPanel panel = new JPanel(); 
        panel.setLayout(null);
        panel.setBounds(0, 0, x-15,y-60); 
        
        JLabel nen;
        ImageIcon myImage=new ImageIcon("D:\\imageChess\\nen3.jpg");
        nen=new JLabel(myImage);
        nen.setBounds(0, 0, x-15, y-60);
        nen.setVisible(true);
        panel.add(nen);
        
        //name=loadUser(name);
        labelHello= new JLabel("Hello "+name);
        labelHello.setBounds(50, 10, 220, 80);
        labelHello.setFont(new Font("Times New Roman", Font.BOLD,25));
        nen.add(labelHello);
        
        btNotyou= new JButton("Not You?");
        btNotyou.setBounds(250, 20, 120, 40);
        btNotyou.setFont(new Font("Times New Roman", Font.BOLD,20));
        nen.add(btNotyou);
        
        ImageIcon newImage=new ImageIcon("D:\\imageChess\\new.jpg");
        btNew=new JButton(newImage);
        //btNew.setFont(new Font("Times New Roman", Font.BOLD,23));
        btNew.setBounds(50, 140, 220, 80);
        btNew.setBorderPainted(false);
        nen.add(btNew);
        
        ImageIcon continueImage=new ImageIcon("D:\\imageChess\\continue.jpg");
        btContinue=new JButton(continueImage);
        panel.add(btContinue);
        btContinue.setBounds(50,270, 420, 86);    
        btContinue.setBorderPainted(false);
        nen.add(btContinue);
        
        ImageIcon exitImage=new ImageIcon("D:\\imageChess\\exit.jpg");
        btExit=new JButton(exitImage);
        btExit.setBorderPainted(false);
        btExit.setBounds(50, 400, 190, 70);
        nen.add(btExit);
        
        btExit.addActionListener(this);
        btNew.addActionListener(this);
        btNotyou.addActionListener(this);
        btContinue.addActionListener(this);
        f.add(panel);
        f.setVisible(true);
    }
    public void setUpConsumer(Consumer<String> consumer)
    {
        consumerBanCo= consumer;        
    }
    public static void main(String[] args)throws Exception
    {        
        GiaoDien giaoDien = new GiaoDien();
        giaoDien.HienThiGiaoDien();        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==btNew)
        {            
            new BanCo();
        }
        if(ae.getSource()==btNotyou)
        {
            dn= new DangNhap();
            dn.setUpConsumer(consumerName,consumerDisplayName);
                System.out.println("name= "+name);
            labelHello.setText("Hello "+name);
        }            
        if(ae.getSource()==btContinue)
        {
            BanCo t= new BanCo();
            t.continueChess();
        }            
        if(ae.getSource()==btExit)
            System.exit(0);
                System.out.println("name= "+name);
    }
    
    public String loadUser(String s)
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
                s=rs.getString(2); 
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
        return s;
        }
}

