package com.evworld.price.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evworld.price.models.CarModelPrice;
import com.evworld.price.models.CarPriceSearchResponse;
import com.evworld.price.repositories.CarModelPriceRepository;
import com.evworld.price.repositories.utils.MetaDataUtils;

@RestController
public class CarPriceController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CarModelPriceRepository carModelPriceRepository;

	@GetMapping("/prices/{model}")
	public CarPriceSearchResponse getModelPrices(@PathVariable String model) {
		
		int tokenCount = 100;
		
		String tokens = env.getProperty("metadata.tokens", tokenCount + "");
		
		try {
			tokenCount = Integer.parseInt(tokens);
		} catch (Exception e) {
			
		}
		MetaDataUtils.getHashList(0);
		List<CarModelPrice> carModelList = carModelPriceRepository.findByModelName(model);
		Map<String, Object> metaData = new HashMap<String, Object>();
		
		metaData.put("tokens", MetaDataUtils.getHashList(tokenCount));
		
		return new CarPriceSearchResponse(carModelList, metaData);
	}
	
}
