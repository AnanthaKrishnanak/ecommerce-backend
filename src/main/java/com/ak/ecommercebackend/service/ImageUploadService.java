package com.ak.ecommercebackend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageUploadService {
    public String uploadImage(MultipartFile file) throws IOException;
}
