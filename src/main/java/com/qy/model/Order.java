package com.qy.model;

import javax.persistence.*;

public class Order {
    /**
     * 订单编号
     */
    @Id
    private Integer order_code;

    /**
     * 0待付款 1代发货 2待收货 3待评价 4退款中 5已退款 6交易关闭
     */
    private Integer type;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收获电话
     */
    private String phone;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 留言
     */
    private String leave_message;

    /**
     * 发票抬头
     */
    private String invoice_title;

    /**
     * 物流单号
     */
    private String logistics_num;

    /**
     * 物流名称
     */
    private String logistics_name;

    /**
     * 订单时间
     */
    private String add_time;

    /**
     * 付款时间
     */
    private String payment_time;

    /**
     * 发货时间
     */
    private String delivery_time;

    /**
     * 确认收货时间
     */
    private String confirm_receive_time;

    /**
     * 申请退款时间
     */
    private String add_refund_time;

    /**
     * 交易关闭时间
     */
    private String close_time;

    /**
     * 真正退款时间
     */
    private String refund_time;

    /**
     * 获取订单编号
     *
     * @return order_code - 订单编号
     */
    public Integer getOrder_code() {
        return order_code;
    }

    /**
     * 设置订单编号
     *
     * @param order_code 订单编号
     */
    public void setOrder_code(Integer order_code) {
        this.order_code = order_code;
    }

    /**
     * 获取0待付款 1代发货 2待收货 3待评价 4退款中 5已退款 6交易关闭
     *
     * @return type - 0待付款 1代发货 2待收货 3待评价 4退款中 5已退款 6交易关闭
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0待付款 1代发货 2待收货 3待评价 4退款中 5已退款 6交易关闭
     *
     * @param type 0待付款 1代发货 2待收货 3待评价 4退款中 5已退款 6交易关闭
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取收货人
     *
     * @return consignee - 收货人
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 设置收货人
     *
     * @param consignee 收货人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * 获取收获电话
     *
     * @return phone - 收获电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置收获电话
     *
     * @param phone 收获电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取收货地址
     *
     * @return address - 收货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置收货地址
     *
     * @param address 收货地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取留言
     *
     * @return leave_message - 留言
     */
    public String getLeave_message() {
        return leave_message;
    }

    /**
     * 设置留言
     *
     * @param leave_message 留言
     */
    public void setLeave_message(String leave_message) {
        this.leave_message = leave_message;
    }

    /**
     * 获取发票抬头
     *
     * @return invoice_title - 发票抬头
     */
    public String getInvoice_title() {
        return invoice_title;
    }

    /**
     * 设置发票抬头
     *
     * @param invoice_title 发票抬头
     */
    public void setInvoice_title(String invoice_title) {
        this.invoice_title = invoice_title;
    }

    /**
     * 获取物流单号
     *
     * @return logistics_num - 物流单号
     */
    public String getLogistics_num() {
        return logistics_num;
    }

    /**
     * 设置物流单号
     *
     * @param logistics_num 物流单号
     */
    public void setLogistics_num(String logistics_num) {
        this.logistics_num = logistics_num;
    }

    /**
     * 获取物流名称
     *
     * @return logistics_name - 物流名称
     */
    public String getLogistics_name() {
        return logistics_name;
    }

    /**
     * 设置物流名称
     *
     * @param logistics_name 物流名称
     */
    public void setLogistics_name(String logistics_name) {
        this.logistics_name = logistics_name;
    }

    /**
     * 获取订单时间
     *
     * @return add_time - 订单时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置订单时间
     *
     * @param add_time 订单时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    /**
     * 获取付款时间
     *
     * @return payment_time - 付款时间
     */
    public String getPayment_time() {
        return payment_time;
    }

    /**
     * 设置付款时间
     *
     * @param payment_time 付款时间
     */
    public void setPayment_time(String payment_time) {
        this.payment_time = payment_time;
    }

    /**
     * 获取发货时间
     *
     * @return delivery_time - 发货时间
     */
    public String getDelivery_time() {
        return delivery_time;
    }

    /**
     * 设置发货时间
     *
     * @param delivery_time 发货时间
     */
    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    /**
     * 获取确认收货时间
     *
     * @return confirm_receive_time - 确认收货时间
     */
    public String getConfirm_receive_time() {
        return confirm_receive_time;
    }

    /**
     * 设置确认收货时间
     *
     * @param confirm_receive_time 确认收货时间
     */
    public void setConfirm_receive_time(String confirm_receive_time) {
        this.confirm_receive_time = confirm_receive_time;
    }

    /**
     * 获取申请退款时间
     *
     * @return add_refund_time - 申请退款时间
     */
    public String getAdd_refund_time() {
        return add_refund_time;
    }

    /**
     * 设置申请退款时间
     *
     * @param add_refund_time 申请退款时间
     */
    public void setAdd_refund_time(String add_refund_time) {
        this.add_refund_time = add_refund_time;
    }

    /**
     * 获取交易关闭时间
     *
     * @return close_time - 交易关闭时间
     */
    public String getClose_time() {
        return close_time;
    }

    /**
     * 设置交易关闭时间
     *
     * @param close_time 交易关闭时间
     */
    public void setClose_time(String close_time) {
        this.close_time = close_time;
    }

    /**
     * 获取真正退款时间
     *
     * @return refund_time - 真正退款时间
     */
    public String getRefund_time() {
        return refund_time;
    }

    /**
     * 设置真正退款时间
     *
     * @param refund_time 真正退款时间
     */
    public void setRefund_time(String refund_time) {
        this.refund_time = refund_time;
    }
}