package com.company.counterapi.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.counterapi.dao.CounterDao;
import com.company.counterapi.entity.CounterEntity;
import com.company.counterapi.exception.CounterException;
import com.company.counterapi.request.CounterRequest;
import com.company.counterapi.response.CounterResponse;
import com.company.counterapi.service.CounterService;

@Service
public class CounterServiceImpl implements CounterService {
	
	@Autowired
	CounterDao counterDao;
	
	@Autowired
	ModelMapper modelMapper;


	@Override
	public CounterResponse insertCounter(CounterRequest counterRequest) {
		// TODO Auto-generated method stub
		
		Optional<CounterEntity> optionalcounterEntity= counterDao.getCounter(counterRequest.getCounterName());
		
		if(optionalcounterEntity.isPresent())
			throw new CounterException(optionalcounterEntity.get().getCounterName() + " Found in the Database ");
		
		CounterEntity counterEntity= CounterEntity.builder()
				.counterName(counterRequest.getCounterName())
				.counterCount(1)
				.build();
		
		counterEntity = counterDao.saveCounter(counterEntity);
		
		CounterResponse counterResponse=CounterResponse.builder()
				.counterName(counterEntity.getCounterName())
				.counterCount(counterEntity.getCounterCount())
				.build();
		
		return counterResponse;
	}

	@Override
	public CounterResponse updateCounter(CounterRequest counterRequest) {
		// TODO Auto-generated method stub
		Optional<CounterEntity> optionalcounterEntity= counterDao.getCounter(counterRequest.getCounterName());
		if(optionalcounterEntity.isPresent()) {
			
			CounterEntity counterEntity = CounterEntity.builder()
					.counterName(optionalcounterEntity.get().getCounterName())
					.counterCount(optionalcounterEntity.get().getCounterCount()+1)
					.build();
			
			counterEntity = counterDao.saveCounter(counterEntity);
			
			return modelMapper.map(counterEntity, CounterResponse.class);
		}else {
			throw new CounterException(optionalcounterEntity.get().getCounterName()+ " Counter Not found in the Database" );
		}
	}

	@Override
	public CounterResponse getCounter(String counter) {
		// TODO Auto-generated method stub
		Optional<CounterEntity> counterEntity= counterDao.getCounter(counter);
		if(counterEntity.get().getCounterName()!="" || counterEntity.get().getCounterName()==null) {
			CounterResponse counterResponse=CounterResponse.builder()
					.counterName(counterEntity.get().getCounterName())
					.counterCount(counterEntity.get().getCounterCount())
					.build();
			return counterResponse;
		}else {
			throw new CounterException(counterEntity.get().getCounterName()+ " Counter Not found in the Database" );
		}
			
	}

	@Override
	public List<CounterResponse> getAllCounters() {
		// TODO Auto-generated method stub
		List<CounterResponse> counterResponseList=Arrays.asList(modelMapper.map(counterDao.getAllCounters(),
													CounterResponse[].class));
		return counterResponseList;
	}

}
