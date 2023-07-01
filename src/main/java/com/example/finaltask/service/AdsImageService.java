package com.example.finaltask.service;

import com.example.finaltask.model.entity.Ads;
import com.example.finaltask.model.entity.AdsImage;
import com.example.finaltask.repository.AdsRepository;
import com.example.finaltask.repository.AdsImageRepository;
import com.example.finaltask.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@Slf4j
public class AdsImageService {
    private final AdsImageRepository adsImageRepository;
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;

    public AdsImageService(AdsImageRepository adsImageRepository, AdsRepository adsRepository, UserRepository userRepository) {
        this.adsImageRepository = adsImageRepository;
        this.adsRepository = adsRepository;
        this.userRepository = userRepository;
    }

//    public byte[] saveImage(Ads ads, MultipartFile file, Authentication authentication) throws IOException {
//        log.info("Was invoked method to upload photo to ads with id {}");
//        if (file.isEmpty()) {
//            throw new IllegalArgumentException("File is empty");
//        }
//
//        AdsImage adsImageToSave = new AdsImage();
//        adsImageToSave.setUser(userRepository.findByLogin(authentication.getName()).orElseThrow());
//        adsImageToSave.setAds(ads);
//        adsImageToSave.setImage(file.getBytes());
//
//        adsImageRepository.save(adsImageToSave);
//        return adsImageToSave.getImage();
//    }
public byte[] saveImage(Integer id, MultipartFile file) throws IOException {
    log.info("Was invoked method to upload photo to ads with id {}", id);
    if (file.isEmpty()) {
        throw new IllegalArgumentException("File is empty");
    }
    Ads ads = adsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ads not found"));
    AdsImage imageToSave = new AdsImage();
    imageToSave.setId(id);
    imageToSave.setAds(ads);
    imageToSave.setPreview(file.getBytes());

//        imageToSave.setUser(userRepository.findById(ads.getAuthorId().getId()).get());
    System.out.println(ads);
    adsImageRepository.save(imageToSave);
    return imageToSave.getPreview();
}
    public byte[] getImage(int id) { //for AdsMapper
        log.info("Was invoked method to get image from ads with id {}", id);
        AdsImage image = adsImageRepository.findImageByAds_Id(id);
        System.out.println(image);
        if (isEmpty(image)) {
            throw new IllegalArgumentException("Image not found");
        }
        return adsImageRepository.findById(id).get().getPreview();
    }



}