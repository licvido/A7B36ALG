
package semestralniprace;
import java.io.Serializable;

public class SeznamCD implements Serializable {

    public CD [] seznam;

    SeznamCD(){
        seznam = new CD[50];
    }

    SeznamCD(int polozek){
        seznam = new CD[polozek];
    }

    public int pridatCD(CD cede){
        for(int i = 0; i < seznam.length; i++)
        {
            if (seznam[i]==null)
            {
                seznam[i]=cede;

                System.out.println("CD bylo pridano do seznamu.");
                return 1;
            }
        }

        System.out.println("Pridani CD do seznamu se nezdarilo!");
        return 0;
    }

    public void vypsatCD(int i){
        if(seznam[i] != null)
        {
            System.out.println("DETAILNI VYPIS CD");
            System.out.println("Id CD: "+i);
            System.out.println("Interpret: "+seznam[i].getInterpret());
            System.out.println("Titul: "+seznam[i].getTitul());
            System.out.println("Rok: "+seznam[i].getRok());
        }else{
            System.out.println("Zvolene CD nebylo nalezeno.");
        }
    }

    public void vypsatSeznam(){
        int pocet = 0;

        for(int i=0; i < seznam.length; i++)
        {
            if(seznam[i] != null)
            {
                System.out.println("#"+i+" "+seznam[i].getInterpret()+" - "+seznam[i].getTitul()+" ("+seznam[i].getRok()+")");
                pocet++;
            }
        }

        if(pocet == 0)
            System.out.println("Seznam je prazdny.");
        if(pocet == 1)
            System.out.println("Vypsana 1 polozka.");
        if(pocet == 2 || pocet == 3 || pocet == 4)
            System.out.println("Vypsany "+pocet+" polozky.");
        if(pocet >= 5)
            System.out.println("Vypsano "+pocet+" polozek.");
    }

    public void odebratCD(int i){
        CD cede;

        cede = seznam[i];
        if(seznam[i] != null)
        {
            seznam[i] = null;
            System.out.println("CD bylo odebrano ze seznamu.");
        }else{
            System.out.println("CD nebylo nalezeno, proto nelze odebrat.");
        }
    }

    public int polozek(){
        int pol = 0;

        for(int i = 0; i < seznam.length; i++)
        {
            if(seznam[i] != null)
                pol++;
        }

        return pol;
    }

    public void hledatCD(String q){
        int pol = 0;

        for(int i=0; i < seznam.length; i++)
        {
            if(seznam[i] != null)
            {
                if((seznam[i].getInterpret()).equals(q) || (seznam[i].getTitul()).equals(q))
                {
                    pol++;
                    System.out.println("#"+i+" "+seznam[i].getInterpret()+" - "+seznam[i].getTitul()+" ("+seznam[i].getRok()+")");
                }
            }
        }

        if(pol == 0)
            System.out.println("Pro vyraz \""+q+"\" nebyl nalezen zadny vysledek.");
        if(pol == 1)
            System.out.println("Nalezena 1 polozka.");
        if(pol == 2 || pol == 3 || pol == 4)
            System.out.println("Nalezeny "+pol+" polozky.");
        if(pol >= 5)
            System.out.println("Nalezeno "+pol+" polozek.");
    }

}
