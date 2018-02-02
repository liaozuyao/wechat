package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.utils.ViewData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Controller
public class FileUploadController extends BaseController{

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ViewData upload(@RequestParam MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            //上传文件路径
            String path = Constants.USERINFO_FILE_PATH;
            //上传文件名
            String fileName = file.getOriginalFilename();
            File filePath = new File(path, fileName);
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            //将上传文件保存到目标文件中
            file.transferTo(new File(path + File.separator + fileName));
            return buildSuccessViewData(StatusConstants.SUCCESS_CODE,"成功", fileName);
        } else {
            return buildFailureJson(StatusConstants.ERROR_CODE,"失败");
        }
    }
}
