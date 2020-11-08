package top.javahai.subtlechat.api.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (MailSendLog)实体类
 *
 * @author makejava
 * @since 2020-10-02 15:10:48
 */
public class MailSendLog implements Serializable {
    private static final long serialVersionUID = 740872026109078508L;

    private String msgId;
    /**
    * 0:反馈，1:验证码
    */
    private Integer contentType;

    private String content;

    private Integer status;

    private String routeKey;

    private String exchange;

    private Integer count;

    private Date tryTime;

    private Date createTime;

    private Date updateTime;


    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getTryTime() {
        return tryTime;
    }

    public void setTryTime(Date tryTime) {
        this.tryTime = tryTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
