import re

text = "135 3360 8080"
data = re.findall("^1[0-9 ]{12}$", text)
print(data)

#  ^表示起始 $表示结束  如果text没按照这个开始和结束, 就搜寻不到