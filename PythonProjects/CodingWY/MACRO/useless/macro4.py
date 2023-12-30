# coding=utf-8
# @time     :2020/12/7/007 22:04
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :Main_Ver1.0.0.py
# @Software :#{PRODUCT_NAME}
import pyautogui
import pydirectinput
import time

time.sleep(3)

# pyautogui.keyDown('shift')
# time.sleep(1)
# pyautogui.keyUp('shift')
#
# pyautogui.keyDown('S')
# time.sleep(7)
# pyautogui.keyUp('S')

for each in range(3):
    pyautogui.moveRel(-200, 0)
pyautogui.keyDown('w')
time.sleep(27)
pyautogui.keyUp('w')
