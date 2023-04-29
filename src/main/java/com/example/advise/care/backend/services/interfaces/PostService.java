package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.post.PostDto;

public interface PostService {
    public PostDto createPost(String doctorId, PostDto postDto) throws Exception;
}
