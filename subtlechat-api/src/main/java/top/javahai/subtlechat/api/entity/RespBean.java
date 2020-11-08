package top.javahai.subtlechat.api.entity;

/**
 * @author Hai
 * @date 2020/4/19 - 23:23
 */
//JSON返回值的实体类
public class RespBean {
  private Integer status;//状态码
  private String msg;//返回消息
  private Object obj;//返回实体

  public static RespBean build(){
    return new RespBean();
  }

  public static RespBean ok(String msg){
    return new RespBean(200,msg,null);
  }
  public static RespBean ok(String msg,Object obj){
    return new RespBean(200,msg,obj);
  }

  public static RespBean error(String msg){
    return new RespBean(500,msg,null);
  }
  public static RespBean error(String msg,Object obj){
    return new RespBean(500,msg,obj);
  }

  private RespBean(){

  }

  private RespBean(Integer status, String msg, Object obj) {
    this.status = status;
    this.msg = msg;
    this.obj = obj;
  }

  public Integer getStatus() {
    return status;
  }

  public RespBean setStatus(Integer status) {
    this.status = status;
    return this;
  }

  public String getMsg() {
    return msg;
  }

  public RespBean setMsg(String msg) {
    this.msg = msg;
    return this;
  }

  public Object getObj() {
    return obj;
  }

  public RespBean setObj(Object obj) {
    this.obj = obj;
    return this;
  }
}
