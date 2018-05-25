package com.czyl.controller;

import com.czyl.common.Constants;
import com.czyl.common.StatusConstants;
import com.czyl.utils.ViewData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by liaozuyao on 2017/12/19.
 */
@Controller
@Api(description = "文件上传下载")
public class FileUploadController extends BaseController{

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传")
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

    @PostMapping(value = "download")
    @ApiOperation(value = "下载")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("fileName")String fileName)
                        throws Exception{
        //下载路径
        String path = Constants.DOWNLOAD_FILE_PATH;
        File file = new File(path + File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
