package top.javahai.subtlechat.api.entity;

/**
 * @author Hai
 * @date 2020/10/2 - 14:52
 */
public class MailConstants {
    //消息投递中
    public static final  Integer DELIVERING=0;
    //消息投递成功
    public static final  Integer SUCCESS=1;
    //消息投递失败
    public static final  Integer FAILURE=2;
    //最大重试次数
    public static final  Integer MAX_TRY_COUNT=3;
    //消息超时时间
    public static final  Integer MEG_TIMEOUT=1;
    //消息类型为反馈
    public static final Integer FEEDBACK_TYPE=1;
    //消息类型为验证码
    public static final Integer VERIFY_CODE_TYPE=2;
}
