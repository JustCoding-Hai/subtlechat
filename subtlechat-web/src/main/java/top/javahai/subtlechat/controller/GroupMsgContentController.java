package top.javahai.subtlechat.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import top.javahai.subtlechat.api.data.GroupMsgContentData;
import top.javahai.subtlechat.api.entity.GroupMsgContent;
import top.javahai.subtlechat.api.entity.RespBean;
import top.javahai.subtlechat.api.entity.RespPageBean;
import top.javahai.subtlechat.dao.GroupMsgContentDao;
import top.javahai.subtlechat.service.GroupMsgContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (GroupMsgContent)表控制层
 *
 * @author makejava
 * @since 2020-06-17 10:51:13
 */
@RestController
@RequestMapping("/groupMsgContent")
public class GroupMsgContentController {
    /**
     * 服务对象
     */
    @Resource
    private GroupMsgContentService groupMsgContentService;

    @GetMapping("/")
    private List<GroupMsgContent> getAllGroupMsgContent(){
        return groupMsgContentService.queryAllByLimit(null,null);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public GroupMsgContent selectOne(Integer id) {
        return this.groupMsgContentService.queryById(id);
    }

    /**
     * 分页返回数据
     * @author luo
     * @param page 页数
     * @param size 单页大小
     * @param nickname 发送者昵称
     * @param type 消息类型
     * @param dateScope 发送时间范围
     * @return
     */
    @GetMapping("/page")
    public RespPageBean getAllGroupMsgContentByPage(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                    @RequestParam(value = "size",defaultValue = "10") Integer size,
                                                    String nickname, Integer type,
                                                    Date[] dateScope){
        return groupMsgContentService.getAllGroupMsgContentByPage(page,size,nickname,type,dateScope);
    }

    /**
     * 根据id删除单条记录
     * @author luo
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deleteGroupMsgContentById(@PathVariable Integer id){
        if (groupMsgContentService.deleteById(id)){
            return RespBean.ok("删除成功！");
        }else{
            return RespBean.error("删除失败！");
        }
    }
    @DeleteMapping("/")
    public RespBean deleteGroupMsgContentByIds(Integer[] ids){
        if (groupMsgContentService.deleteGroupMsgContentByIds(ids)==ids.length){
            return RespBean.ok("删除成功！");
        }else {
            return RespBean.error("删除失败！");
        }
    }


    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {

        groupMsgContentService.handleDownload(response);

       }
}
