package th.go.dxc.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.extern.slf4j.Slf4j;
import th.go.dxc.app.model.RtpNationalCriminalOffence;
import th.go.dxc.app.model.RtpNationalCriminalOffenceFilter;
import th.go.dxc.app.util.RtpNationalCriminalOffenceServiceImplMapper;
import th.go.dxc.infra.datasource.policeraw.entity.RtpNationalCriminalOffenceEntity;
import th.go.dxc.infra.datasource.policeraw.entity.RtpNationalCriminalOffenceEntityFilter;
import th.go.dxc.infra.datasource.policeraw.repository.RtpNationalCriminalOffenceRepository;

@Slf4j
public class RtpNationalCriminalOffenceServiceImpl implements RtpNationalCriminalOffenceService {
	
	private final RtpNationalCriminalOffenceRepository repository;
	private final RtpNationalCriminalOffenceServiceImplMapper mapper;
	
	public RtpNationalCriminalOffenceServiceImpl(RtpNationalCriminalOffenceRepository repository ,RtpNationalCriminalOffenceServiceImplMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Page<RtpNationalCriminalOffence> findAll(RtpNationalCriminalOffenceFilter filter, Pageable pageable) {
		RtpNationalCriminalOffenceEntityFilter entityFilter = mapper.mapEntityFilter(filter);
		Pageable entityPageable = mapper.mapEntityPageable(pageable);
		Page<RtpNationalCriminalOffenceEntity> entityPage = repository.findByFilterNative(entityFilter, entityPageable);
		Page<RtpNationalCriminalOffence> resultPage = mapper.mapModelPage(entityPage);
		if (log.isDebugEnabled()) log.debug("RtpCriminalOffence findAll: {}", entityPage);
		return resultPage;
	}
	
}
