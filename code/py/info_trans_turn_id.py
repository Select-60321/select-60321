import csv

file_path1 = 'C:\\Users\\Lori\\Desktop\\info_transfer.csv'
file_path2 = 'C:\\Users\\Lori\\Desktop\\stations_rectified.csv'
file_path = 'C:\\Users\\Lori\\Desktop\\info_trans_id.csv'
f = open(file_path, 'w', encoding='gbk', newline='')


origin1 = open(file_path1, 'r', encoding='gbk')
origin2 = open(file_path2, 'r', encoding='gbk')


csv_writer = csv.writer(f)

reader1 = csv.reader(origin1)
reader2 = csv.reader(origin2)
header_row1 = next(reader1)
header_row2 = next(reader2)

dic = {}

for row in reader2:
    # dic.append(str(row[0].strip()))
    dic[str(row[0].strip())] = str(row[2].strip())

for row in reader1:
    ls = []
    ls.append(str(row[0].strip()))
    ls.append(str(row[1].strip()))
    tmp = str(row[2].strip())
    idx = dic[tmp]
    ls.append(idx)
    ls.append(str(row[3].strip()))
    ls.append(str(row[4].strip()))
    ls.append(str(row[5].strip()))
    ls.append(str(row[6].strip()))
    ls.append(str(row[7].strip()))
    csv_writer.writerow(ls)
