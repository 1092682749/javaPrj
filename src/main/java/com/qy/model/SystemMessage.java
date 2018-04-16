package com.qy.model;

import javax.persistence.*;

@Table(name = "system_message")
public class SystemMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 系统消息内容
     */
    private String message_content;

    /**
     * 发送时间
     */
    private String send_time;

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
     * 获取系统消息内容
     *
     * @return message_content - 系统消息内容
     */
    public String getMessage_content() {
        return message_content;
    }

    /**
     * 设置系统消息内容
     *
     * @param message_content 系统消息内容
     */
    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    /**
     * 获取发送时间
     *
     * @return send_time - 发送时间
     */
    public String getSend_time() {
        return send_time;
    }

    /**
     * 设置发送时间
     *
     * @param send_time 发送时间
     */
    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }
}