package vv.common.demo.entity;

import java.io.Serializable;

/**
 * Created by vivien on 16/10/25.
 */

public class Book implements Serializable {

    public String url;
    public String title;

    public Book(String url, String title) {
        this.url = url;
        this.title = title;
    }
}
