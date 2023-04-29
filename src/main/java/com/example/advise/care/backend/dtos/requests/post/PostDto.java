package com.example.advise.care.backend.dtos.requests.post;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDto {

    String title;

    String body;

    String imageUrl;
}
