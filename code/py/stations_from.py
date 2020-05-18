import json
import csv
file_path = "C:\\Users\\lori\\desktop\\station_from_cities.csv"
f = open(file_path, 'w', encoding='gbk')
f.write('station_name,station_telecode,province,city\n')


def resolveJson(path):
    file = open(path, "rb")
    fileJson = json.load(file)
    for t in fileJson:
        sta_name = t['station_name'].strip()
        sta_code = t['station_telecode'].strip()
        province = t['province'].strip()
        city = t['city'].strip()
        temp_str = sta_code+","+sta_name+","+province+","+city+"\n"
        f.write(temp_str)


path = "C:\\Users\\lori\\desktop\\stations_prov_city.json"
resolveJson(path)
