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
                if (line.contains("Nmap version")) {
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
    public static void menu() {
        Scanner menuNumber = new Scanner(System.in);

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
        menuTab[4][1] = "List all addresses and hosts to which given IPs are assigned";
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
        byte menuVar = menuNumber.nextByte();
        switch (menuVar) {
            case 1:
                System.out.println("\u001B[33mAvailable hosts:\u001B[0m");
                String commandAvailableHosts = "arp -a";
                ProcessBuilder AvailableHosts = new ProcessBuilder("powershell.exe","-c", commandAvailableHosts);
                try {
                    Process process = AvailableHosts.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                    String errorLine;
                    while ((errorLine = error.readLine()) != null) {
                        System.err.println(errorLine);
                    }
                    int exitCodeAvailableHosts = process.waitFor();
                    if (exitCodeAvailableHosts != 0) {
                        System.out.println("End with code: " + exitCodeAvailableHosts);
                    }
                } catch (IOException | InterruptedException availableHostsCatch) {
                    availableHostsCatch.printStackTrace();
                }

                System.out.println("Example host address: 192.168.1.1");
                System.out.println("\u001B[32mEnter the host address\u001B[0m");
                Scanner networkCase1 = new Scanner(System.in);
                String networkAddress = networkCase1.nextLine();

                String commandOne = "nmap"+ " " + networkAddress;
                ProcessBuilder caseOne = new ProcessBuilder("powershell.exe", "-c", commandOne);
                try {
                    Process processCaseOne = caseOne.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(processCaseOne.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    int exitCodeCaseOne = processCaseOne.waitFor();
                    if (exitCodeCaseOne != 0) {
                        System.out.println("End with code: " + exitCodeCaseOne);
                    }
                } catch (IOException | InterruptedException One) {
                    One.printStackTrace();
                }
                exitToSecondMenu.typeNumberToExitToSecondMenu();

            case 2:
                System.out.println("\u001B[32mSample range:\u001B[0m 192.168.1.10-50");
                System.out.println();
                System.out.println("Enter range");

                Scanner range = new Scanner(System.in);
                String rangeString = range.nextLine();

                String commandTwo = "nmap -sn " + rangeString;
                ProcessBuilder caseTwo = new ProcessBuilder("powershell.exe", "-c", commandTwo);
                try {
                    Process process = caseTwo.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    int exitCodeCaseTwo = process.waitFor();
                    if (exitCodeCaseTwo != 0) {
                        System.out.println("End with code: " + exitCodeCaseTwo);
                    }
                } catch (IOException | InterruptedException Two) {
                    Two.printStackTrace();
                }
                exitToSecondMenu.typeNumberToExitToSecondMenu();

            case 3:
                System.out.println("Example subnet: 192.168.1.0/24");
                System.out.println("\u001B[33mEnter the network subnet\u001B[0m");
                Scanner network = new Scanner(System.in);
                String networkSubnet = network.nextLine();

                String commandThree = "nmap" + " " + networkSubnet;
                ProcessBuilder caseThree = new ProcessBuilder("powershell.exe", "-c", commandThree);
                try {
                    Process process = caseThree.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    int exitCodeCaseThree = process.waitFor();
                    if (exitCodeCaseThree != 0) {
                        System.out.println("End with code: " + exitCodeCaseThree);
                    }
                } catch (IOException | InterruptedException Three) {
                    Three.printStackTrace();
                }
                exitToSecondMenu.typeNumberToExitToSecondMenu();

            case 4:
                System.out.println("Example subnet: 192.168.1.0/24");
                System.out.println("\u001B[33mEnter the IP or network subnet\u001B[0m");
                Scanner networkCase4 = new Scanner(System.in);
                String networkSubnetCase4 = networkCase4.nextLine();

                String commandFour = "nmap -F" + " " + networkSubnetCase4;
                ProcessBuilder caseFour = new ProcessBuilder("powershell.exe", "-c", commandFour);
                try {
                    Process process = caseFour.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    int exitCodeCaseFour = process.waitFor();
                    if (exitCodeCaseFour != 0) {
                        System.out.println("End with code: " + exitCodeCaseFour);
                    }
                } catch (IOException | InterruptedException Four) {
                    Four.printStackTrace();
                }
                exitToSecondMenu.typeNumberToExitToSecondMenu();
            case 5:
                System.out.println("Example subnet: 192.168.1.0/24");
                System.out.println("\u001B[33mEnter the network subnet\u001B[0m");
                Scanner networkCase5 = new Scanner(System.in);
                String networkSubnetCase5 = networkCase5.nextLine();

                String commandFive = "nmap -sL" + " " + networkSubnetCase5;
                ProcessBuilder caseFive = new ProcessBuilder("powershell.exe", "-c", commandFive);
                try {
                    Process process = caseFive.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    int exitCodeCaseFive = process.waitFor();
                    if (exitCodeCaseFive != 0) {
                        System.out.println("End with code: " + exitCodeCaseFive);
                    }
                } catch (IOException | InterruptedException Five) {
                    Five.printStackTrace();
                }
                exitToSecondMenu.typeNumberToExitToSecondMenu();
            case 6:
                System.out.println("Example subnet: 192.168.1.0/24");
                System.out.println("\u001B[33mEnter the IP or network subnet\u001B[0m");
                Scanner networkCase6 = new Scanner(System.in);
                String networkSubnetCase6 = networkCase6.nextLine();

                String commandSix = "nmap -O" + " " + networkSubnetCase6;
                ProcessBuilder caseSix = new ProcessBuilder("powershell.exe","-c", commandSix);
                try {
                    Process process = caseSix.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    int exitCodeCaseSix = process.waitFor();
                    if (exitCodeCaseSix != 0) {
                        System.out.println("End with code: " + exitCodeCaseSix);
                    }
                } catch (IOException | InterruptedException Six) {
                    Six.printStackTrace();
                }
                exitToSecondMenu.typeNumberToExitToSecondMenu();
            case 7:
                System.out.println("Example subnet: 192.168.1.0/24");
                System.out.println("\u001B[33mEnter the network subnet\u001B[0m");
                Scanner networkCase7 = new Scanner(System.in);
                String networkSubnetCase7 = networkCase7.nextLine();

                String commandSeven = "nmap -sV" + " " + networkSubnetCase7;
                ProcessBuilder caseSeven = new ProcessBuilder("powershell.exe","-c", commandSeven);
                try {
                    Process process = caseSeven.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    int exitCodeCaseSeven = process.waitFor();
                    if (exitCodeCaseSeven != 0) {
                        System.out.println("End with code: " + exitCodeCaseSeven);
                    }
                } catch (IOException | InterruptedException Seven) {
                    Seven.printStackTrace();
                }
                exitToSecondMenu.typeNumberToExitToSecondMenu();
            case 8:
                System.out.println("Backing to main menu");
                Main.main(new String[0]);
            case 9:
                System.out.println("Exiting..");
                System.exit(0);
            default:
                System.out.println("Wrong Number");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                menu();

        }
    }
}

class Third {
    public static void thirdOption() {
        System.out.println("\u001B[33mSelected Advanced mode\u001B[0m");
    }
}
class exitToSecondMenu {
    public static void typeNumberToExitToSecondMenu() {
        System.out.println("\u001B[32mEnter number 0 to back to main menu\u001B[0m");
        Scanner exitToSecondMenuNumber = new Scanner(System.in);
        byte InsertedExitToSecondMenuNumber = exitToSecondMenuNumber.nextByte();
        if (InsertedExitToSecondMenuNumber == 0) {
            Second.menu();
        } else {
            System.out.println("Wrong Number !");
            typeNumberToExitToSecondMenu();
        }
    }
}

