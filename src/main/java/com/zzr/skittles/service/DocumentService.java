package com.zzr.skittles.service;

import com.zzr.skittles.domain.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    public int addDocument(Document document);
    public int deleteDocument(int documentId);
    public int updateDocument(Document document);
    public Document selectDocument(int documentId);
    public List<Document> selectDocuments();
    public String savePicture(MultipartFile file);
}
