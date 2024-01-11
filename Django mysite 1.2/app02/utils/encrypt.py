import hashlib
from mysite.settings import SECRET_KEY


def md5(data_str):
    salt = SECRET_KEY
    obj = hashlib.md5(salt.encode('utf-8'))
    obj.update(data_str.encode('utf-8'))
    return obj.hexdigest()