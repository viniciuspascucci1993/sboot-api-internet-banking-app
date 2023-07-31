package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.City;
import com.vinicius.sbootapiinternetbankingapp.entities.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long id;
    private String name;
    private String cityArea;
    private State state;

    public CityDTO(City entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cityArea = entity.getCityArea();
    }
}
