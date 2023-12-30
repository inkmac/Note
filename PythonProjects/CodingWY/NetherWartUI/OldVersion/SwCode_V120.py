# coding=utf-8
# @time     :2021/1/11/011 23:10
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :SwCode.py
# @Software :#{PRODUCT_NAME}


from PyQt5.QtGui import QKeySequence
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from MainUI import Ui_MainWindow
import time
import datetime
import sys
import winreg as wg
import random
import pyautogui
import numpy as np
import cv2
from PIL import ImageGrab
import win32api, win32con

ReleaseNote = """
Rev1.0.0:  first to nether warts
RsV1.1.0: first for Image check in island or not and back island
Rev1.1.1: 
RsV1.1.2: add back Island delay to avoid lag. 
Rev1.1.3: update for direction and memory image load (before is take when sw starting)
Rev1.1.4: only turn left or right when put in storage 
Rev1.1.5: add "start with HUB" / "if check in Island" / "add turn delay"
Rev1.1.6: checkbox change will update flag, not need press apply button 

Rev1.2.0: auto login and check communication lost. important modification 
"""
VersionD = "Rev1.2.0"

'''
PRM Setting
'''
RegPath = r"Software\MVBImport\Config"
RegKeyName = 'CurrentCount'
RegTotalName = 'TotalValue'
EndDateString = '2021-12-08 11:59:58'

McblockLength = 159
Mck = 27
McSpeed = 175
TimerStart = 3
turnXPos = 200
turnXNo = 3       #
turnYPos = 100
turnYNo = 3       #
turnDelay: float = 0     #
boxItem1 = [660, 680]
ItemDis = 72
firstTime = 15
afterTime = 18
IslandDirectionFlag = 1  # 1 is Right and 2 is Left
startFromLogin = 0
startFromHUB = 1   #
checkInIsland = 1  #
putBlockInBoxDelay = 0.5

xDis = win32api.GetSystemMetrics(win32con.SM_CXSCREEN)  # 获得屏幕分辨率X轴
yDis = win32api.GetSystemMetrics(win32con.SM_CYSCREEN)  # 获得屏幕分辨率Y轴
PicFulList = [0, 0, xDis, yDis]  # left, top, right, bottom
PicNewList = [3*xDis/4, yDis/10, xDis, 3*yDis/4]
# print(PicFulList, PicNewList)

hypixelFlag: bool = False
gameMenuFlag: bool = False

logFlag: bool = False
loggedFlag: bool = False

PathMut = r'.\Image\Multiplayer.jpg'
PathHyp = r'.\Image\Hypixel.jpg'
PathJon = r'.\Image\Join.jpg'
PathCan = r'.\Image\Cancel.jpg'
PathGam = r'.\Image\GameMenu.jpg'
PathSky = r'.\Image\SkyblockIcon.jpg'
PathDon = r'.\Image\Done.jpg'
PathSer = r'.\Image\Server.jpg'
PathIsl = r'.\Image\Island.jpg'
PathVil = r'.\Image\Village.jpg'

PathList = [PathMut, PathHyp, PathJon, PathCan, PathGam, PathSky, PathDon, PathSer]


def date_compare(date1, date2, fmt='%Y-%m-%d %H:%M:%S') -> bool:
    """
    比较两个真实日期之间的大小，date1 > date2 则返回True
    :param date1:
    :param date2:
    :param fmt:
    :return:
    """
    zero = datetime.datetime.fromtimestamp(0)
    try:
        d1 = datetime.datetime.strptime(str(date1), fmt)
    except:
        d1 = zero
    try:
        d2 = datetime.datetime.strptime(str(date2), fmt)
    except:
        d2 = zero
    return d1 > d2


