package com.example.zhoukao0301.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MessageEntity {
    @NotNull
    String msg;

    @Generated(hash = 536296485)
    public MessageEntity(@NotNull String msg) {
        this.msg = msg;
    }

    @Generated(hash = 1797882234)
    public MessageEntity() {
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
