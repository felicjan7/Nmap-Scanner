import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuInstall {
    public void menuInstallTest() {
        System.out.println("Instalacja123");

        // Tworzymy polecenie PowerShell do uruchomienia
        String command = "powershell.exe Get-ChildItem";
        try {
        //Uruchamiamy proces
        Process process = Runtime.getRuntime().exec(command);

        //Odczytujemy wynik diałania procesu

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); //Wypisuje wynik w konsoli
        }

        //Zakończenie procesu
        int exitCode = process.waitFor();
        System.out.println(exitCode);
    } catch(
    Exception e)

    {
        e.printStackTrace();
    }
}
}
