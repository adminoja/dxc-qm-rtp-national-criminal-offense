package th.go.dxc.app.util;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import th.go.dxc.app.model.RtpNationalCriminalOffenceFilter;
import th.go.dxc.infra.datasource.policeraw.entity.RtpNationalCriminalOffenceEntityFilter;

@Mapper
public interface RtpNationalCriminalOffenceFilterToEntityFilterConverter extends Converter<RtpNationalCriminalOffenceFilter, RtpNationalCriminalOffenceEntityFilter> {
	public RtpNationalCriminalOffenceEntityFilter convert(RtpNationalCriminalOffenceFilter source);
}
