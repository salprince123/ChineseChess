/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
public class Piece 
{
    private boolean white;
    private boolean alive;
    private int x; 
    private int y; 
    private int type;
    private String name;
    public Piece()
    {
        this.white=true;
        this.alive=true;
        this.x=0;
        this.y=0;
        this.type=-1;
        this.name="";
        
    }
    public Piece(boolean white, boolean alive,int type, int x, int y, String s)
    {
        this.white=white;
        this.alive=alive;
        this.x=x;
        this.y=y;
        this.name=s;
        this.type=type;
    }
    public void setWhite(boolean status)
    {
        this.white= status;
    }
    public void setAlive(boolean status)
    {
        this.alive= status;
    }
    public boolean getWhite()
    {
        return this.white;
    }
    public boolean getAlive()
    {
        return this.alive;
    }
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public String getName()
    {
        return this.name;
    }
    public int getType()
    {
        return this.type;
    }
    public Piece copyChess()
    {
        return this;
    }
}
