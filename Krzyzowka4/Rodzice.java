package Krzyzowka4;

import java.util.Arrays;

public class Rodzice {

    private String Rodzic1;
    private String Rodzic2;

    //Konstruktor rodziców
    public Rodzice(String Rodzic1, String Rodzic2){
        this.Rodzic1 = Rodzic1;
        this.Rodzic2 = Rodzic2;

        //Zaklinam rodziców w tablice i ich literuje
        String[] Rodzic1WTablicy = Rodzic1.split("");
        Arrays.sort(Rodzic1WTablicy);

        String[] Rodzic2WTablicy = Rodzic2.split("");
        Arrays.sort(Rodzic2WTablicy);

        //Tworze AB, Ab, aB, ab
        //                          ***Trzeba to zautomatyzować***
        /*
            0  1  2  3
            A, a, B, b
            A, a, B, b
        */
        String pierwszyAllel = Rodzic1WTablicy[0] + Rodzic2WTablicy[1]; //AB
        String drugiAllel = Rodzic1WTablicy[0] + Rodzic2WTablicy[3];    //Ab
        String trzeciAllel = Rodzic1WTablicy[2] + Rodzic2WTablicy[1];   //aB
        String czwartyAllel = Rodzic1WTablicy[2] + Rodzic2WTablicy[3];  //ab

        System.out.println("1 " + pierwszyAllel + " 2 " + drugiAllel + " 3 " + trzeciAllel + " 4 " + czwartyAllel);

        String[][] krzyzowkaGenetyczna = new String[Rodzic1.length()+1][Rodzic2.length()+1];
        krzyzowkaGenetyczna [0][0] = null;

        krzyzowkaGenetyczna [0][1] = pierwszyAllel;
        krzyzowkaGenetyczna [0][2] = drugiAllel;
        krzyzowkaGenetyczna [0][3] = trzeciAllel;
        krzyzowkaGenetyczna [0][4] = czwartyAllel;

        krzyzowkaGenetyczna [1][0] = pierwszyAllel;
        krzyzowkaGenetyczna [2][0] = drugiAllel;
        krzyzowkaGenetyczna [3][0] = trzeciAllel;
        krzyzowkaGenetyczna [4][0] = czwartyAllel;

        for (int i = 1; i <= Rodzic1.length(); i++){
            //krzyzowkaGenetyczna[0][i] = null;
            //krzyzowkaGenetyczna[i][0] = null;

                //[1][1], [2][1], [3][1], [4][1]
                krzyzowkaGenetyczna[i][1] = krzyzowkaGenetyczna[i][0] + krzyzowkaGenetyczna[0][1];

                //[1][2], [2][2], [3][2], [4][2]
                krzyzowkaGenetyczna[i][2] = krzyzowkaGenetyczna[i][0] + krzyzowkaGenetyczna[0][2];

                //[1][3], [2][3], [3][3], [4][3]
                krzyzowkaGenetyczna[i][3] = krzyzowkaGenetyczna[i][0] + krzyzowkaGenetyczna[0][3];

                //[1][4], [2][4], [3][4], [4][4]
                krzyzowkaGenetyczna[i][4] = krzyzowkaGenetyczna[i][0] + krzyzowkaGenetyczna[0][4];

            //Arrays.sort(krzyzowkaGenetyczna);
                for(int j = 1; j <= 4; j++){
                    System.out.println(i + "." + j +". " + krzyzowkaGenetyczna[i][j]);
                }

        }

    }
}
