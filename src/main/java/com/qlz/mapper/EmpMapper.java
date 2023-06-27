package com.qlz.mapper;

import com.qlz.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from tb_emp where id = #{id}")
    public void delete(Integer id);

    // 新增
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO tb_emp (username, name, gender, image, job, entrydate,dept_id, create_time, update_time)" +
            "VALUES (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    //更新
    @Update("update tb_emp set username = #{username}, name=#{name}, gender=#{gender}, image=#{image}," +
    "job = #{job}, entrydate = #{entrydate} , dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

    @Select("select * from tb_emp where id = #{id}")
    public Emp getById(Integer id);

//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime from tb_emp where id = #{id}")
//    public Emp getById(Integer id);
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from tb_emp where id = #{id}")
//    public Emp getById(Integer id);
//    @Select("select * from tb_emp where name like concat('%', #{name}, '%') and gender =#{gender} and entrydate between #{begin} and #{end} order by update_time")
//    public List<Emp> list2(String name, Short gender, LocalDate begin, LocalDate end);

//    @Select("select * from tb_emp where name like '%${name}%' and gender =#{gender} and entrydate between #{begin} and #{end} order by update_time")
//    public List<Emp> list2(String name, Short gender, LocalDate begin, LocalDate end);

    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    public void update2(Emp emp);

    public void deleteByIds(List<Integer> ids);



}
