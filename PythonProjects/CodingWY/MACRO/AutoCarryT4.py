from pynput import keyboard
import time
import pyautogui

from pynput import keyboard

def on_press(key):
    try:
        if key == keyboard.KeyCode.from_char('g') and any([key == keyboard.Key.ctrl for key in current_keys]):
            time.sleep(3)
            count = 1

            time.sleep(6)  # 破盾
            # 放球
            pyautogui.press("8")
            pyautogui.rightClick()

            pyautogui.press("q")
            for i in range(3):
                if count != 1:
                    time.sleep(6)
                for j in range(16):
                    pyautogui.mouseDown(button="right")
                    pyautogui.mouseUp(button="right")
                time.sleep(10)  # 旋转激光
                for j in range(16):
                    pyautogui.mouseDown(button="right")
                    pyautogui.mouseUp(button="right")


    except AttributeError:
        pass

def on_release(key):
    if key == keyboard.Key.esc:
        # Stop listener
        return False

# 当前按下的键
current_keys = set()

def on_key_down(key):
    try:
        current_keys.add(key)
    except AttributeError:
        pass

def on_key_up(key):
    try:
        current_keys.remove(key)
    except AttributeError:
        pass

# 启动监听
with keyboard.Listener(on_press=on_press, on_release=on_release) as listener:
    listener.join()

# 启动监听键盘按下事件
with keyboard.Listener(on_press=on_key_down, on_release=on_key_up) as listener:
    listener.join()

