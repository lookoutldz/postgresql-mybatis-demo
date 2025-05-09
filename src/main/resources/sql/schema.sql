-- 创建枚举类型
CREATE TYPE mood AS ENUM ('happy', 'sad', 'neutral');

-- 创建复合类型
CREATE TYPE address_type AS (
    street VARCHAR(100),
    city VARCHAR(50),
    postal_code VARCHAR(20)
);

-- 创建包含多种 PostgreSQL 数据类型的表
CREATE TABLE IF NOT EXISTS pg_type_demo (
    -- 数值类型
    id BIGSERIAL PRIMARY KEY,
    int_value INTEGER,
    smallint_value SMALLINT,
    bigint_value BIGINT,
    decimal_value DECIMAL(10, 2),
    numeric_value NUMERIC(10, 2),
    real_value REAL,
    double_value DOUBLE PRECISION,
    
    -- 货币类型
    money_value MONEY,
    
    -- 字符类型
    char_value CHAR(10),
    varchar_value VARCHAR(255),
    text_value TEXT,
    
    -- 日期/时间类型
    date_value DATE,
    time_value TIME,
    timestamp_value TIMESTAMP,
    timestamptz_value TIMESTAMPTZ,
    interval_value INTERVAL,
    
    -- 布尔类型
    boolean_value BOOLEAN,
    
    -- 枚举类型
    mood_value mood,
    
    -- 几何类型
    point_value POINT,
    line_value LINE,
    box_value BOX,
    circle_value CIRCLE,
    
    -- 网络地址类型
    inet_value INET,
    cidr_value CIDR,
    macaddr_value MACADDR,
    
    -- 文本搜索类型
    tsvector_value TSVECTOR,
    
    -- XML 类型
    xml_value XML,
    
    -- UUID 类型
    uuid_value UUID,
    
    -- JSON 类型
    json_value JSON,
    jsonb_value JSONB,
    
    -- 数组类型
    int_array INTEGER[],
    text_array TEXT[],
    
    -- 范围类型
    int_range INT4RANGE,
    timestamp_range TSRANGE,
    
    -- 对象标识符类型
    oid_value OID,
    
    -- 复合类型
    address_value address_type,
    
    -- 创建和更新时间
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 创建索引
CREATE INDEX IF NOT EXISTS idx_pg_type_demo_varchar ON pg_type_demo(varchar_value);
CREATE INDEX IF NOT EXISTS idx_pg_type_demo_created_at ON pg_type_demo(created_at);