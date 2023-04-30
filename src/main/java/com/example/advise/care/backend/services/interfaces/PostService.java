package com.example.advise.care.backend.services.interfaces;

import com.example.advise.care.backend.dtos.requests.PostRequestDto;
import com.example.advise.care.backend.dtos.responses.PostResponseDto;

import java.util.List;

public interface PostService {
    public PostResponseDto createPost(String doctorId, PostRequestDto postRequestDto) throws Exception;

    public String deletePost(String doctorId, String postId) throws Exception;

    public List<PostResponseDto> getAllPosts() throws Exception;
}
