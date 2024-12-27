import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] Mainmenu) {
        Scanner menu = new Scanner(System.in);
        System.out.println("Select an option:");

        Object[][] menuTab = new Object[4][2];
        menuTab[0][0] = (byte) 1;
        menuTab[0][1] = "Install";
        menuTab[1][0] = (byte) 2;
        menuTab[1][1] = "Basic mode";
        menuTab[2][0] = (byte) 3;
        menuTab[2][1] = "Advanced mode";
        menuTab[3][0] = (byte) 4;
        menuTab[3][1] = "Exit";

        for (Object[] row : menuTab) {  // Przechodzimy po każdym wierszu (tablicy jednowymiarowej)
            for (Object element : row) {  // Przechodzimy po każdym elemencie w wierszu
                System.out.print(element + " ");
            }
            System.out.println();
        }
        byte menuVar = menu.nextByte();

        if (menuVar == (byte) 1) {
            MenuInstall.InstallationPowerShellScript();
            First.firstOption();
            Main.main(Mainmenu);
        } else if (menuVar == (byte) 2) {
            Second.secondOption();
        } else if (menuVar == (byte) 3) {
            Third.thirdOption();
        } else if (menuVar == (byte) 4) {
            System.out.println("\u001B[33mSelected Exit\u001B[0m");
            System.exit(0);
        } else {
            System.out.println("Wrong Number");
            Main.main(Mainmenu);
        }
    }
}
class First {
    public static void firstOption() {
        System.out.println("Installation complete");

        try {
            Thread.sleep(2000); // Wstrzymanie na 5000 milisekund czyli 5 sekund
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Getting back to menu...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Second {
    public static void secondOption() {
        System.out.println("\u001B[33mSelected Basic mode\u001B[0m");
    }
}
class Third {
    public static void thirdOption() {
        System.out.println("\u001B[33mSelected Advanced mode\u001B[0m");
    }
}

class MenuInstall {
    public static void InstallationPowerShellScript() {
        System.out.println("\u001B[33mSelected Install option\u001B[0m");
        String command = "C:\\Users\\admin\\Desktop\\Nmap-Scanner\\src\\installNmap.ps1";
        ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-ExecutionPolicy", "Bypass", "-File", command);
        try {
            // Uruchamiamy proces
            Process process = processBuilder.start();

            // Odczytujemy dane wyjściowe
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Wyświetlanie danych wyjściowych skryptu
            }
            // Oczekujemy na zakończenie procesu
            int exitCode = process.waitFor();
            System.out.println("End with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
