-- 创建数据库
CREATE DATABASE bookmanage;
-- 使用数据库
use bookmanage;

DROP TABLE IF EXISTS t_book;
-- 创建书籍信息表
CREATE TABLE t_book(
  `book_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '书籍id',
  `book_name` VARCHAR(100) NOT NULL COMMENT '书籍名称',
  `book_author` VARCHAR(50) NOT NULL COMMENT '作者',
  `book_publisher` VARCHAR(100) NOT NULL COMMENT '出版社',
  `book_status` INT NOT NULL DEFAULT 0 COMMENT '状态',
  `book_category` BIGINT NOT NULL COMMENT '所属书目',
  `book_price` DECIMAL DEFAULT NULL COMMENT '价格',
  `book_description` VARCHAR(1000) DEFAULT NULL COMMENT '简介',
  `create_date` TIMESTAMP NOT NULL DEFAULT COMMENT '创建时间',
  PRIMARY KEY (book_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT ='书籍信息表';

DROP TABLE IF EXISTS t_admin;
-- 创建管理员信息表
CREATE TABLE t_admin(
  `admin_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` VARCHAR(50) NOT NULL COMMENT '管理员名称',
  `admin_password` VARCHAR(100) NOT NULL COMMENT '密码',
  `admin_email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (admin_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT ='管理员信息表';

DROP TABLE IF EXISTS t_reader;
-- 创建用户信息表
CREATE TABLE t_reader(
  `user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
  `user_password` VARCHAR(100) NOT NULL COMMENT '密码',
  `user_email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  `user_status` VARCHAR(50) DEFAULT 0 COMMENT '用户状态：0-正常，1-注销',
  `create_date` TIMESTAMP NOT NULL DEFAULT COMMENT '创建时间',
  PRIMARY KEY (user_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT ='用户信息表';

DROP TABLE IF EXISTS t_category;
-- 创建书目表
CREATE TABLE t_category(
  `cate_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '书目id',
  `cate_name` VARCHAR(50) NOT NULL COMMENT '书目名称',
  PRIMARY KEY (cate_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT ='书目表';

DROP TABLE IF EXISTS t_borrow_history;
-- 创建借阅记录表
CREATE TABLE t_borrow_history(
  `borrow_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '书目id',
  `user_id` VARCHAR(50) NOT NULL COMMENT '书目名称',
  `book_id` VARCHAR(50) NOT NULL COMMENT '书目名称',
  `borrow_status` VARCHAR(50) NOT NULL COMMENT '书目名称',
  `borrow_date` TIMESTAMP NOT NULL DEFAULT COMMENT '创建时间',
  `return_date` TIMESTAMP DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (borrow_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT ='借阅记录表';

-- 数据库连接控制台
mysql -uroot -p root