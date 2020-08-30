package com.atomikos.mapper.primarydb;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * article
 * @author 
 */
@Data
@AllArgsConstructor
public class Article implements Serializable {
    private Integer id;

    private String author;

    private String title;

    private String context;


    private static final long serialVersionUID = 1L;
}