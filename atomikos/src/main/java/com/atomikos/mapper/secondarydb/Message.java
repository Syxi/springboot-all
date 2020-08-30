package com.atomikos.mapper.secondarydb;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * message
 * @author 
 */
@Data
@AllArgsConstructor
public class Message implements Serializable {
    private Integer id;

    private String name;

    private String context;

    private static final long serialVersionUID = 1L;
}