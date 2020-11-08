package top.javahai.subtlechat.service;

/**
 * @author Hai
 * @date 2020/10/2 - 23:27
 */
public interface VerifyCodeService {

    String getVerifyCode();

    void sendVerifyCodeMail(String code);

}
