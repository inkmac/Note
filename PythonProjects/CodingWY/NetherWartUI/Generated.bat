set /p ver=pls input ver:
copy SwCode.py SwCode_%ver%.py

del /F /Q SwCode.pyd
python setup.py build_ext --inplace
rename SwCode.cp3*.pyd SwCode.pyd
pyinstaller -w main.py
copy Config.txt .\dist\main\*.*
copy ConfigPostion.txt .\dist\main\*.*
md .\dist\main\Image
md .\dist\main\ImageTemp
copy .\Image\Island.jpg .\dist\main\Image\*.*
copy .\Image\Multiplayer.jpg .\dist\main\Image\*.*
copy .\Image\Hypixel.jpg .\dist\main\Image\*.*
copy .\Image\Join.jpg .\dist\main\Image\*.*
copy .\Image\Cancel.jpg .\dist\main\Image\*.*
copy .\Image\GameMenu.jpg .\dist\main\Image\*.*
copy .\Image\SkyblockIcon.jpg .\dist\main\Image\*.*
copy .\Image\Done.jpg .\dist\main\Image\*.*
copy .\Image\Server.jpg .\dist\main\Image\*.*
copy .\Image\Island.jpg .\dist\main\Image\*.*
copy .\Image\Village.jpg .\dist\main\Image\*.*
copy .\Image\BackGame.jpg .\dist\main\Image\*.*
copy .\Image\Ticket.jpg .\dist\main\Image\*.*
copy .\Image\Mithril.jpg .\dist\main\Image\*.*
rename .\dist\main NertherWartsUI_%ver%
"D:\Program Files\7-zip\7z.exe" a .\dist\NertherWartsUI_%ver%.7z .\dist\NertherWartsUI_%ver%