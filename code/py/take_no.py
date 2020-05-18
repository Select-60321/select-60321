import csv

file_path1 = 'C:\\Users\\Lori\\Desktop\\info_transfer.csv'
file_path2 = 'C:\\Users\\Lori\\Desktop\\stations.csv'
file_path = 'C:\\Users\\Lori\\Desktop\\no.csv'
f = open(file_path, 'w', encoding='gbk')

origin1 = open(file_path1, 'r', encoding='gbk')
origin2 = open(file_path2, 'r', encoding='gbk')


csv_writer = csv.writer(f)
reader1 = csv.reader(origin1)
reader2 = csv.reader(origin2)
header_row1 = next(reader1)
header_row2 = next(reader2)

list_station = []
for row in reader2:
    list_station.append(str(row[0].strip()))

list_no = []
for row in reader1:
    tmp = str(row[2].strip())
    if tmp not in list_station and tmp not in list_no:
        list_no.append(tmp)

for i in list_no:
    f.write(i)
    f.write('\n')
