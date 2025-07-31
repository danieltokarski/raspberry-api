package com.outeseratest.raspberry.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProducerInterval {
	
    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;

}
