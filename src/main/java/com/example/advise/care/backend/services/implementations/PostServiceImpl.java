package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.dtos.requests.PostRequestDto;
import com.example.advise.care.backend.dtos.responses.PostResponseDto;
import com.example.advise.care.backend.models.Doctor;
import com.example.advise.care.backend.models.Post;
import com.example.advise.care.backend.models.User;
import com.example.advise.care.backend.repositories.DoctorRepository;
import com.example.advise.care.backend.repositories.PostRepository;
import com.example.advise.care.backend.services.interfaces.CloudinaryService;
import com.example.advise.care.backend.services.interfaces.PostService;
import com.example.advise.care.backend.transformers.PostTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    CloudinaryService cloudinaryService = new CloudinaryServiceImpl("${CLOUD_NAME}", "${API_KEY}","${API_SECRET}");

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public PostResponseDto createPost(PostRequestDto postRequestDto) throws Exception {

        try {
            String imageUrl = null;

            if (postRequestDto.getFile() != null) {
                imageUrl = cloudinaryService.uploadImage(postRequestDto.getFile());
            }

            Post post = Post.builder()
                    .title(postRequestDto.getTitle())
                    .imageUrl(imageUrl)
                    .body(postRequestDto.getBody())
                    .build();

//            Doctor doctor = doctorRepository.findById(Integer.parseInt(doctorId)).get();
//            User user;
//            user.



//            post.setAuthor(doctor);
//            doctorRepository.save(doctor);
            postRepository.save(post);

            return PostTransformer.postEntityToPostResponseDto(post);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong id format");
        }
    }

    @Override
    public String deletePost(String doctorId, String postId) throws Exception {
        return null;
    }

    @Override
    public List<PostResponseDto> getAllPosts() throws Exception {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        for (Post post: posts) {
            PostResponseDto postResponseDto = PostTransformer.postEntityToPostResponseDto(post);

            postResponseDtos.add(postResponseDto);
        }

        postResponseDtos.sort((a, b) -> {
            return b.getCreatedAt().compareTo(a.getCreatedAt());
        });

        return postResponseDtos;
    }
}
