package th.go.dxc.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import th.go.dxc.app.model.RtpNationalCriminalOffence;
import th.go.dxc.app.model.RtpNationalCriminalOffenceFilter;

public interface RtpNationalCriminalOffenceService {

	Page<RtpNationalCriminalOffence> findAll(RtpNationalCriminalOffenceFilter filter, Pageable pageable);

}
