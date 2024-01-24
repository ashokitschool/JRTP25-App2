package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.City;

public interface CityRepo extends JpaRepository<City, Integer> {

}
