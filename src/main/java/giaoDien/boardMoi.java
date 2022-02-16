package giaoDien;

import chess.ListChess;
import chess.Piece;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public abstract class  boardMoi 
{
    protected JFrame f;
    protected JLabel board;
    protected JLabel chieu,turnLabel;
    protected JButton saveButton,newButton,xinThuaButton;
    protected JLabel TuongDen,SiDen1,SiDen2, VoiDen1,VoiDen2, XeDen1,XeDen2, PhaoDen1,PhaoDen2, MaDen1,MaDen2, TotDen1,TotDen2,TotDen3,TotDen4,TotDen5;
    protected JLabel TuongTrang,SiTrang1,SiTrang2, VoiTrang1,VoiTrang2, XeTrang1,XeTrang2, PhaoTrang1,PhaoTrang2, MaTrang1,MaTrang2, TotTrang1,TotTrang2,TotTrang3,TotTrang4,TotTrang5;
    protected final int orgX = 35, orgY = 30, side = 71,chieuRong=70;
    protected Map <Piece,JLabel> chessLabelMap;
    protected Map <JLabel,Piece> labelChessMap;
    protected Map <Integer, String> namePositionMap;
    protected Map <Integer, Boolean> positionWhiteMap;    
    protected Map <Integer, JLabel> positionLabelMap;    
    protected JLabel  disPlayNameLabel;     
    protected  ListChess  list;
    public boardMoi()
    {
        f = new JFrame("Cờ Tướng");
        f.setSize(1000, 770);
        f.setLocation(250, 50);
        f.setResizable(false);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list= new ListChess();
        JPanel p= new JPanel();
        JPanel p1= new JPanel();
        JPanel p2= new JPanel();
        p.setLayout(null);
        p2.setLayout(null);        
        p.setBounds(0,0,800,770);
        p1.setBounds(0,0,650 ,770);
        p2.setBounds(650,0,340 ,770);
        setChess(p1);
        setUpMap();
        setP2(p2);
        f.add(p);
        p.add(p1);
        p.add(p2);
        f.setVisible(true);
    }
    public void resetListChess()
    {
        this.list = new ListChess();
    }
   
    public void setP2(JPanel p)
    {        
        disPlayNameLabel= new JLabel("Hello______");
        disPlayNameLabel.setFont(new Font("Times New Roman", Font.ITALIC,25));
        disPlayNameLabel.setBounds(80 , 10, 300, 50);
        turnLabel= new JLabel("Đỏ đi",SwingConstants.CENTER);
        turnLabel.setBounds(80 , 360, 150, 50);
        turnLabel.setFont(new Font("Times New Roman", Font.BOLD,40));
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 3);        
        turnLabel.setBorder(border1);
        saveButton = new JButton("Lưu ván cờ");
        saveButton.setFont(new Font("Times New Roman", Font.BOLD,25));
        saveButton.setBounds(65 , 460, 200, 50);
        saveButton.setBackground(Color.GREEN);
        newButton = new JButton("Ván Mới");
        newButton.setFont(new Font("Times New Roman", Font.BOLD,25));
        newButton.setBounds(65 , 530, 200, 50);
        newButton.setBackground(Color.BLUE);
        xinThuaButton = new JButton("Xin Thua");
        xinThuaButton.setFont(new Font("Times New Roman", Font.BOLD,25));
        xinThuaButton.setBounds(65 , 600, 200, 50);
        xinThuaButton.setBackground(Color.LIGHT_GRAY);
        ImageIcon myImage=new ImageIcon("D:\\imageChess\\userIcon.jpg");
        JLabel label=new JLabel(myImage);
        label.setBounds(45 , 60, 250, 250);
        p.add(label);
        p.add(turnLabel);
        p.add(saveButton);
        p.add(newButton);
        p.add(xinThuaButton);
        p.add(disPlayNameLabel);
    }
    public void setChess(JPanel p)
    {
        f.add(p);
        ImageIcon myImage=new ImageIcon("D:\\imageChess\\ChessBoard.png");
        board=new JLabel(myImage);
        p.add(board);
        ImageIcon chieuImage=new ImageIcon("D:\\imageChess\\chieu.jpg");
        chieu=new JLabel(chieuImage);
        chieu.setBounds(200,320,300,100);
        chieu.setVisible(false);
        ImageIcon totDenImage=new ImageIcon("D:\\imageChess\\TotDen.png");
        TotDen1=new JLabel(totDenImage);
        TotDen2=new JLabel(totDenImage);
        TotDen3=new JLabel(totDenImage);
        TotDen4=new JLabel(totDenImage);
        TotDen5=new JLabel(totDenImage);
        ImageIcon TotTrangImage=new ImageIcon("D:\\imageChess\\TotTrang.png");
        TotTrang1=new JLabel(TotTrangImage);
        TotTrang2=new JLabel(TotTrangImage);
        TotTrang3=new JLabel(TotTrangImage);
        TotTrang4=new JLabel(TotTrangImage);
        TotTrang5=new JLabel(TotTrangImage);
        //tuong
        ImageIcon TuongTrangImage=new ImageIcon("D:\\imageChess\\TuongTrang.png");
        TuongTrang=new JLabel(TuongTrangImage);
        ImageIcon TuongDenImage=new ImageIcon("D:\\imageChess\\TuongDen.png");
        TuongDen=new JLabel(TuongDenImage);
        //sĩ
        ImageIcon SiTrangImage=new ImageIcon("D:\\imageChess\\SiTrang.png");
         SiTrang1=new JLabel(SiTrangImage);
         SiTrang2=new JLabel(SiTrangImage);
        ImageIcon SiDenImage=new ImageIcon("D:\\imageChess\\SiDen.png");
         SiDen1=new JLabel(SiDenImage);
         SiDen2=new JLabel(SiDenImage);
        //Voi
        ImageIcon VoiTrangImage=new ImageIcon("D:\\imageChess\\VoiTrang.png");
         VoiTrang1=new JLabel(VoiTrangImage);
         VoiTrang2=new JLabel(VoiTrangImage);
        ImageIcon VoiDenImage=new ImageIcon("D:\\imageChess\\VoiDen.png");
         VoiDen1=new JLabel(VoiDenImage);
         VoiDen2=new JLabel(VoiDenImage);
        //xe
        ImageIcon XeTrangImage=new ImageIcon("D:\\imageChess\\XeTrang.png");
         XeTrang1=new JLabel(XeTrangImage);
         XeTrang2=new JLabel(XeTrangImage);
        ImageIcon XeDenImage=new ImageIcon("D:\\imageChess\\XeDen.png");
         XeDen1=new JLabel(XeDenImage);
         XeDen2=new JLabel(XeDenImage);
        //pháo
        ImageIcon PhaoTrangImage=new ImageIcon("D:\\imageChess\\PhaoTrang.png");
         PhaoTrang1=new JLabel(PhaoTrangImage);
         PhaoTrang2=new JLabel(PhaoTrangImage);
        ImageIcon PhaoDenImage=new ImageIcon("D:\\imageChess\\PhaoDen.png");
         PhaoDen1=new JLabel(PhaoDenImage);
         PhaoDen2=new JLabel(PhaoDenImage);
        //Mã
        ImageIcon MaTrangImage=new ImageIcon("D:\\imageChess\\MaTrang.png");
         MaTrang1=new JLabel(MaTrangImage);
         MaTrang2=new JLabel(MaTrangImage);
        ImageIcon MaDenImage=new ImageIcon("D:\\imageChess\\MaDen.png");
         MaDen1=new JLabel(MaDenImage);
         MaDen2=new JLabel(MaDenImage);
        
        XeDen1.setBounds(orgX-chieuRong/2, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        MaDen1.setBounds(orgX-chieuRong/2+1*side, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        VoiDen1.setBounds(orgX-chieuRong/2+2*side, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        SiDen1.setBounds(orgX-chieuRong/2+3*side, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        TuongDen.setBounds(orgX-chieuRong/2+4*side, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        SiDen2.setBounds(orgX-chieuRong/2+5*side, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        VoiDen2.setBounds(orgX-chieuRong/2+6*side, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        MaDen2.setBounds(orgX-chieuRong/2+7*side, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        XeDen2.setBounds(orgX-chieuRong/2+8*side, orgY-chieuRong/2+0*side, chieuRong, chieuRong);
        
        PhaoDen1.setBounds(orgX-chieuRong/2+1*side, orgY-chieuRong/2+2*side+ 10, chieuRong, chieuRong);
        PhaoDen2.setBounds(orgX-chieuRong/2+7*side, orgY-chieuRong/2+2*side+ 10, chieuRong, chieuRong);
        
        TotDen1.setBounds(orgX-chieuRong/2+0*side, orgY-chieuRong/2+3*side+ 10, chieuRong, chieuRong);
        TotDen2.setBounds(orgX-chieuRong/2+2*side, orgY-chieuRong/2+3*side+ 10, chieuRong, chieuRong);
        TotDen3.setBounds(orgX-chieuRong/2+4*side, orgY-chieuRong/2+3*side+ 10, chieuRong, chieuRong);
        TotDen4.setBounds(orgX-chieuRong/2+6*side, orgY-chieuRong/2+3*side+ 10, chieuRong, chieuRong);
        TotDen5.setBounds(orgX-chieuRong/2+8*side, orgY-chieuRong/2+3*side+ 10, chieuRong, chieuRong);
        
        XeTrang1.setBounds(orgX-chieuRong/2, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        MaTrang1.setBounds(orgX-chieuRong/2+1*side, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        VoiTrang1.setBounds(orgX-chieuRong/2+2*side, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        SiTrang1.setBounds(orgX-chieuRong/2+3*side, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        TuongTrang.setBounds(orgX-chieuRong/2+4*side, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        SiTrang2.setBounds(orgX-chieuRong/2+5*side, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        VoiTrang2.setBounds(orgX-chieuRong/2+6*side, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        MaTrang2.setBounds(orgX-chieuRong/2+7*side, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        XeTrang2.setBounds(orgX-chieuRong/2+8*side, orgY-chieuRong/2+9*side+20, chieuRong, chieuRong);
        
        PhaoTrang1.setBounds(orgX-chieuRong/2+1*side, orgY-chieuRong/2+7*side+20, chieuRong, chieuRong);
        PhaoTrang2.setBounds(orgX-chieuRong/2+7*side, orgY-chieuRong/2+7*side+20, chieuRong, chieuRong);
        
        TotTrang1.setBounds(orgX-chieuRong/2+0*side, orgY-chieuRong/2+6*side+20, chieuRong, chieuRong);
        TotTrang2.setBounds(orgX-chieuRong/2+2*side, orgY-chieuRong/2+6*side+20, chieuRong, chieuRong);
        TotTrang3.setBounds(orgX-chieuRong/2+4*side, orgY-chieuRong/2+6*side+20, chieuRong, chieuRong);
        TotTrang4.setBounds(orgX-chieuRong/2+6*side, orgY-chieuRong/2+6*side+20, chieuRong, chieuRong);
        TotTrang5.setBounds(orgX-chieuRong/2+8*side, orgY-chieuRong/2+6*side+20, chieuRong, chieuRong);
        
        //board.add(TuongTrang);
        board.add(TotTrang1);
        board.add(TotTrang2);
        board.add(TotTrang3);
        board.add(TotTrang4);
        board.add(TotTrang5);
    
        board.add(TuongTrang);
        board.add(SiTrang1);
        board.add(SiTrang2);
        board.add(VoiTrang1);
        board.add(VoiTrang2);
        board.add(XeTrang1);
        board.add(XeTrang2);
        board.add(PhaoTrang1);
        board.add(PhaoTrang2);
        board.add(MaTrang1);
        board.add(MaTrang2);

        board.add(TuongDen);
        board.add(SiDen1);
        board.add(SiDen2);
        board.add(VoiDen1);
        board.add(VoiDen2);
        board.add(XeDen1);
        board.add(XeDen2);
        board.add(PhaoDen1);
        board.add(PhaoDen2);
        board.add(MaDen1);
        board.add(MaDen2);
        board.add(TotDen1);
        board.add(TotDen2);
        board.add(TotDen3);
        board.add(TotDen4);
        board.add(TotDen5);
        board.add(chieu);
        chessLabelMap=new HashMap<>();
        labelChessMap=new HashMap<>();
        namePositionMap=new HashMap<>();
        positionWhiteMap= new HashMap<>();
        positionLabelMap= new HashMap<>();
        
    }
    public void clearMap()
    {
        chessLabelMap.clear();
        labelChessMap.clear();
        namePositionMap.clear();
        positionWhiteMap.clear();
        positionLabelMap.clear();
    }
    public void setUpMap()
    {
        
        chessLabelMap.put(list.getChess(0),TuongTrang);
        chessLabelMap.put(list.getChess(1),SiTrang1);
        chessLabelMap.put(list.getChess(2),SiTrang2);
        chessLabelMap.put(list.getChess(3),VoiTrang1);
        chessLabelMap.put(list.getChess(4),VoiTrang2);
        chessLabelMap.put(list.getChess(9),MaTrang1);
        chessLabelMap.put(list.getChess(10),MaTrang2);
        chessLabelMap.put(list.getChess(5),XeTrang1);
        chessLabelMap.put(list.getChess(6),XeTrang2);
        chessLabelMap.put(list.getChess(7),PhaoTrang1);
        chessLabelMap.put(list.getChess(8),PhaoTrang2);
        chessLabelMap.put(list.getChess(11),TotTrang1);
        chessLabelMap.put(list.getChess(12),TotTrang2);
        chessLabelMap.put(list.getChess(13),TotTrang3);
        chessLabelMap.put(list.getChess(14),TotTrang4);
        chessLabelMap.put(list.getChess(15),TotTrang5);
        
       chessLabelMap.put(list.getChess(16),TuongDen);
        chessLabelMap.put(list.getChess(17),SiDen1);
        chessLabelMap.put(list.getChess(18),SiDen2);
        chessLabelMap.put(list.getChess(19),VoiDen1);
        chessLabelMap.put(list.getChess(20),VoiDen2);
        chessLabelMap.put(list.getChess(21),MaDen1);
        chessLabelMap.put(list.getChess(22),MaDen2);
        chessLabelMap.put(list.getChess(23),XeDen1);
        chessLabelMap.put(list.getChess(24),XeDen2);
        chessLabelMap.put(list.getChess(25),PhaoDen1);
        chessLabelMap.put(list.getChess(26),PhaoDen2);
        chessLabelMap.put(list.getChess(27),TotDen1);
        chessLabelMap.put(list.getChess(28),TotDen2);
        chessLabelMap.put(list.getChess(29),TotDen3);
        chessLabelMap.put(list.getChess(30),TotDen4);
        chessLabelMap.put(list.getChess(31),TotDen5);
        
        labelChessMap.put(TuongTrang,list.getChess(0));
        labelChessMap.put(SiTrang1,list.getChess(1));
        labelChessMap.put(SiTrang2,list.getChess(2));
        labelChessMap.put(VoiTrang1,list.getChess(3));
        labelChessMap.put(VoiTrang2,list.getChess(4));
        labelChessMap.put(MaTrang1,list.getChess(9));
        labelChessMap.put(MaTrang2,list.getChess(10));
        labelChessMap.put(XeTrang1,list.getChess(5));
        labelChessMap.put(XeTrang2,list.getChess(6));
        labelChessMap.put(PhaoTrang1,list.getChess(7));
        labelChessMap.put(PhaoTrang2,list.getChess(8));
        labelChessMap.put(TotTrang1,list.getChess(11));
        labelChessMap.put(TotTrang2,list.getChess(12));
        labelChessMap.put(TotTrang3,list.getChess(13));
        labelChessMap.put(TotTrang4,list.getChess(14));
        labelChessMap.put(TotTrang5,list.getChess(15));
        
        labelChessMap.put(TuongDen,list.getChess(16));
        labelChessMap.put(SiDen1,list.getChess(17));
        labelChessMap.put(SiDen2,list.getChess(18));
        labelChessMap.put(VoiDen1,list.getChess(19));
        labelChessMap.put(VoiDen2,list.getChess(20));
        labelChessMap.put(MaDen1,list.getChess(21));
        labelChessMap.put(MaDen2,list.getChess(22));
        labelChessMap.put(XeDen1,list.getChess(23));
        labelChessMap.put(XeDen2,list.getChess(24));
        labelChessMap.put(PhaoDen1,list.getChess(25));
        labelChessMap.put(PhaoDen2,list.getChess(26));
        labelChessMap.put(TotDen1,list.getChess(27));
        labelChessMap.put(TotDen2,list.getChess(28));
        labelChessMap.put(TotDen3,list.getChess(29));
        labelChessMap.put(TotDen4,list.getChess(30));
        labelChessMap.put(TotDen5,list.getChess(31));    
                
        namePositionMap.put(list.getChess(0).getX()*10 +list.getChess(0).getY(),"TuongTrang");
        namePositionMap.put(list.getChess(1).getX()*10 +list.getChess(1).getY(),"SiTrang1");
        namePositionMap.put(list.getChess(2).getX()*10 +list.getChess(2).getY(),"SiTrang2");
        namePositionMap.put(list.getChess(3).getX()*10 +list.getChess(3).getY(),"VoiTrang1");
        namePositionMap.put(list.getChess(4).getX()*10 +list.getChess(4).getY(),"VoiTrang2");
        namePositionMap.put(list.getChess(9).getX()*10 +list.getChess(9).getY(),"MaTrang1");
        namePositionMap.put(list.getChess(10).getX()*10 +list.getChess(10).getY(),"MaTrang2");
        namePositionMap.put(list.getChess(5).getX()*10 +list.getChess(5).getY(),"XeTrang1");
        namePositionMap.put(list.getChess(6).getX()*10 +list.getChess(6).getY(),"XeTrang2");
        namePositionMap.put(list.getChess(7).getX()*10 +list.getChess(7).getY(),"PhaoTrang1");
        namePositionMap.put(list.getChess(8).getX()*10 +list.getChess(8).getY(),"PhaoTrang2");
        namePositionMap.put(list.getChess(11).getX()*10 +list.getChess(11).getY(),"TotTrang1");
        namePositionMap.put(list.getChess(12).getX()*10 +list.getChess(12).getY(),"TotTrang2");
        namePositionMap.put(list.getChess(13).getX()*10 +list.getChess(13).getY(),"TotTrang3");
        namePositionMap.put(list.getChess(14).getX()*10 +list.getChess(14).getY(),"TotTrang4");
        namePositionMap.put(list.getChess(15).getX()*10 +list.getChess(15).getY(),"TotTrang5");
        
        namePositionMap.put(list.getChess(16).getX()*10 +list.getChess(16).getY(),"TuongDen");
        namePositionMap.put(list.getChess(17).getX()*10 +list.getChess(17).getY(),"SiDen1");
        namePositionMap.put(list.getChess(18).getX()*10 +list.getChess(18).getY(),"SiDen2");
        namePositionMap.put(list.getChess(19).getX()*10 +list.getChess(19).getY(),"VoiDen1");
        namePositionMap.put(list.getChess(20).getX()*10 +list.getChess(20).getY(),"VoiDen2");
        namePositionMap.put(list.getChess(25).getX()*10 +list.getChess(25).getY(),"MaDen1");
        namePositionMap.put(list.getChess(26).getX()*10 +list.getChess(26).getY(),"MaDen2");
        namePositionMap.put(list.getChess(21).getX()*10 +list.getChess(21).getY(),"XeDen1");
        namePositionMap.put(list.getChess(22).getX()*10 +list.getChess(22).getY(),"XeDen2");
        namePositionMap.put(list.getChess(23).getX()*10 +list.getChess(23).getY(),"PhaoDen1");
        namePositionMap.put(list.getChess(24).getX()*10 +list.getChess(24).getY(),"PhaoDen2");
        namePositionMap.put(list.getChess(27).getX()*10 +list.getChess(27).getY(),"TotDen1");
        namePositionMap.put(list.getChess(28).getX()*10 +list.getChess(28).getY(),"TotDen2");
        namePositionMap.put(list.getChess(29).getX()*10 +list.getChess(29).getY(),"TotDen3");
        namePositionMap.put(list.getChess(30).getX()*10 +list.getChess(30).getY(),"TotDen4");
        namePositionMap.put(list.getChess(31).getX()*10 +list.getChess(31).getY(),"TotDen5");
        
        positionWhiteMap.put(list.getChess(0).getX()*10 +list.getChess(0).getY(),true);
        positionWhiteMap.put(list.getChess(1).getX()*10 +list.getChess(1).getY(),true);
        positionWhiteMap.put(list.getChess(2).getX()*10 +list.getChess(2).getY(),true);
        positionWhiteMap.put(list.getChess(3).getX()*10 +list.getChess(3).getY(),true);
        positionWhiteMap.put(list.getChess(4).getX()*10 +list.getChess(4).getY(),true);
        positionWhiteMap.put(list.getChess(9).getX()*10 +list.getChess(9).getY(),true);
        positionWhiteMap.put(list.getChess(10).getX()*10 +list.getChess(10).getY(),true);
        positionWhiteMap.put(list.getChess(5).getX()*10 +list.getChess(5).getY(),true);
        positionWhiteMap.put(list.getChess(6).getX()*10 +list.getChess(6).getY(),true);
        positionWhiteMap.put(list.getChess(7).getX()*10 +list.getChess(7).getY(),true);
        positionWhiteMap.put(list.getChess(8).getX()*10 +list.getChess(8).getY(),true);
        positionWhiteMap.put(list.getChess(11).getX()*10 +list.getChess(11).getY(),true);
        positionWhiteMap.put(list.getChess(12).getX()*10 +list.getChess(12).getY(),true);
        positionWhiteMap.put(list.getChess(13).getX()*10 +list.getChess(13).getY(),true);
        positionWhiteMap.put(list.getChess(14).getX()*10 +list.getChess(14).getY(),true);
        positionWhiteMap.put(list.getChess(15).getX()*10 +list.getChess(15).getY(),true);
        
        positionWhiteMap.put(list.getChess(16).getX()*10 +list.getChess(16).getY(),false);
        positionWhiteMap.put(list.getChess(17).getX()*10 +list.getChess(17).getY(),false);
        positionWhiteMap.put(list.getChess(18).getX()*10 +list.getChess(18).getY(),false);
        positionWhiteMap.put(list.getChess(19).getX()*10 +list.getChess(19).getY(),false);
        positionWhiteMap.put(list.getChess(20).getX()*10 +list.getChess(20).getY(),false);
        positionWhiteMap.put(list.getChess(25).getX()*10 +list.getChess(25).getY(),false);
        positionWhiteMap.put(list.getChess(26).getX()*10 +list.getChess(26).getY(),false);
        positionWhiteMap.put(list.getChess(21).getX()*10 +list.getChess(21).getY(),false);
        positionWhiteMap.put(list.getChess(22).getX()*10 +list.getChess(22).getY(),false);
        positionWhiteMap.put(list.getChess(23).getX()*10 +list.getChess(23).getY(),false);
        positionWhiteMap.put(list.getChess(24).getX()*10 +list.getChess(24).getY(),false);
        positionWhiteMap.put(list.getChess(27).getX()*10 +list.getChess(27).getY(),false);
        positionWhiteMap.put(list.getChess(28).getX()*10 +list.getChess(28).getY(),false);
        positionWhiteMap.put(list.getChess(29).getX()*10 +list.getChess(29).getY(),false);
        positionWhiteMap.put(list.getChess(30).getX()*10 +list.getChess(30).getY(),false);
        positionWhiteMap.put(list.getChess(31).getX()*10 +list.getChess(31).getY(),false);
        
        positionLabelMap.put(list.getChess(0).getX()*10 +list.getChess(0).getY(),TuongTrang);
        positionLabelMap.put(list.getChess(1).getX()*10 +list.getChess(1).getY(),SiTrang1);
        positionLabelMap.put(list.getChess(2).getX()*10 +list.getChess(2).getY(),SiTrang2);
        positionLabelMap.put(list.getChess(3).getX()*10 +list.getChess(3).getY(),VoiTrang1);
        positionLabelMap.put(list.getChess(4).getX()*10 +list.getChess(4).getY(),VoiTrang2);
        positionLabelMap.put(list.getChess(9).getX()*10 +list.getChess(9).getY(),MaTrang1);
        positionLabelMap.put(list.getChess(10).getX()*10 +list.getChess(10).getY(),MaTrang2);
        positionLabelMap.put(list.getChess(5).getX()*10 +list.getChess(5).getY(),XeTrang1);
        positionLabelMap.put(list.getChess(6).getX()*10 +list.getChess(6).getY(),XeTrang2);
        positionLabelMap.put(list.getChess(7).getX()*10 +list.getChess(7).getY(),PhaoTrang1);
        positionLabelMap.put(list.getChess(8).getX()*10 +list.getChess(8).getY(),PhaoTrang2);
        positionLabelMap.put(list.getChess(11).getX()*10 +list.getChess(11).getY(),TotTrang1);
        positionLabelMap.put(list.getChess(12).getX()*10 +list.getChess(12).getY(),TotTrang2);
        positionLabelMap.put(list.getChess(13).getX()*10 +list.getChess(13).getY(),TotTrang3);
        positionLabelMap.put(list.getChess(14).getX()*10 +list.getChess(14).getY(),TotTrang4);
        positionLabelMap.put(list.getChess(15).getX()*10 +list.getChess(15).getY(),TotTrang5);
        
        positionLabelMap.put(list.getChess(16).getX()*10 +list.getChess(16).getY(),TuongDen);
        positionLabelMap.put(list.getChess(17).getX()*10 +list.getChess(17).getY(),SiDen1);
        positionLabelMap.put(list.getChess(18).getX()*10 +list.getChess(18).getY(),SiDen2);
        positionLabelMap.put(list.getChess(19).getX()*10 +list.getChess(19).getY(),VoiDen1);
        positionLabelMap.put(list.getChess(20).getX()*10 +list.getChess(20).getY(),VoiDen2);
        positionLabelMap.put(list.getChess(25).getX()*10 +list.getChess(25).getY(),MaDen1);
        positionLabelMap.put(list.getChess(26).getX()*10 +list.getChess(26).getY(),MaDen2);
        positionLabelMap.put(list.getChess(21).getX()*10 +list.getChess(21).getY(),XeDen1);
        positionLabelMap.put(list.getChess(22).getX()*10 +list.getChess(22).getY(),XeDen2);
        positionLabelMap.put(list.getChess(23).getX()*10 +list.getChess(23).getY(),PhaoDen1);
        positionLabelMap.put(list.getChess(24).getX()*10 +list.getChess(24).getY(),PhaoDen2);
        positionLabelMap.put(list.getChess(27).getX()*10 +list.getChess(27).getY(),TotDen1);
        positionLabelMap.put(list.getChess(28).getX()*10 +list.getChess(28).getY(),TotDen2);
        positionLabelMap.put(list.getChess(29).getX()*10 +list.getChess(29).getY(),TotDen3);
        positionLabelMap.put(list.getChess(30).getX()*10 +list.getChess(30).getY(),TotDen4);
        positionLabelMap.put(list.getChess(31).getX()*10 +list.getChess(31).getY(),TotDen5);
        
    }
    
}
