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

insert into province_info(`name`, `longitude`, `latitude`)
values ('安徽省', 117.330139, 31.734559),
       ('河南省', 113.753094, 34.767052);

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

drop table if exists country_log_info;
create table country_log_info
(
    `id`                      int    not null auto_increment comment '编号',
    `year`                    int    not null comment '年份',
    `log_volume`              double not null default 0.0 comment '物流量',
    `log_income`              double not null default 0.0 comment '物流收入',
    `ind_scale`               double not null default 0.0 comment '行业规模',
    `ind_activity`            double not null default 0.0 comment '行业活跃度',
    `l_tran_volume`           double not null default 0.0 comment '陆运总量',
    `w_tran_volume`           double not null default 0.0 comment '水运总量',
    `a_tran_volume`           double not null default 0.0 comment '空运总量',
    `local_op_volume`         double not null default 0.0 comment '同城快递量',
    `remote_op_volume`        double not null default 0.0 comment '异地快递量',
    `international_op_volume` double not null default 0.0 comment '国际快递量',
    `e_log_volume`            double not null default 0.0 comment '东部物流量',
    `m_log_volume`            double not null default 0.0 comment '中部物流量',
    `w_log_volume`            double not null default 0.0 comment '西部物流量',
    `e_log_income`            double not null default 0.0 comment '东部物流收入',
    `m_log_income`            double not null default 0.0 comment '中部物流收入',
    `w_log_income`            double not null default 0.0 comment '西部物流收入',
    primary key (`id`),
    unique key (`year`)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '国家物流信息表'
    row_format = dynamic;

insert into country_log_info(`year`, `log_volume`, `ind_scale`,
                             `l_tran_volume`, `w_tran_volume`, `a_tran_volume`,
                             `log_income`, `ind_activity`, `local_op_volume`,
                             `remote_op_volume`, `international_op_volume`, `e_log_volume`,
                             `m_log_volume`, `w_log_volume`, `e_log_income`,
                             `m_log_income`, `w_log_income`)
values (2013, 918674.89, 2013, 2013, 2013, 2013, 2013, 2013, 2013, 2013, 2013, 2013, 2013, 2013, 2013, 2013, 2013),
       (2014, 1395925.30, 2014, 2014, 2014, 2014, 2014, 2014, 2014, 2014, 2014, 2014, 2014, 2014, 2014, 2014, 2014),
       (2015, 2066636.84, 2015, 2015, 2015, 2015, 2015, 2015, 2015, 2015, 2015, 2015, 2015, 2015, 2015, 2015, 2015),
       (2016, 3128315.11, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016),
       (2017, 4005591.91, 2017, 2017, 2017, 2017, 2017, 2017, 2017, 2017, 2017, 2017, 2017, 2017, 2017, 2017, 2017),
       (2018, 5071042.80, 2018, 2018, 2018, 2018, 2018, 2018, 2018, 2018, 2018, 2018, 2018, 2018, 2018, 2018, 2018),
       (2019, 6352290.97, 2019, 2019, 2019, 2019, 2019, 2019, 2019, 2019, 2019, 2019, 2019, 2019, 2019, 2019, 2019),
       (2020, 8335789.43, 2020, 2020, 2020, 2020, 2020, 2020, 2020, 2020, 2020, 2020, 2020, 2020, 2020, 2020, 2020),
       (2021, 10829641.32, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021);

drop table if exists industry_cycle;
create table industry_cycle
(
    `id`           int    not null auto_increment comment '编号',
    `ind_cycle_id` int    not null comment '行业景气编号',
    `month`        int    not null comment '月份',
    `ind_cycle`    double not null default 0.0 comment '行业景气',
    primary key (`id`)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '行业景气信息表'
    row_format = dynamic;

insert into industry_cycle(`ind_cycle_id`, `month`, `ind_cycle`)
values (1000, 1, 2023),
       (1000, 2, 2023),
       (1000, 3, 2023),
       (1000, 4, 2023),
       (1000, 5, 2023),
       (1000, 6, 2023),
       (1000, 7, 2023),
       (1000, 8, 2023),
       (1000, 9, 2023),
       (1000, 10, 2023),
       (1000, 11, 2023),
       (1000, 12, 2023);

drop table if exists province_log_info;
create table province_log_info
(
    `id`               int    not null auto_increment comment '编号',
    `year`             int    not null comment '年份',
    `pro_id`           int    not null default 0.0 comment '省编号',
    `log_volume`       double not null default 0.0 comment '物流量',
    `ind_scale`        double not null default 0.0 comment '行业规模',
    `l_tran_volume`    double not null default 0.0 comment '陆运总量',
    `w_tran_volume`    double not null default 0.0 comment '水运总量',
    `a_tran_volume`    double not null default 0.0 comment '空运总量',
    `log_income`       double not null default 0.0 comment '物流收入',
    `ind_cycle_id`     int    not null comment '行业景气',
    `sf_sto_volume`    double not null default 0.0 comment '顺丰入库量',
    `dj_sto_volume`    double not null default 0.0 comment '京东入库量',
    `ems_sto_volume`   double not null default 0.0 comment 'EMS入库量',
    `other_sto_volume` double not null default 0.0 comment '其他入库量',

    primary key (`id`),
    unique key (`year`),
    foreign key (`pro_id`) references province_info (`id`)
)
    engine = InnoDB
    character set utf8mb4
    collate utf8mb4_0900_ai_ci
    comment '省物流信息表'
    row_format = dynamic;

insert into province_log_info(`year`, `pro_id`, `log_volume`,
                              `ind_scale`, `l_tran_volume`, `w_tran_volume`,
                              `a_tran_volume`, `log_income`, `ind_cycle_id`, `sf_sto_volume`, `dj_sto_volume`,
                              `ems_sto_volume`, `other_sto_volume`)
values (2013, 1000, 2013, 2013, 2013, 2013, 2013, 2013, 1000, 2013, 2013, 2013, 2013),
       (2014, 1000, 2014, 2014, 2014, 2014, 2014, 2014, 1000, 2014, 2014, 2014, 2014),
       (2015, 1000, 2015, 2015, 2015, 2015, 2015, 2015, 1000, 2015, 2015, 2015, 2015),
       (2016, 1000, 2016, 2016, 2016, 2016, 2016, 2016, 1000, 2016, 2016, 2016, 2016),
       (2017, 1000, 2017, 2017, 2017, 2017, 2017, 2017, 1000, 2017, 2017, 2017, 2017),
       (2018, 1000, 2018, 2018, 2018, 2018, 2018, 2018, 1000, 2018, 2018, 2018, 2018),
       (2019, 1000, 2019, 2019, 2019, 2019, 2019, 2019, 1000, 2019, 2019, 2019, 2019),
       (2020, 1000, 2020, 2020, 2020, 2020, 2020, 2020, 1000, 2020, 2020, 2020, 2020),
       (2021, 1000, 2021, 2021, 2021, 2021, 2021, 2021, 1000, 2021, 2021, 2021, 2021),
       (2022, 1000, 2022, 2022, 2022, 2022, 2022, 2022, 1000, 2022, 2022, 2022, 2022);