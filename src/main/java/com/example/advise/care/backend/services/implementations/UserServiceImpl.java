package com.example.advise.care.backend.services.implementations;

import com.example.advise.care.backend.dtos.requests.UserLoginRequestDto;
import com.example.advise.care.backend.dtos.responses.user.UserLoginResponseDto;
import com.example.advise.care.backend.exceptions.EmailIdNotFoundException;
import com.example.advise.care.backend.exceptions.UserNotFoundException;
import com.example.advise.care.backend.exceptions.WrongPasswordException;
import com.example.advise.care.backend.models.User;
import com.example.advise.care.backend.repositories.UserRepository;
import com.example.advise.care.backend.services.interfaces.UserService;
import com.example.advise.care.backend.transformers.UserTransformer;
import com.example.advise.care.backend.utilities.UserValidatorUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    HttpServletRequest request;

    @Override
    public UserLoginResponseDto userLogin(UserLoginRequestDto userLoginRequestDto) throws Exception {

        try{
            User user = userRepository.findByEmailId(userLoginRequestDto.getEmailId());

            if(UserValidatorUtil.validateUserPassword(userLoginRequestDto.getPassWord(), user.getPassword())) return UserTransformer.userEntityToUserLoginResponseDto(user);
        }
        catch (WrongPasswordException e) {
            throw new WrongPasswordException("Password is incorrect");
        }

        throw new EmailIdNotFoundException("Email not found");

    }

    public void sendEmail(String to, String subject, String body) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("advisecare256@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        message.setHeader("X-SES-CONFIGURATION-SET", "ConfigSet");
        message.saveChanges();

        javaMailSender.send(message);
    }

    public String getBaseUrl() {

        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    @Override
    public String userForgotPassword(String emailId) throws Exception {

        try {
            User user = userRepository.findByEmailId(emailId);

            String subject = "Reset Password";
            String body = "Please click the following link to reset your password:\n" +  getBaseUrl() + "/user/forgot-password/" + user.getId() + "/reset";

            sendEmail(emailId, subject, body);

            return "Password reset instructions sent to " + emailId;
        }
        catch (MessagingException e) {
            throw new MessagingException("Failed to send mail");
        }
        catch (Exception e) {
            throw new EmailIdNotFoundException("Email does not exist");
        }
    }

    @Override
    public String resetUserPassword(String id, String newPassword) throws Exception {

       try {
           User user = userRepository.findById(Integer.parseInt(id)).get();

           user.setPassword(newPassword);
           userRepository.save(user);

           return "You can now login using your new Password";
       }
       catch (NumberFormatException e) {
           throw new NumberFormatException("Wrong id format");
       } catch (Exception e) {
           throw new UserNotFoundException("User no found");
       }
    }
}
/*
TODO
-> handle sending realtime email
get base url
 */
