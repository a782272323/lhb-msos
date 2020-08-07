/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云服务器47.95.206.128(itoken-database-mysql-5-7-22)
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 47.95.206.128:3306
 Source Schema         : lhb-msos-db

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 07/08/2020 15:51:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL COMMENT '客户端ID',
  `resource_ids` varchar(255) DEFAULT NULL COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
  `client_secret` varchar(255) DEFAULT NULL COMMENT '客户端密匙',
  `scope` varchar(255) DEFAULT NULL COMMENT '客户端申请的权限范围',
  `authorized_grant_types` varchar(255) DEFAULT NULL COMMENT '客户端支持的grant_type',
  `web_server_redirect_uri` varchar(255) DEFAULT NULL COMMENT '重定向URI',
  `authorities` varchar(255) DEFAULT NULL COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
  `access_token_validity` int(11) DEFAULT NULL COMMENT '访问令牌有效时间值(单位:秒)',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '更新令牌有效时间值(单位:秒)',
  `additional_information` varchar(255) DEFAULT NULL COMMENT '预留字段',
  `autoapprove` varchar(255) DEFAULT NULL COMMENT '用户是否自动Approval操作',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES ('app_client', 'provider-app-user,provider-oauth2', '$2a$10$hlCHz2XevSCYweshOCQ88.5kSRRi/CSSeoBrVMOzvxGYxaH8L3E3S', 'uni-app', 'implicit,client_credentials,authorization_code,refresh_token,password', NULL, 'ROLE_USER', 43200, 604800, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('manager_client', 'provider-manager-user,provider-oauth2,,consumer-help-center', '$2a$10$05NlevF.meB4Aj2IIqiJUefeAQtZ7JIWEhwUsIQ8FSWcBQWBwcHKe', 'web-manager', 'implicit,client_credentials,authorization_code,refresh_token,password', NULL, 'ROLE_USER', 43200, 604800, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('portal_client', 'provider-portal-user,provider-oauth2,consumer-help-center', '$2a$10$H6hueDYZP/sof/tvaJPYP.TTmCLs1wZDCRKuevvJkOSxUEy1gId9G', 'web-portal', 'implicit,client_credentials,authorization_code,refresh_token,password', NULL, 'ROLE_USER', 43200, 604800, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_country_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_country_info`;
CREATE TABLE `sys_country_info` (
  `id` int(11) NOT NULL COMMENT '自增主键',
  `name` varchar(32) DEFAULT NULL COMMENT '国家名字-英文',
  `name_zh` varchar(64) DEFAULT NULL COMMENT '国家名字-中文',
  `area_code` varchar(20) DEFAULT NULL COMMENT '国家电话代码',
  `code` varchar(20) DEFAULT NULL COMMENT '代号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_manager_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_manager_permission`;
CREATE TABLE `sys_manager_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `name` varchar(32) DEFAULT NULL COMMENT '权限名-英文',
  `name_zh` varchar(64) DEFAULT NULL COMMENT '权限吗-中文',
  `status` int(1) DEFAULT NULL COMMENT '权限状态: 0-禁用，1-启用',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级权限id',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_manager_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_manager_role`;
CREATE TABLE `sys_manager_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名-英文',
  `name_zh` varchar(64) DEFAULT NULL COMMENT '角色名-中文',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(1) DEFAULT NULL COMMENT '角色状态:0-禁用，1-启用',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_manager_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_manager_role_permission`;
CREATE TABLE `sys_manager_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_manager_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_manager_user`;
CREATE TABLE `sys_manager_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(64) DEFAULT NULL COMMENT '管理网站用户真实姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `area_code` varchar(20) DEFAULT NULL COMMENT '电话区号',
  `status` int(1) DEFAULT NULL COMMENT '账户状态:0-禁用，1-启用',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名，登录系统使用',
  `sys_type` int(1) DEFAULT NULL COMMENT '系统类型，管理网站用户写死 2',
  `user_icon` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_manager_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_manager_user_role`;
CREATE TABLE `sys_manager_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL COMMENT '管理网站用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_portal_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_portal_permission`;
CREATE TABLE `sys_portal_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `name` varchar(32) DEFAULT NULL COMMENT '权限名-英文',
  `name_zh` varchar(64) DEFAULT NULL COMMENT '权限名-中文',
  `status` int(1) DEFAULT NULL COMMENT '权限状态: 0-禁用，1-启用',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级权限id',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_portal_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_portal_role`;
CREATE TABLE `sys_portal_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(32) DEFAULT NULL COMMENT '角色名-英文',
  `name_zh` varchar(64) DEFAULT NULL COMMENT '角色名-中文',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(1) DEFAULT NULL COMMENT '角色状态，0-禁用，1启用',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_portal_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_portal_role_permission`;
CREATE TABLE `sys_portal_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_portal_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_portal_user`;
CREATE TABLE `sys_portal_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(64) DEFAULT NULL COMMENT '平台用户昵称',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `area_code` varchar(20) DEFAULT NULL COMMENT '电话地区码',
  `user_type` int(1) DEFAULT NULL COMMENT '用户类型: 0-网站注册，1-微信登录，2-qq登录，3-新浪登录，4-github登录',
  `sys_type` int(1) DEFAULT NULL COMMENT '系统类型，写死为 1',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `status` int(1) DEFAULT NULL COMMENT '账户状态, 0-禁用，1-开启',
  `user_number` varchar(40) DEFAULT NULL COMMENT '门户网站用户编号，生成规则暂定为：PU+年月日+四位递增书',
  `user_icon` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_portal_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_portal_user_role`;
CREATE TABLE `sys_portal_user_role` (
  `id` int(11) NOT NULL COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `created` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `updated` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_province_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_province_info`;
CREATE TABLE `sys_province_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(32) DEFAULT NULL COMMENT '省份名字-拼音',
  `name_zh` varchar(64) DEFAULT NULL COMMENT '省份名字-英文',
  `code` varchar(20) DEFAULT NULL COMMENT '代号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
