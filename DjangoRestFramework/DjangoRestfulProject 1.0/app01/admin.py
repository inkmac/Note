from django.contrib import admin

from app01.models import Student, Teacher


@admin.register(Student)
class StudentAdmin(admin.ModelAdmin):
    list_display = ('name', 'age', 'description', 'created_time', 'teacher')
    search_fields = ('name', 'age')
    list_filter = ('teacher',)


@admin.register(Teacher)
class TeacherAdmin(admin.ModelAdmin):
    list_display = ('name', 'id')
    search_fields = ('name',)