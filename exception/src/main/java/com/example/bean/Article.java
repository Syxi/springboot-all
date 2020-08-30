package com.example.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author suYan
 * @Date 2020/7/9 21:30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private int id;
    private String author;
    private String title;
    private String content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT + 8")
    private Data creatTime;
    private List<Reader> readers;

}