def DataLog(log_name, info_log):
    """
    This is usd to write info_log to LogName file.
    :param info_log:
    """

    with open(log_name, 'a+') as logfile:
        logfile.writelines(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S') + '\n')
        logfile.writelines(info_log + '\n')


def gotNertL(presstime):
    pyautogui.mouseDown(button="left")
    time.sleep(0.1)
    pyautogui.keyDown('a')
    time.sleep(presstime)
    pyautogui.keyUp('a')
    pyautogui.mouseUp(button="left")


def gotNertR(presstime):
    pyautogui.mouseDown(button="left")
    time.sleep(0.1)
    pyautogui.keyDown('d')
    time.sleep(presstime)
    pyautogui.keyUp('d')
    pyautogui.mouseUp(button="left")


# def littleBack():
#     pyautogui.keyDown('shift')
#     pyautogui.press('s')
#     pyautogui.keyUp('shift')
#     pyautogui.keyDown('d')
#     pyautogui.keyUp('d')


def turn90L():
    for each in range(turnXNo):
        time.sleep(turnDelay)
        pyautogui.moveRel(-turnXPos, 0)


def turn90R():
    for each in range(turnXNo):
        time.sleep(turnDelay)
        pyautogui.moveRel(turnXPos, 0)


def turn90Down():
    for each in range(turnYNo):
        time.sleep(turnDelay)
        pyautogui.moveRel(0, turnYPos)


def turn90up():
    for each in range(turnYNo):
        time.sleep(turnDelay)
        pyautogui.moveRel(0, -turnYPos)


def put2store():
    time.sleep(putBlockInBoxDelay)
    pyautogui.press('2')
    time.sleep(putBlockInBoxDelay)
    pyautogui.click(button="right")
    time.sleep(1)
    pyautogui.moveTo(boxItem1[0] + ItemDis, boxItem1[1] + (ItemDis * 3))
    pyautogui.keyDown('shift')
    pyautogui.click(button="right")
    time.sleep(putBlockInBoxDelay)
    for each in range(random.randint(1, 2)):
        pyautogui.moveRel(ItemDis, 0)
        pyautogui.click(button="right")
        time.sleep(putBlockInBoxDelay)
    pyautogui.keyUp('shift')
    time.sleep(putBlockInBoxDelay)
    pyautogui.press('esc')
    time.sleep(putBlockInBoxDelay)
    pyautogui.press('1')
    time.sleep(putBlockInBoxDelay)


def backPIsland() -> None:
    pyautogui.press('t')
    time.sleep(putBlockInBoxDelay)
    pyautogui.typewrite('/is')
    time.sleep(putBlockInBoxDelay)
    pyautogui.press('enter')
    time.sleep(putBlockInBoxDelay+16)
    pyautogui.keyDown('w')
    time.sleep(2)
    pyautogui.keyUp('w')
    pyautogui.keyDown('shift')
    pyautogui.press('s')
    pyautogui.keyUp('shift')


def backHUB():
    pyautogui.press('t')
    time.sleep(putBlockInBoxDelay)
    pyautogui.typewrite('/hub')
    time.sleep(putBlockInBoxDelay)
    pyautogui.press('enter')


def IslandLeft():
    pyautogui.keyDown('a')
    time.sleep(2)
    pyautogui.keyUp('a')


def IslandRight():
    pyautogui.keyDown('d')
    time.sleep(2)
    pyautogui.keyUp('d')


# def LoadWBImage(inputFile):
#     img = cv2.imread(inputFile)
#     r, g, b = cv2.split(img)
#     cv2.merge([b, g, r], img)
#
#     imgry = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)  # 转化为灰度图
#     ret, bins = cv2.threshold(imgry, 170, 255, cv2.THRESH_BINARY)  # 转化为二值图，阈值为threahold，小于阈值设为0，大于阈值设为180
#     return bins


def LoadWBImage(inputFile):
    """
    This is load a color image and output white/black Image
    :param inputFile: the path of color image.
    :return:
    """
    img = cv2.imread(inputFile)
    r, g, b = cv2.split(img)
    cv2.merge([b, g, r], img)

    imgry = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)  # 转化为灰度图
    ret, bins = cv2.threshold(imgry, 170, 255, cv2.THRESH_BINARY)  # 转化为二值图，阈值为threahold，小于阈值设为0，大于阈值设为180
    return bins


