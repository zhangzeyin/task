package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.SysTask;
import com.example.demo.entity.SysTaskExample;

@Repository
public interface SysTaskMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(SysTaskExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(SysTaskExample example);

    /**
     * 根据主键删除数据库的记录
     *
     * @param seqId
     */
    int deleteByPrimaryKey(Integer seqId);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(SysTask record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(SysTask record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<SysTask> selectByExample(SysTaskExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    SysTask selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective( SysTask record, SysTaskExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample( SysTask record, SysTaskExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SysTask record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SysTask record);
}