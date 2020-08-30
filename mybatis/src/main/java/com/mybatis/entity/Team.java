package com.mybatis.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * team
 * @author 
 */
@Data
public class Team implements Serializable {
    private Integer id;

    private String teamName;

    private static final long serialVersionUID = 1L;
}