def GetWBImage(inputList):
    """
    give a list for position to take a white/black image.
    :param inputList: a list with 4 value for # left, top, right, bottom of screen
    :return:
    """
    img = ImageGrab.grab(bbox=(inputList[0], inputList[1], inputList[2], inputList[3]))
    img = np.array(img.getdata(), np.uint8).reshape(img.size[1], img.size[0], 3)
    r, g, b = cv2.split(img)
    cv2.merge([b, g, r], img)

    imgry = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)  # 转化为灰度图
    ret, bins = cv2.threshold(imgry, 170, 255, cv2.THRESH_BINARY)  # 转化为二值图，阈值为threahold，小于阈值设为0，大于阈值设为180
    return bins


def haveSmallImage(bigImg, smallImg):
    """
    try to find smallImg in bigImg. if have, return True.
    :param bigImg:
    :param smallImg:
    :return:
    """
    result = cv2.matchTemplate(bigImg, smallImg, cv2.TM_CCOEFF_NORMED)
    threshold = 0.7
    with open('d:\log_name.txt', 'a+') as logfile:
        for each in result:
            for cell in each:
                logfile.writelines(str(cell) + '\n')
    flag = False
    for each in result:
        for cell in each:
            if cell >= threshold:
                flag = True
                break
        if flag:
            break
    return flag


def GetColorImage(inputList):
    """
    give a list for position to take a color image.
    :param inputList: a list with 4 value for # left, top, right, bottom of screen
    :return:
    """
    img = ImageGrab.grab(bbox=(inputList[0], inputList[1], inputList[2], inputList[3]))
    img = np.array(img.getdata(), np.uint8).reshape(img.size[1], img.size[0], 3)
    return img


def search_returnPoint(img, template, template_size):
    """
    try to find template in img.
        if have, return img and position x y.
        if no, return None None None
    :param img:
    :param template:
    :param template_size:
    :return:
    """
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    template_ = cv2.cvtColor(template, cv2.COLOR_BGR2GRAY)
    result = cv2.matchTemplate(img_gray, template_, cv2.TM_CCOEFF_NORMED)
    threshold = 0.8
    # res大于70%
    loc = np.where(result >= threshold)
    # 使用灰度图像中的坐标对原始RGB图像进行标记
    point = ()
    for pt in zip(*loc[::-1]):
        cv2.rectangle(img, pt, (pt[0] + template_size[1], pt[1] + + template_size[0]), (7, 249, 151), 2)
        point = pt
    if point == ():
        return None, None, None
    return img, point[0] + template_size[1] / 2, point[1]


