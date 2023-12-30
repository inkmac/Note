# AutoCarryT4

import time
import pyautogui

time.sleep(3)
count = 0


def move():
    for j in range(3):
        pyautogui.keyDown("shift")
        pyautogui.keyDown("w", "d")
        time.sleep(0.5)
        pyautogui.keyUp("w", "d")
        pyautogui.keyUp("shift")

        pyautogui.keyDown("shift")
        pyautogui.keyDown("w", "a")
        time.sleep(0.5)
        pyautogui.keyUp("w", "a")
        pyautogui.keyUp("shift")

        pyautogui.keyDown("shift")
        pyautogui.keyDown("s", "a")
        time.sleep(0.5)
        pyautogui.keyUp("s", "a")
        pyautogui.keyUp("shift")

        pyautogui.keyDown("shift")
        pyautogui.keyDown("s", "d")
        time.sleep(0.5)
        pyautogui.keyUp("s", "d")
        pyautogui.keyUp("shift")


# 放球
pyautogui.press("8")
pyautogui.rightClick()

for i in range(3):
    pyautogui.press("5")
    # pyautogui.rightClick()
    pyautogui.mouseDown(button="right")
    pyautogui.mouseUp(button="right")

    # time.sleep(6)                          # 破盾
    move()

    pyautogui.rightClick()

    pyautogui.press("q")
    for j in range(16):
        pyautogui.mouseDown(button="right")
        pyautogui.mouseUp(button="right")

    # time.sleep(10)                           # 旋转激光
    for j in range(5):
        pyautogui.keyDown("shift")
        pyautogui.keyDown("w")
        time.sleep(1)
        pyautogui.keyUp("w")
        pyautogui.keyUp("shift")

        pyautogui.keyDown("shift")
        pyautogui.keyDown("s")
        time.sleep(1)
        pyautogui.keyUp("s")
        pyautogui.keyUp("shift")

    for j in range(16):
        pyautogui.mouseDown(button="right")
        pyautogui.mouseUp(button="right")

    count += 1
    time.sleep(1)
