package com.evworld.options.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evworld.options.models.CarModelOptions;
import com.evworld.options.models.CarOptionsSearchResponse;
import com.evworld.options.repositories.CarModelOptionsRepository;
import com.evworld.options.utils.MetaDataUtils;

@RestController
public class CarOptionsController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CarModelOptionsRepository carModelOptionsRepository;

	@GetMapping("/options/model/{model}")
	public CarOptionsSearchResponse getModelOptions(@PathVariable String model) {
		
		int tokenCount = 100;
		
		String tokens = env.getProperty("metadata.tokens", tokenCount + "");
		
		try {
			tokenCount = Integer.parseInt(tokens);
		} catch (Exception e) {
			
		}

		List<CarModelOptions> carModelList = carModelOptionsRepository.findByModelName(model);
		Map<String, Object> metaData = new HashMap<String, Object>();
		
		metaData.put("tokens", MetaDataUtils.getHashList(tokenCount));
		
		return new CarOptionsSearchResponse(carModelList, metaData);
	}
	
	@GetMapping("/options/{optionName}")
	public CarOptionsSearchResponse getOptionName(@PathVariable String optionName) {
		
		int tokenCount = 100;
		
		String tokens = env.getProperty("metadata.tokens", tokenCount + "");
		
		try {
			tokenCount = Integer.parseInt(tokens);
		} catch (Exception e) {
			
		}

		List<CarModelOptions> carModelList = carModelOptionsRepository.findByOptionName(optionName);
		Map<String, Object> metaData = new HashMap<String, Object>();
		
		metaData.put("tokens", MetaDataUtils.getHashList(tokenCount));
		
		return new CarOptionsSearchResponse(carModelList, metaData);
	}
	
	@GetMapping("/options/{optionName}/model/{modelName}")
	public CarOptionsSearchResponse getOptionName(@PathVariable String optionName, @PathVariable String modelName) {
		
		int tokenCount = 100;
		
		String tokens = env.getProperty("metadata.tokens", tokenCount + "");
		
		try {
			tokenCount = Integer.parseInt(tokens);
		} catch (Exception e) {
			
		}

		List<CarModelOptions> carModelList = carModelOptionsRepository.findByModelAndOptionName(modelName, optionName);
		Map<String, Object> metaData = new HashMap<String, Object>();
		
		metaData.put("tokens", MetaDataUtils.getHashList(tokenCount));
		
		return new CarOptionsSearchResponse(carModelList, metaData);
	}
	
}
