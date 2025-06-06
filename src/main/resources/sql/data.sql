-- 插入测试数据
INSERT INTO pg_type_demo (
    int_value, smallint_value, bigint_value, decimal_value, numeric_value, real_value, double_value,
    money_value, char_value, varchar_value, text_value, date_value, time_value, timestamp_value, timestamptz_value,
    interval_value, boolean_value, mood_value, point_value, line_value, box_value, circle_value,
    inet_value, cidr_value, macaddr_value, tsvector_value, xml_value, uuid_value, json_value, jsonb_value,
    int_array, text_array, int_range, timestamp_range, oid_value, address_value
) VALUES
-- 记录 1
(
    42, 100, 9223372036854775807, 123.45, 456.78, 3.14, 2.71828,
    '$1,234.56', 'CHAR值1   ', '变长字符串1', '这是一段长文本，可以包含很多内容。这是第一条记录的文本值。',
    '2023-01-01', '08:30:00', '2023-01-01 08:30:00', '2023-01-01 08:30:00+08',
    '1 day 2 hours', TRUE, 'happy', '(1,2)', '{1,2,3}', '((0,0),(1,1))', '<(0,0),5>',
    '192.168.1.1', '192.168.1.0/24', '08:00:2b:01:02:03', 'PostgreSQL 是一个功能强大的开源对象关系数据库系统',
    '<root><element>XML数据1</element></root>', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11',
    '{"name": "张三", "age": 30, "hobbies": ["读书", "游泳"]}',
    '{"name": "张三", "contact": {"email": "zhangsan@example.com", "phone": "13800138000"}}',
    '{1,2,3,4,5}', '{"苹果", "香蕉", "橙子"}', '[1,100)', '[2023-01-01, 2023-12-31)', 1000,
    ROW('北京路100号', '上海市', '200001')::address_type
),

-- 记录 2
(
    -42, 200, 8223372036854775806, 234.56, 567.89, 6.28, 1.41421,
    '$2,345.67', 'CHAR值2   ', '变长字符串2', '这是第二条记录的文本值，展示了TEXT类型的灵活性。',
    '2023-02-02', '09:45:00', '2023-02-02 09:45:00', '2023-02-02 09:45:00+08',
    '2 days 4 hours 30 minutes', FALSE, 'sad', '(3,4)', '{4,5,6}', '((1,1),(2,2))', '<(1,1),3>',
    '10.0.0.1', '10.0.0.0/8', '00:1A:2B:3C:4D:5E', '全文搜索 是 PostgreSQL 的一个强大功能',
    '<data><item>XML数据2</item></data>', 'b1eebc99-9c0b-4ef8-bb6d-6bb9bd380a22',
    '{"name": "李四", "age": 25, "address": "北京市海淀区"}',
    '{"name": "李四", "skills": ["Java", "Python", "SQL"]}',
    '{10,20,30,40}', '{"猫", "狗", "兔子"}', '[10,200)', '[2022-01-01, 2022-06-30)', 2000,
    ROW('南京路200号', '北京市', '100001')::address_type
),

-- 记录 3
(
    100, 300, 7223372036854775805, 345.67, 678.90, 9.8, 3.14159,
    '$3,456.78', 'CHAR值3   ', '变长字符串3', '这是第三条记录的文本内容，可以存储大量文本数据。',
    '2023-03-03', '10:15:00', '2023-03-03 10:15:00', '2023-03-03 10:15:00+08',
    '1 week 3 days', TRUE, 'neutral', '(5,6)', '{7,8,9}', '((2,2),(3,3))', '<(2,2),4>',
    '172.16.0.1', '172.16.0.0/16', 'AC:DE:48:23:45:67', 'PostgreSQL 支持 JSON JSONB XML 等多种数据类型',
    '<user><name>王五</name><age>28</age></user>', 'c2eebc99-9c0b-4ef8-bb6d-6bb9bd380a33',
    '{"name": "王五", "projects": [{"name": "项目A", "status": "进行中"}, {"name": "项目B", "status": "已完成"}]}',
    '{"name": "王五", "education": {"university": "北京大学", "degree": "硕士"}}',
    '{100,200,300}', '{"红", "绿", "蓝"}', '[20,300)', '[2021-01-01, 2021-12-31)', 3000,
    ROW('广州路300号', '广州市', '510000')::address_type
),

