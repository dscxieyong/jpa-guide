package com.orange.jpa.n.plus.one.domain;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xieyong on 2018/10/16 16:49.
 * 典型的 多层级 区域关系   用于描述N+1现象
 */

@Entity
@Table(name = "jpa_area")
@Data
@ToString
public class Area {
    /**
     * Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * 区域名
     */
    private String name;

    /**
     * 一个区域信息下面很多子区域(多级) 比如 分类 : 广东省  (子)区域 : 广州市  (孙)子区域 : 天河区
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Area parent;


    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Area> children;
}
