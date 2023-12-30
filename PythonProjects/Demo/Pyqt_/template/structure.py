from PyQt5.Qt import *
import sys

# 1. 创建一个应用程序对象
app = QApplication(sys.argv)

# 2. 控件的操作
# 创建控件, 如果该控件是顶层控件, 则系统会自动给一些装饰
window = QWidget()
window.setWindowTitle("社会我赵哥")
window.resize(500, 500)
window.move(400, 400)

label = QLabel(window)  # 控件可以作为一个容器(承载其他控件)
label.setText("Hello, Windows")
label.move(200, 200)

window.show()  # 显示控件

# 3. 让整个程序开始执行, 并且进入到消息循环, 检测用户的交互信息
# 当用户退出时, 程序结束
sys.exit(app.exec_())
