import csv
import time
file_path = "C:\\Users\\lori\\desktop\\info.csv"
to_path = "C:\\Users\\lori\\desktop\\info_transfer.csv"
origin = open(file_path, 'r', encoding='utf-8')
f = open(to_path, 'w', encoding='gbk', newline='')  # to write into
f.write('tid,sno,sname,arrive_time,depart_time,arrive_day,depart_day,distance\n')
csv_writer = csv.writer(f)

reader = csv.reader(origin)
header_row = next(reader)
const = '-99:00'
constdate = '2020-01-01 '
sec = ':00'
for row in reader:
    tid = str(row[0].strip())
    sno = int(row[1].strip())
    sname = str(row[2].strip())
    arr_time = str(row[3].strip())
    dep_time = str(row[4].strip())
    day = int(row[5].strip())
    distance = int(row[6].strip())

    if arr_time == const:
        arr_time = 'null'
        arr_day = 'null'
        dep_day = 1
    else:
        if dep_time == const:
            dep_time = 'null'
            arr_day = day
            dep_day = 'null'
        else:
            arr_day = day
            arr = constdate+arr_time+sec
            dep = constdate+dep_time+sec
            a = time.mktime(time.strptime(arr, '%Y-%m-%d %H:%M:%S'))
            b = time.mktime(time.strptime(dep, '%Y-%m-%d %H:%M:%S'))
            if a > b:
                dep_day = 2
            else:
                dep_day = day

    string = [tid, str(sno), sname, arr_time, dep_time,
              str(arr_day), str(dep_day), str(distance)]
    csv_writer.writerow(string)
