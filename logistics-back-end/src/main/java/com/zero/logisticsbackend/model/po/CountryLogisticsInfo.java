package com.zero.logisticsbackend.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全国物流信息
 *
 * @author ZERO
 * @date 2023/3/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("country_log_info")
public class CountryLogisticsInfo {

    /**
     * 编号
     */
    @TableId
    private Integer id;

    /**
     * 年份
     */
    @TableField("year")
    private Integer year;

    /**
     * 物流量
     */
    @TableField("log_volume")
    private Double logVolume;

    /**
     * 行业规模
     */
    @TableField("ind_scale")
    private Double indScale;

    /**
     * 陆运总量
     */
    @TableField("l_tran_volume")
    private Double lTranVolume;

    /**
     * 水运总量
     */
    @TableField("w_tran_volume")
    private Double wTranVolume;

    /**
     * 空运总量
     */
    @TableField("a_tran_volume")
    private Double aTranVolume;

    /**
     * 物流收入
     */
    @TableField("log_income")
    private Double logIncome;

    /**
     * 行业活跃度
     */
    @TableField("ind_activity")
    private Double indActivity;

    /**
     * 同城快递量
     */
    @TableField("local_op_volume")
    private Double localOpVolume;

    /**
     * 异地快递量
     */
    @TableField("remote_op_volume")
    private Double remoteOpVolume;

    /**
     * 国际快递量
     */
    @TableField("international_op_volume")
    private Double internationalOpVolume;

    /**
     * 东部物流量
     */
    @TableField("e_log_volume")
    private Double eLogVolume;

    /**
     * 中部物流量
     */
    @TableField("m_log_volume")
    private Double mLogVolume;

    /**
     * 西部物流量
     */
    @TableField("w_log_volume")
    private Double wLogVolume;

    /**
     * 东部物流收入
     */
    @TableField("e_log_income")
    private Double eLogIncome;

    /**
     * 中部物流收入
     */
    @TableField("m_log_income")
    private Double mLogIncome;

    /**
     * 西部物流收入
     */
    @TableField("w_log_income")
    private Double wLogIncome;

}
