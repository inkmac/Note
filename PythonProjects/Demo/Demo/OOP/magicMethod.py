class Student:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __str__(self):    # java的toString方法
        return f"name: {self.name}, age: {self.age}"

    def __eq__(self, other):    # java的equals方法
        return self.age == other.age and self.name == other.name

    def __lt__(self, other):   # less than
        return self.age < other.age

    def __le__(self, other):   # less equals
        return self.age <= other.age


stu = Student("BOB", 100)
stu1 = Student("Jack", 90)
print(stu)
print(stu.__dict__)  # 将对象信息以字典形式输出
print(stu.__eq__(stu1))
print(stu < stu1)
print(stu <= stu1)
print(stu == stu1)