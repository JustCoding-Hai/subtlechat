package top.javahai.subtlechat.api.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.util.IoUtils;
import top.javahai.subtlechat.api.utils.ImgUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

/**
 * @author Hai
 * @program: subtlechat
 * @description: 处理聊天记录的内容的导出
 * @create 2020/10/8 - 23:59
 **/
public class MyContentConverter implements Converter<String> {
    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.IMAGE;
    }

    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                    GlobalConfiguration globalConfiguration) {
        throw new UnsupportedOperationException("Cannot convert images to string");
    }

    @Override
    public CellData convertToExcelData(String value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) throws IOException {
        if (value.toLowerCase().startsWith("http")){
            InputStream inputStream = null;
            URL imageUrl = new URL(value);
            try {
                //开启连接
                URLConnection uc = imageUrl.openConnection();
                URL url  = null;
                //获取响应状态
                int statusCode = ((HttpURLConnection) uc).getResponseCode();
                switch (statusCode){
                    case 200:
                        inputStream = imageUrl.openStream();
                        break;
                    default :
                        //直接当成String处理
                        return new CellData(value);
                }
                byte[] bytes = IoUtils.toByteArray(inputStream);
                //压缩图片
                byte[] compressBytes = ImgUtil.compressPicForScale(bytes,200, UUID.randomUUID().toString());
                return new CellData(compressBytes);
            }catch (Exception exception) {
                //直接当成String处理
                return new CellData(value);
            }finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }

        }

        else{
            return new CellData(value);
        }
    }
}
