package th.go.dxc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import th.go.dxc.share.security.model.DxcUserStatusType;
import th.go.dxc.share.security.util.DxcJwtAuthenticationConverter;

import static org.springframework.security.config.Customizer.withDefaults;

@Profile("sit")
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@Slf4j
public class SitSecurityConfig {

  public SitSecurityConfig() {
    log.info("Init {}", this.getClass().getName());
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring().requestMatchers(
      "/h2-console/**",
      "/mock/**"
    );
  }

  @Bean
  public SecurityFilterChain sitSecurityFilterChain(HttpSecurity http) throws Exception {
    http
      .cors(withDefaults())
      .csrf(csrf -> csrf.disable())
      .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/**").hasRole(DxcUserStatusType.ACCOUNT_ACTIVE.name())
        .anyRequest().permitAll()
      )
      .oauth2ResourceServer(oauth2 -> oauth2
        .jwt(jwt -> jwt.jwtAuthenticationConverter(new DxcJwtAuthenticationConverter()))
      );

    return http.build();
  }
}
