import csv

file_path2 = 'C:\\Users\\Lori\\Desktop\\info_trans_id.csv'
file = 'C:\\Users\\Lori\\Desktop\\journeys_no.sql'
f = open(file, 'w', encoding='gbk')

origin2 = open(file_path2, 'r', encoding='gbk')
reader2 = csv.reader(origin2)


sql = 'insert into public.journeys (train_id, station_index, station_id, arrive_time, depart_time, arrive_day, depart_day, distance) values('

lines_str = []
train = []
for row in reader2:
    uni = str(row[0].strip())+str(row[1].strip())
    if uni in train:
        continue
    else:
        train.append(uni)
        arr_t = 'null'
        if str(row[3].strip()) != 'null':
            arr_t = str(row[3].strip())
            arr_t = "'"+arr_t+"'"
        dep_t = 'null'
        if str(row[4].strip()) != 'null':
            dep_t = str(row[4].strip())
            dep_t = "'"+dep_t+"'"
        sql2 = sql + "'" + str(row[0].strip())+"'," + \
            str(row[1].strip())+","+str(row[2].strip())+"," + arr_t + \
            ","+dep_t+","+str(row[5].strip())+"," + \
            str(row[6].strip())+","+str(row[7].strip())+");\n"
        # print(sql2)
        # break
        lines_str.append(sql2)
lines_str.append('commit;')
f.writelines(lines_str)
