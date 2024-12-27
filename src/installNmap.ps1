# Definicja URL do programu
$installerUrl = "https://nmap.org/dist/nmap-7.95-setup.exe";
# Definicja pobranego instalatora
$installerPath = "$env:TEMP\nmap-7.95-setup.exe";
# Wyświetlenie , przejścia do kolejnego procesu instalacji
Write-host -f Yellow "Installing app";
# Instalacja programu
Invoke-WebRequest -Uri $installerUrl -OutFile $installerPath;
# Otwarcie instalatora
Start-Process -FilePath $installerPath -Wait;
# Zakończenie instalacji

$programName = "nmap.exe";
$command = Get-Command $programName -ErrorAction SilentlyContinue
if ($command) {
    Write-host "$programName is installed";
    
} else {
    Write-Host "$programName is not installed";
    
}
Write-host -f Yellow "Instalation completed";
