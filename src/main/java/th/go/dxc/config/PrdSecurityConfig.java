package th.go.dxc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Profile("prd")
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@Slf4j
public class PrdSecurityConfig {

  public PrdSecurityConfig() {
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
  public SecurityFilterChain prdSecurityFilterChain(HttpSecurity http) throws Exception {
    http
      .securityMatcher("/services/**", "/api/**")
      .cors(withDefaults())
      .csrf(csrf -> csrf.disable())
      .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

      .authorizeHttpRequests(auth -> auth
        // ✅ Boot 4 safe (no "**" in middle)
        .requestMatchers("/services/*/v2/api-docs").permitAll()

        .requestMatchers("/api/**").authenticated()
        .anyRequest().permitAll()
      )
      .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));

    return http.build();
  }
}
