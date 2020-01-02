package com.accp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.TbBill;
import com.accp.service.TbBillService;

@Controller
public class TbBillController {
	
	@Autowired
	TbBillService tbBillService;
	
	//��ת��ҳ
	@RequestMapping("/toIndex")
	public String toIndex() {
		return "index";
	}
	
	//��ѯ��������
	@RequestMapping("/findOne")
	@ResponseBody
	public TbBill findOne() {
		return tbBillService.findOne();
	}
	
	//���
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody TbBill tb) {
		int count = tbBillService.insert(tb);
		return "result:"+count;
	}
}
