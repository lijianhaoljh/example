<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<div id="ctx">
		<form action="javascript:void(0)">
			<table>
				<tr>
					<td colspan="4"><strong>采购入库</strong></td>
				</tr>
				<tr>
					<td>单据编号:</td><td><input name="billno" v-model="bill.billno"></td>
					<td>单据日期:</td><td><input type="date" name="billdate" v-model="bill.billdate"></td>
				</tr>
				<tr>
					<td>供应商:</td><td><input name="suppliername" v-model="bill.suppliername"></td>
					<td>供应商地址:</td><td><input name="supplieraddress" v-model="bill.supplieraddress"></td>
				</tr>
				<tr>
					<td>部门:</td><td><input name="department" v-model="bill.department"></td>
					<td>仓库:</td><td><input name="warehouse" v-model="bill.warehouse"></td>
				</tr>
				<tr>
					<td>采购人员:</td><td><input name="buyer" v-model="bill.buyer"></td>
					<td>制单人员:</td><td><input name="executor" v-model="bill.executor"></td>
				</tr>
				<tr>
					<td>入库明细:</td>
					<td colspan="3">
						<textarea rows="5" cols="50" name="details" v-model="getDetails">
						</textarea>
					</td>
				</tr>
				<tr>
					<td>
						<button @click="loadTestData">加载测试数据</button>
						<button @click="loadServerData">加载服务器数据</button>
						<button @click="insert">保存</button>
						<button @click="removeAll">清空</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="static/js/vue.js"></script>
	<script type="text/javascript">
		var vm=new Vue({
			el:"#ctx",
			data(){
				return{
					billTestData:{
						"billno":"20160119001",          //单据编号
						"billdate":"2016-01-19",         //单据日期
						"suppliername":"联想株洲总代理",     // 供应商
						"supplieraddress":"株洲天元区黄山路", //供应商地址
						"department":"物控部",             //采购所属部门
						"warehouse":"株洲仓",              //入库仓库
						"buyer":"牛采购",                  //采购人员
						"executor":"小花",                 //制单人
						"details":[{                      //商品明细数据
							"billno":"20160119001",         //商品编号
							"lineid":1,                     //序号，或者行号
							"goodsname":"联想笔记本",          //商品名称
							"goodsnum":10,                  //数量
							"goodsprice":3000.00,           //单价
							"goodsmoneyamt":30000.00,       //金额
							"ispresent":1               //是否赠品
							},{
								"billno":"20160119001",
								"lineid":2,
								"goodsname":"数码相机",
								"goodsnum":10,
								"goodsprice":2000.00,
								"goodsmoneyamt":20000.00,
								"ispresent":0
						}]
					},
					bill:{}
				}
			},computed:{
				getDetails(){
					let that=this;
					return JSON.stringify(that.bill.details);
				},setDetails(newValue){
					let that=this;
					that.bill.details=JSON.parse(newValue);
				}
			}
			,methods:{
				loadTestData(){
					//加载测试数据
					this.bill=this.billTestData;
				},
				loadServerData(){
					$.ajax({
						url:"findOne",
						dataType:"json",
						success:function(result){
							vm.bill=result;
						   console.log(result);
						},error:function(result){
							console.log(result);
						}
					});
				},
				removeAll(){
					vm.bill={};
				},
				insert(){
					/*
						方式一：
						JSON.stringify(evtValue)=='{}'
						方式二：
						Object.keys(xxx).length==0
					*/
					if(JSON.stringify(vm.bill)=='{}'){
						alert("请完善单据信息!");
						return;
					}
					$.ajax({
						url:"insert",
						data:JSON.stringify(vm.bill),
						contentType:"application/json;charset=utf-8",
						dataType:"text",
						type:"post",
						success:function(result){
						   console.log(result);
						},error:function(result){
							console.log(result);
						}
					});
				}
			}
		});

		//jq加载
		
	</script>
</body>
</html>