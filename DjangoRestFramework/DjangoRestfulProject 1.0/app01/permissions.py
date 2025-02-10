from rest_framework import permissions


class IsOwnerOrReadOnly(permissions.BasePermission):
    """ 自定义权限: 只有对象所有者可以有所有权限, 否则只能读取 """
    def has_object_permission(self, request, view, obj):
        if request.method in permissions.SAFE_METHODS:
            return True
        return obj.owner == request.user
