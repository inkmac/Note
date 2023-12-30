# coding=utf-8
# @time     :2020/12/7/007 22:04
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :Main_Ver1.0.0.py
# @Software :#{PRODUCT_NAME}

import time
import pyautogui

aaa = 10


def function(time_sleep):
    pyautogui.keyDown('S')
    time.sleep(time_sleep)
    pyautogui.keyUp('S')
    return 999


function(aaa)



