package com.company.counterapi.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.counterapi.dao.CounterDao;
import com.company.counterapi.entity.CounterEntity;
import com.company.counterapi.repository.CounterRepository;

@Service
public class CounterDaoImpl implements CounterDao {
	
	@Autowired
	CounterRepository counterRepository;

	@Override
	public CounterEntity saveCounter(CounterEntity counterEntity) {
		// TODO Auto-generated method stub
		return counterRepository.save(counterEntity);
	}

	
	@Override
	public Optional<CounterEntity> getCounter(String counterName) {
		// TODO Auto-generated method stub
		Optional<CounterEntity> counterEntity=counterRepository.findById(counterName);
		return counterEntity;
	}

	@Override
	public List<CounterEntity> getAllCounters() {
		// TODO Auto-generated method stub
		return counterRepository.findAll();
	}

}
