import re

text = "Hello, 123 want 123@World"
data = re.findall("", text)
print(data)


'''  
123 匹配文本中的123
[abc] 匹配a或b或c字符
[^abc] 匹配除了abc以外的字符
[a-z] 匹配a~z的任意字符  eg: [0-9] [A-Z]
. 代表除换行符以外的任意字符
\w 代指字母或数字或下划线或汉字
\d 代指数字

+ 1个或更多个
? 0个或1个
* 任意个
{n} n个
{n,} n个或更多个
{n,m} n~m个
'''