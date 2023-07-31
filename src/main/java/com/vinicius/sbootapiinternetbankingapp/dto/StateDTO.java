package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.City;
import com.vinicius.sbootapiinternetbankingapp.entities.State;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateDTO {

    private Long id;
    private String name;
    private String country;

    @NotEmpty(message = "Favor informar ao menos uma cidade.")
    private List<City> cities = new ArrayList<>();

    public StateDTO(State entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.country = entity.getCountry();
    }
}
