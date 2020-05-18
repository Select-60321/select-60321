import requests
import lxml.html as lh
import pandas as pd

train_code = 'D1'

url = 'http://www.huochepiao.net/chaxun/resultc.asp?txtCheCi='+train_code
page = requests.get(url)
file_path = 'C:\\Users\\lori\\desktop\\D617.csv'
f = open(file_path, 'a+', encoding='gbk')


doc = lh.fromstring(page.content)
try:
    tr_elements = doc.xpath('//tr')
    # print([len(T) for T in tr_elements[12:len(tr_elements)-1]])
    col = []
    i = 0
    # head = ''
    for t in tr_elements[12]:
        i += 1
        # name = t.text_content()
        # head = head + name + ","
        # print(i, name)
        # col.append((name, []))
    size = i
    # f.write(head+"\n")
    # print("size is", size)
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
                # print(data, end=',')
                line = line + data + ','
            else:
                # print(data)
                line = line + data + '\n'
                k = 0
    f.write(line)
except Exception:
    print("error")
# print(line)
