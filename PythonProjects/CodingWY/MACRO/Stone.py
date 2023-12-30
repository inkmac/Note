# coding=utf-8
# @time     :2020/12/7/007 22:04
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :Main_Ver1.0.0.py
# @Software :#{PRODUCT_NAME}

import time
import pyautogui
time.sleep(3)

lineRun = 21
pyautogui.mouseDown(button='left')
pyautogui.keyDown('shift')
pyautogui.keyDown('W')

while True:
    time.sleep(lineRun)
    pyautogui.moveRel(200, 0)
    pyautogui.moveRel(200, 0)
    pyautogui.moveRel(200, 0)
    pyautogui.keyDown('D')
    pyautogui.keyUp('D')





