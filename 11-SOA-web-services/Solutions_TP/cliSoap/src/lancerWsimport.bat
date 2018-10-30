REM open with / text editor pour saisir le script sous eclipse
REM open with / system editor pour lancer le script sous eclipse

cd /d "%~dp0" 
set WSDL_URL=http://form284:8080/servSoap/serviceDevise?wsdl
REM wsimport est dans le répertoire bin du jdk >=1.6 (normalement déja dans %PATH%)
wsimport -keep -d ./main/java %WSDL_URL%

pause
REM "refresh" eclipse pour visualiser le code généré pas wsimport