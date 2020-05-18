# import requests
# import bs4
# # from lxml import html
# import time

# path = 'http://www.huochepiao.net/chaxun/resultc.asp?txtCheCi=D1'

# page = ''
# while page == '':
#     try:
#         page = requests.get(path)
#         break
#     except:
#         print("Connection refused by the server...")
#         print("Let me sleep for 5 seconds")
#         print("ZZzzzz...")
#         time.sleep(5)
#         print("Was a nice sleep, now let me continue...")
#         continue
# # res = requests.get('https://qq.ip138.com/train/D10.htm')
# # try:
# #     page1 = requests.get(ap)
# # except requests.exceptions.ConnectionError:
# #     r.status_code = "Connection refused"

# soup = bs4.BeautifulSoup(page.text, "html.parser")
# print(soup)


# # import requests
# # from lxml import html

# # page = requests.get("https://itunes.apple.com/in/genre/ios-business/id6000?mt=8")
# # tree = html.fromstring(page.text)

# # flist = []
# # plist = []
# # for i in range(0, 100):
# #     app = tree.xpath("//div[@class='column first']/ul/li/a/@href")
# #     ap = app[0]
# #     page1 = requests.get(ap)
# import requests
# import bs4
# res = requests.get('http://www.huochepiao.net/chaxun/resultc.asp?txtCheCi=D1')
# res.raise_for_status()
# noStarchSoup = bs4.BeautifulSoup(res.text, "html.parser")
# print(type(noStarchSoup))


"""body > table:nth-child(3) > tbody > tr > td > center > table:nth-child(25) > tbody"""

from bs4 import BeautifulSoup
import requests

path = "http://www.huochepiao.net/chaxun/resultc.asp?txtCheCi=D1"

res = requests.get(path)
res.raise_for_status()
soup = BeautifulSoup(res.text, "lxml")
for table in soup.findAll('table'):
    print("<table border='1'>")

    for row in table.findAll('tr'):
        print("<tr>")
        for tr in row.findAll('td'):
            print("<td>")
            print(tr.text.encode("utf-8"))
            print("<td>")

        print("</tr>")
    print("</table>")
    break
