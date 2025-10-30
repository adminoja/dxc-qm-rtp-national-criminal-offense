package th.go.dxc.app.util;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import th.go.dxc.app.model.RtpNationalCriminalOffence;
import th.go.dxc.infra.datasource.policeraw.entity.RtpNationalCriminalOffenceEntity;

@Mapper
public interface RtpNationalCriminalOffenceEntityToModelConverter extends Converter<RtpNationalCriminalOffenceEntity, RtpNationalCriminalOffence>{
	public RtpNationalCriminalOffence convert(RtpNationalCriminalOffenceEntity source);
}
