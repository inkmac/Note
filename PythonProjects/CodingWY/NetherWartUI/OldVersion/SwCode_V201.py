# coding=utf-8
# @time     :2021/1/11/011 23:10
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :SwCode.py
# @Software :#{PRODUCT_NAME}


from PyQt5.QtGui import *
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
Rev1.0.0:   first to nether warts
RsV1.1.0:   first for Image check in island or not and back island
Rev1.1.1: 
RsV1.1.2:   add back Island delay to avoid lag. 
Rev1.1.3:   update for direction and memory image load (before is take when sw starting)
Rev1.1.4:   only turn left or right when put in storage 
Rev1.1.5:   add "start with HUB" / "if check in Island" / "add turn delay"
Rev1.1.6:   checkbox change will update flag, not need press apply button 

Rev1.2.0:   auto login and check communication lost. important modification 
Rev1.2.1:   fix first move left time double issue. 
            modify the order of input of GUI. 
            fix checkboxHUB initial failure issue.
            fix login break failure
            add potato angle function
Rev1.2.2:   fix login failure. add right click after "done" button pressed. 
            remove move one of double left after back island 
            add PRM for picture delay
            move press '1' from main function to backIsland function 
            remove D: log which is used to save result in havesmallImage function 
            add description in each functions
            
Rev1.3.0:   Image display on Main Window
            for potato selection, add time delay after mouse angle adjust
            fix the comboxDirection mistake. 
Rev1.3.1:   add image checking after put chest to void not open chest to press "esc" button. 
            remove potato delay and adjust angle when start not from HUB.             
Rev1.3.2:   fix lastest version did not put chest failure 
Rev1.3.3:   fix 2nd put chest time length double issue
Rev1.3.4:   add Ticket checking, the chest putting will increase 20 times. 
Rev1.3.5:   reset putChestTime to 1 when auto back HUB to avoid put chest with long time. 
            update UI for TpMax TpStart TpLayer input
Rev1.3.6:   The log for putchesttime and pollingTrip will be loggged. 
            change Islandleft IslandRight function to IslandTP1/2/3/4. next version need to add pollingtime for 4 TP.
            if ticket detected, PutChestTime is based on pollingtrip + 2  
            modified datalog datatype error issue 
            add move mouse to left during login.
Rev1.3.7:   add back island checking
            add loginmax checking
            
Rev2.0.0:   add get Mithril function.
Rev2.0.1:   add time sleep between "open chest" and put first block
            
