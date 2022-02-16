/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaoDien;

import java.util.Map;

public class luatDiChuyen 
{
    public luatDiChuyen(){}
    
    public boolean Phao(int x0, int y0,int x, int y,boolean white,Map <Integer,Boolean> positionWhiteMap,int count)
    {
        if(x0==x || y0==y)
        {
            if(x==x0)
            {
                if(y>y0)
                    for(int i=y0+1; i<y; i++)
                        if(positionWhiteMap.containsKey(x*10+i))
                            count++;
                if(y<y0)
                    for(int i=y+1; i<y0; i++)
                        if(positionWhiteMap.containsKey(x*10+i))
                            count++;
            }
            if(y==y0)
            {
                if(x>x0)
                    for(int i=x0+1; i<x; i++)
                        if(positionWhiteMap.containsKey(i*10+y))
                            count++;
                if(x<x0)
                    for(int i=x+1; i<x0; i++)
                        if(positionWhiteMap.containsKey(i*10+y))
                            count++;
            }
            if(count==0&& positionWhiteMap.containsKey(x*10+y)==false)
                return true;
        }            
        if(count==1 && positionWhiteMap.containsKey(x*10+y))
            return true;
        
        return false;
    }
    public boolean Xe(int x0, int y0,int x, int y,boolean white,Map <Integer,Boolean> positionWhiteMap,int count)
    {
       
        if(x0==x || y0==y)
        {
            if(x==x0)
            {
                if(y>y0)
                    for(int i=y0+1; i<y; i++)
                        if(positionWhiteMap.containsKey(x*10+i))
                            count++;
                if(y<y0)
                    for(int i=y+1; i<y0; i++)
                        if(positionWhiteMap.containsKey(x*10+i))
                            count++;
            }
            if(y==y0)
            {
                if(x>x0)
                    for(int i=x0+1; i<x; i++)
                        if(positionWhiteMap.containsKey(i*10+y))
                            count++;
                if(x<x0)
                    for(int i=x+1; i<x0; i++)
                        if(positionWhiteMap.containsKey(i*10+y))
                            count++;
            }
            if(count==0)
                return true;
        }            
        return false;
    }
    
    public boolean Tuong(int x0, int y0,int x, int y, boolean white )
    {
        //  || () 
        if((y0==y && Math.abs(x-x0)==1) || (x0==x && Math.abs(y-y0)==1) )
        {
            if(white ==true)
            {
                if(x>=3 && x<=5 && y>=7 && y<=9)
                {
                    return true;
                }
            }
            else 
            {
                if(x>=3 && x<=5 && y>=0 && y<=2)
                {
                    return true;
                }
            }
        }
        
        return false;
     
    }
    public boolean Si(int x, int y, boolean white )
    {
        if(white ==true)
        {
            if(x==3 && y==9) return true;
            if(x==3 && y==7) return true;
            if(x==4 && y==8) return true;
            if(x==5 && y==7) return true;
            if(x==5 && y==9) return true;
        }
        else 
        {
            if(x==3 && y==2) return true;
            if(x==3 && y==0) return true;
            if(x==4 && y==1) return true;
            if(x==5 && y==0) return true;
            if(x==5 && y==2) return true;
        }
        return false;
     
    }
    public boolean Ma(int x0, int y0, int x, int y, Map <Integer,Boolean> positionWhiteMap)
    {
        boolean result= false;
        int position=0;
        if(Math.abs(x-x0)==1 && Math.abs(y-y0)==2)
        {
            position=x0*10+(y+y0)/2;
            if(!positionWhiteMap.containsKey(position))
                result=true;
        }            
        else
        {            
            if(Math.abs(x-x0)==2 && Math.abs(y-y0)==1)
            {
                position=(x+x0)*5 + y0;
                if(!positionWhiteMap.containsKey(position))
                    result=true;
            }            
        }
        return result;
    }
    public boolean Tot(int x0, int y0, int x, int y, boolean white)
    {
        boolean result= false;
        if(white==true)
        {
            if(y0>=5)
                if(x==x0 && (y==y0-1))
                    result=true;
            if(y0<5)            
                if((Math.abs(x-x0)+Math.abs(y-y0))<=1)
                    result=true;    
            if((y-y0)==1)
                result=false;
        }
        else
        {
            
            if(x==x0&& (y==y0+1))
                    result=true;
            if(y0>4)            
                if((Math.abs(x-x0)+Math.abs(y-y0))<=1)
                    result=true;
            if((y-y0)==-1)
                result=false;
        }
        
        return result;
    }
    public boolean Voi(int x0, int y0, int x, int y, boolean white)
    {
        boolean result= false;
        if(white==true)
        {
            if(Math.abs(x-x0)==2 && Math.abs(y-y0)==2 && y>=5)
                result=true;
        }
        else if(Math.abs(x-x0)==2 && Math.abs(y-y0)==2 && y<=4)
            result=true;
        return result;
    }
}
