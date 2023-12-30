from PyQt5.Qt import *
import sys

class Window(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Learn OOP")
        self.resize(500, 500)
        self.init_ui()

    def init_ui(self):
        self.obj = QObject()

        def objNameSlot(name):  # 创建槽
            print("objName changed~", name)

        self.obj.objectNameChanged.connect(objNameSlot)  # 建立信号连接
        self.obj.setObjectName("BOB")

        self.obj.blockSignals(True)   # 临时阻断连接
        self.obj.setObjectName("Steve")
        print("block status:" ,self.obj.signalsBlocked())
        self.obj.blockSignals(False)   # 恢复连接

        self.obj.setObjectName("Alex")
        self.obj.objectNameChanged.disconnect()   # 断开信号



if __name__ == '__main__':
    app = QApplication(sys.argv)

    window = Window()
    window.show()

    sys.exit(app.exec_())