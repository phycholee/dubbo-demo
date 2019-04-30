package com.llf.dubbo.dto;

import java.io.Serializable;

/**
 * @author: Oliver.li
 * @Description:
 * @date: 2019/1/17 15:09
 */
public class HelloDto implements Serializable {

    private static final long serialVersionUID = -177931786740824558L;

    private Long id;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HelloDto{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
