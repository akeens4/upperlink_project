package com.project.upperlink.service;

import com.project.upperlink.exception.StopFileSavingException;
import com.project.upperlink.model.UpperlinkUser;
import com.project.upperlink.registration.ConfirmationToken;
import com.project.upperlink.repository.UpperlinkUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UpperlinkUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final UpperlinkUserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            return userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException(
                            String.format(USER_NOT_FOUND_MSG,email)));
    }

    public String signUpUser(UpperlinkUser upperlinkUser) throws StopFileSavingException {
        boolean userExists = userRepository
                .findByEmail(upperlinkUser.getEmail())
                .isPresent();

     //   int myInt = userRepository.findByEmail(upperlinkUser.getEmail()).
        if(userExists){

            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(upperlinkUser.getPassword());

        upperlinkUser.setPassword(encodedPassword);

            userRepository.save(upperlinkUser);

        String token = UUID.randomUUID().toString();
        //TODO: Send confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(45),
                upperlinkUser
        );

        confirmationTokenService.saveConfirmationToken(
                confirmationToken
        );

        // TODO SEND EMAIL

        return token;
    }

    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }

}
