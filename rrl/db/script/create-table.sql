DROP TABLE RRL_REQ_LOG;
CREATE TABLE RRL_REQ_LOG(
    ID BIGINT UNSIGNED NOT NULL   COMMENT 'ID' ,
    METHOD VARCHAR(10) NOT NULL   COMMENT '请求方法' ,
    URI VARCHAR(512) NOT NULL   COMMENT '请求地址' ,
    HEADERS VARCHAR(3076)    COMMENT '请求头' ,
    CONTENT_TYPE VARCHAR(30)    COMMENT '内容类型' ,
    QUERY_PARAMS VARCHAR(2048)    COMMENT '请求查询参数' ,
    BODY VARCHAR(2048)    COMMENT '请求主体' ,
    PRIMARY KEY (ID)
) COMMENT = '请求日志 ';

ALTER TABLE RRL_REQ_LOG COMMENT '请求日志';
DROP TABLE RRL_RESP_LOG;
CREATE TABLE RRL_RESP_LOG(
    ID BIGINT UNSIGNED NOT NULL   COMMENT 'ID' ,
    STATUS_CODE TINYINT(3) NOT NULL   COMMENT '响应状态码' ,
    HEADERS VARCHAR(3076) NOT NULL   COMMENT '响应头部' ,
    PRIMARY KEY (ID)
) COMMENT = '响应日志 ';

ALTER TABLE RRL_RESP_LOG COMMENT '响应日志';
DROP TABLE RRL_FILTER;
CREATE TABLE RRL_FILTER(
    ID BIGINT UNSIGNED NOT NULL   COMMENT 'ID' ,
    METHOD VARCHAR(10) NOT NULL   COMMENT '请求方法' ,
    URI VARCHAR(512) NOT NULL   COMMENT '请求地址' ,
    PRIMARY KEY (ID)
) COMMENT = '过滤器 只在过滤器中匹配的请求才进行记录';

ALTER TABLE RRL_FILTER COMMENT '过滤器';
