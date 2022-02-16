/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaoDien;
public class viTriDatQuanCo 
{
    public viTriDatQuanCo(){}
     public int positionInMap_X(int x)
    {
        if(x>=0 && x<=120)
            return 0;
        else if(x>=121 && x<=190)
            return 1;
        else if(x>=191 && x<=260)
            return 2;
        else if(x>=261 && x<=330)
            return 3;
        else if(x>=331 && x<=400)
            return 4;
        else if(x>=401 && x<=480)
            return 5;
        else if(x>=481 && x<=550)
            return 6;
        else if(x>=551&& x<=620)
            return 7;
        else if(x>=621 && x<=680)
            return 8;
        else
            return -1;
    }
    public int positionInMap_Y(int y)
    {
        if(y>=61 && y<=120)
            return 0;
        else if(y>=121 && y<=190)
            return 1;
        else if(y>=191 && y<=260)
            return 2;
        else if(y>=261 && y<=330)
            return 3;
        else if(y>=331 && y<=400)
            return 4;
        else if(y>=401 && y<=480)
            return 5;
        else if(y>=481&& y<=550)
            return 6;
        else if(y>=551 && y<=630)
            return 7;
        else if(y>=631 && y<=710)
            return 8;
        else if(y>=711 && y<=770)
            return 9;
        else
            return -1;
    }
    public int positionPutChessFromCoor_X(int x)
    {
        if(x>=0 && x<=120)
            return 85;
        else if(x>=121 && x<=190)
            return 155;
        else if(x>=191 && x<=260)
            return 227;
        else if(x>=261 && x<=330)
            return 296;
        else if(x>=331 && x<=400)
            return 367;
        else if(x>=401 && x<=480)
            return 440;
        else if(x>=481 && x<=550)
            return 510;
        else if(x>=551&& x<=620)
            return 580;
        else if(x>=621 && x<=680)
            return 652;
        else
            return 85;
    }
    public int positionPutChessFromCoor_Y(int y)
    {
        if(y>=61 && y<=120)
            return 82;
        else if(y>=121 && y<=190)
            return 153;
        else if(y>=191 && y<=260)
            return 225;
        else if(y>=261 && y<=330)
            return 300;
        else if(y>=331 && y<=400)
            return 372;
        else if(y>=401 && y<=480)
            return 448;
        else if(y>=481&& y<=550)
            return 519;
        else if(y>=551 && y<=630)
            return 593;
        else if(y>=631 && y<=710)
            return 668;
        else if(y>=711 && y<=770)
            return 740;
        else
            return 85;
    }
    public int positionPutChessFromMap_X(int x)
    {
        int result=85;
        switch(x)
        {
            case 0:result=85;break;
            case 1:result=155;break;
            case 2:result=227;break;
            case 3:result=296;break;
            case 4:result=367;break;
            case 5:result=440;break;
            case 6:result=510;break;
            case 7:result=580;break;
            case 8:result=652;break;
        }
        return result;
    }
    public int positionPutChessFromMap_Y(int y)
    {
        int result=85;
        switch(y)
        {
            case 0:result=82;break;
            case 1:result=153;break;
            case 2:result=225;break;
            case 3:result=300;break;
            case 4:result=372;break;
            case 5:result=448;break;
            case 6:result=519;break;
            case 7:result=593;break;
            case 8:result=668;break;
            case 9:result=740;break;
        }
        return result;
    }
    
}
