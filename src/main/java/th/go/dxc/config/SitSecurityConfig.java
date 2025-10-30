package th.go.dxc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;
import th.go.dxc.share.security.model.DxcUserStatusType;
import th.go.dxc.share.security.util.DxcJwtAuthenticationConverter;

@Profile("sit")
@Configuration
@Slf4j
public class SitSecurityConfig extends WebSecurityConfigurerAdapter {

	public SitSecurityConfig() {
		super();
		log.info("Init {}", this.getClass().getName());
	}

	public SitSecurityConfig(boolean disableDefaults) {
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
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()		
		.authorizeRequests(authz -> 
			authz
			.antMatchers("/api/**").hasRole(DxcUserStatusType.ACCOUNT_ACTIVE.name())
//			.antMatchers("/api/**").authenticated()
			.anyRequest().permitAll()
		)
		.oauth2ResourceServer(oauth2 -> oauth2
				.jwt()
				.jwtAuthenticationConverter(new DxcJwtAuthenticationConverter())
				);
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.csrf(csrf -> csrf.disable())
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.authorizeHttpRequests(authz -> authz
//						.requestMatchers("/api/**").hasRole(DxcUserStatusType.ACCOUNT_ACTIVE.name())
//						.anyRequest().permitAll()
//				)
//				.oauth2ResourceServer(oauth2 -> oauth2
//						.jwt(jwt -> jwt.jwtAuthenticationConverter(new DxcJwtAuthenticationConverter())));
//		return http.build();
//	}
//
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return web -> web.ignoring().requestMatchers("/h2-console/**", "/mock/**");
//	}
}
