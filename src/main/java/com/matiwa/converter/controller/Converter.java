package com.matiwa.converter.controller;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.matiwa.converter.service.IConverter;

@RestController
public class Converter {

	@Autowired
	private IConverter convertService;

	Logger logger = LoggerFactory.getLogger(Converter.class);
	
	

	@GetMapping("/conversions/mtok/{miles}")
	public double GetKM(@PathVariable String miles) {
		long timeBefore = System.currentTimeMillis();
		Double km = convertService.GetKM(miles);
		long timeAfter = System.currentTimeMillis();		
		logger.info(String.format("Time taken to convert miles to km is : %d",(timeAfter - timeBefore)));
		return km;
	}

	@GetMapping("/conversions/ktom/{km}")
	public double GetMiles(@PathVariable String km) {
		long timeBefore = System.currentTimeMillis();
		Double m = convertService.GetMiles(km);
		long timeAfter = System.currentTimeMillis();		
		logger.info(String.format("Time taken to convert km to miles is : %d", (timeAfter - timeBefore)));
		return m;
	}

	@GetMapping("/conversions/ktoc/{kevin}")
	public double GetCelcius(@PathVariable String kevin) {
		long timeBefore = System.currentTimeMillis();
		Double c = convertService.GetCelcius(kevin);
		long timeAfter = System.currentTimeMillis();		
		logger.info(String.format("Time taken to convert kevin to celcius is : %d ", (timeAfter - timeBefore)));
		return c;
	}

	@GetMapping("/conversions/ctok/{celcius}")
	public double GetKevin(@PathVariable String celcius) {
		long timeBefore = System.currentTimeMillis();
		Double k = convertService.GetKevin(celcius);
		long timeAfter = System.currentTimeMillis();
		logger.info(String.format("Time taken to convert celcius to kevin is : %d", (timeAfter - timeBefore)));
		return k;
	}

}
