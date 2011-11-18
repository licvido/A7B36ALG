
package semestralniprace;
import java.io.Serializable;

public class CD implements Serializable {


    public String info;

    private int rok;
    private String interpret;
    private String titul;

    CD(String i, String t, int r){
        interpret = i;
        titul = t;
        rok = r;
        info="CD: "+interpret+" - "+titul+" ("+rok+")";
    }



    public String getInterpret(){
        return interpret;
    }

    public String getTitul(){
        return titul;
    }

    public int getRok(){
        return rok;
    }


}
