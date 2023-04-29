package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.dtos.requests.post.PostDto;
import com.example.advise.care.backend.models.Doctor;
import com.example.advise.care.backend.models.Post;
import com.example.advise.care.backend.models.User;
import com.example.advise.care.backend.repositories.DoctorRepository;
import com.example.advise.care.backend.services.interfaces.CloudinaryService;
import com.example.advise.care.backend.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public PostDto createPost(String doctorId, PostDto postDto) throws Exception {

        try {
            String imageUrl = null;

            if (postDto.getFile() != null) {
                imageUrl = cloudinaryService.uploadImage(postDto.getFile());
            }

            Post post = Post.builder()
                    .title(postDto.getTitle())
                    .imageUrl(imageUrl)
                    .body(postDto.getBody())
                    .build();

            Doctor doctor = doctorRepository.findById(Integer.parseInt(doctorId)).get();

            post.setAuthor(doctor);
            doctorRepository.save(doctor);

            return postDto;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong id format");
        }



    }
}
