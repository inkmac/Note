# coding=utf-8
# @time     :2020/12/7/007 22:04
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :Main_Ver1.0.0.py
# @Software :#{PRODUCT_NAME}

import time
import pyautogui

# start_line = 0
line = 18
line_run = 1+1
revers_run = 2
forward_run = 17+1
time_adjust = 1

start_line = int(input("请输入起始行数"))
while start_line <= 0 or start_line > (line/2):
    print("请输入1到" + str(line/2) + "的整数")
    start_line = int(input("请输入起始行数"))

time.sleep(3)
while True:
    for each in range(start_line - 1, int(line/2)):
        pyautogui.mouseDown(button='left')
        pyautogui.keyDown('A')
        time.sleep(line_run)
        pyautogui.keyUp('A')
        pyautogui.mouseUp(button='left')

        pyautogui.keyDown('S')
        time.sleep(revers_run)
        pyautogui.keyUp('S')

        pyautogui.press("W", 2)

        pyautogui.mouseDown(button='left')
        pyautogui.keyDown('D')
        time.sleep(line_run)
        pyautogui.keyUp('D')
        pyautogui.mouseUp(button='left')

        pyautogui.keyDown('S')
        time.sleep(revers_run)
        pyautogui.keyUp('S')

        pyautogui.keyDown('shift')
        pyautogui.keyDown('W')
        time.sleep(0.01)
        pyautogui.keyUp('shift')
        pyautogui.keyUp('W')

    start_line = 1
    pyautogui.keyDown('A')
    time.sleep(time_adjust)
    pyautogui.keyUp('A')

    pyautogui.keyDown('W')
    time.sleep(forward_run)
    pyautogui.keyUp('W')

    pyautogui.keyDown('D')
    time.sleep(time_adjust)
    pyautogui.keyUp('D')
