package com.gulshan.expensetrackersvc.service;

import com.gulshan.expensetrackersvc.dto.ProfileDto;
import com.gulshan.expensetrackersvc.entity.ProfileEntity;
import com.gulshan.expensetrackersvc.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDto createProfile(ProfileDto profileDto){
        ProfileEntity newProfileEntity = toEntity(profileDto);
        newProfileEntity.setActivationToken(UUID.randomUUID().toString());
        newProfileEntity = profileRepository.save(newProfileEntity);
        return  toDto(newProfileEntity);
    }

    public ProfileEntity toEntity(ProfileDto profileDto){
        return ProfileEntity.builder()
                .id(profileDto.getId())
                .fullName(profileDto.getFullName())
                .email(profileDto.getEmail())
                .password(profileDto.getPassword())
                .profileImageUrl(profileDto.getProfileImageUrl())
                .createAt(profileDto.getCreateAt())
                .updatedAt(profileDto.getUpdatedAt())
                .build();
    }

    public ProfileDto toDto(ProfileEntity profileEntity){
        return ProfileDto.builder()
                .id(profileEntity.getId())
                .fullName(profileEntity.getFullName())
                .email(profileEntity.getEmail())
                .profileImageUrl(profileEntity.getProfileImageUrl())
                .createAt(profileEntity.getCreateAt())
                .updatedAt(profileEntity.getUpdatedAt())
                .build();
    }



}
