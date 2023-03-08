package com.zero.logisticsbackend.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * FailureResponseBody
 *
 * @author ZERO
 * @date 2023/3/8
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class FailureResponseBody {
    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;
}