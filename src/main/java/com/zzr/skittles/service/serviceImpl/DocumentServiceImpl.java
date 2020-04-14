package com.zzr.skittles.service.serviceImpl;

import com.zzr.skittles.dao.DocumentMapper;
import com.zzr.skittles.domain.Document;
import com.zzr.skittles.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentMapper documentMapper;
    @Override
    public int addDocument(Document document) {
       return documentMapper.insertSelective(document);
    }

    @Override
    public int deleteDocument(int documentId) {
        return documentMapper.deleteByPrimaryKey(documentId);
    }

    @Override
    public int updateDocument(Document document) {
        return documentMapper.updateByPrimaryKeySelective(document);
    }

    @Override
    public Document selectDocument(int documentId) {
        return documentMapper.selectByPrimaryKey(documentId);
    }

    @Override
    public List<Document> selectDocuments() {
        return documentMapper.selectAll();
    }

    @Override
    public String savePicture(MultipartFile file) {
        final String dirPath="/static/userPicture/";
        final String dirPath2="/userPicture/";
        String url=null;
            if (file != null){
                // 原始文件名
                String originalFileName = file.getOriginalFilename();
                // 获取图片后缀
                String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
                // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
                String fileName = UUID.randomUUID().toString() + suffix;

                String projectPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
                String filePath = projectPath+dirPath+fileName;
                File saveFile = new File(filePath);
                try {
                    // 将上传的文件保存到服务器文件系统
                    file.transferTo(saveFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                 url=dirPath2+fileName;
            }
        return url;
    }
}
