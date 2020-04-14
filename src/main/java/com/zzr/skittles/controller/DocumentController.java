package com.zzr.skittles.controller;

import com.google.gson.Gson;
import com.zzr.skittles.domain.Document;
import com.zzr.skittles.result.CommonResult;
import com.zzr.skittles.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Api(tags = "对文档的操作")
@Controller
@ResponseBody
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @ApiOperation("添加文档")
    @PostMapping("/addDocument")
    public CommonResult addDocument(@RequestBody Document document) {
        int i = documentService.addDocument(document);
        if (i != 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除一个文档")
    @PostMapping(value = "/deleteDocument", produces = "application/json")
    public CommonResult deleteDocument(@RequestBody Integer documentId) {
        int i = documentService.deleteDocument(documentId);
        if (i != 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("更新一个文档")
    @PostMapping("/updateDocument")
    public CommonResult updateDocument(@RequestBody Document document) {
        int i = documentService.updateDocument(document);
        if (i != 0) {
            return CommonResult.success();
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查找一个文档")
    @GetMapping("/selectDocument")
    public CommonResult selectDocument(int documentId) {
        Document document = documentService.selectDocument(documentId);
        if (document != null) {
            return CommonResult.success(document);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查找所有文档")
    @GetMapping("/selectDocuments")
    public CommonResult selectDocuments() {
        List<Document> documents = documentService.selectDocuments();
        if (documents != null) {
            return CommonResult.success(documents);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("接受上传图片")
    @PostMapping("/receivePicture")
    public Map<String, Object> receivePicture(@RequestBody MultipartFile file, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String[] urls = new String[1];
        String uri = documentService.savePicture(file);
        if (uri != null) {
            String url = request.getRequestURL().toString().replace(request.getRequestURI(), "")+uri;
           /* String url="https://images.nowcoder.com/images/20190920/8222772_1568947992119_9BD6C182BA1E0CCFB8045290C38272A1?x-oss-process=image/resize,m_mfit,h_100,w_100";*/
            urls[0]=url;
            map.put("errno", 0);
            map.put("data", urls);
        } else {
            map.put("error", -1);
            map.put("dta", urls);
        }
        return map;
    }

   /* @ApiOperation("接受上传图片")
    @PostMapping("/receivePicture")
    public String receivePicture(MultipartFile file, HttpServletRequest request) {
        String a="{\n" +
                "    // errno 即错误代码，0 表示没有错误。\n" +
                "    //       如果有错误，errno != 0，可通过下文中的监听函数 fail 拿到该错误码进行自定义处理\n" +
                "    \"errno\": 0,\n" +
                "\n" +
                "    // data 是一个数组，返回若干图片的线上地址\n" +
                "    \"data\": [\n" +
                "        \"图片1地址\",\n" +
                "        \"图片2地址\",\n" +
                "        \"……\"\n" +
                "    ]\n" +
                "}"
        return new String("");
    }*/
}
