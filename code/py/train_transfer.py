import csv
import time
file_path = "C:\\Users\\lori\\desktop\\carriage.csv"
to_path = "C:\\Users\\lori\\desktop\\carriage_transfer.csv"
origin = open(file_path, 'r', encoding='utf-8')
f = open(to_path, 'w', encoding='gbk', newline='')  # to write into
# f.write('tid,sno,sname,arrive_time,depart_time,arrive_day,depart_day,distance\n')
csv_writer = csv.writer(f)
reader = csv.reader(origin)
header_row = next(reader)

gaoji = '高级软卧'
ruanwo = '软卧'
yingwo = '硬卧'
yingzuo = '硬座'
wuzuo = '无座'
shangwu = '商务'
yidengzuo = '一等'
erdengzuo = '二等'


for row in reader:
    tid = str(row[0].strip())
    cid = str(row[1].strip())
    ctype = str(row[2].strip())
    seat_num = str(row[3].strip())
    ctype_id = 0

    try:
        num_tid = int(tid)
        if ctype == ruanwo:
            ctype_id = 15
        elif ctype == yingwo:
            ctype_id = 16
        elif ctype == yingzuo:
            ctype_id = 17
        elif ctype == wuzuo:
            ctype_id = 18
    except ValueError:
        pass
    heads = tid[0:1]
    if heads == 'D':
        if ctype == yidengzuo:
            ctype_id = 4
        elif ctype == erdengzuo:
            ctype_id = 5
    elif heads == 'G':
        if ctype == shangwu:
            ctype_id = 1
        elif ctype == yidengzuo:
            ctype_id = 2
        elif ctype == erdengzuo:
            ctype_id = 3
    elif heads == 'T' or heads == 'Z':
        if ctype == gaoji:
            ctype_id = 6
        elif ctype == ruanwo:
            ctype_id = 7
        elif ctype == yingwo:
            ctype_id = 8
        elif ctype == yingzuo:
            ctype_id = 9
        elif ctype == wuzuo:
            ctype_id = 10
    elif heads == 'K':
        if ctype == ruanwo:
            ctype_id = 11
        elif ctype == yingwo:
            ctype_id = 12
        elif ctype == yingzuo:
            ctype_id = 13
        elif ctype == wuzuo:
            ctype_id = 14
    elif heads == 'C' or heads == 'Y' or heads == 'S':
        if ctype == ruanwo:
            ctype_id = 15
        elif ctype == yingwo:
            ctype_id = 16
        elif ctype == yingzuo:
            ctype_id = 17
        elif ctype == wuzuo:
            ctype_id = 18

    string = [tid, cid, str(ctype_id), seat_num]
    csv_writer.writerow(string)
