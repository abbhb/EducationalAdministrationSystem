/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 25/03/2023 17:00:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for klass
-- ----------------------------
DROP TABLE IF EXISTS `klass`;
CREATE TABLE `klass`  (
  `klass_id` int NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `klass_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级名',
  `professional_id` int NOT NULL COMMENT '专业Id',
  PRIMARY KEY (`klass_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_college
-- ----------------------------
DROP TABLE IF EXISTS `t_college`;
CREATE TABLE `t_college`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '//学院id',
  `college_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '//学院名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'course_id',
  `course_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名',
  `course_teacher_id` int NOT NULL,
  `credits` double(4, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `course_teacher_id`(`course_teacher_id` ASC) USING BTREE,
  CONSTRAINT `course_teacher_id` FOREIGN KEY (`course_teacher_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_courseinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_courseinfo`;
CREATE TABLE `t_courseinfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL COMMENT '对应course表的id',
  `week` int NOT NULL,
  `weekday` int NOT NULL,
  `length` int NOT NULL COMMENT '持续长度',
  `begin` int NOT NULL,
  `classroom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地点',
  `klass` int NOT NULL COMMENT 'classid',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_professional
-- ----------------------------
DROP TABLE IF EXISTS `t_professional`;
CREATE TABLE `t_professional`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '//专业id',
  `professional_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '//专业name',
  `professional_college_id` int NOT NULL COMMENT '//学院id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `sid` int NOT NULL AUTO_INCREMENT,
  `klass_id` int NOT NULL COMMENT '学生所在班级，直接查班级的课',
  `credits` double(10, 2) NOT NULL COMMENT '学分',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `tid` int NOT NULL COMMENT 'teacherid',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `register_time` datetime(6) NULL DEFAULT NULL COMMENT '注册时间',
  `last_modification_time` datetime(6) NOT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '最后修改时间',
  `dept` int NOT NULL COMMENT '所属权限组',
  `userphoto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像url',
  `gender` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `safe` int(1) UNSIGNED ZEROFILL NOT NULL COMMENT '是否安全,0为安全,1为标记异常,2为封禁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
