package com.zzr.skittles.controller;

import com.zzr.skittles.dao.DocumentMapper;
import com.zzr.skittles.domain.Document;
import com.zzr.skittles.result.CommonResult;
import com.zzr.skittles.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Api(tags = "对文档的操作")
@Controller
@ResponseBody
public class DocumentController {
    @Autowired
    DocumentService documentService;
    @ApiOperation("添加文档")
    @PostMapping("/addDocument")
    public CommonResult addDocument(@RequestBody Document document){
        int i = documentService.addDocument(document);
        if(i!=0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除一个文档")
    @PostMapping(value = "/deleteDocument", produces = "application/json")
    public CommonResult deleteDocument(@RequestBody Integer documentId){
        int i = documentService.deleteDocument(documentId);
        if(i!=0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("更新一个文档")
    @PostMapping("/updateDocument")
    public CommonResult updateDocument(@RequestBody Document document){
        int i = documentService.updateDocument(document);
        if(i!=0){
            return CommonResult.success();
        }else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("查找一个文档")
    @GetMapping("/selectDocument")
    public CommonResult selectDocument( int documentId){
        Document document = documentService.selectDocument(documentId);
        if(document!=null){
            return CommonResult.success(document);
        }else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("查找所有文档")
    @GetMapping("/selectDocuments")
    public CommonResult selectDocuments(){
        List<Document> documents = documentService.selectDocuments();
        if(documents!=null){
            return CommonResult.success(documents);
        }else {
            return CommonResult.failed();
        }
    }
}
