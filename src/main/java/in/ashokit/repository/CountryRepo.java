package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{

}
