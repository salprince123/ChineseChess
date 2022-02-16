
package giaoDien;
import chess.Piece;
import com.mysql.jdbc.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final class BanCo extends boardMoi implements MouseListener,ActionListener
{
    private int typeChessPress,eX,eY;
    private boolean xTurnTrang = true;
    private viTriDatQuanCo chessPosition= new viTriDatQuanCo();
    private luatDiChuyen ruleMove= new luatDiChuyen();
    private luatChieuTuong winRule= new luatChieuTuong();
    private Boolean flagChieu=false;
    private String benBiChieu;
    private Consumer<String> consumerBanCo;
    private GiaoDien gd;
    public String name ;
    //thêm mấy cái actionlistener
    public BanCo()
    {
        super();
        TotTrang1.addMouseListener(this);
        TotTrang2.addMouseListener(this);
        TotTrang3.addMouseListener(this);
        TotTrang4.addMouseListener(this);
        TotTrang5.addMouseListener(this);
        TuongTrang.addMouseListener(this);
        SiTrang1.addMouseListener(this);
        SiTrang2.addMouseListener(this);
        VoiTrang1.addMouseListener(this);
        VoiTrang2.addMouseListener(this);
        XeTrang1.addMouseListener(this);
        XeTrang2.addMouseListener(this);
        PhaoTrang1.addMouseListener(this);
        PhaoTrang2.addMouseListener(this);
        MaTrang1.addMouseListener(this);
        MaTrang2.addMouseListener(this);
        
        TotDen1.addMouseListener(this);
        TotDen2.addMouseListener(this);
        TotDen3.addMouseListener(this);
        TotDen4.addMouseListener(this);
        TotDen5.addMouseListener(this);
        TuongDen.addMouseListener(this);
        SiDen1.addMouseListener(this);
        SiDen2.addMouseListener(this);
        VoiDen1.addMouseListener(this);
        VoiDen2.addMouseListener(this);
        XeDen1.addMouseListener(this);
        XeDen2.addMouseListener(this);
        PhaoDen1.addMouseListener(this);
        PhaoDen2.addMouseListener(this);
        MaDen1.addMouseListener(this);
        MaDen2.addMouseListener(this);      
        disableDen();
        saveButton.addActionListener(this);
        newButton.addActionListener(this);
        xinThuaButton.addActionListener(this);
    }
    
    

    @Override
    public void mousePressed(MouseEvent e) 
    {        
        e.getComponent().setLocation(-50,-50);
        eX=e.getX();
        eY=e.getY();
        if(e.getComponent().equals(TotTrang1))
            typeChessPress=711;        
        else if(e.getSource().equals(TotTrang2))
            typeChessPress=712;        
        else if(e.getSource().equals(TotTrang3))
            typeChessPress=713;        
        else if(e.getSource().equals(TotTrang4))
            typeChessPress=714;        
        else if(e.getSource().equals(TotTrang5))
            typeChessPress=715;
        else if(e.getSource().equals(TuongTrang))
                    typeChessPress=11;
        else if(e.getSource().equals(SiTrang1))
            typeChessPress=211;
        else if(e.getSource().equals(SiTrang2))
            typeChessPress=212;
        else if(e.getSource().equals(VoiTrang1))
            typeChessPress=311;
        else if(e.getSource().equals(VoiTrang2))
            typeChessPress=312;
        else if(e.getSource().equals(XeTrang1))
            typeChessPress=411;
        else if(e.getSource().equals(XeTrang2))
            typeChessPress=412;
        else if(e.getSource().equals(PhaoTrang1))
            typeChessPress=511;
        else if(e.getSource().equals(PhaoTrang2))
            typeChessPress=512;
        else if(e.getSource().equals(MaTrang1))
            typeChessPress=611;
        else if(e.getSource().equals(MaTrang2))
            typeChessPress=612;
        
        else if(e.getComponent().equals(TotDen1))
            typeChessPress=721;        
        else if(e.getSource().equals(TotDen2))
            typeChessPress=722;        
        else if(e.getSource().equals(TotDen3))
            typeChessPress=723;        
        else if(e.getSource().equals(TotDen4))
            typeChessPress=724;        
        else if(e.getSource().equals(TotDen5))
            typeChessPress=725;
        else if(e.getSource().equals(TuongDen))
            typeChessPress=12;
        else if(e.getSource().equals(SiDen1))
            typeChessPress=221;
        else if(e.getSource().equals(SiDen2))
            typeChessPress=222;
        else if(e.getSource().equals(VoiDen1))
            typeChessPress=321;
        else if(e.getSource().equals(VoiDen2))
            typeChessPress=322;
        else if(e.getSource().equals(XeDen1))
            typeChessPress=421;
        else if(e.getSource().equals(XeDen2))
            typeChessPress=422;
        else if(e.getSource().equals(PhaoDen1))
            typeChessPress=521;
        else if(e.getSource().equals(PhaoDen2))
            typeChessPress=522;
        else if(e.getSource().equals(MaDen1))
            typeChessPress=621;
        else if(e.getSource().equals(MaDen2))
            typeChessPress=622;
        else typeChessPress=0;
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        int x, y,x0,y0;    
        x=chessPosition.positionInMap_X(e.getX());
        y=chessPosition.positionInMap_Y(e.getY());        
        switch (typeChessPress)
        {
            case 11:
            {   
                x0=list.getChess(0).getX();
                y0=list.getChess(0).getY();
                if(canMove(TuongTrang,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(TuongTrang,x0,y0,e.getX(),e.getY(),true,typeChessPress);
                    this.namePositionMap.put(10*x+y, "TuongTrang");
                }
                else TuongTrang.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 211:
            {
                x0=list.getChess(1).getX();
                y0=list.getChess(1).getY();
                if(canMove(SiTrang1,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(SiTrang1,x0,y0,e.getX(),e.getY(),true,typeChessPress);
                    this.namePositionMap.put(10*x+y, "SiTrang1");
                }
                else SiTrang1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 212:
            {
                x0=list.getChess(2).getX();
                y0=list.getChess(2).getY();
                if(canMove(SiTrang2,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(SiTrang2,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "SiTrang2");
                }
                else SiTrang2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }            
            case 311:
            {
                x0=list.getChess(3).getX();
                y0=list.getChess(3).getY();
                if(canMove(VoiTrang1,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(VoiTrang1,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "VoiTrang1");
                }
                else VoiTrang1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 312:
            {
                x0=list.getChess(4).getX();
                y0=list.getChess(4).getY();
                if(canMove(VoiTrang2,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(VoiTrang2,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "VoiTrang2");
                }
                else VoiTrang2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 411:
            {
                x0=list.getChess(5).getX();
                y0=list.getChess(5).getY();
                if(canMove(XeTrang1,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(XeTrang1,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "XeTrang1");
                }
                else XeTrang1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }    
            case 412:
            {
                x0=list.getChess(6).getX();
                y0=list.getChess(6).getY();
                if(canMove(XeTrang2,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(XeTrang2,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "XeTrang2");
                }
                else XeTrang2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 511:
            {
                x0=list.getChess(7).getX();
                y0=list.getChess(7).getY();
                if(canMove(PhaoTrang1,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(PhaoTrang1,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "PhaoTrang1");
                }
                else PhaoTrang1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 512:
            {
                x0=list.getChess(8).getX();
                y0=list.getChess(8).getY();
                if(canMove(PhaoTrang2,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(PhaoTrang2,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "PhaoTrang2");
                }
                else PhaoTrang2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 611:
            {
                x0=list.getChess(9).getX();
                y0=list.getChess(9).getY();
                if(canMove(MaTrang1,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(MaTrang1,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "MaTrang1");
                }
                else MaTrang1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 612:
            {
                x0=list.getChess(10).getX();
                y0=list.getChess(10).getY();
                if(canMove(MaTrang2,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(MaTrang2,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "MaTrang2");
                }
                else MaTrang2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 711:
            {
                x0=list.getChess(11).getX();
                y0=list.getChess(11).getY();
                if(canMove(TotTrang1,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(TotTrang1,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotTrang1");
                }
                else TotTrang1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 712:
            {
                x0=list.getChess(12).getX();
                y0=list.getChess(12).getY();
                if(canMove(TotTrang2,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(TotTrang2,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotTrang2");
                }
                else TotTrang2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 713:
            {
                x0=list.getChess(13).getX();
                y0=list.getChess(13).getY();
                if(canMove(TotTrang3,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(TotTrang3,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotTrang3");
                }
                else TotTrang3.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 714:
            {
                x0=list.getChess(14).getX();
                y0=list.getChess(14).getY();
                if(canMove(TotTrang4,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(TotTrang4,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotTrang4");
                }
                else TotTrang4.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 715:
            {
                x0=list.getChess(15).getX();
                y0=list.getChess(15).getY();
                if(canMove(TotTrang5,x0,y0,e.getX(),e.getY(),typeChessPress,true))
                {
                    move(TotTrang5,x0,y0,e.getX(),e.getY(),true,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotTrang5");
                }
                else TotTrang5.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }            
            case 12:
            {   
                x0=list.getChess(16).getX();
                y0=list.getChess(16).getY();
                if(canMove(TuongDen,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                     System.out.println("x0,y0=" + x0+y0);
                    move(TuongDen,x0,y0,e.getX(),e.getY(),false,typeChessPress);
                    this.namePositionMap.put(10*x+y, "TuongDen");
                }
                else TuongDen.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 221:
            {
                x0=list.getChess(17).getX();
                y0=list.getChess(17).getY();
                if(canMove(SiDen1,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(SiDen1,x0,y0,e.getX(),e.getY(),false,typeChessPress);
                    this.namePositionMap.put(10*x+y, "SiDen1");
                }
                else SiDen1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }                
            case 222:
            {
                x0=list.getChess(18).getX();
                y0=list.getChess(18).getY();
                if(canMove(SiDen2,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(SiDen2,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "SiDen2");
                }
                else SiDen2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }    
            case 321:
            {
                x0=list.getChess(19).getX();
                y0=list.getChess(19).getY();
                if(canMove(VoiDen1,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(VoiDen1,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "VoiDen1");
                }
                else VoiDen1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 322:
            {
                x0=list.getChess(20).getX();
                y0=list.getChess(20).getY();
                if(canMove(VoiDen2,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(VoiDen2,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "VoiDen2");
                }
                else VoiDen2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 421:
            {
                x0=list.getChess(21).getX();
                y0=list.getChess(21).getY();
                if(canMove(XeDen1,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(XeDen1,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "XeDen1");
                }
                else XeDen1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }    
            case 422:
            {
                x0=list.getChess(22).getX();
                y0=list.getChess(22).getY();
                if(canMove(XeDen2,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(XeDen2,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "XeDen2");
                }
                else XeDen2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 521:
            {
                x0=list.getChess(23).getX();
                y0=list.getChess(23).getY();
                if(canMove(PhaoDen1,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(PhaoDen1,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "PhaoDen1");
                }
                else PhaoDen1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 522:
            {
                x0=list.getChess(24).getX();
                y0=list.getChess(24).getY();
                if(canMove(PhaoDen2,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(PhaoDen2,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "PhaoDen2");
                }
                else PhaoDen2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 621:
            {
                x0=list.getChess(25).getX();
                y0=list.getChess(25).getY();
                if(canMove(MaDen1,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(MaDen1,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "MaDen1");
                }
                else MaDen1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 622:
            {
                x0=list.getChess(26).getX();
                y0=list.getChess(26).getY();
                if(canMove(MaDen2,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(MaDen2,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "MaDen2");
                }
                else MaDen2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 721:
            {
                x0=list.getChess(27).getX();
                y0=list.getChess(27).getY();
                if(canMove(TotDen1,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(TotDen1,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotDen1");
                }
                else TotDen1.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 722:
            {
                x0=list.getChess(28).getX();
                y0=list.getChess(28).getY();
                if(canMove(TotDen2,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(TotDen2,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotDen2");
                }
                else TotDen2.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 723:
            {
                x0=list.getChess(29).getX();
                y0=list.getChess(29).getY();
                if(canMove(TotDen3,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(TotDen3,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotDen3");
                }
                else TotDen3.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 724:
            {
                x0=list.getChess(30).getX();
                y0=list.getChess(30).getY();
                if(canMove(TotDen4,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(TotDen4,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotDen4");
                }
                else TotDen4.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }
            case 725:
            {
                x0=list.getChess(31).getX();
                y0=list.getChess(31).getY();
                if(canMove(TotDen5,x0,y0,e.getX(),e.getY(),typeChessPress,false))
                {
                    move(TotDen5,x0,y0,e.getX(),e.getY(),false,typeChessPress);                    
                    this.namePositionMap.put(10*x+y, "TotDen5");
                }
                else TotDen5.setLocation(chessPosition.positionPutChessFromMap_X(x0)-80, chessPosition.positionPutChessFromMap_Y(y0)-80);
                break;
            }            
        }  
        
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {        
        if(e.getSource()==newButton)
        {
            super.resetListChess();
            super.clearMap();
            super.setUpMap();
            clearBoard(); 
            loadNewBoard();
            xTurnTrang = true;
            JOptionPane.showMessageDialog(f,"Đã tải board mới");
        }
        if(e.getSource()==saveButton)
        {
            clearDataBoard();
            for(int i=0 ; i <32; i++)
                if(list.getChess(i).getAlive())
                    save(list.getChess(i),i);                   
            JOptionPane.showMessageDialog(f,"Đã Lưu");
        }
        if(e.getSource()==xinThuaButton)
        {            
            JOptionPane.showMessageDialog(f,"Bạn đã thua.Xin chia buồn cùng bạn");
            f.dispose();
        }
    }
    // không sử dụng
    @Override 
    public void mouseClicked(MouseEvent e) 
    {
        System.out.println("");
    }
    @Override
    public void mouseEntered(MouseEvent e) 
    {
        System.out.print("");
    }
    @Override
    public void mouseExited(MouseEvent e) 
    {
        System.out.print("");
    }
    //hàm bổ trợ move & conMove
    public boolean checkPosition(int x0, int y0, int eX, int eY,boolean white,int typeGetChess)
    {
        int x,y;
        x=chessPosition.positionInMap_X(eX);
        y=chessPosition.positionInMap_Y(eY);
        if(positionWhiteMap.containsKey(x*10+y))
        {   
            if(positionWhiteMap.get(x*10+y)!=white)
                return true;
            else return false;
        }
        return true;
    }  
    //hàm di chuyển quân cờ
    public void move (JLabel label, int x0, int y0, int eX, int eY, boolean white,int typeGetChess)
    {
        int x= chessPosition.positionInMap_X(eX);
        int y= chessPosition.positionInMap_Y(eY);
        label.setLocation(chessPosition.positionPutChessFromCoor_X(eX)-80, chessPosition.positionPutChessFromCoor_Y(eY)-80);
        this.namePositionMap.remove(x0*10+y0);        
        int type=-1;
        if(label==TuongTrang)       type=0;
        else if (label==SiTrang1)   type=1;
        else if (label==SiTrang2)   type=2;
        else if (label==VoiTrang1)  type=3;
        else if (label==VoiTrang2)  type=4;
        else if (label==XeTrang1)   type=5;
        else if (label==XeTrang2)   type=6;
        else if (label==PhaoTrang1) type=7;
        else if (label==PhaoTrang2) type=8;
        else if (label==MaTrang1)   type=9;
        else if (label==MaTrang2)   type=10;
        else if (label==TotTrang1)  type=11;
        else if (label==TotTrang2)  type=12;
        else if (label==TotTrang3)  type=13;
        else if (label==TotTrang4)  type=14;
        else if (label==TotTrang5)  type=15;
        
        else if (label==TuongDen)   type=16;            
        else if (label==SiDen1)     type=17;
        else if (label==SiDen2)     type=18;
        else if (label==VoiDen1)    type=19;
        else if (label==VoiDen2)    type=20;
        else if (label==XeDen1)     type=21;
        else if (label==XeDen2)     type=22;
        else if (label==PhaoDen1)   type=23;
        else if (label==PhaoDen2)   type=24;
        else if (label==MaDen1)     type=25;
        else if (label==MaDen2)     type=26;
        else if (label==TotDen1)    type=27;
        else if (label==TotDen2)    type=28;
        else if (label==TotDen3)    type=29;
        else if (label==TotDen4)    type=30;
        else if (label==TotDen5)    type=31;
        list.getChess(type).setX(x);
        list.getChess(type).setY(y);
        if(isCapture(x0,y0,x,y,white,typeGetChess))
        {            
            this.positionLabelMap.get(10*x+y).setVisible(false);
            this.labelChessMap.get(this.positionLabelMap.get(10*x+y)).setAlive(false);
            this.positionWhiteMap.remove(x*10+y);            
        }
        this.positionWhiteMap.remove(x0*10+y0);        
        this.positionWhiteMap.put(10*x+y, white);
        this.positionLabelMap.remove(x0*10+y0);
        this.positionLabelMap.put(10*x+y, label);
        if(!list.getChess(16).getAlive())   
        {
                 JOptionPane.showMessageDialog(f,"Đỏ thắng");
                 f.dispose();
        }
        if(!list.getChess(0).getAlive())    
        {
            JOptionPane.showMessageDialog(f,"Đen thắng");
            f.dispose();
        }
        
        if(chieuTuongDen())
                JOptionPane.showMessageDialog(f,"CHIẾU TƯỚNG ĐEN");
        if(chieuTuongTrang())
                JOptionPane.showMessageDialog(f,"CHIẾU TƯỚNG TRẮNG");
        
        if(!xTurnTrang) 
        {
            disableDen();
            enableTrang();
            turnLabel.setText("Đỏ Đi");
        }
        else
        {  
            disableTrang();
            enableDen();
            turnLabel.setText("Đen Đi");            
        }        
        xTurnTrang = !xTurnTrang;
    }
    //kiểm tra tính hợp lệ trước khi di chuyển
    public boolean canMove(JLabel label, int x0, int y0, int eX, int eY,int typeGetChess,boolean white)
    {
        boolean kq=false;
        int x= chessPosition.positionInMap_X(eX);
        int y= chessPosition.positionInMap_Y(eY);
        boolean bool =checkPosition(x0,y0,eX,eY,white,typeGetChess);
        //ruleMove.PhaoV(x0, y0, x, y, white, positionWhiteMap, 0);
        if(bool==true)
        {
            switch(typeGetChess)
            {
                case 11:if(ruleMove.Tuong(x0,y0,x,y,true))kq=true;break;
                case 12:if(ruleMove.Tuong(x0,y0,x,y,false))kq=true;break;
                case 211:case 212:if(ruleMove.Si(x,y,true))kq=true;break;
                case 221:case 222:if(ruleMove.Si(x,y,false))kq=true;break;
                case 311:case 312:if(ruleMove.Voi(x0,y0,x,y,true))kq=true;break;
                case 321:case 322:if(ruleMove.Voi(x0,y0,x,y,false))kq=true;break;//tượng
                case 411:case 412:if(ruleMove.Xe(x0,y0,x,y,true,positionWhiteMap,0)) kq=true;break;
                case 421:case 422:if(ruleMove.Xe(x0,y0,x,y,false,positionWhiteMap,0)) kq=true;break;
                case 511:case 512:if(ruleMove.Phao(x0,y0,x,y,true,positionWhiteMap,0) )kq=true;break;
                case 522:case 521:if(ruleMove.Phao(x0,y0,x,y,false,positionWhiteMap,0))kq=true;break;
                case 611:case 612:case 621:case 622:if(ruleMove.Ma(x0,y0,x,y,positionWhiteMap))kq=true;break;//mã
                case 711:case 712:case 713:case 714:case 715:if(ruleMove.Tot(x0,y0,x,y,true))kq=true;break;
                case 721:case 722:case 723:case 724:case 725:if(ruleMove.Tot(x0,y0,x,y,false))kq=true;break;
            }
        }
        
        return kq;
    }
    //kiểm tra xem có thể bắt quân được hay không
    public boolean isCapture(int x0,int y0,int x, int y,boolean white,int typeGetChess)
    {    
        
        if(!positionWhiteMap.containsKey(x*10+y))
            return false;        
        else 
        {
            if(typeGetChess==511 || typeGetChess==512 || typeGetChess==521 || typeGetChess==522 )
            {
                boolean result=ruleMove.Phao(x0,y0,x,y,white,positionWhiteMap,0);
                return result;                
            }
            else
            {
                if (positionWhiteMap.containsKey(x*10+y))
                    if (positionWhiteMap.get(x*10+y)!=white)
                        return true;
            }
        }
        return false;
    }
      
    //kiểm tra chiếu tướng sau mỗi lượt đi
    public int chieuTuong()
    {
        int xTuongTrang=list.getChess(0).getX();
        int yTuongTrang=list.getChess(0).getY();
        int xTuongDen=list.getChess(16).getX();
        int yTuongDen=list.getChess(16).getY();
        
        if(winRule.chieuTuongXe(list.getChess(5).getX(), list.getChess(5).getY(), list.getChess(16).getX()*10 +list.getChess(16).getY(),positionWhiteMap))
            return 11;
        if(winRule.chieuTuongXe(list.getChess(6).getX(), list.getChess(6).getY(), list.getChess(16).getX()*10 +list.getChess(16).getY(),positionWhiteMap))
            return 11;
        if(winRule.chieuTuongPhao(list.getChess(7).getX(), list.getChess(7).getY(), list.getChess(16).getX()*10 +list.getChess(16).getY(),positionWhiteMap))
            return 21;
        if(winRule.chieuTuongPhao(list.getChess(8).getX(), list.getChess(8).getY(), list.getChess(16).getX()*10 +list.getChess(16).getY(),positionWhiteMap))
            return 21;
        if(winRule.chieuTuongMa(list.getChess(9).getX(), list.getChess(9).getY(), xTuongDen, yTuongDen))
            return 31;            
        if(winRule.chieuTuongMa(list.getChess(10).getX(), list.getChess(10).getY(), xTuongDen, yTuongDen))
            return 31;
        if(winRule.chieuTuongXe(list.getChess(21).getX(), list.getChess(21).getY(), list.getChess(0).getX()*10 +list.getChess(0).getY(),positionWhiteMap))
            return 10;
        if(winRule.chieuTuongXe(list.getChess(22).getX(), list.getChess(22).getY(), list.getChess(0).getX()*10 +list.getChess(0).getY(),positionWhiteMap))
            return 10;
        if(winRule.chieuTuongPhao(list.getChess(23).getX(), list.getChess(23).getY(), list.getChess(0).getX()*10 +list.getChess(0).getY(),positionWhiteMap))
            return 20;
        if(winRule.chieuTuongPhao(list.getChess(24).getX(), list.getChess(24).getY(), list.getChess(0).getX()*10 +list.getChess(0).getY(),positionWhiteMap))
            return 20;
        if(winRule.chieuTuongMa(list.getChess(25).getX(), list.getChess(25).getY(),xTuongTrang, yTuongTrang))
            return 30;
        if(winRule.chieuTuongMa(list.getChess(26).getX(), list.getChess(26).getY(), xTuongTrang, yTuongTrang))
            return 30;
        if(winRule.chieuTuongTot(list.getChess(11).getX(), list.getChess(11).getY(), xTuongDen, yTuongDen, true))
            return 41;
        if(winRule.chieuTuongTot(list.getChess(12).getX(), list.getChess(12).getY(), xTuongDen, yTuongDen, true))
            return 41;
        if(winRule.chieuTuongTot(list.getChess(13).getX(), list.getChess(13).getY(), xTuongDen, yTuongDen, true))
            return 41;
        if(winRule.chieuTuongTot(list.getChess(14).getX(), list.getChess(14).getY(), xTuongDen, yTuongDen, true))
            return 41;
        if(winRule.chieuTuongTot(list.getChess(15).getX(), list.getChess(15).getY(), xTuongDen, yTuongDen, true))
            return 41;
        if(winRule.chieuTuongTot(list.getChess(27).getX(), list.getChess(27).getY(), xTuongTrang, yTuongTrang, false))
            return 40;
        if(winRule.chieuTuongTot(list.getChess(28).getX(), list.getChess(28).getY(), xTuongTrang, yTuongTrang, false))
            return 40;
        if(winRule.chieuTuongTot(list.getChess(29).getX(), list.getChess(29).getY(), xTuongTrang, yTuongTrang, false))
            return 40;
        if(winRule.chieuTuongTot(list.getChess(30).getX(), list.getChess(30).getY(), xTuongTrang, yTuongTrang, false))
            return 40;
        if(winRule.chieuTuongTot(list.getChess(31).getX(), list.getChess(31).getY(), xTuongTrang, yTuongTrang, false))
            return 40;
        return -1;
    }
    public Boolean chieuTuongPheMinh(JLabel label,int x0, int y0,int x, int y, int typeGetChess, Boolean white)
    {
        Boolean kq=false;
        //tạo map mới để không ảnh hưởng map cũ
        Map <Integer,Boolean> positionWhiteMap1=new HashMap<>();
        positionWhiteMap1.putAll(positionWhiteMap);
        int xTuongTrang=list.getChess(0).getX();
        int yTuongTrang=list.getChess(0).getY();
        int xTuongDen=list.getChess(16).getX();
        int yTuongDen=list.getChess(16).getY();
        //cập nhật map mới để sử dụng
        if(positionWhiteMap1.containsKey(10*x+y))
            positionWhiteMap1.remove(10*x+y);
        positionWhiteMap1.remove(x0*10+y0);        
        positionWhiteMap1.put(10*x+y, white);
        int type=-1;
        if      (label==XeTrang1)   type=5;
        else if (label==XeTrang2)   type=6;
        else if (label==PhaoTrang1) type=7;
        else if (label==PhaoTrang2) type=8;
        else if (label==MaTrang1)   type=9;
        else if (label==MaTrang2)   type=10;
        else if (label==TotTrang1)  type=11;
        else if (label==TotTrang2)  type=12;
        else if (label==TotTrang3)  type=13;
        else if (label==TotTrang4)  type=14;
        else if (label==TotTrang5)  type=15;
        
        else if (label==XeDen1)     type=21;
        else if (label==XeDen2)     type=22;
        else if (label==PhaoDen1)   type=23;
        else if (label==PhaoDen2)   type=24;
        else if (label==MaDen1)     type=25;
        else if (label==MaDen2)     type=26;
        else if (label==TotDen1)    type=27;
        else if (label==TotDen2)    type=28;
        else if (label==TotDen3)    type=29;
        else if (label==TotDen4)    type=30;
        else if (label==TotDen5)    type=31;
        if(type==-1)
            return false;
        if(type!= -1)
        {
            list.getChess(type).setX(x);
            list.getChess(type).setY(y);
        }
        int typeChessChieuTuong=-1;
        if(winRule.chieuTuongXe(list.getChess(5).getX(), list.getChess(5).getY(), list.getChess(16).getX()*10 +list.getChess(16).getY(),positionWhiteMap1))
            typeChessChieuTuong=41;
        if(winRule.chieuTuongXe(list.getChess(6).getX(), list.getChess(6).getY(), list.getChess(16).getX()*10 +list.getChess(16).getY(),positionWhiteMap1))
            typeChessChieuTuong=41;
        if(winRule.chieuTuongPhao(list.getChess(7).getX(), list.getChess(7).getY(), list.getChess(16).getX()*10 +list.getChess(16).getY(),positionWhiteMap1))
            typeChessChieuTuong=51;
        if(winRule.chieuTuongPhao(list.getChess(8).getX(), list.getChess(8).getY(), list.getChess(16).getX()*10 +list.getChess(16).getY(),positionWhiteMap1))
            typeChessChieuTuong=51;
        if(winRule.chieuTuongMa(list.getChess(9).getX(), list.getChess(9).getY(), xTuongDen, yTuongDen))
            typeChessChieuTuong=61;     
        if(winRule.chieuTuongMa(list.getChess(10).getX(), list.getChess(10).getY(), xTuongDen, yTuongDen))
            typeChessChieuTuong=61;
        if(winRule.chieuTuongXe(list.getChess(21).getX(), list.getChess(21).getY(), list.getChess(0).getX()*10 +list.getChess(0).getY(),positionWhiteMap1))
            typeChessChieuTuong=42;
        if(winRule.chieuTuongXe(list.getChess(22).getX(), list.getChess(22).getY(), list.getChess(0).getX()*10 +list.getChess(0).getY(),positionWhiteMap1))
            typeChessChieuTuong=42;
        if(winRule.chieuTuongPhao(list.getChess(23).getX(), list.getChess(23).getY(), list.getChess(0).getX()*10 +list.getChess(0).getY(),positionWhiteMap1))
            typeChessChieuTuong=52;
        if(winRule.chieuTuongPhao(list.getChess(24).getX(), list.getChess(24).getY(), list.getChess(0).getX()*10 +list.getChess(0).getY(),positionWhiteMap1))
            typeChessChieuTuong=52;
        if(winRule.chieuTuongMa(list.getChess(25).getX(), list.getChess(25).getY(),xTuongTrang, yTuongTrang))
            typeChessChieuTuong=62;
        if(winRule.chieuTuongMa(list.getChess(26).getX(), list.getChess(26).getY(), xTuongTrang, yTuongTrang))
            typeChessChieuTuong=62;
        if(winRule.chieuTuongTot(list.getChess(11).getX(), list.getChess(11).getY(), xTuongDen, yTuongDen, true))
            typeChessChieuTuong=71;
        if(winRule.chieuTuongTot(list.getChess(12).getX(), list.getChess(12).getY(), xTuongDen, yTuongDen, true))
            typeChessChieuTuong=71;
        if(winRule.chieuTuongTot(list.getChess(13).getX(), list.getChess(13).getY(), xTuongDen, yTuongDen, true))
            typeChessChieuTuong=71;
        if(winRule.chieuTuongTot(list.getChess(14).getX(), list.getChess(14).getY(), xTuongDen, yTuongDen, true))
            typeChessChieuTuong=71;
        if(winRule.chieuTuongTot(list.getChess(15).getX(), list.getChess(15).getY(), xTuongDen, yTuongDen, true))
            typeChessChieuTuong=71;
        if(winRule.chieuTuongTot(list.getChess(27).getX(), list.getChess(27).getY(), xTuongTrang, yTuongTrang, false))
            typeChessChieuTuong=72;
        if(winRule.chieuTuongTot(list.getChess(28).getX(), list.getChess(28).getY(), xTuongTrang, yTuongTrang, false))
            typeChessChieuTuong=72;
        if(winRule.chieuTuongTot(list.getChess(29).getX(), list.getChess(29).getY(), xTuongTrang, yTuongTrang, false))
            typeChessChieuTuong=72;
        if(winRule.chieuTuongTot(list.getChess(30).getX(), list.getChess(30).getY(), xTuongTrang, yTuongTrang, false))
            typeChessChieuTuong=72;
        if(winRule.chieuTuongTot(list.getChess(31).getX(), list.getChess(31).getY(), xTuongTrang, yTuongTrang, false))
            typeChessChieuTuong=72;
        //trả về vị trí cũ 
        System.out.println("after ++ "+list.getChess(type).getX() +list.getChess(type).getY() +" "+kq);
        positionWhiteMap1.clear();
        if(type !=-1)
        {
            list.getChess(type).setX(x0);
            list.getChess(type).setY(y0);
        }
        if(white==false)
            if(typeChessChieuTuong==71 ||typeChessChieuTuong==61 ||typeChessChieuTuong==51 ||typeChessChieuTuong==41 )
                kq=true;
        if(white==true)
            if(typeChessChieuTuong==72 ||typeChessChieuTuong==62 ||typeChessChieuTuong==52 ||typeChessChieuTuong==42 )
                kq=true;
        return kq;
    }
    public Boolean chieuTuongTrang()
    {
        int flag=chieuTuong() ;
        if (flag==10 ||flag==20 ||flag==30 ||flag==40  )
            return true;
        return false;
    }
    public Boolean chieuTuongDen()
    {
        int flag=chieuTuong() ;
        if (flag==11 ||flag==21 ||flag==31 ||flag==41  )
            return true;
        return false;
    }
    
    public void disableDen()
    {
        TotDen1.removeMouseListener(this);
        TotDen2.removeMouseListener(this);
        TotDen3.removeMouseListener(this);
        TotDen4.removeMouseListener(this);
        TotDen5.removeMouseListener(this);
        TuongDen.removeMouseListener(this);
        SiDen1.removeMouseListener(this);
        SiDen2.removeMouseListener(this);
        VoiDen1.removeMouseListener(this);
        VoiDen2.removeMouseListener(this);
        XeDen1.removeMouseListener(this);
        XeDen2.removeMouseListener(this);
        PhaoDen1.removeMouseListener(this);
        PhaoDen2.removeMouseListener(this);
        MaDen1.removeMouseListener(this);
        MaDen2.removeMouseListener(this);
    }
    public void disableTrang()
    {
        TotTrang1.removeMouseListener(this);
        TotTrang2.removeMouseListener(this);
        TotTrang3.removeMouseListener(this);
        TotTrang4.removeMouseListener(this);
        TotTrang5.removeMouseListener(this);
        TuongTrang.removeMouseListener(this);
        SiTrang1.removeMouseListener(this);
        SiTrang2.removeMouseListener(this);
        VoiTrang1.removeMouseListener(this);
        VoiTrang2.removeMouseListener(this);
        XeTrang1.removeMouseListener(this);
        XeTrang2.removeMouseListener(this);
        PhaoTrang1.removeMouseListener(this);
        PhaoTrang2.removeMouseListener(this);
        MaTrang1.removeMouseListener(this);
        MaTrang2.removeMouseListener(this);
    }
    public void enableDen()
    {
        TotDen1.addMouseListener(this);
        TotDen2.addMouseListener(this);
        TotDen3.addMouseListener(this);
        TotDen4.addMouseListener(this);
        TotDen5.addMouseListener(this);
        TuongDen.addMouseListener(this);
        SiDen1.addMouseListener(this);
        SiDen2.addMouseListener(this);
        VoiDen1.addMouseListener(this);
        VoiDen2.addMouseListener(this);
        XeDen1.addMouseListener(this);
        XeDen2.addMouseListener(this);
        PhaoDen1.addMouseListener(this);
        PhaoDen2.addMouseListener(this);
        MaDen1.addMouseListener(this);
        MaDen2.addMouseListener(this);
    }
    public void enableTrang()
    {
        TotTrang1.addMouseListener(this);
        TotTrang2.addMouseListener(this);
        TotTrang3.addMouseListener(this);
        TotTrang4.addMouseListener(this);
        TotTrang5.addMouseListener(this);
        TuongTrang.addMouseListener(this);
        SiTrang1.addMouseListener(this);
        SiTrang2.addMouseListener(this);
        VoiTrang1.addMouseListener(this);
        VoiTrang2.addMouseListener(this);
        XeTrang1.addMouseListener(this);
        XeTrang2.addMouseListener(this);
        PhaoTrang1.addMouseListener(this);
        PhaoTrang2.addMouseListener(this);
        MaTrang1.addMouseListener(this);
        MaTrang2.addMouseListener(this);
    }

    //lưu ván cờ đánh dang dở
    public void save(Piece p,int stt)
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
            String whiteS;
            if (p.getWhite()) 
                whiteS="1" ;
            else whiteS="0" ;
            String xS= String.valueOf(p.getX());
            String yS= String.valueOf(p.getY());
            String typeS= String.valueOf(p.getType());
            String nameS= String.valueOf(p.getName());
            String SQL = "insert into piece(stt,white,alive,x,y,type,name) values ('"+stt+"','"+whiteS+"','1','"+xS+"','"+yS+"','"+typeS+"','"+nameS+"')";         
            Statement statements =  (Statement) conn.createStatement();
            statements.executeUpdate(SQL); 
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
    //load ván cờ đánh dở
    public void loadBoard()
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
            String SQL = "select * from piece ";         
            Statement statements =  (Statement) conn.createStatement();
            statements.executeQuery(SQL);  
            ResultSet rs = statements.executeQuery(SQL);
            while (rs.next()) 
            {
                int stt, alive,white,x,y,type;
                String s;
                stt=rs.getInt(1);
                white=rs.getInt(2);
                alive=rs.getInt(3);
                x=rs.getInt(4);
                y=rs.getInt(5);
                type=rs.getInt(6);
                s=rs.getString(7);
                list.getChess(stt).setX(x);
                list.getChess(stt).setY(y);
                if(alive ==1 )
                    list.getChess(stt).setAlive(true);
                if(alive ==0 ) list.getChess(stt).setAlive(false);
                //System.out.println(stt +"   "+alive + " "+white+"   "+x+"   "+y+" "+s);
                xuLyKhiLoad(x,y,s); 
            } 
            for(int i=0 ; i <32; i++)
                System.out.println(list.getChess(i).getName()+" "+list.getChess(i).getAlive());
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
    //load ván mới
    public void loadNewBoard()
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
            String SQL = "select * from new order by type asc";         
            Statement statements =  (Statement) conn.createStatement();
            statements.executeQuery(SQL);  
            ResultSet rs = statements.executeQuery(SQL);
            while (rs.next()) 
            {
                xuLyKhiLoad(rs.getInt(3),rs.getInt(4),rs.getString(6));
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
    public void clearDataBoard()
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
            String SQL = "delete from piece";         
            Statement statements =  (Statement) conn.createStatement();
            statements.executeUpdate(SQL); 
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
    
    //hàm bổ trở được gọi khi loadBoard , có chức năng xếp cờ ra bàn 
    public void xuLyKhiLoad(int x , int y,  String name)
    {
        JLabel label = new JLabel();
        switch(name)
        {
            case "TuongTrang" : label= TuongTrang;break;
            case "TuongDen" : label= TuongDen;break;
            case "SiTrang1" : label= SiTrang1;break;
            case "SiTrang2" : label= SiTrang2;break;
            case "SiDen1" : label= SiDen1;break;
            case "SiDen2" : label= SiDen2;break;
            case "VoiTrang1" : label= VoiTrang1;break;
            case "VoiTrang2" : label= VoiTrang2;break;
            case "VoiDen1" : label= VoiDen1;break;
            case "VoiDen2" : label= VoiDen2;break;
            case "XeTrang1" : label= XeTrang1;break;
            case "XeTrang2" : label= XeTrang2;break;
            case "XeDen1" : label= XeDen1;break;
            case "XeDen2" : label= XeDen2;break;
            case "PhaoTrang1" : label= PhaoTrang1;break;
            case "PhaoTrang2" : label= PhaoTrang2;break;
            case "PhaoDen1" : label= PhaoDen1;break;
            case "PhaoDen2" : label= PhaoDen2;break;
            case "MaTrang1" : label= MaTrang1;break;
            case "MaTrang2" : label= MaTrang2;break;
            case "MaDen1" : label= MaDen1;break;
            case "MaDen2" : label= MaDen2;break;
            case "TotTrang1" : label= TotTrang1;break;
            case "TotTrang2" : label= TotTrang2;break;
            case "TotTrang3" : label= TotTrang3;break;
            case "TotTrang4" : label= TotTrang4;break;
            case "TotTrang5" : label= TotTrang5;break;
            case "TotDen1" : label= TotDen1;break;
            case "TotDen2" : label= TotDen2;break;
            case "TotDen3" : label= TotDen3;break;
            case "TotDen4" : label= TotDen4;break;
            case "TotDen5" : label= TotDen5;break;            
        }
        label.setLocation(chessPosition.positionPutChessFromMap_X(x)-80, chessPosition.positionPutChessFromMap_Y(y)-80);
        label.setVisible(true);
    }
    //vô hình hết các label cờ
    public void clearBoard()
    {
        TotTrang1.setVisible(false);
        TotTrang2.setVisible(false);
        TotTrang3.setVisible(false);
        TotTrang4.setVisible(false);
        TotTrang5.setVisible(false);
        TuongTrang.setVisible(false);
        SiTrang1.setVisible(false);
        SiTrang2.setVisible(false);
        VoiTrang1.setVisible(false);
        VoiTrang2.setVisible(false);
        XeTrang1.setVisible(false);
        XeTrang2.setVisible(false);
        PhaoTrang1.setVisible(false);
        PhaoTrang2.setVisible(false);
        MaTrang1.setVisible(false);
        MaTrang2.setVisible(false);
        
        TotDen1.setVisible(false);
        TotDen2.setVisible(false);
        TotDen3.setVisible(false);
        TotDen4.setVisible(false);
        TotDen5.setVisible(false);
        TuongDen.setVisible(false);
        SiDen1.setVisible(false);
        SiDen2.setVisible(false);
        VoiDen1.setVisible(false);
        VoiDen2.setVisible(false);
        XeDen1.setVisible(false);
        XeDen2.setVisible(false);
        PhaoDen1.setVisible(false);
        PhaoDen2.setVisible(false);
        MaDen1.setVisible(false);
        MaDen2.setVisible(false);
    }
    //hàm mở ván cở được lưu trong database
    public void continueChess()
    {
        //super.resetListChess();
        super.clearMap();
        super.setUpMap();
        clearBoard(); 
        loadBoard();
        JOptionPane.showMessageDialog(f,"Hãy tiếp tục ván cờ của bạn");
    }
}
