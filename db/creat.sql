CREATE TABLE `weibo` (
    `id`   INT UNSIGNED AUTO_INCREMENT COMMENT '主键',
    `content` TEXT NOT NULL COMMENT '内容',
    `time` DATETIME NOT NULL COMMENT '时间戳',
    PRIMARY KEY (`id`)
) COMMENT '微博表';

CREATE TABLE `user` (
    `id`   INT UNSIGNED AUTO_INCREMENT COMMENT '主键',
    `name` VARCHAR(100) NOT NULL COMMENT '用户名',
    `password` VARCHAR(100) NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
) COMMENT '用户表';