package com.zero.logisticsbackend.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 市信息
 *
 * @author ZERO
 * @date 2023/3/9
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("city_info")
public class CityInfo {

    /**
     * 编号
     */
    @TableId
    private Integer id;

    /**
     * 市名称
     */
    @TableField("name")
    private String name;

    /**
     * 经度
     */
    @TableField("longitude")
    private Double longitude;

    /**
     * 纬度
     */
    @TableField("latitude")
    private Double latitude;

}
