package com.accp.mapper;

import com.accp.domain.TbDetail;
import com.accp.domain.TbDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDetailMapper {
    int countByExample(TbDetailExample example);

    int deleteByExample(TbDetailExample example);

    int insert(TbDetail record);

    int insertSelective(TbDetail record);

    List<TbDetail> selectByExample(TbDetailExample example);

    int updateByExampleSelective(@Param("record") TbDetail record, @Param("example") TbDetailExample example);

    int updateByExample(@Param("record") TbDetail record, @Param("example") TbDetailExample example);
}