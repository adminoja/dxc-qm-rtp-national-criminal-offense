package th.go.dxc.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Profile("dev")
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@Slf4j
public class DevSecurityConfig {

	public DevSecurityConfig() {
		log.info("Init {}", DevSecurityConfig.class.getName());
	}

	/**
	 * Completely bypass Spring Security for dev-only endpoints.
	 * (Equivalent to old web.ignoring().antMatchers(...))
	 */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers(
				"/h2-console/**",
				"/mock/**");
	}

	/**
	 * Applies ONLY to /services/** and /api/** (like old
	 * requestMatchers().antMatchers(...))
	 */
	@Bean
	public SecurityFilterChain devSecurityFilterChain(HttpSecurity http) throws Exception {

		http
				.securityMatcher("/services/**", "/api/**")

				.cors(withDefaults())
				.csrf(csrf -> csrf.disable())
				.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.authorizeHttpRequests(auth -> auth
						// ✅ Boot 4 PathPatternParser-safe (no "**" in the middle)
						.requestMatchers("/services/*/v3/api-docs").permitAll()

						// optional if you also expose root docs or swagger ui (uncomment if needed)
						// .requestMatchers("/v3/api-docs/**", "/swagger-ui/**",
						// "/swagger-ui.html").permitAll()

						.requestMatchers("/api/**").authenticated()
						.anyRequest().permitAll())

				.oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));

		// if H2 console UI is used and you see frame blocking, you may also need:
		// http.headers(h -> h.frameOptions(f -> f.sameOrigin()));

		return http.build();
	}
}
