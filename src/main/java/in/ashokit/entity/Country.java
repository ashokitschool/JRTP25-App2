package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "COUNTRY_MASTER")
public class Country {

	@Id
	private Integer countryId;

	private String countryName;

	public Country() {
	}

	public Country(Integer countryId, String countryName) {
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
