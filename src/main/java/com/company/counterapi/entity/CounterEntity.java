package com.company.counterapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CounterEntity {
	
	@Id
	@Column(name="counter_name",length = 50)
	private String counterName;
	private Integer counterCount;
}
