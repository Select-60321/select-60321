import requests
import lxml.html as lh
import pandas as pd
import csv
import time
file_name = "C:\\Users\\lori\\desktop\\train_list.csv"
file_path = 'C:\\Users\\lori\\desktop\\G.csv'
f = open(file_path, 'a+', encoding='gbk')

flag_pointer = 1

with open(file_name)as fcsv:
    reader = csv.reader(fcsv)
    header_row = next(reader)

    for row in reader:
        if row[0][0] == 'G' and flag_pointer > 5165 and flag_pointer < 5436:
            train_code = row[0]
            url = 'http://www.huochepiao.net/chaxun/resultc.asp?txtCheCi='+train_code
            page = requests.get(url)
            doc = lh.fromstring(page.content)
            try:
                tr_elements = doc.xpath('//tr')
                col = []
                i = 0
                # head = ''
                for t in tr_elements[12]:
                    i += 1
                    # name = t.text_content()
                    # head = head + name + ","
                size = i
                # f.write(head+"\n")
                i = 0
                line = ''
                for j in range(1, len(tr_elements)):
                    if i < 12:
                        i += 1
                        continue
                    T = tr_elements[j]
                    if len(T) != size:
                        break
                    k = 0
                    for t in T.iterchildren():
                        k += 1
                        data = str(t.text_content())
                        data = data.replace("\n", "")
                        data = data.replace("\r", "")
                        data = data.strip()
                        if(k < size):
                            line = line + data + ','
                        else:
                            line = line + data + '\n'
                            k = 0
                f.write(line)
                time.sleep(1.5)
                print("Sleep for a while")
            except Exception:
                time.sleep(1.5)
                print("exception")
            finally:
                continue
            flag_pointer += 1
        else:
            flag_pointer += 1
            # break
