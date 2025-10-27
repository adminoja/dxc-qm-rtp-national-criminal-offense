package th.go.dxc.infra.datasource.policeraw.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RtpCriminalOffenceEntityFilter {
	
	private Integer id;
	private Integer regionNum;
	private String regionCode;
	private Integer policeProvinceNum;
	private String policeProvinceName;
	private Integer policeStationNum;
	private String policeStationName;
	private Integer caseNum;
	private Integer caseYear;
	private String personType;
	private String sex;
	private Integer age;
	private Integer crimeYear;
	private LocalDateTime crimeDate;
	private LocalDateTime crimeTime;
	private String offenceName;
	private String section;
	private String penalty;
	private String allegation;
	private String subdistrict;
	private String district;
	private String province;
	private String lawNum;
	private String lawName;
	private String actionType;
	private LocalDateTime refDate;
}
