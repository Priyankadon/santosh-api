package com.company.counterapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.counterapi.request.CounterRequest;
import com.company.counterapi.response.CounterResponse;
import com.company.counterapi.service.CounterService;


@RestController()
@RequestMapping("counter")
public class CounterController {
	
	@Autowired
	CounterService counterService;

	@PostMapping("create")
	public ResponseEntity<CounterResponse> createCounter(@RequestBody CounterRequest counterRequest) {
		System.out.println("Counter Request"+counterRequest.toString());
		CounterResponse counterResponse =counterService.insertCounter(counterRequest);
		return new ResponseEntity<CounterResponse>(counterResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("update")
	public ResponseEntity<CounterResponse> updateCounter(@RequestBody CounterRequest counterRequest) {
		CounterResponse counterResponse = counterService.updateCounter(counterRequest);
		return new ResponseEntity<CounterResponse>(counterResponse, HttpStatus.OK);
	}
	
	
	@GetMapping("{counterName}")
	public ResponseEntity<CounterResponse> getCounterInfo(@PathVariable("counterName") String counterName) {
		CounterResponse counterResponse = counterService.getCounter(counterName);
		return new ResponseEntity<CounterResponse>(counterResponse, HttpStatus.OK);
	}

	@GetMapping("counters")
	public ResponseEntity<List<CounterResponse>> getCountersList() {
		List<CounterResponse> countersList =counterService.getAllCounters();
		return new ResponseEntity<List<CounterResponse>>(countersList, HttpStatus.OK);
	}

}
