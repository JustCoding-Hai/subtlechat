package top.javahai.subtlechat.api.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.IoUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.poi.hpsf.Thumbnail;
import top.javahai.subtlechat.api.utils.ImgUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

/**
 * @author Hai
 * @program: subtlechat
 * @description: 将URL图片的格式转化器
 * @create 2020/10/8 - 12:45
 **/
public class MyUrlImageConverter implements Converter<URL> {
    @Override
    public Class supportJavaTypeKey() {
        return URL.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.IMAGE;
    }

    @Override
    public URL convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                 GlobalConfiguration globalConfiguration) {
        throw new UnsupportedOperationException("Cannot convert images to url.");
    }

    @Override
    public CellData convertToExcelData(URL value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) throws IOException {
        InputStream inputStream = null;
        try {
            //开启连接
            URLConnection uc = value.openConnection();
            URL url  = null;



            //获取响应状态
            int statusCode = ((HttpURLConnection) uc).getResponseCode();
            switch (statusCode){
                case 200:
                    inputStream = value.openStream();
                    break;
                case 404:
                    //默认给一个图片
                    url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598096095144&di=9a72ad26e83effb9341c711c9818b85f&imgtype=0&src=http%3A%2F%2Fpic.616pic.com%2Fys_bnew_img%2F00%2F11%2F69%2Fj2AjnHspwT.jpg");
                    inputStream = url.openStream();
                    break;
                default :
                    url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598096095144&di=9a72ad26e83effb9341c711c9818b85f&imgtype=0&src=http%3A%2F%2Fpic.616pic.com%2Fys_bnew_img%2F00%2F11%2F69%2Fj2AjnHspwT.jpg");
                    inputStream = url.openStream();
                    break;
            }
            byte[] bytes = IoUtils.toByteArray(inputStream);
            byte[] compressBytes = ImgUtil.compressPicForScale(bytes,200, UUID.randomUUID().toString());
            return new CellData(compressBytes);
        }catch (ConnectException exception){
            //捕获下链接异常
            URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598096095144&di=9a72ad26e83effb9341c711c9818b85f&imgtype=0&src=http%3A%2F%2Fpic.616pic.com%2Fys_bnew_img%2F00%2F11%2F69%2Fj2AjnHspwT.jpg");
            inputStream = url.openStream();
            byte[] bytes = IoUtils.toByteArray(inputStream);
            return new CellData(bytes);
        }catch (FileNotFoundException fileNotFoundException){
            URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1598096095144&di=9a72ad26e83effb9341c711c9818b85f&imgtype=0&src=http%3A%2F%2Fpic.616pic.com%2Fys_bnew_img%2F00%2F11%2F69%2Fj2AjnHspwT.jpg");
            inputStream = url.openStream();
            byte[] bytes = IoUtils.toByteArray(inputStream);
            return new CellData(bytes);
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
