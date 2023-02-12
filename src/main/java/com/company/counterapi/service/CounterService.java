package com.company.counterapi.service;

import java.util.List;

import com.company.counterapi.request.CounterRequest;
import com.company.counterapi.response.CounterResponse;

public interface CounterService {

	public CounterResponse insertCounter(CounterRequest counterRequest);
	public CounterResponse updateCounter(CounterRequest counterRequest);
	public CounterResponse getCounter(String counter);
	public List<CounterResponse> getAllCounters();
	
}
