import java.util.Scanner;
import java.util.Random;

public class TikTakToe3 {

    public static String[][] spielbrett;

    public static void erstelleSpielBrett() {
        spielbrett = new String[5][5];
        for (int reihe = 0; reihe < spielbrett.length; reihe++) {
            for (int spalte = 0; spalte < spielbrett[0].length; spalte++) {
                if ((reihe + 1) % 2 == 0 && (spalte + 1) % 2 == 0) {
                    spielbrett[reihe][spalte] = " + ";
                } else if (reihe % 2 == 0 && spalte % 2 == 1) {
                    spielbrett[reihe][spalte] = " | ";
                } else if ((reihe + 1) % 2 == 0 && (spalte + 1) % 2 == 1) {
                    spielbrett[reihe][spalte] = "-";
                } else {
                    spielbrett[reihe][spalte] = " ";
                }
            }
        }
    }

    public static void ausgabeSpielBrett() {
        for (int reihe = 0; reihe < spielbrett.length; reihe++) {
            for (int spalte = 0; spalte < spielbrett[0].length; spalte++) {
                System.out.print(spielbrett[reihe][spalte]);
            }
            System.out.println();
        }
    }

    public static boolean setzeStein(String[][] spielbrett, String spieler, int position) {

        switch (position) {
            case 1:
                if (spielbrett[4][0].equals(" ")) {
                    spielbrett[4][0] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 1 ist schon belegt");
                }
                break;
            case 2:
                if (spielbrett[4][2].equals(" ")) {
                    spielbrett[4][2] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 2 ist schon belegt");
                }
                break;
            case 3:
                if (spielbrett[4][4].equals(" ")) {
                    spielbrett[4][4] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 3 ist schon belegt");
                }
                break;
            case 4:
                if (spielbrett[2][0].equals(" ")) {
                    spielbrett[2][0] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 4 ist schon belegt");
                }
                break;
            case 5:
                if (spielbrett[2][2].equals(" ")) {
                    spielbrett[2][2] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 5 ist schon belegt");
                }
                break;
            case 6:
                if (spielbrett[2][4].equals(" ")) {
                    spielbrett[2][4] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 6 ist schon belegt");
                }
                break;
            case 7:
                if (spielbrett[0][0].equals(" ")) {
                    spielbrett[0][0] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 7 ist schon belegt");
                }
                break;
            case 8:
                if (spielbrett[0][2].equals(" ")) {
                    spielbrett[0][2] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 8 ist schon belegt");
                }
                break;
            case 9:
                if (spielbrett[0][4].equals(" ")) {
                    spielbrett[0][4] = spieler;
                    return true;
                } else {
                    System.out.println("Das Feld 9 ist schon belegt");
                }
                break;
        }
        return false;
    }

    public static boolean checkWin(String[][] spielbrett, String spieler) {
        for (int reihe = 0; reihe < 6; reihe += 2) {
            if (spielbrett[reihe][0].equals(spieler) && spielbrett[reihe][2].equals(spieler) && spielbrett[reihe][4].equals(spieler)) {
                ausgabeSpielBrett();
                System.out.println("Gewonnen hat " + spieler);
                return true;
            }
        }

        for (int spalte = 0; spalte < 6; spalte += 2) {
            if (spielbrett[0][spalte].equals(spieler) && spielbrett[2][spalte].equals(spieler) && spielbrett[4][spalte].equals(spieler)) {
                ausgabeSpielBrett();
                System.out.println("Gewonnen hat " + spieler);
                return true;
            }
        }
        if (spielbrett[0][4].equals(spieler) && spielbrett[2][2].equals(spieler) && spielbrett[4][0].equals(spieler)) {
            ausgabeSpielBrett();
            System.out.println("Gewonnen hat " + spieler);
            return true;
        }

        if (spielbrett[4][4].equals(spieler) && spielbrett[2][2].equals(spieler) && spielbrett[0][0].equals(spieler)) {
            ausgabeSpielBrett();
            System.out.println("Gewonnen hat " + spieler);
            return true;

        }
        return false;
    }

    public static void main(String[] args) {

        Random random = new Random();
        erstelleSpielBrett();

        String spielerX = "X";
        String spieler0 = "0";

        //Wer den Startstein legen darf
        boolean spielzug = random.nextBoolean();
        System.out.println("Startspieler ist " + (spielzug ? "Spieler" : "Computer"));

        boolean win = false;
        int steine = 0;

        while (steine < 9 && !win) {
            ausgabeSpielBrett();

            int position;
            boolean gueltigerZug;

            do {
                if (spielzug) {
                    System.out.println("Spieler ist am Zug");
                    Scanner scanner = new Scanner(System.in);
                    position = scanner.nextInt();

                } else {
                    position = random.nextInt(9) + 1;
                    System.out.println("Der Computer hat einen Stein in das Feld " + position + " gesetzt.");
                }
                gueltigerZug = setzeStein(spielbrett, spielzug ? spielerX : spieler0, position);
                if (!gueltigerZug) {
                    System.out.println("Nicht gültiger Zug");
                }
            } while (!gueltigerZug);
            //spielzug wird auf false gesetzt, sodass die do-while Schleife den Commputer Zug durchläuft

            if (checkWin(spielbrett, spielzug ? spielerX : spieler0)) {

                win = true;


            } else {
                spielzug = !spielzug;
                steine++;
            }
        }
        if (!win) {
            ausgabeSpielBrett();
            System.out.println("Unentschieden");
        }


        System.out.println("Dange fors Spielön");
    }
}