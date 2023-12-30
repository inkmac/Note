# coding=utf-8
# @time     :2020/12/16/016 23:01
# @Author   :Yifeng.ZHAO
# @Email    :zyf_syjs@163.com
# @File     :setup.py
# @Software :#{PRODUCT_NAME}


import setuptools
from distutils.core import setup
from Cython.Build import cythonize
from distutils.extension import Extension
extensions = []
extensions.append(Extension('SwCode', ['SwCode.py']))
# extensions.append(Extension('subFolder.subModule',['subFolder/subModule.py']))

setup(
    ext_modules = cythonize(extensions, compiler_directives={'language_level': 2}),

)

# setup(ext_modules=cythonize("MVBd.py"))