"""
VersionD = "Rev_2.0.0"

'''
PRM Setting
'''
RegPath = r"Software\MVBImport\Config"
RegKeyName = 'CurrentCount'
RegTotalName = 'TotalValue'
EndDateString = '2022-05-08 11:59:58'

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
TpMax = 4
TpStart = 1
TpLayer = 80
Tp2Next = TpLayer // 10
startFromLogin = 0
startFromHUB = 1   #
checkInIsland = 1  #
putBlockInBoxDelay = 0.5
PutChestFlag = 1
PotatoFlag = 0
MithrilFlag = 1
MithrilBreak = 1
PotatoAngle = 10
LogPicTakeDelay = 10  # 不得小于10
PollingTotal: int = 0  # this is used to for total time
PollingLog: int = 0  # this is used to control Number of Login
PollingTrip: int = 0  # this is used to control left/right Direction and put left/Right Chest
PollingTP: int = 0  # this is control for select TP 1/2/3/4
PositionList: list = []  # Position list for Mithril
MithrilTime: float = 0     #
TitaniumTime: float = 0
SkillTime: int = 0
SkillCooldown: int = 0


xDis: int = win32api.GetSystemMetrics(win32con.SM_CXSCREEN)  # 获得屏幕分辨率X轴
yDis: int = win32api.GetSystemMetrics(win32con.SM_CYSCREEN)  # 获得屏幕分辨率Y轴
PicFulList = [0, 0, xDis, yDis]  # left, top, right, bottom
PicNewList = [3*xDis/4, yDis/10, xDis, 3*yDis/4]
# print(PicFulList, PicNewList)

hypixelFlag: bool = False
gameMenuFlag: bool = False

logFlag: bool = False
loggedFlag: bool = False

PathMult: str = r'.\Image\Multiplayer.jpg'
PathHypi: str = r'.\Image\Hypixel.jpg'
PathJoin: str = r'.\Image\Join.jpg'
PathCanc: str = r'.\Image\Cancel.jpg'
PathGame: str = r'.\Image\GameMenu.jpg'
PathSkyb: str = r'.\Image\SkyblockIcon.jpg'
PathDone: str = r'.\Image\Done.jpg'
PathServ: str = r'.\Image\Server.jpg'
PathIsla: str = r'.\Image\Island.jpg'
PathVill: str = r'.\Image\Village.jpg'
PathBack: str = r'.\Image\BackGame.jpg'
PathTick: str = r'.\Image\Ticket.jpg'
PathMith: str = r'.\Image\Mithril.jpg'

PathList = [PathMult, PathHypi, PathJoin, PathCanc, PathGame, PathSkyb, PathDone, PathServ]
# PathAllList = [PathMult, PathHypi, PathJoin, PathCanc, PathGame, PathSkyb, PathDone, PathServ, PathIsla, PathVill, PathBack]
PathAllList = [PathMult, PathHypi, PathJoin, PathCanc, PathGame, PathSkyb, PathDone, PathServ, PathIsla, PathVill, PathBack, PathTick, PathMith]

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


def DataLog(log_name, info_log) -> None:
    """
    This is usd to write info_log to LogName file.
    :param info_log:
    """

    with open(log_name, 'a+') as logfile:
        logfile.writelines(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S') + '\n')
        logfile.writelines(info_log + '\n')


def gotNertL(presstime):
    """
    left click and keep presstime to left direction
    :param presstime:
    :return:
    """
    pyautogui.mouseDown(button="left")
    time.sleep(0.1)
    pyautogui.keyDown('a')
    time.sleep(presstime)
    pyautogui.keyUp('a')
    pyautogui.mouseUp(button="left")


def gotNertR(presstime):
    """
    left click and keep presstime to right direction
    :param presstime:
    :return:
    """
    pyautogui.mouseDown(button="left")
    time.sleep(0.1)
    pyautogui.keyDown('d')
    time.sleep(presstime)
    pyautogui.keyUp('d')
    pyautogui.mouseUp(button="left")


def littleBack():
    """
    little back to void block to move
    :return:
    """
    pyautogui.keyDown('shift')
    pyautogui.press('s')
    pyautogui.keyUp('shift')


def turn90L():
    """
    turn left turnXPos for turnXNo time
    :return:
    """
    for each in range(turnXNo):
        time.sleep(turnDelay)
        pyautogui.moveRel(-turnXPos, 0)


def turn90R():
    """
        turn right turnXPos for turnXNo time
        :return:
    """
    for each in range(turnXNo):
        time.sleep(turnDelay)
        pyautogui.moveRel(turnXPos, 0)


def turn90Down():
    """
    turn down turnYPos for turnYNo time
    :return:
    """
    for each in range(turnYNo):
        time.sleep(turnDelay)
        pyautogui.moveRel(0, turnYPos)


def turn90up():
    """
    turn up turnYPos for turnYNo time
    :return:
    """
    for each in range(turnYNo):
        time.sleep(turnDelay)
        pyautogui.moveRel(0, -turnYPos)


def put2store():
    """
    put goods in chest
    :return:
    """
    time.sleep(putBlockInBoxDelay)
    pyautogui.press('2')
    time.sleep(putBlockInBoxDelay)
    pyautogui.click(button="right")
    time.sleep(1+putBlockInBoxDelay)
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
    """
    back Island
    :return:
    """
    pyautogui.press('t')
    time.sleep(putBlockInBoxDelay)
    pyautogui.typewrite('/is')
    time.sleep(putBlockInBoxDelay)
    pyautogui.press('enter')
    time.sleep(LogPicTakeDelay+6)
    pyautogui.press('1')
    pyautogui.keyDown('w')
    time.sleep(2)
    pyautogui.keyUp('w')
    pyautogui.keyDown('shift')
    pyautogui.press('s')
    pyautogui.keyUp('shift')


def backHUB():
    """
    back HUB
    :return:
    """
    pyautogui.press('9')
    pyautogui.press('t')
    time.sleep(putBlockInBoxDelay)
    pyautogui.typewrite('/hub')
    time.sleep(putBlockInBoxDelay)
    pyautogui.press('enter')


def IslandLeft():
    """
    go to left TP block
    :return:
    """
    pyautogui.keyDown('a')
    time.sleep(2)
    pyautogui.keyUp('a')


def IslandRight():
    """
    go to right TP block
    :return:
    """
    pyautogui.keyDown('d')
    time.sleep(2)
    pyautogui.keyUp('d')


def IslandTP1():
    """
    go to tp left top
    :return:
    """
    pyautogui.keyDown('w')
    time.sleep(2)
    pyautogui.keyUp('w')
    pyautogui.keyDown('a')
    time.sleep(2)
    pyautogui.keyUp('a')
    pyautogui.keyDown('w')
    time.sleep(2)
    pyautogui.keyUp('w')
    pyautogui.keyDown('a')
    time.sleep(2)
    pyautogui.keyUp('a')


def IslandTP2():
    """
    go to tp right top
    :return:
    """
    pyautogui.keyDown('w')
    time.sleep(2)
    pyautogui.keyUp('w')
    pyautogui.keyDown('d')
    time.sleep(2)
    pyautogui.keyUp('d')
    pyautogui.keyDown('w')
    time.sleep(2)
    pyautogui.keyUp('w')
    pyautogui.keyDown('d')
    time.sleep(2)
    pyautogui.keyUp('d')


def IslandTP3():
    """
    go to tp left bottom
    :return:
    """
    pyautogui.keyDown('w')
    time.sleep(2)
    pyautogui.keyUp('w')
    pyautogui.keyDown('a')
    time.sleep(2)
    pyautogui.keyUp('a')
    pyautogui.keyDown('s')
    time.sleep(2)
    pyautogui.keyUp('s')
    pyautogui.keyDown('a')
    time.sleep(2)
    pyautogui.keyUp('a')


def IslandTP4():
    """
    go to tp right bottom
    :return:
    """
    pyautogui.keyDown('w')
    time.sleep(2)
    pyautogui.keyUp('w')
    pyautogui.keyDown('d')
    time.sleep(2)
    pyautogui.keyUp('d')
    pyautogui.keyDown('s')
    time.sleep(2)
    pyautogui.keyUp('s')
    pyautogui.keyDown('d')
    time.sleep(2)
    pyautogui.keyUp('d')


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
    # with open('d:\log_name.txt', 'a+') as logfile:
    #     for each in result:
    #         for cell in each:
    #             logfile.writelines(str(cell) + '\n')
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
        global PotatoAngle
        global PollingTotal  # this is used to for total time
        global PollingLog  # this is used to control Number of Login
        global PollingTrip  # this is used to control left/right Direction and put left/Right Chest
        global PollingTP  # this is control for select TP 1/2/3/4
        global TpMax
        global TpStart
        global TpLayer
        global Tp2Next
        global startFromHUB
        global MithrilBreak
        global MithrilTime
        global TitaniumTime
        global SkillTime
        global SkillCooldown

        self.startFromHUBFlag = startFromHUB
        ImgIsland = LoadWBImage(PathIsla)
        ImgTicket = LoadWBImage(PathTick)
        ImgVillage = LoadWBImage(PathVill)
        ImgMithril = LoadWBImage(PathMith)
        ImgServer = cv2.imread(PathServ)
        time.sleep(TimerStart)
        # print("program start")
        # print(logFlag)
        # print(loggedFlag)

        PollingLog = 0
        PollingTrip = 0
        PollingTP = 0
        TpLayerSelect = TpStart
        PollingSerPic = 0  # this is used control each pic during login
        

        while True:
            maxLogFlag = 0
            if logFlag == True or loggedFlag == False:
                maxLogFlag += 1
                PollingLog += 1
                # print(PollingLog)
                pyautogui.moveTo(30, yDis//2)
                # pyautogui.click(button="right")
                time.sleep(LogPicTakeDelay)
                ScreenImg = GetColorImage(PicFulList)
                # cv2.imwrite(str(PollingTrip) + '.jpg', ScreenImg)
                PollingSerPic = 0
                for each in PathList:
                    PollingSerPic += 1
                    if hypixelFlag == True and each == PathHypi:
                        hypixelFlag = False
                        DataLog(self.LogFileName, 'hypixelFlag set to 0')
                        continue
                    if gameMenuFlag == True and each == PathGame:
                        gameMenuFlag = False
                        DataLog(self.LogFileName, 'gameMenuFlag set to 0')
                        continue
                    # print(each)
                    templateImg = cv2.imread(each)
                    # cv2.imwrite(str(PollingTrip) + str(PollingTrip) + '.jpg', templateImg)
                    templateImg_size = templateImg.shape[:2]
                    ScreenImg_, x_, y_ = search_returnPoint(ScreenImg, templateImg, templateImg_size)
                    if ScreenImg_ is None:
                        continue
                    else:
                        pyautogui.moveTo(x_, y_)
                        pyautogui.click(button="left")
                        if each == PathJoin:
                            time.sleep(LogPicTakeDelay)
                            pyautogui.click(button="right")
                        if each == PathHypi:
                            hypixelFlag = True
                            DataLog(self.LogFileName, 'hypixelFlag set to 1')
                        if each == PathGame:
                            gameMenuFlag = True
                            DataLog(self.LogFileName, 'gameMenuFlag set to 1')
                        if each == PathDone:
                            time.sleep(LogPicTakeDelay-5)
                            pyautogui.click(button="right")
                        if each == PathSkyb:
                            time.sleep(5)
                            DataLog(self.LogFileName, 'logged done')
                            screenPartImg = GetWBImage(PicNewList)
                            cv2.imwrite(".\ImageTemp\screenPartImg_" + str(PollingLog) + '_' + str(PollingSerPic)
                                        + ".jpg", screenPartImg)
                            # cv2.imwrite("ImgIsland.jpg", ImgIsland)
                            # cv2.imwrite("ImgVillage.jpg", ImgVillage)
                            if haveSmallImage(screenPartImg, ImgIsland):
                                loggedFlag = True
                                logFlag = False
                                DataLog(self.LogFileName, 'logged, and in island')
                                # backHUB()
                            if haveSmallImage(screenPartImg, ImgVillage):
                                loggedFlag = True
                                logFlag = False
                                DataLog(self.LogFileName, 'logged, and in Village')
                            if haveSmallImage(screenPartImg, ImgMithril):
                                loggedFlag = True
                                logFlag = False
                                DataLog(self.LogFileName, 'logged, and in Mithril')
                                backPIsland()

                            self.startFromHUBFlag = 1
                            print('logged')
                        break
                if maxLogFlag > len(PathList) + 7:
                    loggedFlag = True
                    logFlag = False
                    DataLog(self.LogFileName, 'Error: Force to logged, and in Village')
                    self.startFromHUBFlag = 1
                    continue

            else:
                DataLog(self.LogFileName, "already logged and to HUB and Island")
                if self.startFromHUBFlag == 1:
                    backHUB()
                    time.sleep(LogPicTakeDelay+20)
                    backPIsland()
                    time.sleep(LogPicTakeDelay)
                    backPIsland()
                    while True:
                        time.sleep(LogPicTakeDelay)
                        ImageNew = GetWBImage(PicNewList)
                        if haveSmallImage(ImageNew, ImgIsland):
                            break
                        backPIsland()
                # littleBack()
                    if TpLayerSelect == 1:
                        IslandTP1()
                    elif TpLayerSelect == 2:
                        IslandTP2()
                    elif TpLayerSelect == 3:
                        IslandTP3()
                    elif TpLayerSelect == 4:
                        IslandTP4()
                    if PotatoFlag == 1:
                        pyautogui.moveRel(0, PotatoAngle)
                    # time.sleep(LogPicTakeDelay)
                DataLog(self.LogFileName, "prepare to working")
                pressTimeInput = McblockLength * Mck / McSpeed
                PollingTrip = 0
                PollingTotal = 0
                putChestTime = 1
                PollingMithril = 0
                # backISTrig = putChestTime + random.randint(1, 3)
                # backISPoll = 0

                while True:
                    if MithrilFlag == 1 and MithrilBreak == 1:
                        PollingMithril += 1
                        pyautogui.keyDown("shift")
                        pyautogui.mouseDown(button="left")
                        # time.sleep(1)
                        for each in PositionList:
                            pyautogui.moveRel(each[0], each[1])
                            time.sleep(1)
                        pyautogui.mouseUp(button="left")
                        pyautogui.keyUp("shift")
                        ImageNew = GetWBImage(PicNewList)
                        cv2.imwrite(".\ImageTemp\ImageMith" + str(PollingMithril) + ".jpg", ImageNew)

                        if haveSmallImage(ImageNew, ImgMithril):
                            pass
                        elif haveSmallImage(ImageNew, ImgVillage):
                            DataLog(self.LogFileName, 'Not in Island, prepare tp island')
                            backPIsland()
                            while True:
                                time.sleep(LogPicTakeDelay)
                                ImageNew = GetWBImage(PicNewList)
                                if haveSmallImage(ImageNew, ImgIsland):
                                    break
                                backPIsland()
                            # littleBack()
                            if PotatoFlag == 1:
                                pyautogui.moveRel(0, PotatoAngle)
                                time.sleep(LogPicTakeDelay)
                            TpLayerSelect += PollingTrip // TpLayer
                            if PollingTrip % TpLayer > Tp2Next:
                                TpLayerSelect += 1
                            TpLayerSelect = TpLayerSelect % TpMax
                            if TpLayerSelect == 0:
                                TpLayerSelect = 4
                            if TpLayerSelect == 1:
                                IslandTP1()
                            elif TpLayerSelect == 2:
                                IslandTP2()
                            elif TpLayerSelect == 3:
                                IslandTP3()
                            elif TpLayerSelect == 4:
                                IslandTP4()
                            # gotNertL(pressTimeInput + 0.5)
                            PollingTrip = 0
                            putChestTime = 1
                            MithrilBreak = 0
                        else:
                            DataLog(self.LogFileName, "lost communication, to check server list")
                            MithrilBreak = 0
                            ScreenServerImg = GetColorImage(PicFulList)
                            # templateImg = cv2.imread(P)
                            # cv2.imwrite(str(PollingTrip) + str(PollingTrip) + '.jpg', templateImg)
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

                    else:
                        PollingTrip += 1
                        # print(PollingTrip, PutChestFlag, putChestTime)
                        PollingTotal += 1
                        if putChestTime < PollingTrip or putChestTime > PollingTrip + afterTime +1:
                            DataLog(self.LogFileName, "putChestTime is" + str(putChestTime) + ". PollingTrip is " + str(PollingTrip)
                                    + ". putChestTime is mistake. Re-set putChestTime value.")
                            putChestTime = PollingTrip + + random.randint(firstTime, afterTime)

                        if PollingTrip % 2 == 0:
                            gotNertR(pressTimeInput)
                        else:
                            if PollingTrip == 1:
                                gotNertL(pressTimeInput + 0.5)
                            else:
                                gotNertL(pressTimeInput)
                        DataLog(self.LogFileName, 'PollingTrip time' + str(PollingTrip) + ', total is' + str(PollingTotal))
                        ImageNew = GetWBImage(PicNewList)
                        cv2.imwrite(".\ImageTemp\ImageNew" + str(PollingTotal) + ".jpg", ImageNew)

                        if haveSmallImage(ImageNew, ImgIsland):
                            DataLog(self.LogFileName, "current in island")
                            if haveSmallImage(ImageNew, ImgTicket):
                                DataLog(self.LogFileName, "putChestTime is" + str(putChestTime) + ". PollingTrip is "
                                        + str(PollingTrip) + ". putChestTime will be add 1.")
                                putChestTime = PollingTrip + 2
                            # pass
                        elif haveSmallImage(ImageNew, ImgVillage):
                            DataLog(self.LogFileName, 'Not in Island, prepare tp island')
                            backPIsland()
                            while True:
                                time.sleep(LogPicTakeDelay)
                                ImageNew = GetWBImage(PicNewList)
                                if haveSmallImage(ImageNew, ImgIsland):
                                    break
                                backPIsland()
                            # littleBack()
                            if PotatoFlag == 1:
                                pyautogui.moveRel(0, PotatoAngle)
                                time.sleep(LogPicTakeDelay)
                            TpLayerSelect += PollingTrip // TpLayer
                            if PollingTrip % TpLayer > Tp2Next:
                                TpLayerSelect += 1
                            TpLayerSelect = TpLayerSelect % TpMax
                            if TpLayerSelect == 0:
                                TpLayerSelect = 4
                            if TpLayerSelect == 1:
                                IslandTP1()
                            elif TpLayerSelect == 2:
                                IslandTP2()
                            elif TpLayerSelect == 3:
                                IslandTP3()
                            elif TpLayerSelect == 4:
                                IslandTP4()
                            # gotNertL(pressTimeInput + 0.5)
                            PollingTrip = 0
                            putChestTime = 1
                        else:
                            DataLog(self.LogFileName, "lost communication, to check server list")
                            ScreenServerImg = GetColorImage(PicFulList)
                            # templateImg = cv2.imread(P)
                            # cv2.imwrite(str(PollingTrip) + str(PollingTrip) + '.jpg', templateImg)
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
                        # print('flag1')
                        if (PollingTrip == putChestTime) and PutChestFlag:
                            # print('flag')
                            if PollingTrip % 2 == 0:
                                turn90R()
                                put2store()
                                turn90L()
                            else:
                                turn90L()
                                put2store()
                                turn90R()
                            DataLog(self.LogFileName, "put block in chest")
                            putChestTime = putChestTime + random.randint(firstTime, afterTime)

                            ScreenImg = GetColorImage(PicFulList)
                            templateImg = cv2.imread(PathBack)
                            templateImg_size = templateImg.shape[:2]
                            ScreenImg_, x_, y_ = search_returnPoint(ScreenImg, templateImg, templateImg_size)
                            if ScreenImg_ is None:
                                DataLog(self.LogFileName, "did not find back to game menu")
                            else:
                                DataLog(self.LogFileName, "puc chest failure, prepare to HUB")
                                pyautogui.moveTo(x_, y_)
                                pyautogui.click(button="left")
                                # pyautogui.press('9')
                                backHUB()
                                time.sleep(LogPicTakeDelay)
                                backPIsland()
                                while True:
                                    time.sleep(LogPicTakeDelay)
                                    ImageNew = GetWBImage(PicNewList)
                                    if haveSmallImage(ImageNew, ImgIsland):
                                        break
                                    backPIsland()
                                # littleBack()
                                if PotatoFlag == 1:
                                    pyautogui.moveRel(0, PotatoAngle)
                                    time.sleep(LogPicTakeDelay)
                                TpLayerSelect += PollingTrip // TpLayer
                                if PollingTrip % TpLayer > Tp2Next:
                                    TpLayerSelect += 1
                                TpLayerSelect = TpLayerSelect % TpMax
                                if TpLayerSelect == 0:
                                    TpLayerSelect = 4
                                if TpLayerSelect == 1:
                                    IslandTP1()
                                elif TpLayerSelect == 2:
                                    IslandTP2()
                                elif TpLayerSelect == 3:
                                    IslandTP3()
                                elif TpLayerSelect == 4:
                                    IslandTP4()
                                PollingTrip = 0
                                putChestTime = 1



class MainFunWindow(QMainWindow, Ui_MainWindow):
    def __init__(self, parent=None):
        super(MainFunWindow, self).__init__(parent)
        self.setupUi(self)
        self.UiInitialData()
        self.UiAction()

    def UiInitialData(self):
        """
        initial the main windows and PRM which was save in config.txt
        :return:
        """
        global turnXPos
        global turnXNo
        global turnYPos
        global turnYNo
        global turnDelay
        global PotatoAngle
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
        global PotatoFlag
        global PutChestFlag
        global MithrilFlag
        global TpMax
        global TpStart
        global TpLayer
        global Tp2Next
        global PositionList
        global MithrilBreak
        global MithrilTime
        global TitaniumTime
        global SkillTime
        global SkillCooldown

        with open('../ConfigPostion.txt', 'r') as CPfile:
            Lines = CPfile.readlines()
            for each in Lines:
                each = each.strip('\n')
                eachlist = each.split(',')
                # print(eachlist, len(eachlist))
                if len(eachlist) == 2:
                    eachint = []
                    for every in eachlist:
                        eachint.append(int(every))
                    PositionList.append(eachint)
            # print(PositionList)

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
            elif each[0] == 'lineEditPotato':
                PotatoAngle = int(each[1])
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
            elif each[0] == 'lineEditTpMax':
                TpMax = int(each[1])
            elif each[0] == 'lineEditTpStart':
                TpStart = int(each[1])
            elif each[0] == 'lineEditTpLayer':
                TpLayer = int(each[1])
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
            elif each[0] == 'checkBoxPotato':
                PotatoFlag = int(each[1])
            elif each[0] == 'checkBoxPutChest':
                PutChestFlag = int(each[1])
            elif each[0] == 'checkBoxMithril':
                MithrilFlag = int(each[1])
                MithrilBreak = int(each[1])
        Tp2Next = TpLayer // 10
        self.labelRevsion.setText(VersionD)
        self.labelLR.setText(str(turnXPos))
        self.labelLRNo.setText(str(turnXNo))
        self.labelUD.setText(str(turnYPos))
        self.labelUDNo.setText(str(turnYNo))
        self.labelTurnDelay.setText(str(turnDelay))
        self.labelPotato.setText(str(PotatoAngle))
        self.labelFirstX.setText(str(boxItem1[0]))
        self.labelFirstY.setText(str(boxItem1[1]))
        self.labelDist.setText(str(ItemDis))
        self.labelStoneBlock.setText(str(McblockLength))
        self.labelSpeedK.setText(str(Mck))
        self.labelSpeed.setText(str(McSpeed))
        self.labelFirstTime.setText(str(firstTime))
        self.labelSecondTime.setText(str(afterTime))
        self.labelTpMax.setText(str(TpMax))
        self.labelTpStart.setText(str(TpStart))
        self.labelTpLayer.setText(str(TpLayer))
        self.label_5.setVisible(False)
        self.label_6.setVisible(False)
        self.label_13.setVisible(False)
        self.label_21.setVisible(False)
        self.labelUD.setVisible(False)
        self.labelUDNo.setVisible(False)
        self.labelDirection.setVisible(False)
        self.lineEditUD.setVisible(False)
        self.lineEditUDNo.setVisible(False)
        self.lineEditDirection.setVisible(False)
        self.comboBoxDirection.setVisible(False)
        self.PositionText = ''
        self.PositionWarpFlag = 0
        for each in PositionList:
            self.PositionWarpFlag += 1
            for cell in each:
                self.PositionText += str(cell)
                self.PositionText += ","
            self.PositionText += '\t'
            if self.PositionWarpFlag % 5 == 0:
                self.PositionText += '\n'
        self.labelMithril.setText(self.PositionText)
        for each in PathAllList:
            TempImg = cv2.imread(each).shape
            eachName = each.split('\\').pop()[:4]
            if eachName == "Mult":
                self.labelMut.setText(self.labelMut.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelMutD.setPixmap(QPixmap(each))
            elif eachName == 'Hypi':
                self.labelHyp.setText(self.labelHyp.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelHypD.setPixmap(QPixmap(each))
            elif eachName == 'Join':
                self.labelJon.setText(self.labelJon.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelJonD.setPixmap(QPixmap(each))
            elif eachName == 'Canc':
                self.labelCan.setText(self.labelCan.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelCanD.setPixmap(QPixmap(each))
            elif eachName == 'Game':
                self.labelGam.setText(self.labelGam.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelGamD.setPixmap(QPixmap(each))
            elif eachName == 'Skyb':
                self.labelSky.setText(self.labelSky.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelSkyD.setPixmap(QPixmap(each))
            elif eachName == 'Done':
                self.labelDon.setText(self.labelDon.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelDonD.setPixmap(QPixmap(each))
            elif eachName == 'Serv':
                self.labelSer.setText(self.labelSer.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelSerD.setPixmap(QPixmap(each))
            elif eachName == 'Isla':
                self.labelIsl.setText(self.labelIsl.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelIslD.setPixmap(QPixmap(each))
            elif eachName == 'Vill':
                self.labelVil.setText(self.labelVil.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelVilD.setPixmap(QPixmap(each))
            elif eachName == 'Back':
                self.labelBack.setText(self.labelBack.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelBackD.setPixmap(QPixmap(each))
            elif eachName == 'Tick':
                self.labelTick.setText(self.labelTick.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelTickD.setPixmap(QPixmap(each))
            elif eachName == 'Mith':
                self.labelMith.setText(self.labelMith.text() + ': ' + str(TempImg[0]) + " X " + str(TempImg[1]))
                self.labelMithD.setPixmap(QPixmap(each))


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
        if PotatoFlag == 1:
            self.checkBoxPotato.setChecked(True)
            self.label.setText("Minecraft自动土豆脚本")
        else:
            self.checkBoxPotato.setChecked(False)
            self.label.setText("Minecraft自动地狱疣脚本")
        if PutChestFlag == 1:
            self.checkBoxPutChest.setChecked(True)
        else:
            self.checkBoxPutChest.setChecked(False)
        if MithrilFlag == 1:
            self.checkBoxMithril.setChecked(True)
        else:
            self.checkBoxMithril.setChecked(False)
        self.LogFileName = datetime.datetime.now().strftime('%Y-%m-%d') + ".txt"
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
        """
        display setting
        :return:
        """
        # todo this function is not very useful after display detection
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
        """
        the Minecraft Version selection
        after 1.12, turn 600 is 90.
        :return:
        """
        if self.comboBoxVersion.currentText() == "1.12":
            self.lineEditLR.setText('200')
            self.lineEditUD.setText('100')

        if self.comboBoxVersion.currentText() == "":
            self.lineEditLR.setText('')
            self.lineEditUD.setText('')

    def directionUpdate(self):
        """
        Island TP black on right or left selection
        :return:
        """
        # print(self.comboBoxDirection.currentText())
        if self.comboBoxDirection.currentText() == "右":
            self.lineEditDirection.setText('1')

        if self.comboBoxDirection.currentText() == "左":
            self.lineEditDirection.setText('2')

        if self.comboBoxDirection.currentText() == "":
            self.lineEditDirection.setText('')


    def applyData(self):
        """
        apply data if some new input and apply data pushbutton is pressed
        :return:
        """
        global turnXPos
        global turnXNo
        global turnYPos
        global turnYNo
        global turnDelay
        global PotatoAngle
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
        global PutChestFlag
        global MithrilFlag
        global PotatoFlag
        global TpMax
        global TpStart
        global TpLayer
        global Tp2Next
        global MithrilTime
        global TitaniumTime
        global SkillTime
        global SkillCooldown

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
        if self.lineEditPotato.text() != '':
            PotatoAngle = int(self.lineEditPotato.text())
            self.labelPotato.setText(str(PotatoAngle))
            self.lineEditPotato.setText('')
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
        if self.lineEditTpMax.text() != '':
            TpMax = int(self.lineEditTpMax.text())
            self.labelTpMax.setText(str(TpMax))
            self.lineEditTpMax.setText('')
        if self.lineEditTpStart.text() != '':
            TpStart = int(self.lineEditTpStart.text())
            self.labelTpStart.setText(str(TpStart))
            self.lineEditTpStart.setText('')
        if self.lineEditTpLayer.text() != '':
            TpLayer = int(self.lineEditTpLayer.text())
            self.labelTpLayer.setText(str(TpLayer))
            self.lineEditTpLayer.setText('')
        # todo need to code to update according to textEdit
        # print(startFromLogin, startFromHUB, checkInIsland)

    def saveData2File(self):
        """
        save PRM to config.txt file
        :return:
        """
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
            elif each[0] == 'lineEditPotato':
                each[1] = str(PotatoAngle)
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
            elif each[0] == 'lineEditTpMax':
                each[1] = str(TpMax)
            elif each[0] == 'lineEditTpStart':
                each[1] = str(TpStart)
            elif each[0] == 'lineEditTpLayer':
                each[1] = str(TpLayer)
            elif each[0] == 'checkBoxLogin':
                each[1] = str(startFromLogin)
            elif each[0] == 'checkBoxHUB':
                each[1] = str(startFromHUB)
            elif each[0] == 'checkBoxIsland':
                each[1] = str(checkInIsland)
            elif each[0] == 'checkBoxPotato':
                each[1] = str(PotatoFlag)
            elif each[0] == 'checkBoxPutChest':
                each[1] = str(PutChestFlag)
            elif each[0] == 'checkBoxMithril':
                each[1] = str(MithrilFlag)

        with open('../Config.txt', 'w') as logfile:
            NewLines = []
            for each in self.ConfList:
                NewLines.append(each[0]+'='+each[1]+'\n')
            logfile.writelines(NewLines)


    def startGetStone(self):
        """
        start main function
        :return:
        """
        self.startThread.start()
        self.pushButtonStop.setEnabled(True)
        self.pushButtonStart.setEnabled(False)


    def stopGetStone(self):
        """
        stop main funciton
        :return:
        """
        self.startThread.terminate()
        self.pushButtonStop.setEnabled(False)
        self.pushButtonStart.setEnabled(True)


    def checkboxLoginUp(self):
        """
        checkboxLogin action
        :return:
        """
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
        """
        checkboxHUB action
        :return:
        """
        global startFromHUB
        if self.checkBoxHUB.isChecked():
            startFromHUB = 1
        else:
            startFromHUB = 0


    def checkboxIslandUp(self):
        """
        checkboxIsland action
        :return:
        """
        global checkInIsland
        if self.checkBoxIsland.isChecked():
            checkInIsland = 1
        else:
            checkInIsland = 0


    def checkBoxPotatoUp(self):
        """
        checkboxPotato action
        :return:
        """
        global PotatoFlag
        if self.checkBoxPotato.isChecked():
            PotatoFlag = 1
            self.label.setText("Minecraft自动土豆脚本")
        else:
            PotatoFlag = 0
            self.label.setText("Minecraft自动地狱疣脚本")


    def checkBoxPutChestUp(self):
        """
        checkboxPutChest action
        :return:
        """
        global PutChestFlag
        if self.checkBoxPutChest.isChecked():
            PutChestFlag = 1
        else:
            PutChestFlag = 0

    def checkBoxMithrilUp(self):
        """
        checkboxMithril action
        :return:
        """
        global MithrilFlag
        if self.checkBoxMithril.isChecked():
            MithrilFlag = 1
        else:
            MithrilFlag = 0
        print(MithrilFlag)


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
        self.checkBoxPotato.stateChanged.connect(self.checkBoxPotatoUp)
        self.checkBoxPutChest.stateChanged.connect(self.checkBoxPutChestUp)
        self.checkBoxMithril.stateChanged.connect(self.checkBoxMithrilUp)
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
