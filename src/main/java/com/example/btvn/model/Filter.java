package com.example.btvn.model;

import java.util.List;

public class Filter {

    private List<Long> status;
    private List<Long> subject ;
    private List<String> sex ;
    private List<Long> address;

    public Filter() {

    }

    public Filter(List<Long> status, List<Long> subject, List<String> sex, List<Long> address) {

        this.status = status;
        this.subject = subject;
        this.sex = sex;
        this.address = address;
    }



    public List<Long> getStatus() {
        return status;
    }

    public void setStatus(List<Long> status) {
        this.status = status;
    }

    public List<Long> getSubject() {
        return subject;
    }

    public void setSubject(List<Long> subject) {
        this.subject = subject;
    }

    public List<String> getSex() {
        return sex;
    }

    public void setSex(List<String> sex) {
        this.sex = sex;
    }

    public List<Long> getAddress() {
        return address;
    }

    public void setAddress(List<Long> address) {
        this.address = address;
    }
}
