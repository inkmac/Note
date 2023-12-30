# coding=utf-8
# @time     :2020/12/7/007 22:04
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :Main_Ver1.0.0.py
# @Software :#{PRODUCT_NAME}

# 坐标： （43 208 -19）边角
# Towards: 90.0   0.0

import time
import pyautogui
time.sleep(3)

pyautogui.keyDown('shift')

points_list = [
    [-100, 0], [-100, 0], [0, 100], [0, -200], [200, 0],
    [100, 0], [100, 0], [100, 0],  [100, 0], [0, 100], [0, 100], [-100, 0], [-300, -100]
]
sleep_time1 = 0.7
sleep_time2 = 1.4

while True:
    for i in range(5):
        for each in points_list:
            pyautogui.moveRel(each[0], each[1])
            pyautogui.mouseDown(button='left')
            time.sleep(sleep_time1)
            pyautogui.mouseUp(button='left')

    for i in range(1):
        for each in points_list:
            pyautogui.moveRel(each[0], each[1])
            pyautogui.mouseDown(button='left')
            time.sleep(sleep_time2)
            pyautogui.mouseUp(button='left')
