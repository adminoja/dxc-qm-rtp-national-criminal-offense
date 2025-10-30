package th.go.dxc.app.model;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "ข้อมูลการกระทำผิดในคดีอาญาทั่วประเทศ")
public class RtpNationalCriminalOffence {

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
