from rest_framework import serializers

from .models import Student, Teacher


class TeacherSerializer(serializers.ModelSerializer):
    class Meta:
        model = Teacher
        fields = ['name']


class StudentSerializer(serializers.ModelSerializer):
    # 外键字段, 如果不定义默认序列化的是外键的id字段
    teacher = serializers.ReadOnlyField(source='teacher.name')  # 不需要修改, 所以使用ReadOnlyField

    class Meta:
        model = Student   # 序列化的 Model
        fields = ['name', 'age', 'description', 'teacher']   # 序列化的字段
