package com.gulshan.expensetrackersvc.controller;

import com.gulshan.expensetrackersvc.dto.ProfileDto;
import com.gulshan.expensetrackersvc.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/createProfile")
    public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profileDto){
        ProfileDto createdProfile = profileService.createProfile(profileDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
    }
}
