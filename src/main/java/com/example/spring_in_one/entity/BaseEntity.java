package com.example.spring_in_one.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @MappedSuperclass
 * 1. 功能上,可能数据库中有很多表,他们本身有一部分属性为重合的.因此可以单独将这些重合的属性给脱离出来
 * 2. 脱离出来的属性单独作为一个类 对此标注为mapperSupperClass
 * 3. 一旦标注了此类,那么就不可在该类上标注@Entity或@Table注解，也无需实现序列化接口.
 */
@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    @Column(name= "create_date") //创建时间
    Date createDate = new Date();

    @Column(name= "update_date")//修改时间
    Date updateDate;


}
