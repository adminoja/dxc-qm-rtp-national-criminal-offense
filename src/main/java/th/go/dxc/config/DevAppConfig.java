package th.go.dxc.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import th.go.dxc.app.service.RtpNationalCriminalOffenceService;
import th.go.dxc.app.service.RtpNationalCriminalOffenceServiceImpl;
import th.go.dxc.app.util.RtpNationalCriminalOffenceServiceImplMapper;
import th.go.dxc.infra.datasource.policeraw.repository.RtpNationalCriminalOffenceRepository;
import th.go.dxc.share.security.service.SecurityService;
import th.go.dxc.share.security.service.SecurityServiceJwtImpl;

@Profile("dev")
@Configuration
@EnableScheduling
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = {"th.go.dxc"})
@Slf4j
public class DevAppConfig {
	public DevAppConfig() {
		super();
		log.info("Init {}",DevAppConfig.class.getName());
	}

	@Bean
	public MapperFactory mapperFactory() {
		return new DefaultMapperFactory.Builder().build();
	}
	
	@Bean
	public SecurityService securityService() {
		return new SecurityServiceJwtImpl();
	}
	
	@Bean
	public RtpNationalCriminalOffenceService rtpNationalCriminalOffenceService(RtpNationalCriminalOffenceRepository repository ,RtpNationalCriminalOffenceServiceImplMapper mapper) {
		return new RtpNationalCriminalOffenceServiceImpl(repository, mapper);
	}

}
