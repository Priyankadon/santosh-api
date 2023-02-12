package com.company.counterapi.dao;

import com.company.counterapi.entity.CounterEntity;
import java.util.*;

public interface CounterDao {
	
	public CounterEntity saveCounter(CounterEntity counterEntity);
	
	public Optional<CounterEntity> getCounter(String counterName);
	
	public List<CounterEntity> getAllCounters();
}
