package th.go.dxc.app.util;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import th.go.dxc.app.model.RtpNationalCriminalOffence;
import th.go.dxc.app.model.RtpNationalCriminalOffenceFilter;
import th.go.dxc.infra.datasource.policeraw.entity.RtpNationalCriminalOffenceEntity;
import th.go.dxc.infra.datasource.policeraw.entity.RtpNationalCriminalOffenceEntityFilter;
import th.go.dxc.share.commons.util.ObjectMapperService;

@Component
public class RtpNationalCriminalOffenceServiceImplMapper {
	
	private final ObjectMapperService mapper;
	
	public RtpNationalCriminalOffenceServiceImplMapper(ObjectMapperService mapper) {
		super();
		this.mapper = mapper;
	}
	
	public Pageable mapEntityPageable(Pageable pageable) {
		return pageable;
	}
	
	public Page<RtpNationalCriminalOffence> mapModelPage(Page<RtpNationalCriminalOffenceEntity> entityPage) {
		return mapper.mapPage(entityPage, RtpNationalCriminalOffence.class);
	}
	
	public RtpNationalCriminalOffenceEntityFilter mapEntityFilter(RtpNationalCriminalOffenceFilter filter) {
		return mapper.map(filter, RtpNationalCriminalOffenceEntityFilter.class);
	}
	
	public List<RtpNationalCriminalOffence> mapAsList(List<RtpNationalCriminalOffenceEntity> entityList) {
		return mapper.mapAsList(entityList, RtpNationalCriminalOffence.class);
	}
}
