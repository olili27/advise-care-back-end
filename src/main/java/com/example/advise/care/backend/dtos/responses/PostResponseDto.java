package com.example.advise.care.backend.dtos.responses;

import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Valid
public class PostResponseDto {

    String title;

    String body;

    String imageUrl;

    int postViews;

    Date createdAt;
}
