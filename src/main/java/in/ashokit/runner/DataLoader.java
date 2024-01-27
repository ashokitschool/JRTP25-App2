package in.ashokit.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.City;
import in.ashokit.entity.Country;
import in.ashokit.entity.State;
import in.ashokit.repository.CityRepo;
import in.ashokit.repository.CountryRepo;
import in.ashokit.repository.StateRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private StateRepo stateRepo;

	@Autowired
	private CityRepo cityRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		countryRepo.deleteAll();
		stateRepo.deleteAll();
		cityRepo.deleteAll();

		Country c1 = new Country(1, "India");
		Country c2 = new Country(2, "USA");

		countryRepo.saveAll(Arrays.asList(c1, c2));

		State s1 = new State(1, "AP", 1);
		State s2 = new State(2, "TG", 1);

		State s3 = new State(3, "Texas", 2);
		State s4 = new State(4, "New Jersey", 2);

		stateRepo.saveAll(Arrays.asList(s1, s2, s3, s4));

		City city1 = new City(1, "Guntur", 1);
		City city2 = new City(2, "Vijag", 1);

		City city3 = new City(3, "Hyd", 2);
		City city4 = new City(4, "Warangal", 2);

		City city5 = new City(5, "Texas-1", 3);
		City city6 = new City(6, "Texas-2", 3);

		City city7 = new City(7, "NJ-1", 4);
		City city8 = new City(8, "NJ-2", 4);

		cityRepo.saveAll(Arrays.asList(city1, city2, city3, city4, city5, city6, city7, city8));

	}

}
