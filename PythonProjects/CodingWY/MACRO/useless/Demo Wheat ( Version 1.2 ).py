# Wheat Version 1.2
import time
import pyautogui

line = 2
line_run = 3+1
reverse_run = 2
forward_run = 6
time_adjust = 1

start_line = int(input('输入开始的行数'))
while start_line <= 0 or start_line > line:
    print('请输入1-' + str(line) + '之间的整肃')
    start_line = int(input('输入开始的行数'))

time.sleep(3)
while True:
    for each in range(start_line, line + 1):
        pyautogui.mouseDown(button='left')
        pyautogui.keyDown('D')
        time.sleep(line_run)
        pyautogui.mouseUp(button='left')
        pyautogui.keyUp('D')

        pyautogui.keyDown('S')
        time.sleep(reverse_run)
        pyautogui.keyUp('S')

        pyautogui.mouseDown(button='left')
        pyautogui.keyDown('A')
        time.sleep(line_run)
        pyautogui.mouseUp(button='left')
        pyautogui.keyUp('A')

        if each != int(line):
            pyautogui.keyDown('S')
            time.sleep(reverse_run)
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






