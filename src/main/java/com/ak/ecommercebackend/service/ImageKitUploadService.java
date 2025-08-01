package com.ak.ecommercebackend.service;

import com.ak.ecommercebackend.exception.ImageUploadException;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.results.Result;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ImageKitUploadService implements ImageUploadService {

    @Override
    public String uploadImage(MultipartFile multipartFile) throws IOException {
        try {
            byte[] bytes = multipartFile.getBytes();
            String base64 = Base64.getEncoder().encodeToString(bytes);
            String fileName = multipartFile.getOriginalFilename();

            FileCreateRequest fileCreateRequest = new FileCreateRequest(base64, fileName);
            fileCreateRequest.setFileName(fileName);

            Result result = ImageKit.getInstance().upload(fileCreateRequest);

            return result.getUrl();

        } catch (BadRequestException |
                 InternalServerException |
                 UnauthorizedException |
                 ForbiddenException |
                 TooManyRequestsException |
                 UnknownException e) {
            throw new ImageUploadException("Failed to upload image to ImageKit", e);
        }
    }
}
