package top.javahai.subtlechat.api.data;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.converters.string.StringImageConverter;
import com.alibaba.excel.converters.url.UrlImageConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import top.javahai.subtlechat.api.converter.MyUrlImageConverter;
import top.javahai.subtlechat.api.entity.GroupMsgContent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Excel导入导出的数据类
 * @author Hai
 * @date 2020/10/7 - 23:52
 */
@ColumnWidth(25)
@ContentRowHeight(30)
public class GroupMsgContentData {

    @ExcelProperty("消息内容编号")
    private Integer id;

    @ExcelProperty("发送者的编号")
    private Integer fromId;

    @ExcelProperty("昵称")
    private String fromName;

    //@ExcelProperty(value = "头像",converter = UrlImageConverter.class)
    @ExcelIgnore
    private URL fromProfile;

    @ExcelProperty("发送时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ExcelProperty(value = {"内容","文本"})
    @ColumnWidth(50)
    private String textContent;

    @ExcelProperty(value = {"内容","图片"},converter = MyUrlImageConverter.class)
    @ColumnWidth(50)
    private URL imageContent;

    @ExcelIgnore
    private Integer messageTypeId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public URL getFromProfile() {
        return fromProfile;
    }

    public void setFromProfile(URL fromProfile) {
        this.fromProfile = fromProfile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public URL getImageContent() {
        return imageContent;
    }

    public void setImageContent(URL imageContent) {
        this.imageContent = imageContent;
    }

    public Integer getMessageTypeId() {
        return messageTypeId;
    }

    public void setMessageTypeId(Integer messageTypeId) {
        this.messageTypeId = messageTypeId;
    }


    @Override
    public String toString() {
        return "GroupMsgContentData{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", fromName='" + fromName + '\'' +
                ", fromProfile=" + fromProfile +
                ", createTime=" + createTime +
                ", textContent='" + textContent + '\'' +
                ", imageContent=" + imageContent +
                ", messageTypeId=" + messageTypeId +
                '}';
    }
}
