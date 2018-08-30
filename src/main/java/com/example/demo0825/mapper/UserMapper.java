package com.example.demo0825.mapper;

import com.example.demo0825.entity.User;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

    @Select("select * from students where id=#{id}")
    /*实体类和数据库中的字段名一致时省略，如果不一致就要如下写注解，@Results注解里写各个@Result，即实体类属性对应字段名。
    @Results(value={
    @Result(column="id",property="id"),
    @Result(column="name",property="userName"),
    @Result(column="age",property="userAge"),
    @Result(column="position",property="userPosition"),
    })*/
    public User GetID(int id);

    @Select("select * from students where name = #{name}")
    public User GetName(String name);

    @Select("select * from students")
    public List<User> GetList();

    @Insert("insert into students(name,age,position) values (#{name},#{age},#{position})")
    public void AddUser(User data);
//    void AddUser(String name,int age,String position); ???
//    int AddUser(@Param("name") String name);???

    @Update("update students set name='咿呀咿呀哟嘿'  WHERE id=#{id}")
    void ReOrder(int id);

    @Delete("delete from students where id=#{id}")
    void Del(int id);

    /*
    @SelectProvider(type = Employee_MapperSqlProvider.class, method = "getuserapply")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
            @Result(column = "uphone", property = "uphone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "uname", property = "uname", jdbcType = JdbcType.VARCHAR),

    })
    List<User> getuserapplyforsqlprovider();
    */

}
