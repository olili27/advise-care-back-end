package com.example.advise.care.backend.services.implementations;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.advise.care.backend.services.interfaces.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(String cloudName, String apiKey, String apiSecret) {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }
    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        try {
            Map<String, Object> params = ObjectUtils.asMap(
                    "public_id", file.getOriginalFilename(),
                    "overwrite", true
            );

            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), params);

            return (String) uploadResult.get("url");
        } catch (IOException e) {
            throw new IOException("Failed to upload image to Cloudinary", e);
        }
    }
}
