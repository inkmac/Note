# AutoCarryT4

import time
import pyautogui
time.sleep(3)
count = 0

# 放球
pyautogui.press("8")
pyautogui.rightClick()

for i in range(3):
    pyautogui.press("5")
    # pyautogui.rightClick()
    pyautogui.mouseDown(button="right")
    pyautogui.mouseUp(button="right")

    if count != 0:
        for j in range(3):
            pyautogui.moveRel(200,0)
        pyautogui.keyDown("shift")
        pyautogui.keyDown("s")
        time.sleep(0.5)
        pyautogui.keyUp("s")
        pyautogui.keyDown("d")
        time.sleep(0.5)
        pyautogui.keyUp("d")
        pyautogui.keyUp("shift")
        for j in range(3):
            pyautogui.moveRel(0, 200)

    time.sleep(6)                          # 破盾
    pyautogui.rightClick()

    pyautogui.press("q")
    for j in range(16):
        pyautogui.mouseDown(button="right")
        pyautogui.mouseUp(button="right")
    time.sleep(10)                           # 旋转激光
    for j in range(16):
        pyautogui.mouseDown(button="right")
        pyautogui.mouseUp(button="right")

    for j in range(3):
        pyautogui.moveRel(0, -200)
    pyautogui.keyDown("shift")
    pyautogui.keyDown("w")
    time.sleep(0.5)
    pyautogui.keyUp("w")
    pyautogui.keyDown("a")
    time.sleep(0.5)
    pyautogui.keyUp("a")
    pyautogui.keyUp("shift")
    for j in range(3):
        pyautogui.moveRel(-200, 0)

    count += 1
    time.sleep(1)
