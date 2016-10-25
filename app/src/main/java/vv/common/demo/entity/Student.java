package vv.common.demo.entity;

import java.io.Serializable;

/**
 * Created by vivien on 16/10/25.
 */

public class Student implements Serializable {

    public String url;
    public String name;
    public String sex;

    public Student(String url, String name, String sex) {
        this.url = url;
        this.name = name;
        this.sex = sex;
    }
}
