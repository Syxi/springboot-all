package com.mybatis.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * player
 * @author 
 */
@Data
public class Players implements Serializable {
    private Integer id;

    private String playerName;

    // 球队的id
    private Integer tid;

    // 从队员的角度，多个队员组成一个球队。多对一查询
    private Team team;

    private static final long serialVersionUID = 1L;
}