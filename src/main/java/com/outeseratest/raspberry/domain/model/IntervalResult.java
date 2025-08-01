package com.outeseratest.raspberry.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IntervalResult {
	
    private List<ProducerInterval> min;
    private List<ProducerInterval> max;
    
}
