package com.example.advise.care.backend.transformers;

import com.example.advise.care.backend.dtos.responses.PostResponseDto;
import com.example.advise.care.backend.models.Post;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PostTransformer {
    public static PostResponseDto postEntityToPostResponseDto(Post post) {
        return PostResponseDto.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .imageUrl(post.getImageUrl())
                .postViews(post.getPostViewList().size())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
