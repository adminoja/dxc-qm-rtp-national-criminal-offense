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
import th.go.dxc.app.service.RtpCriminalOffenceService;
import th.go.dxc.app.service.RtpCriminalOffenceServiceImpl;
import th.go.dxc.app.util.RtpCriminalOffenceServiceImplMapper;
import th.go.dxc.infra.datasource.policeraw.repository.RtpCriminalOffenceRepository;
import th.go.dxc.share.security.service.SecurityService;
import th.go.dxc.share.security.service.SecurityServiceJwtImpl;

@Profile("stg")
@Configuration
@EnableScheduling
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = {"th.go.dxc"})
@Slf4j
public class StgAppConfig {
	public StgAppConfig() {
		super();
		log.info("Init {}",this.getClass().getName());
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
	public RtpCriminalOffenceService rtpCriminalOffenceService(RtpCriminalOffenceRepository repository ,RtpCriminalOffenceServiceImplMapper mapper) {
		return new RtpCriminalOffenceServiceImpl(repository, mapper);
	}
}
