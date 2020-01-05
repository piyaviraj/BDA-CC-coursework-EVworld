package com.evworld.catagories.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evworld.catagories.models.CarModel;
import com.evworld.catagories.models.CarModelSearchResponse;
import com.evworld.catagories.repositories.CarModelRepository;
import com.evworld.catagories.utils.MetaDataUtils;

@RestController
public class CarModelSearchController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CarModelRepository carModelRepository;
	
	@GetMapping("/models/{model}")
	public CarModelSearchResponse getCarModels(@PathVariable String model) {
		
		int tokenCount = 100;
		
		String tokens = env.getProperty("metadata.tokens", tokenCount + "");
		
		try {
			tokenCount = Integer.parseInt(tokens);
		} catch (Exception e) {
			
		}

		List<CarModel> carModelList = carModelRepository.findByModelName(model);
		Map<String, Object> metaData = new HashMap<String, Object>();
		
		metaData.put("tokens", MetaDataUtils.getHashList(tokenCount));
		
		return new CarModelSearchResponse(carModelList, metaData);
	}
	
}
