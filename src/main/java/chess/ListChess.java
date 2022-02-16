/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;
import java.util.*;
/*type chess
Tướng       1
Sĩ          2
Voi         3
XE          4
Pháo        5
Mã          6
Tốt         7
*/
public class ListChess 
{
    private ArrayList<Piece> list;
    public ListChess()
    {
        //thêm cờ trắng
        list = new ArrayList<Piece >();
        list.add(new Piece(true, true, 1, 4, 9,"TuongTrang"));//0
        list.add(new Piece(true, true, 2, 3, 9,"SiTrang1"));
        list.add(new Piece(true, true, 2, 5, 9,"SiTrang2"));
        list.add(new Piece(true, true, 3, 2, 9,"VoiTrang1"));
        list.add(new Piece(true, true, 3, 6, 9,"VoiTrang2"));//4
        list.add(new Piece(true, true, 4, 0, 9,"XeTrang1"));
        list.add(new Piece(true, true, 4, 8, 9,"XeTrang2"));
        list.add(new Piece(true, true, 5, 1, 7,"PhaoTrang1"));
        list.add(new Piece(true, true, 5, 7, 7,"PhaoTrang2"));//8
        list.add(new Piece(true, true, 6, 1, 9,"MaTrang1"));//9
        list.add(new Piece(true, true, 6, 7, 9,"MaTrang2"));//10
        list.add(new Piece(true, true, 7, 0, 6,"TotTrang1"));
        list.add(new Piece(true, true, 7, 2, 6,"TotTrang2"));
        list.add(new Piece(true, true, 7, 4, 6,"TotTrang3"));
        list.add(new Piece(true, true, 7, 6, 6,"TotTrang4"));
        list.add(new Piece(true, true, 7, 8, 6,"TotTrang5"));//15
        //thêm cờ đen
        list.add(new Piece(false, true, 1, 4, 0,"TuongDen"));//16
        list.add(new Piece(false, true, 2, 3, 0,"SiDen1"));
        list.add(new Piece(false, true, 2, 5, 0,"SiDen2"));
        list.add(new Piece(false, true, 3, 2, 0,"VoiDen1"));
        list.add(new Piece(false, true, 3, 6, 0,"VoiDen2"));//20
        list.add(new Piece(false, true, 4, 0, 0,"XeDen1"));
        list.add(new Piece(false, true, 4, 8, 0,"XeDen2"));
        list.add(new Piece(false, true, 5, 1, 2,"PhaoDen1"));
        list.add(new Piece(false, true, 5, 7, 2,"PhaoDen2"));
        list.add(new Piece(false, true, 6, 1, 0,"MaDen1"));//25
        list.add(new Piece(false, true, 6, 7, 0,"MaDen2"));
        list.add(new Piece(false, true, 7, 0, 3,"TotDen1"));
        list.add(new Piece(false, true, 7, 2, 3,"TotDen2"));
        list.add(new Piece(false, true, 7, 4, 3,"TotDen3"));
        list.add(new Piece(false, true, 7, 6, 3,"TotDen4"));//30
        list.add(new Piece(false, true, 7, 8, 3,"TotDen5"));//31
    }
    public Piece getChess(int x)
    {
        return list.get(x);
    }
}
