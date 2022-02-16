/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaoDien;

import chess.Piece;
import java.util.Map;
import javax.swing.JLabel;

public class luatChieuTuong 
{
    public luatChieuTuong(){}
    public boolean chieuTuongTot(int x, int y, int xT,int yT, boolean white)
    {
        int posT= xT*10 +yT;
        if(white==true)
        {
            if(y >3)
                return false;
            else
            {
                int pos0= (x+1)*10 +y;
                int pos1= (x-1)*10 +y;
                int pos2= x*10 +y-1;
                if((x-1)<0) pos1=-1;
                if((x+1)>8) pos0=-1;
                if((y-1)<0) pos2=-1;
                if(pos0==posT ||pos1==posT ||pos2==posT )
                    return true;
            }
        }
        else
        {
            if(y <6)
                return false;
            else
            {
                int pos0= (x+1)*10 +y;
                int pos1= (x-1)*10 +y;
                int pos2= x*10 +y+1;
                if((x-1)<0) pos1=-1;
                if((x+1)>8) pos0=-1;
                if((y+1)>9) pos2=-1;
                if(pos0==posT ||pos1==posT ||pos2==posT )
                    return true;
            }
        }
        return false;
    }
    public boolean chieuTuongMa(int x, int y, int xT, int yT)
    {
        int posT=xT*10 + yT;
        int pos0=(x+2)*10 + y+1;
        int pos1=(x-2)*10 + y+1;
        int pos2=(x+2)*10 + y-1;
        int pos3=(x-2)*10 + y-1;
        int pos4=(x-1)*10 + y+2;
        int pos5=(x-1)*10 + y-2;
        int pos6=(x+1)*10 + y+2;
        int pos7=(x+1)*10 + y-2;
        if(y+2>9)
        {
            pos4=-1;
            pos6=-1;            
        }
        if(y+1>9)
        {
            pos0=-1;
            pos1=-1;            
        }
        if(y-1<0)
        {
            pos2=-1;
            pos3=-1;            
        }
        if(y-2<0)
        {
            pos5=-1;
            pos7=-1;            
        }
        if(x-1<0)
        {
            pos4=-1;
            pos5=-1;            
        }
        if(x-2<0)
        {
            pos1=-1;
            pos3=-1;            
        }
        if(pos0==posT || pos1==posT ||pos2==posT||pos3==posT||pos4==posT||pos5==posT||pos6==posT||pos7==posT)
            return true;
        return false;
    }
    public boolean chieuTuongPhao(int x, int y, int positionTuong,Map <Integer,Boolean> positionWhiteMap)
    {
        int count=0;
        int xT=positionTuong/10;
        int yT= positionTuong -xT*10;
        if(xT!=x && yT != y)
            return false;
        if(x==xT)
        {
            if(y>yT)
                for(int i=yT+1; i<y; i++)
                    if(positionWhiteMap.containsKey(x*10+i))
                        count++;
            if(y<yT)
                for(int i=y+1; i<yT; i++)
                    if(positionWhiteMap.containsKey(x*10+i))
                        count++;
        }
        if(y==yT)
        {
            if(x>xT)
                for(int i=xT+1; i<x; i++)
                    if(positionWhiteMap.containsKey(i*10+y))
                        count++;
            if(x<xT)
                for(int i=x+1; i<xT; i++)
                    if(positionWhiteMap.containsKey(i*10+y))
                        count++;
        }
        
        if(count==1 )
            return true;
        return false;
    }
    public boolean chieuTuongXe(int x, int y, int positionTuong,Map <Integer,Boolean> positionWhiteMap)
    {
        int count=0;
        int xT=positionTuong/10;
        int yT= positionTuong -xT*10;
        if(xT!=x && yT != y)
            return false;
        if(x==xT)
        {
            if(y>yT)
                for(int i=yT+1; i<y; i++)
                    if(positionWhiteMap.containsKey(x*10+i))
                        count++;
            if(y<yT)
                for(int i=y+1; i<yT; i++)
                    if(positionWhiteMap.containsKey(x*10+i))
                        count++;
        }
        if(y==yT)
        {
            if(x>xT)
                for(int i=xT+1; i<x; i++)
                    if(positionWhiteMap.containsKey(i*10+y))
                        count++;
            if(x<xT)
                for(int i=x+1; i<xT; i++)
                    if(positionWhiteMap.containsKey(i*10+y))
                        count++;
        }        
        if(count==0 )
            return true;
        return false;
    }
}