-- 记录 4
(
    200, 400, 6223372036854775804, 456.78, 789.01, 0.577, 0.6180339,
    '$4,567.89', 'CHAR值4   ', '变长字符串4', '第四条记录的文本值。TEXT类型可以存储任意长度的字符串。',
    '2023-04-04', '11:30:00', '2023-04-04 11:30:00', '2023-04-04 11:30:00+08',
    '1 month', FALSE, 'happy', '(7,8)', '{10,11,12}', '((3,3),(4,4))', '<(3,3),2>',
    '192.168.2.1', '192.168.2.0/24', '00:00:5E:00:53:AF', '数组类型 可以 存储 多个 相同类型 的值',
    '<order><id>12345</id><items><item>商品1</item><item>商品2</item></items></order>', 'd3eebc99-9c0b-4ef8-bb6d-6bb9bd380a44',
    '{"name": "赵六", "contacts": [{"type": "email", "value": "zhaoliu@example.com"}, {"type": "phone", "value": "13900139000"}]}',
    '{"name": "赵六", "preferences": {"theme": "dark", "notifications": true}}',
    '{5,15,25,35,45}', '{"春", "夏", "秋", "冬"}', '[30,400)', '[2020-06-01, 2020-12-31)', 4000,
    ROW('深圳路400号', '深圳市', '518000')::address_type
),

-- 记录 5
(
    300, 500, 5223372036854775803, 567.89, 890.12, 1.732, 2.236,
    '$5,678.90', 'CHAR值5   ', '变长字符串5', '这是第五条记录的文本内容。PostgreSQL的TEXT类型非常适合存储长文本。',
    '2023-05-05', '12:45:00', '2023-05-05 12:45:00', '2023-05-05 12:45:00+08',
    '1 year 2 months', TRUE, 'sad', '(9,10)', '{13,14,15}', '((4,4),(5,5))', '<(4,4),6>',
    '10.10.10.1', '10.10.10.0/24', 'FF:FF:FF:FF:FF:FF', '范围类型 允许 存储 数值 日期 时间 的范围',
    '<product><name>产品A</name><price>99.99</price><description>这是产品A的描述</description></product>', 'e4eebc99-9c0b-4ef8-bb6d-6bb9bd380a55',
    '{"name": "孙七", "orders": [{"id": "ORD-001", "amount": 199.99}, {"id": "ORD-002", "amount": 299.99}]}',
    '{"name": "孙七", "address": {"province": "浙江省", "city": "杭州市", "street": "西湖区文三路"}}',
    '{1000,2000,3000}', '{"篮球", "足球", "乒乓球"}', '[40,500)', '[2019-01-01, 2019-12-31)', 5000,
    ROW('杭州路500号', '杭州市', '310000')::address_type
),

-- 记录 6
(
    400, 600, 4223372036854775802, 678.90, 901.23, 2.718, 3.1622,
    '$6,789.01', 'CHAR值6   ', '变长字符串6', '第六条记录的文本。这里可以包含很长的内容，比如产品描述或文章内容。',
    '2023-06-06', '13:15:00', '2023-06-06 13:15:00', '2023-06-06 13:15:00+08',
    '6 months 15 days', FALSE, 'neutral', '(11,12)', '{16,17,18}', '((5,5),(6,6))', '<(5,5),3>',
    '172.17.0.1', '172.17.0.0/16', '01:23:45:67:89:AB', 'PostgreSQL 支持 复合类型 可以 组合 多个 字段',
    '<message><sender>周八</sender><content>这是一条XML格式的消息</content><time>2023-06-06T13:15:00</time></message>', 'f5eebc99-9c0b-4ef8-bb6d-6bb9bd380a66',
    '{"name": "周八", "profile": {"bio": "数据库工程师", "years_experience": 8}}',
    '{"name": "周八", "projects": [{"name": "数据迁移", "completed": true}, {"name": "性能优化", "completed": false}]}',
    '{2,4,6,8,10}', '{"Java", "Python", "Go", "Rust"}', '[50,600)', '[2018-06-01, 2018-12-31)', 6000,
    ROW('成都路600号', '成都市', '610000')::address_type
),

-- 记录 7
(
    500, 700, 3223372036854775801, 789.01, 123.45, 3.14159, 1.4142,
    '$7,890.12', 'CHAR值7   ', '变长字符串7', '这是第七条记录的文本值。TEXT类型没有长度限制，可以存储大量文本。',
    '2023-07-07', '14:30:00', '2023-07-07 14:30:00', '2023-07-07 14:30:00+08',
    '3 weeks 2 days', TRUE, 'happy', '(13,14)', '{19,20,21}', '((6,6),(7,7))', '<(6,6),7>',
    '192.168.3.1', '192.168.3.0/24', 'DE:AD:BE:EF:12:34', 'JSONB 类型 比 JSON 类型 更高效 支持索引',
    '<config><server>db01</server><port>5432</port><user>postgres</user></config>', 'a6eebc99-9c0b-4ef8-bb6d-6bb9bd380a77',
    '{"name": "吴九", "settings": {"notifications": true, "language": "zh-CN", "timezone": "Asia/Shanghai"}}',
    '{"name": "吴九", "family": {"spouse": "李十", "children": ["小明", "小红"]}}',
    '{101,202,303,404}', '{"MySQL", "PostgreSQL", "MongoDB", "Redis"}', '[60,700)', '[2017-01-01, 2017-12-31)', 7000,
    ROW('武汉路700号', '武汉市', '430000')::address_type
),

