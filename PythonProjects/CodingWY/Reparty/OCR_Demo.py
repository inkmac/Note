# coding=utf-8
# @time     :2020/12/7/007 22:04
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :Main_Ver1.0.0.py
# @Software :#{PRODUCT_NAME}

import cv2


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
    # print('get wb pic done')
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
