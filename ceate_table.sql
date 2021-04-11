drop table st_user;
create table st_user
(
    uid      int unsigned auto_increment comment '用户id'
        primary key,
    uname    varchar(255) not null comment '用户名，同时也是唯一登录凭证',
    upsswd   varchar(255) null comment '用户登录密码',
    uprofile varchar(255) null comment '用户个人简介',
    constraint uname
        unique (uname)
);

drop table admin;
create table admin
(
    aid    int auto_increment comment '管理员id'
        primary key,
    aname  varchar(255) not null comment '管理员名字，登录名',
    apsswd varchar(255) null comment '管理员登录密码',
    constraint aname
        unique (aname)
);

drop table appointment_record;
create table appointment_record
(
    uid      int      not null comment '预约用户的id',
    rid      int      not null comment '预约机房的id',
    arstatus int      not null comment '预约状态，0表示预约中，1表示已同意，-1表示已拒绝',
    reqdate  datetime not null comment '预约请求时间'
        primary key,
    dealdate datetime null comment '预约处理时间',
    artype   int      null comment '预约类型，0表示预约机房需处理，1表示预约机位无需处理',
    cid      int      null comment '机位id，当预约记录类型是机房则该项为null'
);

drop table computer;
create table computer
(
    cid     int unsigned auto_increment comment '机位id'
        primary key,
    rid     int null comment '该机子所在机房id',
    cstatus int null comment '机子状态1表示可预约，0表示正在使用'
);

drop table computer_room;
create table computer_room
(
    rid     int auto_increment comment '机房id'
        primary key,
    rstatus int null comment '机房状态，1表示可预约，0表示正在预约，-1表示正在使用'
);

drop table usage_record;
create table usage_record
(
    uid int not null comment '用户id
'
        primary key,
    cid int null comment '电脑id',
    rid int null comment '机房id',
    start_time date null comment '开始上机时间',
    end_time date null comment '结束上机时间',
    status int(1) null comment '状态
0：正在使用
1：暂停使用
2：结束使用，待结算
3：费用已结清',
    cost double null comment '上机花费'
);