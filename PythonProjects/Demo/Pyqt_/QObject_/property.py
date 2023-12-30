from PyQt5.Qt import *
import sys

class Window(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Learn OOP")
        self.resize(500, 500)
        self.init_ui()

    def init_ui(self):
        self.operateAttr()
        self.qss()

    def operateAttr(self):
        obj = QObject()
        obj.setObjectName("notice")  # 设置名称(一般是唯一的, 当做id使用)
        print(obj.objectName())  # 获取Qt name

        obj.setProperty("notice_level", "error")  # 给Qt对象动态添加一个属性和值
        obj.setProperty("notice_level2", "error")
        print(obj.property("notice_level"))  # 获取Qt property
        print(obj.dynamicPropertyNames())  # 获取以前所有通过setProperty设置的属性名称

    def qss(self):
        label = QLabel(self)
        label.setText("Hello")
        label.setStyleSheet("font-size: 30px; color: blue")  # 设置qss



if __name__ == '__main__':
    app = QApplication(sys.argv)

    window = Window()
    window.show()

    sys.exit(app.exec_())

