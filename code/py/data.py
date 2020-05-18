import time
string = '2018-06-26 23:59:00'
string_2 = '2018-06-26 00:01:00'
print(time.mktime(time.strptime(string, '%Y-%m-%d %H:%M:%S')))
print(time.mktime(time.strptime(string_2, '%Y-%m-%d %H:%M:%S')))
