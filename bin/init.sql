-- 本地
-- mysql -uroot -proot -P3306 -Dbook --default-character-set=utf8

CREATE database if NOT EXISTS book;

CREATE TABLE IF NOT EXISTS user(
    userId INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
    email VARCHAR(200) COMMENT '用户email',
    password VARCHAR(200) COMMENT '密码',
    userIdentity int COMMENT '用户身份',
    groupId int COMMENT '用户分组',
    userName VARCHAR(50) COMMENT '用户姓名',
    sex int COMMENT '性别',
    jobNumber int COMMENT '用户工号',
    telephoneNumber int COMMENT '电话号码',
    introduce varchar(200) COMMENT '介绍'
    ) COMMENT '用户表';

CREATE TABLE IF NOT EXISTS userGroup(
    groupId INT PRIMARY KEY AUTO_INCREMENT COMMENT '分组id',
    groupName VARCHAR(200) COMMENT '分组名字',
    groupLeaderId int COMMENT '组长id',
    groupLeaderName VARCHAR(200) COMMENT '组长姓名',
    groupPeopleNumber int COMMENT '分组人数'
    introduce varchar(200) COMMENT '介绍'
    ) COMMENT '用户表';