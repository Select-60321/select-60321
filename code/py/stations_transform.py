import csv

file_path2 = 'C:\\Users\\Lori\\Desktop\\stations_rectified.csv'
file = 'C:\\Users\\Lori\\Desktop\\stations_last.sql'
f = open(file, 'w', encoding='gbk')

origin2 = open(file_path2, 'r', encoding='gbk')
reader2 = csv.reader(origin2)
header_row2 = next(reader2)

sql = 'insert into public.stations (station_name, city_id) values('

lines_str = []
for row in reader2:
    sql2 = sql + "'" + str(row[0].strip())+"',"+str(row[1].strip())+");\n"
    lines_str.append(sql2)
f.writelines(lines_str)
