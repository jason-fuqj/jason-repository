-- 创建数据库
CREATE DATABASE bookdb;
-- 使用数据库
use bookdb;

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
  `create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (book_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT ='书籍信息表';

DROP TABLE IF EXISTS t_role;
-- 创建管理员信息表
CREATE TABLE t_role(
  `role_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` VARCHAR(50) NOT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (role_id)
)ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET = utf8 COMMENT ='角色信息表';

DROP TABLE IF EXISTS t_permissions;

CREATE TABLE `t_permissions` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台权限表';

DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '0' COMMENT '是否有效 0有效，1无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

DROP TABLE IF EXISTS t_user;
-- 创建用户信息表
CREATE TABLE t_user(
  `user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
  `user_password` VARCHAR(100) NOT NULL COMMENT '密码',
  `user_email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  `role_id` int(11) DEFAULT '0' COMMENT '角色ID',
  `user_status` VARCHAR(1) DEFAULT '0' COMMENT '用户状态：0-正常，1-注销',
  `create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
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
  `borrow_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '借还id',
  `user_id` VARCHAR(50) NOT NULL COMMENT '用户id',
  `book_id` VARCHAR(50) NOT NULL COMMENT '书籍id',
  `borrow_status` VARCHAR(50) NOT NULL COMMENT '借还状态 1-在借  0-已还',
  `borrow_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '借书时间',
  `return_date` TIMESTAMP COMMENT '还书时间',
  PRIMARY KEY (borrow_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT ='借阅记录表';

-- 数据库连接控制台
mysql -uroot -p root