package th.go.dxc.app.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "เงื่อนไขการค้นหาข้อมูล")
public class RtpNationalCriminalOffenceFilter {
	
	@Parameter(description = "รหัสข้อมูล")
	private Integer id;
	@Parameter(description = "รหัส บช./ภ.")
	private Integer regionNum;
	@Parameter(description = "ชื่อย่อ บช./ภ.")
	private String regionCode;
	@Parameter(description = "รหัส บก./ภ.จว.")
	private Integer policeProvinceNum;
	@Parameter(description = "ชื่อย่อ บก./ภ.จว.")
	private String policeProvinceName;
	@Parameter(description = "รหัส สน./สภ./กก.")
	private Integer policeStationNum;
	@Parameter(description = "ชื่อย่อ สน./สภ./กก.")
	private String policeStationName;
	@Parameter(description = "เลขคดี")
	private Integer caseNum;
	@Parameter(description = "ปีคดี")
	private Integer caseYear;
	@Parameter(description = "สถานะตัวผู้ถูกกล่าวหา")
	private String personType;
	@Parameter(description = "เพศ")
	private String sex;
	@Parameter(description = "อายุ")
	private Integer age;
	@Parameter(description = "ปีที่เกิดเหตุ ( Ex.2559 )")
	private Integer crimeYear;
	@JsonIgnore
	@Parameter(description = "วันที่เกิดเหตุ")
	private LocalDateTime crimeDate;
	@JsonIgnore
	@Parameter(description = "เวลาที่เกิดเหตุ-เริ่มต้น")
	private LocalDateTime crimeTime;
	@Parameter(description = "ชื่อหมวด")
	private String offenceName;
	@Parameter(description = "มาตราข้อหา")
	private String section;
	@Parameter(description = "มาตราโทษ")
	private String penalty;
	@Parameter(description = "ชื่อข้อหา")
	private String allegation;
	@Parameter(description = "ชื่อตำบล")
	private String subdistrict;
	@Parameter(description = "ชื่ออำเภอ")
	private String district;
	@Parameter(description = "ชื่อจังหวัด")
	private String province;
	@Parameter(description = "รหัสข้อกฎหมาย")
	private String lawNum;
	@Parameter(description = "ชื่อข้อกฎหมาย")
	private String lawName;
	@Parameter(description = "คำนำหน้าข้อหา")
	private String actionType;
	@JsonIgnore
	@Parameter(description = "วันที่ - ใช้สำหรับเป็นเงื่อนไข")
	private LocalDateTime refDate;
}
