package com.example.zhoukao0301.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class GoodsEntity {
    @Id(autoincrement = true)
    Long id;
    @NotNull
    String url;
    @NotNull
    String title;
    @Generated(hash = 53192680)
    public GoodsEntity(Long id, @NotNull String url, @NotNull String title) {
        this.id = id;
        this.url = url;
        this.title = title;
    }
    @Generated(hash = 223916156)
    public GoodsEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
