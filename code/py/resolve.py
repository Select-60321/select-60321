""""Created by Li Shilong on 2020/04/12 02:08"""
import json
import csv
type_list = ['D', 'T', 'G', 'C', 'O', 'K', 'Z']
file_path = "C:\\Users\\lori\\desktop\\train_list.csv"
f = open(file_path, 'w', encoding='gbk')
f.write('Station_train_code,Departure,Destination\n')
big_list = []


def resolveJson(path):
    k = 0
    file = open(path, "rb")
    fileJson = json.load(file)

    while k < 7:
        for i in fileJson['2019-10-10'][type_list[k]]:
            temp_str = i['station_train_code']
            temp_str = temp_str.replace('(', ',')
            temp_str = temp_str.replace("-", ",")
            temp_str = temp_str.replace(")", "")
            temp_str = temp_str.replace("\r", "")
            temp_str = temp_str.replace("\n", "")
            f.write(temp_str+"\n")
        k += 1


path = "C:\\Users\\lori\\desktop\\train_list.json"
resolveJson(path)
