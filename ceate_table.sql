drop table if exists st_user;
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

drop table if exists admin;
create table admin
(
    aid    int auto_increment comment '管理员id'
        primary key,
    aname  varchar(255) not null comment '管理员名字，登录名',
    apsswd varchar(255) null comment '管理员登录密码',
    constraint aname
        unique (aname)
);

drop table if exists appointment_record;
create table appointment_record
(
    uid      int      not null comment '预约用户的id',
    rid      int      not null comment '预约机房的id',
    arstatus int      not null comment '预约状态：
0： cid!=null,预约成功，等待使用
1： cid!=null,机位正在使用
2;  cid!=null,机位使用结束
3:  rid!=null,机房预约中
4:  rid!=null,机房预约成功
5:  rid!=null,机房预约被拒绝
6:  rid!=null,机房使用中
7:  rid!=null,机房使用结束',
    reqdate  datetime not null comment '预约请求时间'
        primary key,
    dealdate datetime null comment '预约处理时间',
    artype   int      null comment '预约类型：
0：预约机房需处理
1：表示预约机位无需处理',
    cid      int      null comment '机位id，当预约记录类型是机房则该项为null',
    info     varchar(255) null comment '申请理由'
);

drop table if exists computer;
create table computer
(
    cid     int unsigned auto_increment comment '机位id'
        primary key,
    rid     int null comment '该机子所在机房id',
    cstatus int null comment '机子状态：
1：可预约
0：不可预约'
);

drop table if exists computer_room;
create table computer_room
(
    rid     int auto_increment comment '机房id'
        primary key,
    rstatus int null comment '机房状态：
3：机房空闲
2：可预约机位
1：不可预约'
);

drop table if exists usage_record;
create table usage_record
(
    uid int not null comment '用户id',
    cid int null comment '电脑id',
    rid int null comment '机房id',
    start_time datetime null comment '开始上机时间',
    end_time datetime null comment '结束上机时间',
    status int(1) null comment '状态
0：正在使用
1：暂停使用
2：结束使用，待结算
3：费用已结清',
    cost double null comment '上机花费',
    id int auto_increment comment 'id'
        primary key,
    reqdate datetime null
);