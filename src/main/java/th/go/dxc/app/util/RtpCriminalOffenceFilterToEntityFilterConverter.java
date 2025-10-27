package th.go.dxc.app.util;

import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import th.go.dxc.app.model.RtpCriminalOffenceFilter;
import th.go.dxc.infra.datasource.policeraw.entity.RtpCriminalOffenceEntityFilter;

@Mapper
public interface RtpCriminalOffenceFilterToEntityFilterConverter extends Converter<RtpCriminalOffenceFilter, RtpCriminalOffenceEntityFilter> {
	public RtpCriminalOffenceEntityFilter convert(RtpCriminalOffenceFilter source);
}
