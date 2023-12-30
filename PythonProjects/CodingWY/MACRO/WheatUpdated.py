import time
import pyautogui

line = 9
line_run = 94.5  # CHANGTUIAN 95+1   # 38.5 # diyuyou 57+1
revers_run = 1.8  # 2
forward_run = 15
time_adjust = 1


start_line = int(input("请输入起始行数: "))
while start_line <= 0 or start_line > line:
    print("请输入1到" + str(line) + "的整数")
    start_line = int(input("请输入起始行数"))

time.sleep(3)


def go_to_right(time_run):
    pyautogui.mouseDown(button='left')
    pyautogui.keyDown('d')
    time.sleep(time_run)
    pyautogui.keyUp('d')
    pyautogui.mouseUp(button='left')
    pyautogui.keyDown('shift')
    pyautogui.keyDown('a')
    pyautogui.keyUp('a')
    pyautogui.keyUp('shift')


def go_back(time_run):
    pyautogui.keyDown('s')
    time.sleep(time_run)
    pyautogui.keyUp('s')
    pyautogui.keyDown('shift')
    pyautogui.keyDown('w')
    pyautogui.keyUp('w')
    pyautogui.keyUp('shift')


def go_to_left(time_run):
    pyautogui.mouseDown(button='left')
    pyautogui.keyDown('a')
    time.sleep(time_run)
    pyautogui.keyUp('a')
    pyautogui.mouseUp(button='left')
    pyautogui.keyDown('shift')
    pyautogui.keyDown('d')
    pyautogui.keyUp('d')
    pyautogui.keyUp('shift')


def go_forward(time_run):
    pyautogui.keyDown('w')
    pyautogui.keyDown('e')
    time.sleep(time_run)
    pyautogui.keyUp('e')
    pyautogui.keyUp('w')
    pyautogui.keyDown('shift')
    pyautogui.keyDown('s')
    pyautogui.keyUp('s')
    pyautogui.keyUp('shift')


current_line = start_line
while True:
    for each in range(start_line - 1, line):
        go_to_right(line_run)
        go_back(revers_run)
        time.sleep(0.5)
        go_to_left(line_run)
        if current_line != 9:
            time.sleep(0.5)
            go_back(revers_run)

    start_line = 1
    current_line = start_line

    go_to_left(time_adjust)
    go_forward(forward_run)
    go_to_right(time_adjust)
