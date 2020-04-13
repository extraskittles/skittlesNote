package com.zzr.skittles.service.serviceImpl;

import com.zzr.skittles.dao.DocumentMapper;
import com.zzr.skittles.domain.Document;
import com.zzr.skittles.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
