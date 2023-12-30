# Wheat Version 1.2
import time
import pyautogui

line = 2
line_run = 3+1
revers_run = 2
forward_run = 3+1
time_adjust = 1

start_line = int(input('请输入起始行数'))
while start_line <= 0 or start_line > line:
    print('请输入1-' + str(line) + '之间的整数')
    start_line = int(input('请输入起始行数'))

time.sleep(3)
while True:
    for each in range(start_line, line + 1):
        pyautogui.mouseDown(button='left')
        pyautogui.keyDown('D')
        time.sleep(line_run)
        pyautogui.keyUp('D')
        pyautogui.mouseUp(button='left')

        pyautogui.keyDown('S')
        time.sleep(revers_run)
        pyautogui.keyUp('S')

        pyautogui.mouseDown(button='left')
        pyautogui.keyDown('A')
        time.sleep(line_run)
        pyautogui.keyUp('A')
        pyautogui.mouseUp(button='left')

        if each != int(line):
            pyautogui.keyDown('S')
            time.sleep(revers_run)
            pyautogui.keyUp('S')

    pyautogui.keyDown('A')
    time.sleep(time_adjust)
    pyautogui.keyUp('A')

    pyautogui.keyDown('W')
    time.sleep(forward_run)
    pyautogui.keyUp('W')

    pyautogui.keyDown('D')
    time.sleep(time_adjust)
    pyautogui.keyUp('D')

    start_line = 1
