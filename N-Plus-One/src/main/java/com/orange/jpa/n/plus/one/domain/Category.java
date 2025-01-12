package com.orange.jpa.n.plus.one.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 *
 * @author xieyong
 * @date 2018/10/16 16:13
 * 典型的 多层级 分类
 * <p>
 * :@NamedEntityGraph :注解在实体上 , 解决典型的N+1问题
 * name表示实体图名, 与 repository中的注解 @EntityGraph的value属性相对应,
 * attributeNodes 表示被标注要懒加载的属性节点 比如此例中 : 要懒加载的子分类集合children
 */

@Entity
@Table(name = "jpa_category")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Category.findAll", attributeNodes = {@NamedAttributeNode("children")}),
        @NamedEntityGraph(name = "Category.findByParent",
                attributeNodes = {@NamedAttributeNode(value = "children", subgraph = "son")},                         //一级延伸
                subgraphs = {@NamedSubgraph(name = "son", attributeNodes = @NamedAttributeNode(value = "children", subgraph = "grandson")),         //二级延伸
                        @NamedSubgraph(name = "grandson", attributeNodes = @NamedAttributeNode(value = "children", subgraph = "greatGrandSon")),    //三级延伸
                        @NamedSubgraph(name = "greatGrandSon", attributeNodes = @NamedAttributeNode(value = "children"))})                          //四级延伸
//                      有多少次延伸,就有多少个联表关系,自身关联的表设计中,子节点是可以无限延伸的,所以关联数可能查询的.....
})
@Data
@EqualsAndHashCode(of={"id"})
public class Category {
    /**
     * Id
     * UUID
    *  @GeneratedValue(generator = "UUID")
    *  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * 分类名
     */
    private String name;

    /**
     * 父分类
     * 一个商品分类下面可能有多个商品子分类(多级) 比如 分类 : 家用电器  (子)分类 : 电脑  (孙)子分类 : 笔记本电脑
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;


    /**子分类集合**/
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<Category> children;

}