class startGetStoneThread(QThread):
    def __init__(self, logName):
        # 初始化函数
        super(startGetStoneThread, self).__init__()
        self.LogFileName = logName

    def run(self):
        global logFlag
        global loggedFlag
        global hypixelFlag
        global gameMenuFlag
        ImgIsland = LoadWBImage(PathIsl)
        ImgVillage = LoadWBImage(PathVil)
        ImgServer = cv2.imread(PathSer)
        time.sleep(TimerStart)
        # print("program start")
        # print(logFlag)
        # print(loggedFlag)

        pollingLog: int = 0

        while True:
            if logFlag == True or loggedFlag == False:
                pollingLog += 1
                # pyautogui.moveTo(30, 50)
                # pyautogui.click(button="right")
                time.sleep(5)
                ScreenImg = GetColorImage(PicFulList)
                # cv2.imwrite(str(polling) + '.jpg', ScreenImg)
                for each in PathList:
                    if hypixelFlag == True and each == PathHyp:
                        hypixelFlag = False
                        DataLog(self.LogFileName, 'hypixelFlag set to 0')
                        continue
                    if gameMenuFlag == True and each == PathGam:
                        gameMenuFlag = False
                        DataLog(self.LogFileName, 'gameMenuFlag set to 0')
                        continue
                    # print(each)
                    templateImg = cv2.imread(each)
                    # cv2.imwrite(str(polling) + str(polling) + '.jpg', templateImg)
                    templateImg_size = templateImg.shape[:2]
                    ScreenImg_, x_, y_ = search_returnPoint(ScreenImg, templateImg, templateImg_size)
                    if ScreenImg_ is None:
                        continue
                    else:
                        pyautogui.moveTo(x_, y_)
                        pyautogui.click(button="left")
                        if each == PathJon:
                            time.sleep(5)
                            pyautogui.click(button="right")
                        if each == PathHyp:
                            hypixelFlag = True
                            DataLog(self.LogFileName, 'hypixelFlag set to 1')
                        if each == PathGam:
                            gameMenuFlag = True
                            DataLog(self.LogFileName, 'gameMenuFlag set to 1')
                        if each == PathSky:
                            time.sleep(5)
                            DataLog(self.LogFileName, 'logged done')
                            screenPartImg = GetWBImage(PicNewList)
                            cv2.imwrite(".\ImageTemp\screenPartImg" + str(pollingLog) + ".jpg", screenPartImg)
                            # cv2.imwrite("ImgIsland.jpg", ImgIsland)
                            # cv2.imwrite("ImgVillage.jpg", ImgVillage)
                            if haveSmallImage(screenPartImg, ImgIsland):
                                loggedFlag = True
                                DataLog(self.LogFileName, 'logged, and in island')
                                backHUB()
                            if haveSmallImage(screenPartImg, ImgVillage):
                                loggedFlag = True
                                DataLog(self.LogFileName, 'logged, and in island')
                        break

            else:
                DataLog(self.LogFileName, "already logged and to HUB and Island")
                if startFromHUB == 1:
                    backHUB()
                    time.sleep(5)
                    backPIsland()
                    if IslandDirectionFlag == 1:
                        IslandRight()
                    elif IslandDirectionFlag == 2:
                        IslandLeft()
                pyautogui.press('1')
                DataLog(self.LogFileName, "prepare to working")
                pressTimeInput = McblockLength * Mck / McSpeed
                gotNertL(pressTimeInput + 0.5)
                # ImageMem = LoadWBImage(PathIsl)
                # turn90L()
                # put2store()
                # turn90R()
                Polling = 0
                PollingTotal = 0
                putChestTime = 0
                putChestTime = putChestTime + random.randint(firstTime, afterTime)
                # backISTrig = putChestTime + random.randint(1, 3)
                # backISPoll = 0

                while True:
                    Polling += 1
                    PollingTotal += 1
                    if Polling % 2 == 0:
                        gotNertR(pressTimeInput)
                    else:
                        gotNertL(pressTimeInput)
                    DataLog(self.LogFileName, 'polling time' + str(Polling) + ', total is' + str(PollingTotal))
                    ImageNew = GetWBImage(PicNewList)
                    cv2.imwrite(".\ImageTemp\ImageNew" + str(PollingTotal) + ".jpg", ImageNew)

                    if haveSmallImage(ImageNew, ImgIsland):
                        DataLog(self.LogFileName, "current in island")
                        # pass
                    elif haveSmallImage(ImageNew, ImgVillage):
                        DataLog(self.LogFileName, 'Not in Island, prepare tp island')
                        backPIsland()
                        if IslandDirectionFlag == 1:
                            IslandRight()
                        elif IslandDirectionFlag == 2:
                            IslandLeft()
                        gotNertL(pressTimeInput + 0.5)
                        Polling = 0
                    else:
                        DataLog(self.LogFileName, "lost communication, to check server list")
                        ScreenServerImg = GetColorImage(PicFulList)
                        # templateImg = cv2.imread(P)
                        # cv2.imwrite(str(polling) + str(polling) + '.jpg', templateImg)
                        ImgServer_size = ImgServer.shape[:2]
                        ScreenCancelImg_, Cx_, Cy_ = search_returnPoint(ScreenServerImg, ImgServer, ImgServer_size)
                        cv2.imwrite(".\ImageTemp\Imageserver" + str(PollingTotal) + ".jpg", ScreenServerImg)
                        if ScreenCancelImg_ is None:
                            DataLog(self.LogFileName, "no server list found")
                            continue
                        else:
                            DataLog(self.LogFileName, "found server list")
                            pyautogui.moveTo(Cx_, Cy_)
                            pyautogui.click(button="left")
                            loggedFlag = 0
                            break

                    if Polling == putChestTime or Polling == 1:
                        if Polling % 2 == 0:
                            turn90R()
                            put2store()
                            turn90L()
                        else:
                            turn90L()
                            put2store()
                            turn90R()
                        DataLog(self.LogFileName, "put block in chest")
                        putChestTime = putChestTime + random.randint(firstTime, afterTime)


