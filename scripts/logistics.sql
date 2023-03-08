drop database if exists logistics;

create database logistics;

use logistics;

drop table if exists province_info;
create table province_info
(
    `id`        int                                                           not null auto_increment comment '编号',
    `name`      varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '省名',
    `longitude` double                                                        not null comment '经度',
    `latitude`  double                                                        not null comment '纬度',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '省信息表'
    row_format = dynamic;

drop table if exists city_info;
create table city_info
(
    `id`        int                                                           not null auto_increment comment '编号',
    `name`      varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '市名',
    `longitude` double                                                        not null comment '经度',
    `latitude`  double                                                        not null comment '纬度',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '市信息表'
    row_format = dynamic;

drop table if exists route_info;
create table route_info
(
    `id`            int    not null auto_increment comment '编号',
    `city_start_id` int    not null comment '出发地编号',
    `city_end_id`   int    not null comment '目的地编号',
    `distance`      double not null comment '距离',
    `duration`      long   not null comment '预计时间(s)',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '路线信息表'
    row_format = dynamic;

drop table if exists order_info;
create table order_info
(
    `id`            int                                                            not null auto_increment comment '编号',
    `city_start_id` int                                                            not null comment '发货地',
    `city_end_id`   int                                                            not null comment '收货地',
    `consignee`     varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci  not null comment '收货人',
    `phone`         varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci  not null comment '电话',
    `time`          datetime                                                       not null comment '时间',
    `status`        int                                                            not null comment '状态',
    `comment`       varchar(1024) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '备注',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '订单信息表'
    row_format = dynamic;

drop table if exists car_info;
create table car_info
(
    `id`     int                                                           not null auto_increment comment '编号',
    `car_id` varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '车牌号',
    `status` int                                                           not null default 1 comment '状态',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '车辆信息表'
    row_format = dynamic;

drop table if exists driver_info;
create table driver_info
(
    `id`     int                                                           not null auto_increment comment '编号',
    `name`   varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '姓名',
    `status` int                                                           not null default 1 comment '状态',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '司机信息表'
    row_format = dynamic;


drop table if exists freight_meth;
create table freight_meth
(
    `id`     int                                                           not null auto_increment comment '编号',
    `method` varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '方法',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '货运方式表'
    row_format = dynamic;

drop table if exists goods_status;
create table goods_status
(
    `id`     int                                                           not null auto_increment comment '编号',
    `status` varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '状态',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '货物状态表'
    row_format = dynamic;

drop table if exists goods_type;
create table goods_type
(
    `id`   int                                                           not null auto_increment comment '编号',
    `type` varchar(255) character set utf8mb4 collate utf8mb4_0900_ai_ci not null comment '类型',
    primary key (`id`)
)
    engine = InnoDB
    auto_increment = 1000
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '货物类型表'
    row_format = dynamic;

drop table if exists pro_city;
create table pro_city
(
    `pro_id`  int not null comment '省编号',
    `city_id` int not null comment '市编号',
    primary key (pro_id, city_id),
    foreign key (pro_id) references province_info (id),
    foreign key (city_id) references city_info (id)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '省市关系表'
    row_format = dynamic;

drop table if exists route_order;
create table route_order
(
    `route_id` int not null comment '线路编号',
    `order_id` int not null comment '订单编号',
    primary key (`route_id`, `order_id`),
    foreign key (`route_id`) references route_info (`id`),
    foreign key (`order_id`) references order_info (`id`)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '路线订单关系表'
    row_format = dynamic;

drop table if exists order_freight_meth;
create table order_freight_meth
(
    `order_id`        int not null comment '订单编号',
    `freight_meth_id` int not null comment '货运方式编号',
    primary key (`order_id`, `freight_meth_id`),
    foreign key (`order_id`) references order_info (`id`),
    foreign key (`freight_meth_id`) references freight_meth (id)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '订单货运方式关系表'
    row_format = dynamic;

drop table if exists order_goods_status;
create table order_goods_status
(
    `order_id`        int not null comment '订单编号',
    `goods_status_id` int not null comment '货物状态编号',
    primary key (`order_id`, `goods_status_id`),
    foreign key (`order_id`) references order_info (`id`),
    foreign key (`goods_status_id`) references goods_status (`id`)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '订单货运状态关系表'
    row_format = dynamic;

drop table if exists order_goods_type;
create table order_goods_type
(
    `order_id`      int not null comment '订单编号',
    `goods_type_id` int not null comment '货物类型编号',
    primary key (`order_id`, `goods_type_id`),
    foreign key (`order_id`) references order_info (`id`),
    foreign key (`goods_type_id`) references goods_type (`id`)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '订单货运类型关系表'
    row_format = dynamic;

drop table if exists car_driver;
create table car_driver
(
    `car_id`    int not null comment '车辆编号',
    `driver_id` int not null comment '司机编号',
    primary key (`car_id`, `driver_id`),
    foreign key (`car_id`) references car_info (`id`),
    foreign key (`driver_id`) references driver_info (`id`)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '订单货运类型关系表'
    row_format = dynamic;