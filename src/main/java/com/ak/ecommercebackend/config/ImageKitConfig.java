package com.ak.ecommercebackend.config;

import io.imagekit.sdk.ImageKit;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import io.imagekit.sdk.config.Configuration;


@org.springframework.context.annotation.Configuration
public class ImageKitConfig {
    @Value("${imagekit.public-key}")
    private String publicKey;

    @Value("${imagekit.private-key}")
    private String privateKey;

    @Value("${imagekit.url-endpoint}")
    private String urlEndpoint;

    @PostConstruct
    public void init() {
        Configuration config = new Configuration(publicKey, privateKey, urlEndpoint);
        ImageKit.getInstance().setConfig(config);
    }
}