class MainFunWindow(QMainWindow, Ui_MainWindow):
    def __init__(self, parent=None):
        super(MainFunWindow, self).__init__(parent)
        self.setupUi(self)
        self.UiInitialData()
        self.UiAction()

    def UiInitialData(self):
        global turnXPos
        global turnXNo
        global turnYPos
        global turnYNo
        global turnDelay
        global boxItem1
        global ItemDis
        global McblockLength
        global Mck
        global McSpeed
        global firstTime
        global afterTime
        global IslandDirectionFlag
        global startFromLogin
        global startFromHUB
        global checkInIsland
        global loggedFlag
        global logFlag

        with open('../Config.txt', 'r') as logfile:
            Lines = logfile.readlines()
            self.ConfList = []
            for each in Lines:
                each = each.strip('\n')
                self.ConfList.append(each.split("="))
        for each in self.ConfList:
            if each[0] == 'lineEditLR':
                turnXPos = int(each[1])
            elif each[0] == 'lineEditLRNo':
                turnXNo = int(each[1])
            elif each[0] == 'lineEditUD':
                turnYPos = int(each[1])
            elif each[0] == 'lineEditUDNo':
                turnYNo = int(each[1])
            elif each[0] == 'lineEditTurnDelay':
                turnDelay = float(each[1])
            elif each[0] == 'lineEditFirstX':
                boxItem1[0] = int(each[1])
            elif each[0] == 'lineEditFirstY':
                boxItem1[1] = int(each[1])
            elif each[0] == 'lineEditDist':
                ItemDis = int(each[1])
            elif each[0] == 'lineEditStoneBlock':
                McblockLength = int(each[1])
            elif each[0] == 'lineEditSpeedK':
                Mck = int(each[1])
            elif each[0] == 'lineEditSpeed':
                McSpeed = int(each[1])
            elif each[0] == 'lineEditFirstTime':
                firstTime = int(each[1])
            elif each[0] == 'lineEditSecondTime':
                afterTime = int(each[1])
            elif each[0] == 'lineEditDirection':
                IslandDirectionFlag = int(each[1])
            elif each[0] == 'checkBoxLogin':
                startFromLogin = int(each[1])
                if startFromLogin == 1:
                    loggedFlag = 0
                    logFlag = 1
                else:
                    loggedFlag = 1
                    logFlag = 0
            elif each[0] == 'checkBoxHUB':
                startFromHUB = int(each[1])
            elif each[0] == 'checkBoxIsland':
                checkInIsland = int(each[1])

        self.labelRevsion.setText(VersionD)
        self.labelLR.setText(str(turnXPos))
        self.labelLRNo.setText(str(turnXNo))
        self.labelUD.setText(str(turnYPos))
        self.labelUDNo.setText(str(turnYNo))
        self.labelTurnDelay.setText(str(turnDelay))
        self.labelFirstX.setText(str(boxItem1[0]))
        self.labelFirstY.setText(str(boxItem1[1]))
        self.labelDist.setText(str(ItemDis))
        self.labelStoneBlock.setText(str(McblockLength))
        self.labelSpeedK.setText(str(Mck))
        self.labelSpeed.setText(str(McSpeed))
        self.labelFirstTime.setText(str(firstTime))
        self.labelSecondTime.setText(str(afterTime))
        if IslandDirectionFlag == 1:
            self.labelDirection.setText("右")
        else:
            self.labelDirection.setText("左")
        if startFromLogin == 1:
            self.checkBoxLogin.setChecked(True)
        else:
            self.checkBoxLogin.setChecked(False)
        if startFromHUB == 1:
            self.checkBoxHUB.setChecked(True)
        else:
            self.checkBoxHUB.setChecked(False)
        if checkInIsland == 1:
            self.checkBoxIsland.setChecked(True)
        else:
            self.checkBoxIsland.setChecked(False)
        self.LogFileName:str = datetime.datetime.now().strftime('%Y-%m-%d') + ".txt"
        self.startThread = startGetStoneThread(self.LogFileName)
        self.comboBoxDisplay.addItem("")
        self.comboBoxDisplay.addItem("1920*1080")
        self.comboBoxDisplay.addItem("1366*768")
        self.comboBoxVersion.addItem("")
        self.comboBoxVersion.addItem("1.12")
        self.comboBoxDirection.addItem("")
        self.comboBoxDirection.addItem("右")
        self.comboBoxDirection.addItem("左")
        self.pushButtonStop.setEnabled(False)
        # self.label_2.setVisible(False)
        # self.label_3.setVisible(False)
        # self.labelFirstTime.setVisible(False)
        # self.labelSecondTime.setVisible(False)
        # self.lineEditFirstTime.setVisible(False)
        # self.lineEditSecondTime.setVisible(False)

        # self.pushButtonStart.setShortcut('Ctrl + S')
        # self.pushButtonStop.setShortcut('Ctrl + Q')

        # print(McblockLength, Mck, McSpeed, TimerStart, adjustRotate, tolantTimeNew, tolantTimeMem, turnXPos, turnYPos, boxItem1, ItemDis, firstTime, afterTime)


    def displayUpdate(self):
        if self.comboBoxDisplay.currentText() == "1366*768":
            self.lineEditFirstX.setText('540')
            self.lineEditFirstY.setText('450')
            self.lineEditDist.setText('36')

        if self.comboBoxDisplay.currentText() == "1920*1080":
            self.lineEditFirstX.setText('660')
            self.lineEditFirstY.setText('680')
            self.lineEditDist.setText('72')

        if self.comboBoxDisplay.currentText() == "":
            self.lineEditFirstX.setText('')
            self.lineEditFirstY.setText('')
            self.lineEditDist.setText('')


    def versionUpdate(self):
        if self.comboBoxVersion.currentText() == "1.12":
            self.lineEditLR.setText('200')
            self.lineEditUD.setText('100')

        if self.comboBoxVersion.currentText() == "":
            self.lineEditLR.setText('')
            self.lineEditUD.setText('')

    def directionUpdate(self):
        if self.comboBoxVersion.currentText() == "右":
            self.lineEditDirection.setText('1')

        if self.comboBoxVersion.currentText() == "左":
            self.lineEditDirection.setText('2')

        if self.comboBoxVersion.currentText() == "":
            self.lineEditDirection.setText('')


    def applyData(self):
        global turnXPos
        global turnXNo
        global turnYPos
        global turnYNo
        global turnDelay
        global boxItem1
        global ItemDis
        global McblockLength
        global Mck
        global McSpeed
        global firstTime
        global afterTime
        global IslandDirectionFlag
        global startFromLogin
        global startFromHUB
        global checkInIsland

        if self.lineEditLR.text() != '':
            turnXPos = int(self.lineEditLR.text())
            self.labelLR.setText(str(turnXPos))
            self.lineEditLR.setText('')
        if self.lineEditLRNo.text() != '':
            turnXNo = int(self.lineEditLRNo.text())
            self.labelLRNo.setText(str(turnXNo))
            self.lineEditLRNo.setText('')
        if self.lineEditUD.text() != '':
            turnYPos = int(self.lineEditUD.text())
            self.labelUD.setText(str(turnYPos))
            self.lineEditUD.setText('')
        if self.lineEditUDNo.text() != '':
            turnYNo = int(self.lineEditUDNo.text())
            self.labelUDNo.setText(str(turnYNo))
            self.lineEditUDNo.setText('')
        if self.lineEditTurnDelay.text() != '':
            turnDelay = float(self.lineEditTurnDelay.text())
            self.labelTurnDelay.setText(str(turnDelay))
            self.lineEditTurnDelay.setText('')
        if self.lineEditFirstX.text() != '':
            boxItem1[0] = int(self.lineEditFirstX.text())
            self.labelFirstX.setText(str(boxItem1[0]))
            self.lineEditFirstX.setText('')
        if self.lineEditFirstY.text() != '':
            boxItem1[1] = int(self.lineEditFirstY.text())
            self.labelFirstY.setText(str(boxItem1[1]))
            self.lineEditFirstY.setText('')
        if self.lineEditDist.text() != '':
            ItemDis = int(self.lineEditDist.text())
            self.labelDist.setText(str(ItemDis))
            self.lineEditDist.setText('')
        if self.lineEditStoneBlock.text() != '':
            McblockLength = int(self.lineEditStoneBlock.text())
            self.labelStoneBlock.setText(str(McblockLength))
            self.lineEditStoneBlock.setText('')
        if self.lineEditSpeedK.text() != '':
            Mck = int(self.lineEditSpeedK.text())
            self.labelSpeedK.setText(str(Mck))
            self.lineEditSpeedK.setText('')
        if self.lineEditSpeed.text() != '':
            McSpeed = int(self.lineEditSpeed.text())
            self.labelSpeed.setText(str(McSpeed))
            self.lineEditSpeed.setText('')
        if self.lineEditFirstTime.text() != '':
            firstTime = int(self.lineEditFirstTime.text())
            self.labelFirstTime.setText(str(firstTime))
            self.lineEditFirstTime.setText('')
        if self.lineEditSecondTime.text() != '':
            afterTime = int(self.lineEditSecondTime.text())
            self.labelSecondTime.setText(str(afterTime))
            self.lineEditSecondTime.setText('')
        if self.lineEditDirection.text() != '':
            IslandDirectionFlag = int(self.lineEditDirection.text())
            if self.lineEditDirection.text() == '1':
                self.labelDirection.setText('右')
            else:
                self.labelDirection.setText('左')
            self.lineEditDirection.setText('')

        # print(startFromLogin, startFromHUB, checkInIsland)

    def saveData2File(self):
        # print(self.ConfList)
        for each in self.ConfList:
            if each[0] == 'lineEditLR':
                each[1] = str(turnXPos)
            elif each[0] == 'lineEditLRNo':
                each[1] = str(turnXNo)
            elif each[0] == 'lineEditUD':
                each[1] = str(turnYPos)
            elif each[0] == 'lineEditUDNo':
                each[1] = str(turnYNo)
            elif each[0] == 'lineEditTurnDelay':
                each[1] = str(turnDelay)
            elif each[0] == 'lineEditFirstX':
                each[1] = str(boxItem1[0])
            elif each[0] == 'lineEditFirstY':
                each[1] = str(boxItem1[1])
            elif each[0] == 'lineEditDist':
                each[1] = str(ItemDis)
            elif each[0] == 'lineEditStoneBlock':
                each[1] = str(McblockLength)
            elif each[0] == 'lineEditSpeedK':
                each[1] = str(Mck)
            elif each[0] == 'lineEditSpeed':
                each[1] = str(McSpeed)
            elif each[0] == 'lineEditFirstTime':
                each[1] = str(firstTime)
            elif each[0] == 'lineEditSecondTime':
                each[1] = str(afterTime)
            elif each[0] == 'lineEditDirection':
                each[1] = str(IslandDirectionFlag)
            elif each[0] == 'checkBoxLogin':
                each[1] = str(startFromLogin)
            elif each[0] == 'checkBoxHUB':
                each[1] = str(startFromHUB)
            elif each[0] == 'checkBoxIsland':
                each[1] = str(checkInIsland)

        with open('../Config.txt', 'w') as logfile:
            NewLines = []
            for each in self.ConfList:
                NewLines.append(each[0]+'='+each[1]+'\n')
            logfile.writelines(NewLines)


    def startGetStone(self):
        self.startThread.start()
        self.pushButtonStop.setEnabled(True)
        self.pushButtonStart.setEnabled(False)


    def stopGetStone(self):
        self.startThread.terminate()
        self.pushButtonStop.setEnabled(False)
        self.pushButtonStart.setEnabled(True)


    def checkboxLoginUp(self):
        global startFromLogin
        global startFromHUB
        global loggedFlag
        global logFlag
        if self.checkBoxLogin.isChecked():
            startFromLogin = 1
            startFromHUB = 1
            self.checkBoxHUB.setChecked(True)
            loggedFlag = 0
            logFlag = 1
        else:
            startFromLogin = 0
            loggedFlag = 1
            logFlag = 0


    def checkboxHUBUp(self):
        global startFromHUB
        if self.checkBoxHUB.isChecked():
            startFromHUB = 1
        else:
            startFromHUB = 0


    def checkboxIslandUp(self):
        global checkInIsland
        if self.checkBoxIsland.isChecked():
            checkInIsland = 1
        else:
            checkInIsland = 0


    def UiAction(self):
        """
        single and slot connection.
        :return:
        """
        self.pushButtonStart.clicked.connect(self.startGetStone)
        self.pushButtonStop.clicked.connect(self.stopGetStone)
        self.pushButtonClose.clicked.connect(self.close)
        self.comboBoxDisplay.currentIndexChanged.connect(self.displayUpdate)
        self.comboBoxVersion.currentIndexChanged.connect(self.versionUpdate)
        self.comboBoxDirection.currentIndexChanged.connect(self.directionUpdate)
        self.pushButtonApply.clicked.connect(self.applyData)
        self.pushButtonSave.clicked.connect(self.saveData2File)
        self.checkBoxLogin.stateChanged.connect(self.checkboxLoginUp)
        self.checkBoxHUB.stateChanged.connect(self.checkboxHUBUp)
        self.checkBoxIsland.stateChanged.connect(self.checkboxIslandUp)
        # self.shortcutStart = QShortcut(QKeySequence("Ctrl+S"), self)
        # self.shortcutStart.activated.connect(self.startGetStone)
        # self.shortcutStop = QShortcut(QKeySequence("Ctrl+Q"), self)
        # self.shortcutStop.activated.connect(self.stopGetStone)


try:
    RegDateValidKey = wg.OpenKey(wg.HKEY_CURRENT_USER, RegPath, 0, access=wg.KEY_ALL_ACCESS)
except:
    RegDateValidKey = wg.CreateKey(wg.HKEY_CURRENT_USER, RegPath + RegKeyName)
try:
    RegDateValid, type = wg.QueryValueEx(RegDateValidKey, RegKeyName)
except:
    wg.SetValueEx(RegDateValidKey, RegKeyName, 0, wg.REG_SZ, '1')
    RegDateValid = "1"

if RegDateValid == '0':
    sys.exit()
else:
    EndDate = datetime.datetime.strptime(EndDateString, '%Y-%m-%d %H:%M:%S')
    CurrentDate = datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    if date_compare(CurrentDate, EndDate):
        wg.SetValueEx(RegDateValidKey, RegKeyName, 1, wg.REG_SZ, '0')
        sys.exit()
    else:
        app = QApplication([])
        mainWindow = MainFunWindow()
        mainWindow.show()
        sys.exit(app.exec_())
