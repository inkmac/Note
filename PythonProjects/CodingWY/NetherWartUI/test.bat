echo rename .\dist\main veraaa

@echo off
echo batchfile=%0
echo full=%~f0
setlocal
  for %%d in (%~dp0.) do set Directory=%%~fd
  echo Directory=%Directory%
  for %%d in (%~dp0..) do set ParentDirectory=%%~fd
  echo ParentDirectory=%ParentDirectory%
endlocal

echo %~p1

pause