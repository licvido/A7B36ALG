
package semestralniprace;

import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.println("1) Vytvorit seznam");
        System.out.println("2) Nacist seznam");
        System.out.println("3) Ulozit seznam");
        System.out.println("4) Pridat CD");
        System.out.println("5) Odebrat CD");
        System.out.println("6) Vypsat urcite CD");
        System.out.println("7) Vypsat cely seznam");
        System.out.println("8) Vyhledat CD");
        System.out.println("9) Menu");
        System.out.println("0) Ukoncit program");

        SeznamCD db = new SeznamCD();

        boolean konec = false;

        while(!konec)
        {
            System.out.print("\nZadejte cislo polozky v menu: ");
            int menu = scan.nextInt();

            switch(menu){
                case 1:
                        scan.nextLine();
                        System.out.println("VYTVORENI SEZNAMU");
                        System.out.println("Velikost seznamu: ");
                        int velikost = scan.nextInt();

                        db = new SeznamCD(velikost);

                        break;
                case 2:
                    try
                    {         
                        File soubor = new File("seznam.dat");
                        ObjectInputStream in = new ObjectInputStream(new FileInputStream(soubor));

                        db = (SeznamCD)in.readObject();
                        in.close();
                    }
                    catch(ClassNotFoundException e)
                        {
                            System.out.println("Nepodarilo se najit definici tridy: "+e);
                            break;
                        }
                    catch(IOException e)
                        {
                            System.out.println("Nacteni souboru se nezdarilo: "+e);
                            break;
                        }
                    System.out.println("Seznam byl uspesne nacten ze souboru.");

                    break;
                case 3:
                    SeznamCD seznam = db;

                    try {
                        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("seznam.dat"));
                        out.writeObject(seznam);

                        out.close();
                    }
                    catch (IOException e)
                        {
                            System.out.println("Zapsani souboru se nezdarilo: "+e);
                            break;
                        }
                    System.out.println("Seznam byl uspesne ulozen do souboru.");

                    break;
                case 4:
                    scan.nextLine();
                    System.out.println("PRIDANI CD DO SEZNAMU");

                    System.out.print("Interpret: ");
                        String interpret = scan.nextLine();
                    System.out.print("Titul: ");
                        String titul = scan.nextLine();
                    System.out.print("Rok: ");
                        int rok = scan.nextInt();

                        String prazdny = "";

                    if(interpret.equals(prazdny))
                        interpret = "Neznamy interpret";
                    if(titul.equals(prazdny))
                        titul = "Neznamy disk";
                    if(rok < 1900 && rok > 2010)
                        rok = 2010;

                    CD noveCD = new CD(interpret,titul,rok);
                    db.pridatCD(noveCD);

                    break;
                case 5:
                    scan.nextLine();
                    System.out.println("ODEBRANI CD ZE SEZNAMU");

                    System.out.print("Cislo CD, ktere se ma odebrat: ");
                        int del = scan.nextInt();

                    db.odebratCD(del);

                    break;
                case 6:
                    scan.nextLine();
                    System.out.println("VYPSANI URCITEHO CD");

                    System.out.print("Cislo CD, ktere se ma vypsat: ");
                        int vyb = scan.nextInt();

                    db.vypsatCD(vyb);

                    break;
                case 7:
                    System.out.println("VYPSANI CELEHO SEZNAMU");

                    db.vypsatSeznam();

                    break;
                case 8:
                    scan.nextLine();
                    System.out.println("VYHLEDANI URCITEHO CD");

                    System.out.print("Presny text, ktery chcete hledat: ");
                        String hled = scan.nextLine();

                    db.hledatCD(hled);

                    break;
                case 9:
                    System.out.println("1) Vytvorit seznam");
                    System.out.println("2) Nacist seznam");
                    System.out.println("3) Ulozit seznam");
                    System.out.println("4) Pridat CD");
                    System.out.println("5) Odebrat CD");
                    System.out.println("6) Vypsat urcite CD");
                    System.out.println("7) Vypsat cely seznam");
                    System.out.println("8) Vyhledat CD");
                    System.out.println("9) Menu");
                    System.out.println("0) Ukoncit program");

                    break;
                case 0:
                    konec = true;
                    System.out.println("Program byl ukoncen. Nashledanou :-)");

                    break;

                default:
                    System.out.println("Zadejte cislo polozky v rozmezi 1 az 9 (9 zobrazi menu, 0 pro konec): ");
                    break;

            }//switch
        }//while


    }

}
