create table if not exists sys_user
(
    user_id                varchar(64) primary key comment '主键',
    username               varchar(20)  not null unique comment '用户名',
    password               varchar(100) not null comment '用户密码',
    enabled                varchar(2)   not null comment '是否启用账号',
    account_no_expired     varchar(2)   not null comment '账号是否过期',
    account_no_locked      varchar(2)   not null comment '账号是否锁定',
    credentials_no_expired varchar(2)   not null comment '凭证是否过期'
);

create table if not exists sys_role
(
    role_id          varchar(64) primary key comment '主键',
    role_name        varchar(20) not null unique comment '权限名称',
    role_description varchar(50) comment '权限说明'
);

create table if not exists sys_user_role_relation
(
    user_role_relation_id varchar(64) primary key comment '主键',
    user_id               varchar(64) not null comment '用户id',
    role_id               varchar(64) not null comment '权限id'
);
