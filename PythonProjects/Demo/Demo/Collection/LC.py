mylist = [1, -2, 3, -4, 5]
print(mylist)

# 列表推导式  list comprehension
# 类似数学的集合
# {item | item ∈ mylist, item > 0}
LC: list = [item for item in mylist if item > 0]
print(LC)


# 生成器表达式  generator expression
GE = (item for item in mylist if item > 0)
for each in GE:
    print(each, end=" ")
