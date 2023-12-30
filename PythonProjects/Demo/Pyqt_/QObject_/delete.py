from PyQt5.Qt import *
import sys

class Window(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("")
        self.resize(500, 500)
        self.init_ui()

    def init_ui(self):
        obj = QLabel(self)
        obj.setText("Hello, World")

        def destroySlot():
            print("Slot released~", obj)

        obj.destroyed.connect(destroySlot)
        obj.deleteLater()   # 删除对象


if __name__ == '__main__':
    app = QApplication(sys.argv)

    window = Window()
    window.show()

    sys.exit(app.exec_())