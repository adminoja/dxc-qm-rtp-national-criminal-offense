package th.go.dxc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;
import th.go.dxc.share.security.model.DxcUserStatusType;
import th.go.dxc.share.security.util.DxcJwtAuthenticationConverter;

@Profile("prd")
@Configuration
@Slf4j
public class PrdSecurityConfig extends WebSecurityConfigurerAdapter {

	public PrdSecurityConfig() {
		super();
		log.info("Init {}", this.getClass().getName());
	}

	public PrdSecurityConfig(boolean disableDefaults) {
		super(disableDefaults);
		log.info("Init {}",this.getClass().getName());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers(
//				"/favicon.ico"
//				,"/favicon.*"
//				,"/icon.svg"
//				,"/apple-touch-icon.png"
//				,"/manifest.webmanifest"
//				, "/index.html"
//				,"/swagger-ui"
//				,"/swagger-ui/**"
//				, "/actuator/**"
//				, "/v3/api-docs/**"
				"/h2-console/**"
				,"/mock/**"
//				,"/error/**"
				);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and()
		.csrf().disable()
		.requestMatchers().antMatchers("/services/**","/api/**").and()
		.authorizeRequests(authz ->
			authz
			.antMatchers("/services/**/v2/api-docs").permitAll()
			.antMatchers("/api/**").authenticated()
			.anyRequest().permitAll()
		)
		.oauth2ResourceServer(oauth2 -> oauth2
			.jwt()
		);
	}

	/**
	 * Security Filter Chain
	 */
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//				// เปิด CORS
//				.cors(Customizer.withDefaults())
//
//				// ปิด CSRF ถ้าใช้ JWT
//				.csrf(csrf -> csrf.disable())
//
//				// การกำหนดสิทธิ์
//				.authorizeHttpRequests(auth -> auth
//						// อนุญาต Swagger หรือ Health endpoint
//						.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/actuator/health")
//						.permitAll()
//
//						// API หลักที่ต้องล็อกอิน
//						.requestMatchers("/api/**", "/services/**").authenticated()
//
//						// อื่น ๆ อนุญาตทั้งหมด
//						.anyRequest().permitAll())
//
//				// ใช้ JWT Resource Server
//				.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
//
//				// ไม่มี session (stateless)
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//		return http.build();
//	}
//
//	/**
//	 * Web Security Customizer to ignore certain paths
//	 */
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return web -> web.ignoring().requestMatchers("/h2-console/**", "/mock/**"
//		// Add more paths to ignore if needed
//		);
//	}

}
