import java.util.Scanner;

public class Main {
    public static void main(String[] Mainmenu) {
        Scanner menu = new Scanner(System.in);
        System.out.println("Wybierz funkcje");

        Object[][] menuTab = new Object[2][2];
        menuTab[0][0] = (byte) 1;
        menuTab[0][1] = "Instalacja";
        menuTab[1][0] = (byte) 2;
        menuTab[1][1] = "Użycie";

//        for (byte i = 0; i < menuTab.length; i++) {
//            for (byte j = 0; j < menuTab[i].length; j++) {
//                System.out.print(menuTab[i][j] + " ");
//            }
//            System.out.println();
//        }
        byte menuVar = menu.nextByte();

        if (menuVar == (byte) 1) {
            System.out.println("Git");
            MenuInstall.InstallationPowerShellScript();
            System.out.println("Instalacja zakończona, kontynuujemy w Main");

        } else if ( menuVar == (byte) 2) {
            System.out.println("NieGit");
        } else {
            System.out.println("Dupa");
        }
         //Main.main(Mainmenu);

    } // method
}// class
