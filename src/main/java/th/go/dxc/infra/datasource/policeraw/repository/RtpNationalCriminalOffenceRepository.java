package th.go.dxc.infra.datasource.policeraw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import th.go.dxc.infra.datasource.policeraw.entity.RtpNationalCriminalOffenceEntity;
import th.go.dxc.infra.datasource.policeraw.entity.RtpNationalCriminalOffenceEntityFilter;

public interface RtpNationalCriminalOffenceRepository extends PagingAndSortingRepository<RtpNationalCriminalOffenceEntity, Integer>,
		QueryByExampleExecutor<RtpNationalCriminalOffenceEntity>, JpaSpecificationExecutor<RtpNationalCriminalOffenceEntity> {
	@Query(nativeQuery = true, 
			countQuery = "SELECT COUNT(*) FROM " + RtpNationalCriminalOffenceEntity.ENTITY_TABLE_NAME + " a "
				+ "where (:#{#filter.id} is null or a.id = :#{#filter.id})"
				+ "and (:#{#filter.regionNum} is null or a.region_num = :#{#filter.regionNum})"
				+ "and (:#{#filter.regionCode} is null or a.region_code = :#{#filter.regionCode})"
				+ "and (:#{#filter.policeProvinceNum} is null or a.police_provice_num = :#{#filter.policeProvinceNum})"
				+ "and (:#{#filter.policeProvinceName} is null or a.police_province_name = :#{#filter.policeProvinceName})"
				+ "and (:#{#filter.policeStationNum} is null or a.police_station_num = :#{#filter.policeStationNum})"
				+ "and (:#{#filter.policeStationName} is null or a.police_station_name = :#{#filter.policeStationName})"
				+ "and (:#{#filter.caseNum} is null or a.case_num = :#{#filter.caseNum})"
				+ "and (:#{#filter.caseYear} is null or a.case_year = :#{#filter.caseYear})"
				+ "and (:#{#filter.personType} is null or a.person_type = :#{#filter.personType})"
				+ "and (:#{#filter.sex} is null or a.sex = :#{#filter.sex})"
				+ "and (:#{#filter.age} is null or a.age = :#{#filter.age})"
				+ "and (:#{#filter.crimeYear} is null or a.crime_year = :#{#filter.crimeYear})"
				+ "and (:#{#filter.offenceName} is null or a.offence_name = :#{#filter.offenceName})"
				+ "and (:#{#filter.section} is null or a.section = :#{#filter.section})"
				+ "and (:#{#filter.penalty} is null or a.penalty = :#{#filter.penalty})"
				+ "and (:#{#filter.allegation} is null or a.allegation = :#{#filter.allegation})"
				+ "and (:#{#filter.subdistrict} is null or a.subdistrict = :#{#filter.subdistrict})"
				+ "and (:#{#filter.district} is null or a.district = :#{#filter.district})"
				+ "and (:#{#filter.province} is null or a.province = :#{#filter.province})"
				+ "and (:#{#filter.lawNum} is null or a.law_num = :#{#filter.lawNum})"
				+ "and (:#{#filter.lawName} is null or a.law_name = :#{#filter.lawName})"
				+ "and (:#{#filter.actionType} is null or a.action_type = :#{#filter.actionType})"
			, value = "SELECT * FROM " + RtpNationalCriminalOffenceEntity.ENTITY_TABLE_NAME + " a "
					+ "where (:#{#filter.id} is null or a.id = :#{#filter.id})"
					+ "and (:#{#filter.regionNum} is null or a.region_num = :#{#filter.regionNum})"
					+ "and (:#{#filter.regionCode} is null or a.region_code = :#{#filter.regionCode})"
					+ "and (:#{#filter.policeProvinceNum} is null or a.police_provice_num = :#{#filter.policeProvinceNum})"
					+ "and (:#{#filter.policeProvinceName} is null or a.police_province_name = :#{#filter.policeProvinceName})"
					+ "and (:#{#filter.policeStationNum} is null or a.police_station_num = :#{#filter.policeStationNum})"
					+ "and (:#{#filter.policeStationName} is null or a.police_station_name = :#{#filter.policeStationName})"
					+ "and (:#{#filter.caseNum} is null or a.case_num = :#{#filter.caseNum})"
					+ "and (:#{#filter.caseYear} is null or a.case_year = :#{#filter.caseYear})"
					+ "and (:#{#filter.personType} is null or a.person_type = :#{#filter.personType})"
					+ "and (:#{#filter.sex} is null or a.sex = :#{#filter.sex})"
					+ "and (:#{#filter.age} is null or a.age = :#{#filter.age})"
					+ "and (:#{#filter.crimeYear} is null or a.crime_year = :#{#filter.crimeYear})"
					+ "and (:#{#filter.offenceName} is null or a.offence_name = :#{#filter.offenceName})"
					+ "and (:#{#filter.section} is null or a.section = :#{#filter.section})"
					+ "and (:#{#filter.penalty} is null or a.penalty = :#{#filter.penalty})"
					+ "and (:#{#filter.allegation} is null or a.allegation = :#{#filter.allegation})"
					+ "and (:#{#filter.subdistrict} is null or a.subdistrict = :#{#filter.subdistrict})"
					+ "and (:#{#filter.district} is null or a.district = :#{#filter.district})"
					+ "and (:#{#filter.province} is null or a.province = :#{#filter.province})"
					+ "and (:#{#filter.lawNum} is null or a.law_num = :#{#filter.lawNum})"
					+ "and (:#{#filter.lawName} is null or a.law_name = :#{#filter.lawName})"
					+ "and (:#{#filter.actionType} is null or a.action_type = :#{#filter.actionType})"
			)
	public Page<RtpNationalCriminalOffenceEntity> findByFilterNative(RtpNationalCriminalOffenceEntityFilter filter, Pageable pageable);
	
}
