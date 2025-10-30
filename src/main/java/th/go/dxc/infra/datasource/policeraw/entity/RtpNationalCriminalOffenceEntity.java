package th.go.dxc.infra.datasource.policeraw.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = RtpNationalCriminalOffenceEntity.ENTITY_TABLE_NAME)
public class RtpNationalCriminalOffenceEntity {

	public static final String ENTITY_TABLE_NAME = "rtp_criminal_offence";

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "region_num")
	private Integer regionNum;

	@Column(name = "region_code")
	private String regionCode;

	@Column(name = "police_provice_num")
	private Integer policeProvinceNum;

	@Column(name = "police_province_name")
	private String policeProvinceName;

	@Column(name = "police_station_num")
	private Integer policeStationNum;

	@Column(name = "police_station_name")
	private String policeStationName;

	@Column(name = "case_num")
	private Integer caseNum;

	@Column(name = "case_year")
	private Integer caseYear;

	@Column(name = "person_type")
	private String personType;

	@Column(name = "sex")
	private String sex;

	@Column(name = "age")
	private Integer age;

	@Column(name = "crime_year")
	private Integer crimeYear;

	@Column(name = "crime_date")
	private LocalDateTime crimeDate;

	@Column(name = "crime_time")
	private LocalDateTime crimeTime;

	@Column(name = "offence_name")
	private String offenceName;

	@Column(name = "section")
	private String section;

	@Column(name = "penalty")
	private String penalty;

	@Column(name = "allegation")
	private String allegation;

	@Column(name = "subdistrict")
	private String subdistrict;

	@Column(name = "district")
	private String district;

	@Column(name = "province")
	private String province;

	@Column(name = "law_num")
	private String lawNum;

	@Column(name = "law_name")
	private String lawName;

	@Column(name = "action_type")
	private String actionType;

	@Column(name = "ref_date")
	private LocalDateTime refDate;
}
