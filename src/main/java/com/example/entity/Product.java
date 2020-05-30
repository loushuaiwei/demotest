package com.example.entity;

/*
 * 商品实体类
 * */
public class Product {

    private long pid;//编号
    private String pname;//名称
    private double pprice;//价格
    private String ptime;//入库时间
    private long pcount;//数量
    private long pstatus;//状态
    //无参构造方法
    public Product() {}
    //带参构造方法
    public Product(long pid, String pname, double pprice, String ptime, long pcount, long pstatus) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.ptime = ptime;
        this.pcount = pcount;
        this.pstatus = pstatus;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }


    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }


    public long getPcount() {
        return pcount;
    }

    public void setPcount(long pcount) {
        this.pcount = pcount;
    }


    public long getPstatus() {
        return pstatus;
    }

    public void setPstatus(long pstatus) {
        this.pstatus = pstatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pprice=" + pprice +
                ", ptime='" + ptime + '\'' +
                ", pcount=" + pcount +
                ", pstatus=" + pstatus +
                '}';
    }
}