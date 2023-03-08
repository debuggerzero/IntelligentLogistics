## 省信息表 province_info

| 列名      | 类型         | 备注 |
| --------- | ------------ | ---- |
| id        | int          | 编号 |
| name      | varchar(255) | 名称 |
| longitude | double       | 经度 |
| latitude  | double       | 纬度 |

## 市信息表 city_info

| 列名      | 类型         | 备注 |
| --------- | ------------ | ---- |
| id        | int          | 编号 |
| name      | varchar(255) | 名字 |
| longitude | double       | 经度 |
| latitude  | double       | 纬度 |

## 路线信息表 route_info

| 列名          | 类型   | 备注         |
| ------------- | ------ | ------------ |
| id            | int    | 编号         |
| city_start_id | int    | 出发地编号   |
| city_end_id   | int    | 目的地编号   |
| distance      | double | 距离         |
| duration      | long   | 预计时间 (s) |

## 订单信息表 order_info

| 列名          | 类型          | 备注   |
| ------------- | ------------- | ------ |
| id            | int           | 编号   |
| city_start_id | int           | 发货地 |
| city_end_id   | int           | 收货地 |
| consignee     | varchar(255)  | 收货人 |
| phone         | varchar(255)  | 电话   |
| time          | datetime      | 时间   |
| comment       | varchar(1024) | 备注   |

## 车辆信息表 car_info

| 列名   | 类型         | 备注   |
| ------ | ------------ | ------ |
| id     | int          | 编号   |
| car_id | varchar(255) | 车牌号 |
| status | int          | 状态   |

## 司机信息表 driver_info

| 列名   | 类型         | 备注 |
| ------ | ------------ | ---- |
| id     | int          | 编号 |
| name   | varchar(255) | 姓名 |
| status | int          | 状态 |

## 货运方式表 freight_meth

| 列名   | 类型         | 备注 |
| ------ | ------------ | ---- |
| id     | int          | 编号 |
| method | varchar(255) | 方式 |

## 货物状态表 goods_status

| 列名   | 类型         | 备注 |
| ------ | ------------ | ---- |
| id     | int          | 编号 |
| status | varchar(255) | 状态 |

## 货物类型 goods_type

| 列名 | 类型         | 备注 |
| ---- | ------------ | ---- |
| id   | int          | 编号 |
| type | varchar(255) | 类型 |

## 省市关系表 pro_city

| 列名    | 类型 | 备注   |
| ------- | ---- | ------ |
| pro_id  | int  | 省编号 |
| city_id | int  | 市编号 |

## 线路订单关系表 route_order

| 列名     | 类型 | 备注     |
| -------- | ---- | -------- |
| route_id | int  | 线路编号 |
| order_id | int  | 订单编号 |

## 订单货运方式关系表 order_freight_meth

| 列名            | 类型 | 备注         |
| --------------- | ---- | ------------ |
| order_id        | int  | 订单编号     |
| freight_meth_id | int  | 货运方式编号 |

## 订单货物状态关系表 order_goods_status

| 列名            | 类型 | 备注         |
| --------------- | ---- | ------------ |
| order_id        | int  | 订单编号     |
| goods_status_id | int  | 货物状态编号 |

## 订单货物类型关系表 order_goods_type

| 列名          | 类型 | 备注         |
| ------------- | ---- | ------------ |
| order_id      | int  | 订单编号     |
| goods_type_id | int  | 货物类型编号 |

## 车辆司机关系表 car_driver

| 列名      | 类型 | 备注     |
| --------- | ---- | -------- |
| car_id    | int  | 车辆编号 |
| driver_id | int  | 司机编号 |

