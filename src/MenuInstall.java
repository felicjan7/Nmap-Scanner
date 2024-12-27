import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MenuInstall {
    public static void InstallationPowerShellScript() {
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
            System.out.println("Zakończono z kodem: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}