-- 记录 8
(
    600, 800, 2223372036854775800, 890.12, 234.56, 0.5, 1.732,
    '$8,901.23', 'CHAR值8   ', '变长字符串8', '第八条记录的文本内容。可以用于存储评论、描述或其他长文本内容。',
    '2023-08-08', '15:45:00', '2023-08-08 15:45:00', '2023-08-08 15:45:00+08',
    '100 days', FALSE, 'sad', '(15,16)', '{22,23,24}', '((7,7),(8,8))', '<(7,7),4>',
    '10.20.30.1', '10.20.30.0/24', '00:11:22:33:44:55', 'UUID 类型 适合 作为 分布式系统 的 唯一标识符',
    '<article><title>PostgreSQL高级特性</title><author>郑十</author><content>这是文章内容...</content></article>', 'b7eebc99-9c0b-4ef8-bb6d-6bb9bd380a88',
    '{"name": "郑十", "stats": {"views": 1024, "likes": 512, "comments": 128}}',
    '{"name": "郑十", "metadata": {"created_at": "2023-08-08T15:45:00", "updated_at": "2023-08-08T16:30:00"}}',
    '{1111,2222,3333}', '{"HTML", "CSS", "JavaScript", "TypeScript"}', '[70,800)', '[2016-06-01, 2016-12-31)', 8000,
    ROW('西安路800号', '西安市', '710000')::address_type
),

-- 记录 9
(
    700, 900, 1223372036854775799, 901.23, 345.67, 1.618, 2.718,
    '$9,012.34', 'CHAR值9   ', '变长字符串9', '这是第九条记录的文本。TEXT类型可以存储大量的文本数据，适合存储文章、评论等。',
    '2023-09-09', '16:00:00', '2023-09-09 16:00:00', '2023-09-09 16:00:00+08',
    '9 months', TRUE, 'neutral', '(17,18)', '{25,26,27}', '((8,8),(9,9))', '<(8,8),9>',
    '172.18.0.1', '172.18.0.0/16', '66:77:88:99:AA:BB', '几何类型 可以 存储 点 线 多边形 等 空间数据',
    '<list><item>项目1</item><item>项目2</item><item>项目3</item></list>', 'c8eebc99-9c0b-4ef8-bb6d-6bb9bd380a99',
    '{"name": "钱十一", "location": {"latitude": 39.9042, "longitude": 116.4074, "city": "北京"}}',
    '{"name": "钱十一", "tags": ["数据库", "后端", "架构设计"]}',
    '{9,18,27,36,45}', '{"Docker", "Kubernetes", "Jenkins", "Git"}', '[80,900)', '[2015-01-01, 2015-12-31)', 9000,
    ROW('南京路900号', '南京市', '210000')::address_type
),

-- 记录 10
(
    800, 1000, 223372036854775798, 123.45, 456.78, 2.236, 3.606,
    '$10,123.45', 'CHAR值10  ', '变长字符串10', '第十条记录的文本内容。这是最后一条测试数据的TEXT类型字段值。',
    '2023-10-10', '17:30:00', '2023-10-10 17:30:00', '2023-10-10 17:30:00+08',
    '10 years', FALSE, 'happy', '(19,20)', '{28,29,30}', '((9,9),(10,10))', '<(9,9),5>',
    '192.168.4.1', '192.168.4.0/24', 'CC:DD:EE:FF:00:11', '网络地址类型 包括 INET CIDR MACADDR 等',
    '<response><status>success</status><code>200</code><message>操作成功</message></response>', 'd9eebc99-9c0b-4ef8-bb6d-6bb9bd380aaa',
    '{"name": "孙十二", "config": {"theme": "light", "fontSize": "medium", "showNotifications": true}}',
    '{"name": "孙十二", "history": [{"action": "login", "time": "2023-10-10T10:00:00"}, {"action": "logout", "time": "2023-10-10T17:00:00"}]}',
    '{10000,20000,30000}', '{"微信", "支付宝", "银联", "PayPal"}', '[90,1000)', '[2014-06-01, 2014-12-31)', 10000,
    ROW('重庆路1000号', '重庆市', '400000')::address_type
);