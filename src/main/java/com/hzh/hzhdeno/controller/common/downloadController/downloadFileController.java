package com.hzh.hzhdeno.controller.common.downloadController;

import com.hzh.hzhdeno.annotion.AssemblyMethod;
import com.hzh.hzhdeno.common.MsgContext;
import com.hzh.hzhdeno.constans.OperateEnums;
import com.hzh.hzhdeno.constans.ResultState;
import com.hzh.hzhdeno.entity.vo.DownloadFileVO;
import com.hzh.hzhdeno.weixin.util.downloadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


@RestController
@RequestMapping("/download")
public class downloadFileController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/downloadFile")
//    @ApiOperation(value = "updateState", notes = "禁用/启用状态")
    @AssemblyMethod(operateEnums = OperateEnums.BUSINESS_LABEL_INDEX, name = "首页", entrance = true)
    public void downloadFile(@RequestBody DownloadFileVO downloadFileVO) {
        try {
            URL root = new URL(downloadFileVO.getUrl());
//            downloadUtil.saveBinary(root);
        } catch (MalformedURLException e) {
            logger.error("传输url异常", e);
        } catch (IOException e) {
            logger.error("下载文件失败", e);
        }
    }


    @PostMapping("/downloadNovelContent")
//    @ApiOperation(value = "updateState", notes = "禁用/启用状态")
    @AssemblyMethod(operateEnums = OperateEnums.BUSINESS_LABEL_INDEX, name = "首页", entrance = true)
    public MsgContext downloadNovelContent(@RequestBody DownloadFileVO downloadFileVO) {

        try {
            URL url = new URL("http://www.ifeng.com");
            String urlSource = downloadUtil.getURLSource(url);
            logger.error("网站内容:" + urlSource);
        } catch (Exception e) {
            logger.error("获取失败");
            e.printStackTrace();
        }
        return new MsgContext(ResultState.SUCCESS);
    }
}
