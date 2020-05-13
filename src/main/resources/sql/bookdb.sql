/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : bookdb

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-05-13 20:19:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_book`
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `book_id` bigint NOT NULL AUTO_INCREMENT COMMENT '书籍id',
  `book_name` varchar(100) NOT NULL COMMENT '书籍名称',
  `book_author` varchar(50) NOT NULL COMMENT '作者',
  `book_publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `book_status` int DEFAULT '0' COMMENT '状态',
  `book_category` bigint DEFAULT NULL COMMENT '所属书目',
  `book_price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `book_description` varchar(1000) DEFAULT NULL COMMENT '简介',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8 COMMENT='书籍信息表';

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1000', '天下无贼', '匿名', '海南出版社', '0', '1000', '20', null, '2020-05-12 18:21:41');
INSERT INTO `t_book` VALUES ('1001', 'SpringBoot实战', 'Craig Walls', '人民邮电出版社', '0', '1000', '59', null, '2020-05-12 18:22:20');
INSERT INTO `t_book` VALUES ('1002', 'Spring实战（第4版）', 'Craig Walls', '人民邮电出版社', '0', '1000', '89', '用云计算丈量世界', '2020-05-12 18:22:41');
INSERT INTO `t_book` VALUES ('1003', 'Spring Cloud与Docker微服务架构实战', '周立', '电子工业出版社', '0', '1002', '79', null, '2020-05-12 18:23:41');
INSERT INTO `t_book` VALUES ('1004', '阿里巴巴创业之路', '马老师', '阿里出版社', '0', '1000', '100', '用云计算丈量世界', '2020-05-12 21:18:30');

-- ----------------------------
-- Table structure for `t_borrow_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_borrow_history`;
CREATE TABLE `t_borrow_history` (
  `borrow_id` bigint NOT NULL AUTO_INCREMENT COMMENT '借还id',
  `user_id` varchar(50) NOT NULL COMMENT '用户id',
  `book_id` varchar(50) NOT NULL COMMENT '书籍id',
  `borrow_status` int NOT NULL COMMENT '状态：1-在借，0-已还',
  `borrow_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '借书时间',
  `return_date` timestamp NULL DEFAULT NULL COMMENT '还书时间',
  PRIMARY KEY (`borrow_id`),
  UNIQUE KEY `pk_userid_bookid` (`user_id`,`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8 COMMENT='借阅记录表';

-- ----------------------------
-- Records of t_borrow_history
-- ----------------------------
INSERT INTO `t_borrow_history` VALUES ('1000', '1000', '1000', '0', '2020-05-13 14:19:31', '2020-05-13 14:57:45');

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `cate_id` bigint NOT NULL AUTO_INCREMENT COMMENT '书目id',
  `cate_name` varchar(50) NOT NULL COMMENT '书目名称',
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8 COMMENT='书目表';

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1000', '商业');
INSERT INTO `t_category` VALUES ('1001', '小说');
INSERT INTO `t_category` VALUES ('1002', '情感');

-- ----------------------------
-- Table structure for `t_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `t_permissions`;
CREATE TABLE `t_permissions` (
  `id` int NOT NULL DEFAULT '0' COMMENT '自定id,主要供前端展示权限列表分类排序使用.',
  `menu_code` varchar(255) DEFAULT '' COMMENT '归属菜单,前端判断并展示菜单使用,',
  `menu_name` varchar(255) DEFAULT '' COMMENT '菜单的中文释义',
  `permission_code` varchar(255) DEFAULT '' COMMENT '权限的代码/通配符,对应代码中@RequiresPermissions 的value',
  `permission_name` varchar(255) DEFAULT '' COMMENT '本权限的中文释义',
  `required_permission` tinyint(1) DEFAULT '2' COMMENT '是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='后台权限表';

-- ----------------------------
-- Records of t_permissions
-- ----------------------------
INSERT INTO `t_permissions` VALUES ('1000', 'book', '图书管理', 'book:list', '图书列表', '1');
INSERT INTO `t_permissions` VALUES ('1001', 'book', '图书管理', 'book:add', '新增', '2');
INSERT INTO `t_permissions` VALUES ('1002', 'book', '图书管理', 'book:update', '修改', '2');
INSERT INTO `t_permissions` VALUES ('1003', 'book', '图书管理', 'book:delete', '删除', '2');
INSERT INTO `t_permissions` VALUES ('2001', 'user', '用户管理', 'user:list', '用户列表', '1');
INSERT INTO `t_permissions` VALUES ('2002', 'user', '用户管理', 'user:add', '新增', '2');
INSERT INTO `t_permissions` VALUES ('2003', 'user', '用户管理', 'user:update', '修改', '2');
INSERT INTO `t_permissions` VALUES ('2004', 'user', '用户管理', 'user:delete', '删除', '2');
INSERT INTO `t_permissions` VALUES ('3001', 'role', '角色权限', 'role:list', '权限列表', '1');
INSERT INTO `t_permissions` VALUES ('3002', 'role', '角色权限', 'role:add', '新增', '2');
INSERT INTO `t_permissions` VALUES ('3003', 'role', '角色权限', 'role:update', '修改', '2');
INSERT INTO `t_permissions` VALUES ('3004', 'role', '角色权限', 'role:delete', '删除', '2');
INSERT INTO `t_permissions` VALUES ('4001', 'borrow', '借书管理', 'borrow:list', '列表', '1');
INSERT INTO `t_permissions` VALUES ('4002', 'borrow', '借书管理', 'borrow:add', '借书', '2');
INSERT INTO `t_permissions` VALUES ('4003', 'borrow', '借书管理', 'borrow:update', '还书', '2');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效  1有效  2无效',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100002 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('100000', '管理员', '2020-05-13 01:31:30', '2020-05-13 01:32:10', '0');
INSERT INTO `t_role` VALUES ('100001', '读者', '2020-05-13 01:31:41', '2020-05-13 01:32:09', '0');

-- ----------------------------
-- Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL COMMENT '角色id',
  `permission_id` int DEFAULT NULL COMMENT '权限id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_status` varchar(1) DEFAULT '1' COMMENT '是否有效 0有效，1无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='角色-权限关联表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('100', '100000', '1000', '2020-05-13 01:43:33', '2020-05-13 01:43:33', '1');
INSERT INTO `t_role_permission` VALUES ('101', '100000', '1001', '2020-05-13 01:43:49', '2020-05-13 01:43:49', '1');
INSERT INTO `t_role_permission` VALUES ('102', '100000', '1002', '2020-05-13 01:44:17', '2020-05-13 01:44:17', '1');
INSERT INTO `t_role_permission` VALUES ('103', '100000', '1003', '2020-05-13 01:44:27', '2020-05-13 01:44:27', '1');
INSERT INTO `t_role_permission` VALUES ('104', '100000', '2001', '2020-05-13 01:44:35', '2020-05-13 01:44:54', '1');
INSERT INTO `t_role_permission` VALUES ('105', '100000', '2002', '2020-05-13 01:44:49', '2020-05-13 01:44:57', '1');
INSERT INTO `t_role_permission` VALUES ('106', '100000', '2003', '2020-05-13 01:45:04', '2020-05-13 01:45:04', '1');
INSERT INTO `t_role_permission` VALUES ('107', '100000', '2004', '2020-05-13 01:45:11', '2020-05-13 01:45:11', '1');
INSERT INTO `t_role_permission` VALUES ('108', '100000', '3001', '2020-05-13 01:45:25', '2020-05-13 01:45:25', '1');
INSERT INTO `t_role_permission` VALUES ('109', '100000', '3002', '2020-05-13 01:45:35', '2020-05-13 01:45:35', '1');
INSERT INTO `t_role_permission` VALUES ('110', '100000', '3003', '2020-05-13 01:45:43', '2020-05-13 01:45:43', '1');
INSERT INTO `t_role_permission` VALUES ('111', '100000', '3004', '2020-05-13 01:45:52', '2020-05-13 01:45:52', '1');
INSERT INTO `t_role_permission` VALUES ('112', '100001', '1000', '2020-05-13 01:46:41', '2020-05-13 01:46:41', '1');
INSERT INTO `t_role_permission` VALUES ('115', '100001', '2003', '2020-05-13 01:51:19', '2020-05-13 01:51:19', '1');
INSERT INTO `t_role_permission` VALUES ('116', '100000', '4001', '2020-05-13 14:06:43', '2020-05-13 14:06:43', '1');
INSERT INTO `t_role_permission` VALUES ('117', '100000', '4002', '2020-05-13 14:06:56', '2020-05-13 14:06:56', '1');
INSERT INTO `t_role_permission` VALUES ('118', '100000', '4003', '2020-05-13 14:07:09', '2020-05-13 14:07:09', '1');
INSERT INTO `t_role_permission` VALUES ('119', '100001', '4001', '2020-05-13 14:08:09', '2020-05-13 14:08:09', '1');
INSERT INTO `t_role_permission` VALUES ('120', '100001', '4002', '2020-05-13 14:08:15', '2020-05-13 14:08:15', '1');
INSERT INTO `t_role_permission` VALUES ('121', '100001', '4003', '2020-05-13 14:08:23', '2020-05-13 14:08:23', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `user_password` varchar(100) NOT NULL COMMENT '密码',
  `user_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `role_id` int DEFAULT '0' COMMENT '角色ID',
  `user_status` varchar(50) DEFAULT '0' COMMENT '用户状态：0-正常，1-注销',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pwd_random` varchar(100) DEFAULT '' COMMENT '加密随机数',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1000', 'jason', '1f89cb2f1c117be90250f661b481fac2', 'jason@qq.com', '100001', '0', '2020-05-12 11:08:22', 'amFzb24=');
INSERT INTO `t_user` VALUES ('1001', 'admin', '9aa75c4d70930277f59d117ce19188b0', null, '100000', '0', '2020-05-13 01:54:46', 'YWRtaW4=');
INSERT INTO `t_user` VALUES ('1002', 'zhangsan', 'b51ae3e5279bc66eae7a4fe2600ab0b1', 'zhangsan@qq.com', '100001', '0', '2020-05-13 12:07:42', 'emhhbmdzYW4=');
INSERT INTO `t_user` VALUES ('1003', 'xidd', '026221143de8057011f59554fbde594b', 'zhangsan@qq.com', '100001', '0', '2020-05-13 12:11:33', 'eGlkZA==');
