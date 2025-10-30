package th.go.dxc.app.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "เงื่อนไขการค้นหาข้อมูล")
public class RtpNationalCriminalOffenceFilter {
	
	@Schema(description = "รหัสข้อมูล")
	private Integer id;
	@Schema(description = "รหัส บช./ภ.")
	private Integer regionNum;
	@Schema(description = "ชื่อย่อ บช./ภ.")
	private String regionCode;
	@Schema(description = "รหัส บก./ภ.จว.")
	private Integer policeProvinceNum;
	@Schema(description = "ชื่อย่อ บก./ภ.จว.")
	private String policeProvinceName;
	@Schema(description = "รหัส สน./สภ./กก.")
	private Integer policeStationNum;
	@Schema(description = "ชื่อย่อ สน./สภ./กก.")
	private String policeStationName;
	@Schema(description = "เลขคดี")
	private Integer caseNum;
	@Schema(description = "ปีคดี")
	private Integer caseYear;
	@Schema(description = "สถานะตัวผู้ถูกกล่าวหา")
	private String personType;
	@Schema(description = "เพศ")
	private String sex;
	@Schema(description = "อายุ")
	private Integer age;
	@Schema(description = "ปีที่เกิดเหตุ ( Ex.2559 )")
	private Integer crimeYear;
	@JsonIgnore
	@Schema(description = "วันที่เกิดเหตุ")
	private LocalDateTime crimeDate;
	@JsonIgnore
	@Schema(description = "เวลาที่เกิดเหตุ-เริ่มต้น")
	private LocalDateTime crimeTime;
	@Schema(description = "ชื่อหมวด")
	private String offenceName;
	@Schema(description = "มาตราข้อหา")
	private String section;
	@Schema(description = "มาตราโทษ")
	private String penalty;
	@Schema(description = "ชื่อข้อหา")
	private String allegation;
	@Schema(description = "ชื่อตำบล")
	private String subdistrict;
	@Schema(description = "ชื่ออำเภอ")
	private String district;
	@Schema(description = "ชื่อจังหวัด")
	private String province;
	@Schema(description = "รหัสข้อกฎหมาย")
	private String lawNum;
	@Schema(description = "ชื่อข้อกฎหมาย")
	private String lawName;
	@Schema(description = "คำนำหน้าข้อหา")
	private String actionType;
	@JsonIgnore
	@Schema(description = "วันที่ - ใช้สำหรับเป็นเงื่อนไข")
	private LocalDateTime refDate;
}
