package com.vinicius.sbootapiinternetbankingapp.dto;

import com.vinicius.sbootapiinternetbankingapp.entities.ContactData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDataDTO {

    private Long id;
    private String phone;
    private String streetOrAvenue;
    private String email;

    public ContactDataDTO(ContactData entity) {
        this.id = entity.getId();
        this.phone = entity.getPhone();
        this.streetOrAvenue = entity.getStreetOrAvenue();
        this.email = entity.getEmail();
    }
}
