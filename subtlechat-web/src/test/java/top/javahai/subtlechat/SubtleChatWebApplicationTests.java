package top.javahai.subtlechat;

import com.github.binarywang.java.emoji.EmojiConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class SubtleChatWebApplicationTests {

  //测试密码加密
  @Test
  void contextLoads() {
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    String encode = encoder.encode("123");
    System.out.println(encode);
  }

  @Test
  void test01(){
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(simpleDateFormat.format(new Date()));
    System.out.println(new Date());
  }
  //测试emoji的转码
  @Test
void test02(){
    EmojiConverter emojiConverter = EmojiConverter.getInstance();
    String str="\uE423 \uE424 \uE425An ??awesome ??string with a few ??emojis!";
    String html = emojiConverter.toHtml(str);
    System.out.println(html);
}
}
