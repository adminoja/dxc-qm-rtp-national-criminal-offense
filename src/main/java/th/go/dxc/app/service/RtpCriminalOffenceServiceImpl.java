package th.go.dxc.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.extern.slf4j.Slf4j;
import th.go.dxc.app.model.RtpCriminalOffence;
import th.go.dxc.app.model.RtpCriminalOffenceFilter;
import th.go.dxc.app.util.RtpCriminalOffenceServiceImplMapper;
import th.go.dxc.infra.datasource.policeraw.entity.RtpCriminalOffenceEntity;
import th.go.dxc.infra.datasource.policeraw.entity.RtpCriminalOffenceEntityFilter;
import th.go.dxc.infra.datasource.policeraw.repository.RtpCriminalOffenceRepository;

@Slf4j
public class RtpCriminalOffenceServiceImpl implements RtpCriminalOffenceService {
	
	private final RtpCriminalOffenceRepository repository;
	private final RtpCriminalOffenceServiceImplMapper mapper;
	
	public RtpCriminalOffenceServiceImpl(RtpCriminalOffenceRepository repository ,RtpCriminalOffenceServiceImplMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Page<RtpCriminalOffence> findAll(RtpCriminalOffenceFilter filter, Pageable pageable) {
		RtpCriminalOffenceEntityFilter entityFilter = mapper.mapEntityFilter(filter);
		Pageable entityPageable = mapper.mapEntityPageable(pageable);
		Page<RtpCriminalOffenceEntity> entityPage = repository.findByFilterNative(entityFilter, entityPageable);
		Page<RtpCriminalOffence> resultPage = mapper.mapModelPage(entityPage);
		if (log.isDebugEnabled()) log.debug("RtpCriminalOffence findAll: {}", entityPage);
		return resultPage;
	}
	
}
