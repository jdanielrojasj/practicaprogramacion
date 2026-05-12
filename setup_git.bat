@echo off
setlocal
cd /d "%~dp0"

echo === Eliminando lock si existe ===
if exist ".git\index.lock" del /f /q ".git\index.lock"

echo === Configurando usuario de git para este repo ===
git config user.email "josdan241@gmail.com"
git config user.name "jdanielrojasj"

echo === Anadiendo archivos ===
git add .gitignore
git add proyecto2/.classpath
git add proyecto2/.project
git add proyecto2/.settings
git add proyecto2/src
git add setup_git.bat

echo === Estado ===
git status

echo === Commit ===
git commit -m "Practica academia de idiomas - version inicial"

echo === Rama main ===
git branch -M main

echo === Push a GitHub ===
git push -u origin main

echo.
echo Si pidio credenciales y fallo, vuelve a ejecutar el script.
pause
endlocal
