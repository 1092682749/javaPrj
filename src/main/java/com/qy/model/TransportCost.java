package com.qy.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "transport_cost")
public class TransportCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 0物流 1快递
     */
    private Integer type;

    /**
     * 配送省
     */
    private String transport_province;

    /**
     * 配送市
     */
    private String transport_city;

    /**
     * 配送费
     */
    private BigDecimal price;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 添加时间
     */
    private String add_time;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取0物流 1快递
     *
     * @return type - 0物流 1快递
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0物流 1快递
     *
     * @param type 0物流 1快递
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取配送省
     *
     * @return transport_province - 配送省
     */
    public String getTransport_province() {
        return transport_province;
    }

    /**
     * 设置配送省
     *
     * @param transport_province 配送省
     */
    public void setTransport_province(String transport_province) {
        this.transport_province = transport_province;
    }

    /**
     * 获取配送市
     *
     * @return transport_city - 配送市
     */
    public String getTransport_city() {
        return transport_city;
    }

    /**
     * 设置配送市
     *
     * @param transport_city 配送市
     */
    public void setTransport_city(String transport_city) {
        this.transport_city = transport_city;
    }

    /**
     * 获取配送费
     *
     * @return price - 配送费
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置配送费
     *
     * @param price 配送费
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置添加时间
     *
     * @param add_time 添加时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}