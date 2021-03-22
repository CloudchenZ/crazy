package com.example.zhoukao0301.entity;

public class MessageA {
    private String msg;

    public MessageA(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MessageA{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
