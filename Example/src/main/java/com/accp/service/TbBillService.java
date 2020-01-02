package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.TbBill;
import com.accp.domain.TbDetail;
import com.accp.domain.TbDetailExample;
import com.accp.mapper.TbBillMapper;
import com.accp.mapper.TbDetailMapper;

@Service
@Transactional
public class TbBillService {
	@Autowired
	TbBillMapper tBillMapper;
	@Autowired
	TbDetailMapper tbDetailMapper;
	
	//查询一条数据
	public TbBill findOne() {
		List<TbBill> list=tBillMapper.selectByExample(null);
		TbBill tb=null;
		if(list.size()>0||list!=null) {
			tb=list.get(0);
		}
		if(tb!=null) {
			TbDetailExample example=new TbDetailExample();
			example.createCriteria().andBillnoEqualTo(tb.getBillno());
			tb.setDetails(tbDetailMapper.selectByExample(example));
		}
		return tb;
	}
	
	//添加
	public int insert(TbBill tb) {
		int count=tBillMapper.insert(tb);
		for(TbDetail td:tb.getDetails()) {
			tbDetailMapper.insert(td);
		}
		return count;
	}
	
}
