package th.go.dxc.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import th.go.dxc.app.model.RtpCriminalOffence;
import th.go.dxc.app.model.RtpCriminalOffenceFilter;

public interface RtpCriminalOffenceService {

	Page<RtpCriminalOffence> findAll(RtpCriminalOffenceFilter filter, Pageable pageable);

}
