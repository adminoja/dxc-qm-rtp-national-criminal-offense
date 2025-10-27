package th.go.dxc.app.util;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import th.go.dxc.app.model.RtpCriminalOffence;
import th.go.dxc.app.model.RtpCriminalOffenceFilter;
import th.go.dxc.infra.datasource.policeraw.entity.RtpCriminalOffenceEntity;
import th.go.dxc.infra.datasource.policeraw.entity.RtpCriminalOffenceEntityFilter;
import th.go.dxc.share.commons.util.ObjectMapperService;

@Component
public class RtpCriminalOffenceServiceImplMapper {
	
	private final ObjectMapperService mapper;
	
	public RtpCriminalOffenceServiceImplMapper(ObjectMapperService mapper) {
		super();
		this.mapper = mapper;
	}
	
	public Pageable mapEntityPageable(Pageable pageable) {
		return pageable;
	}
	
	public Page<RtpCriminalOffence> mapModelPage(Page<RtpCriminalOffenceEntity> entityPage) {
		return mapper.mapPage(entityPage, RtpCriminalOffence.class);
	}
	
	public RtpCriminalOffenceEntityFilter mapEntityFilter(RtpCriminalOffenceFilter filter) {
		return mapper.map(filter, RtpCriminalOffenceEntityFilter.class);
	}
	
	public List<RtpCriminalOffence> mapAsList(List<RtpCriminalOffenceEntity> entityList) {
		return mapper.mapAsList(entityList, RtpCriminalOffence.class);
	}
}
