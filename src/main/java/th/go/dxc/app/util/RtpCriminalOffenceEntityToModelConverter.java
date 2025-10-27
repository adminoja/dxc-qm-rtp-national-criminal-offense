package th.go.dxc.app.util;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import th.go.dxc.app.model.RtpCriminalOffence;
import th.go.dxc.infra.datasource.policeraw.entity.RtpCriminalOffenceEntity;

@Mapper
public interface RtpCriminalOffenceEntityToModelConverter extends Converter<RtpCriminalOffenceEntity, RtpCriminalOffence>{
	public RtpCriminalOffence convert(RtpCriminalOffenceEntity source);
}
