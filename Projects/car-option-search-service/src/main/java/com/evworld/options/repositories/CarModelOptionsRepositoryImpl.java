package com.evworld.options.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.evworld.options.models.CarModelOptions;
import com.evworld.options.models.CarOption;

import static com.evworld.options.models.CarOption.*;

@Component
public class CarModelOptionsRepositoryImpl implements CarModelOptionsRepository {

	private static final List<CarModelOptions> ALL_MODEL_PRICES = Arrays.asList(
			new CarModelOptions(1, "Toyota", "Allion", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, ELECTRIC_SEATS, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY)),
			new CarModelOptions(2, "Toyota", "Preimio", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, ELECTRIC_SEATS, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY)),
			new CarModelOptions(3, "Toyota", "Axio", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY)),
			new CarModelOptions(4, "Toyota", "Belta", 
					Arrays.asList(POWER_MIRROR, AC, HEATED_SEATS)),
			new CarModelOptions(5, "Honda", "FIT GP-5", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, ELECTRIC_SEATS, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY)),
			new CarModelOptions(6, "Honda", "CIVIC", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, ELECTRIC_SEATS, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY, AUTO_BREAK)),
			new CarModelOptions(7, "Honda", "SHUTTLE", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, ELECTRIC_SEATS, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY)),
			new CarModelOptions(8, "Benz", "E200", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, ELECTRIC_SEATS, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY, AUTO_BREAK)),
			new CarModelOptions(9, "BMW", "520D", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, ELECTRIC_SEATS, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY, AUTO_BREAK)),
			new CarModelOptions(10, "RollsRoys", "Phantom", 
					Arrays.asList(CRUISE_CONTROL, POWER_MIRROR, ELECTRIC_SEATS, MULTI_FUNCTIONING_STEERING, AC, HEATED_SEATS, SMART_KEY, AUTO_BREAK)));
			
	@Override
	public List<CarModelOptions> findByModelName(String name) {
		if(name == null || name.isEmpty()) {
			return Arrays.asList();
		}
		return ALL_MODEL_PRICES.stream()
		.filter(model -> model.getModelName().toLowerCase().contains(name.toLowerCase()))
		.collect(Collectors.toList());
	}

	@Override
	public List<CarModelOptions> findByOptionName(String optionName) {
		if(optionName == null || optionName.isEmpty()) {
			return Arrays.asList();
		}
		return ALL_MODEL_PRICES.stream()
				.filter(model -> getMatchingCarOption(model, optionName).size() > 0)
				.collect(Collectors.toList());
	}

	@Override
	public List<CarModelOptions> findByModelAndOptionName(String modelName, String optionName) {
		if(modelName == null || modelName.isEmpty() || optionName == null || optionName.isEmpty()) {
			return Arrays.asList();
		}
		return ALL_MODEL_PRICES.stream()
				.filter(model -> model.getModelName().toLowerCase().contains(modelName.toLowerCase()))
				.filter(model -> getMatchingCarOption(model, optionName).size() > 0)
				.collect(Collectors.toList());
	}
	
	private Map<CarOption, List<String>> getCarOptionIndex() {
		Map<CarOption, List<String>> index = new HashMap<>();
		for(CarOption option : CarOption.values()) {
			index.put(option, Stream.of(option.toString().split("_")).map(String::toLowerCase).collect(Collectors.toList()));			
		}
		return index;
	}
	
	private List<CarOption> getMatchingCarOption(CarModelOptions carModel, String carOption) {
		if(carOption == null || carOption.isEmpty()) {
			return Arrays.asList();
		}
		List<CarOption> carOptions = new ArrayList<CarOption>();
		Map<CarOption, List<String>> index = getCarOptionIndex();
		index.forEach((key, values) -> {
			if(values.contains(carOption.toLowerCase()) ||
					values.stream().anyMatch(v -> (v.startsWith(carOption.toLowerCase()) || v.contains(carOption.toLowerCase()) )) ) {
				if (carModel.getCarOptions().stream().anyMatch(c -> c.equals(key)))
					carOptions.add(key);
			}
		});
		return carOptions;
	}

}
