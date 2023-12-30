from PyQt5.Qt import *
import sys

class Window(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("")
        self.resize(500, 500)
        self.init_ui()

    def init_ui(self):
        btn = QPushButton(self)
        btn.setText("按钮")

        def keyPress():
            text = QLabel(self)
            text.setText("Hello, World")
            text.move(200, 200)
            print("btn is pressed~")

        btn.pressed.connect(keyPress)



if __name__ == '__main__':
    app = QApplication(sys.argv)

    window = Window()
    window.show()

    sys.exit(app.exec_())