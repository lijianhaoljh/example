package com.accp.domain;

public class TbDetail {
    private String billno;

    private Integer lineid;

    private String goodsname;

    private Integer goodsnum;

    private Integer goodsprice;

    private Integer goodsmoneyamt;

    private Integer ispresent;

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public Integer getLineid() {
        return lineid;
    }

    public void setLineid(Integer lineid) {
        this.lineid = lineid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Integer getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Integer goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Integer getGoodsmoneyamt() {
        return goodsmoneyamt;
    }

    public void setGoodsmoneyamt(Integer goodsmoneyamt) {
        this.goodsmoneyamt = goodsmoneyamt;
    }

    public Integer getIspresent() {
        return ispresent;
    }

    public void setIspresent(Integer ispresent) {
        this.ispresent = ispresent;
    }
}