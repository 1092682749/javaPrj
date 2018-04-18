package com.qy.model;

import java.math.BigDecimal;
import javax.persistence.*;

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    private Integer member_id;

    /**
     * 退款金额
     */
    private BigDecimal t_amount;

    /**
     * 退款时间
     */
    private String add_time;

    /**
     * 0 退款中 1退款成功 2退款失败
     */
    private Integer type;

    /**
     * 订单编号
     */
    private Integer order_id;

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
     * 获取用户id
     *
     * @return member_id - 用户id
     */
    public Integer getMember_id() {
        return member_id;
    }

    /**
     * 设置用户id
     *
     * @param member_id 用户id
     */
    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    /**
     * 获取退款金额
     *
     * @return t_amount - 退款金额
     */
    public BigDecimal getT_amount() {
        return t_amount;
    }

    /**
     * 设置退款金额
     *
     * @param t_amount 退款金额
     */
    public void setT_amount(BigDecimal t_amount) {
        this.t_amount = t_amount;
    }

    /**
     * 获取退款时间
     *
     * @return add_time - 退款时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置退款时间
     *
     * @param add_time 退款时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    /**
     * 获取0 退款中 1退款成功 2退款失败
     *
     * @return type - 0 退款中 1退款成功 2退款失败
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0 退款中 1退款成功 2退款失败
     *
     * @param type 0 退款中 1退款成功 2退款失败
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取订单编号
     *
     * @return order_id - 订单编号
     */
    public Integer getOrder_id() {
        return order_id;
    }

    /**
     * 设置订单编号
     *
     * @param order_id 订单编号
     */
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
}