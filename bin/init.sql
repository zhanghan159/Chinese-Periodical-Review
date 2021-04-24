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
    ) COMMENT '分组表';

CREATE TABLE `periodical` (
  `periodicalId` int(11) NOT NULL AUTO_INCREMENT COMMENT '期刊id',
  `periodicalName` varchar(200) DEFAULT NULL COMMENT '期刊名字',
  `groupId` int(11) DEFAULT NULL COMMENT '分配分组Id',
  `periodicalType` int(11) DEFAULT NULL COMMENT '期刊类别',
  `periodicalStatus` int(11) DEFAULT NULL COMMENT '期刊状态',
  `fm` int(11) DEFAULT NULL COMMENT '期刊格式内容是否达标',
  `ct` int(11) DEFAULT NULL COMMENT '期刊内容是否符合主题',
  `ol` int(11) DEFAULT NULL COMMENT '期刊内容是否原创',
  `score` int(11) DEFAULT NULL COMMENT '期刊评分',
  `evaluate` varchar(200) DEFAULT NULL COMMENT '评价',
  `censorshipTime` datetime DEFAULT NULL COMMENT '送审时间',
  `userId` int(11) DEFAULT NULL COMMENT '审核员id',
  `userName` varchar(50) DEFAULT NULL COMMENT '审核员姓名',
  `operateTime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`periodicalId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='期刊审核表'