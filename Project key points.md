# Project key points

## Data Source and manipulations

获取：使用Python爬虫爬取（**黎诗龙**）

http://www.huochepiao.net/chaxun/resultc.asp?txtCheCi=

处理：使用Python和Java转为sql语句（**双人**）



## Database Design Part

主要负责人：**聂秋实**

使用数据库：PostgreSQL

### 9 tables:

1. cities

   存储城市及其省份

2. stations

   存储车站及其所在城市，车站状态

3. journeys

   存储某个车次在某个站的到站时间和离站时间，这个站是第几站，从起点站到这个站的距离是多少，这个站的状态

4. carriages

   存储某个车次的车厢号，及对应车厢的座位类型和座位数量

5. seat_type

   存储10余种座位类型的名称及基础票价

6. users

   存储用户信息

7. admins

   存储管理员信息

8. orders

   存储用户们的订单信息

9. tickets

   存储火车票信息



## Back-end Part

### 4 triggers (with their functions)

1. `update_ticket_price`

   当table seat_type中的seat_basic_price属性改变后，需要改动相应该座位类型的所有火车票的票价

2. `update_order_price`

   当车票价格改变后订单价格也相应的进行修改

3. `update_journey_status`

   当station的状态改变后，改变journey的状态

4. `update_ticket_active`

   当journey的状态改变后，改变ticket的状态





## Back-end Part

主要负责人：**黎诗龙**

主要框架：Springboot + MyBatis



### Springboot：

1. hikari连接池
2. Thymeleaf模板引擎
3. Session拦截器



### ORM框架：

​	MyBatis：

1. JDBC事物管理
2. JDBC连接池
3. `preparedStatement`保证安全
4. 二级缓存使用了eh-cache（第三方包），保证数据不会被修改的情况下，减少了与数据库的交互时间，更快地获取数据，其余情况不使用
5. 写好了接口，可以通过post/get请求调用



## Front-end Part

主要负责人：**聂秋实**

Thymeleaf + HTML + CSS

背景图片主要来源：百度图片



## Functions

### User

1. 用户登录及注册

2. 可以根据始发站和终点站/始发城市和重点城市查询火车

3. 可以查询车次基本信息

4. 可以查询自己的订单



### Administrator

1. 管理员登录

2. 可以取消/恢复站点
3. 可以在一列火车后加站点
4. 可以取消一列火车的某一个停靠站点
5. 可以取消/恢复一列火车

