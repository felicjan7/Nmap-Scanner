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
        First.InstallationPowerShellScript();
        System.out.println("Installation complete");

        try {
            Thread.sleep(2000); // Wstrzymanie na 2000 milisekund czyli 2 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Getting back to menu...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.main(new String[0]);
    }
    private static void InstallationPowerShellScript() {
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

class Second {
    public static void secondOption() {
        System.out.println("\u001B[33mSelected Basic mode\u001B[0m");
        String command = "nmap --version";
        ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-c", command);
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean isNmapInstalled = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Nmap version 7.95")) {
                    isNmapInstalled = true;
                    break;
                }
            }

            if (isNmapInstalled) {
                System.out.println("Check for nmap installed");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(line);
                menu();
            } else {
                System.out.println("Nmap not installed, returning to main menu");
            }

            int exitCode = process.waitFor();

            if (exitCode != 0) {
                System.out.println("End with code: " + exitCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("An error occurred while trying to execute the command ");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Process was interrupted");
        }


    }
    private static void menu() {

        System.out.println("\u001B[33mEnter the network address\u001B[0m");
        Scanner network = new Scanner(System.in);
        String networkAddress = network.nextLine();

        Scanner menu = new Scanner(System.in);
        System.out.println("\u001B[32mEntered network address:\u001B[0m" +" " + networkAddress);
        System.out.println("Select an option:");

        Object[][] menuTab = new Object[9][2];
        menuTab[0][0] = (byte) 1;
        menuTab[0][1] = "Scan single host";
        menuTab[1][0] = (byte) 2;
        menuTab[1][1] = "Scan specific IP range";
        menuTab[2][0] = (byte) 3;
        menuTab[2][1] = "Scan whole subnet";
        menuTab[3][0] = (byte) 4;
        menuTab[3][1] = "Detection of devices on the network and their open ports";
        menuTab[4][0] = (byte) 5;
        menuTab[4][1] = "List all addresses and hosts to which given IP's are assigned";
        menuTab[5][0] = (byte) 6;
        menuTab[5][1] = "Scan for operating system";
        menuTab[6][0] = (byte) 7;
        menuTab[6][1] = "Scan for available services ";
        menuTab[7][0] = (byte) 8;
        menuTab[7][1] = "Back to main menu";
        menuTab[8][0] = (byte) 9;
        menuTab[8][1] = "Exit";

        for (Object[] row : menuTab) {  // Przechodzimy po każdym wierszu (tablicy jednowymiarowej)
            for (Object element : row) {  // Przechodzimy po każdym elemencie w wierszu
                System.out.print(element + " ");
            }
            System.out.println();
        }
        byte menuVar = menu.nextByte();
        if (menuVar == (byte) 1) {
            System.out.println("1");
        } else if (menuVar == (byte) 2) {
            System.out.println("2");
        } else if (menuVar == (byte) 3) {
            System.out.println("3");
        } else if (menuVar == (byte) 4) {
            System.out.println("4");
        } else if (menuVar == (byte) 5) {
            System.out.println("5");
        } else if (menuVar == (byte) 6) {
            System.out.println("6");
        } else if (menuVar == (byte) 7) {
            System.out.println("7");
        } else if (menuVar == (byte) 8) {
            System.out.println("Backing to main menu");
            Main.main(new String[0]);
        } else if (menuVar == (byte) 9) {
            System.out.println("Exiting..");
            System.exit(0);
        } else {
            System.out.println("Wrong Number");
            menu();
        }

    }
}

class Third {
    public static void thirdOption() {
        System.out.println("\u001B[33mSelected Advanced mode\u001B[0m");
    }
}


