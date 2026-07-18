package com.booking.flight.security;

import com.booking.flight.entity.AuthProvider;
import com.booking.flight.entity.Role;
import com.booking.flight.entity.User;
import com.booking.flight.repository.UserRepository;
import com.booking.flight.service.CustomUserDetailsService;
import com.booking.flight.service.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHanlder implements AuthenticationSuccessHandler {

    private final UserRepository repository;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("===== Oauth success ======");
       if(oAuth2User != null) {
           String email = oAuth2User.getAttribute("email");
           String name = oAuth2User.getAttribute("name");
           String picture = oAuth2User.getAttribute("picture");

           User user = repository.findByEmail(email)
                   .orElseGet(() ->
                           repository.save(
                                   User.builder()
                                           .email(email)
                                           .name(name)
                                           .picture(picture)
                                           .provider(AuthProvider.GOOGLE)
                                           .role(Role.ROLE_USER)
                                           .build()
                           )
                   );

           UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());

           String jwt = jwtService.generateToken(userDetails);

           System.out.println("Token : "+jwt);
           System.out.println("Redirecting to: http://localhost:4200/home?token=" + jwt);
           response.sendRedirect(
                   "http://localhost:4200/home?token=" + jwt
           );

        /*   response.setContentType("application/json");
           response.getWriter().write("""
                   {
                   "token":"%s"
                   }
                   """.formatted(jwt));

           response.getWriter().flush();*/
           System.out.println("Response is sent to front end");
       }
       else{
           log.info("oAuth2User is null");
           System.out.println("oAuth2User is null");
       }

    }
}
