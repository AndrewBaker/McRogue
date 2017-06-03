package com.example.examplemod;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Template {
    private String name;
    private int age;
    private String[] roles;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String[] getRoles() {
        return roles;
    }
    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
