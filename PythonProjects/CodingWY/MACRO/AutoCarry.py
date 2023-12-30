import time
import pyautogui
time.sleep(3)
count = 1


# 放球
pyautogui.press("8")
pyautogui.rightClick()


for i in range(3):
    if count != 1:
        for j in range(3):
            pyautogui.moveRel(0, -150)
    pyautogui.press("3")
    pyautogui.mouseDown(button="right")
    time.sleep(17)
    pyautogui.mouseUp(button="right")
    for j in range(3):
        pyautogui.moveRel(0, 150)

    for j in range(16):
        pyautogui.mouseDown(button="right")
        pyautogui.mouseUp(button="right")
    time.sleep(10)                              # 旋转激光

    for j in range(16):
        pyautogui.mouseDown(button="right")
        pyautogui.mouseUp(button="right")

