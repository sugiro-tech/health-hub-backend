package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.InfoNutriDTO;
import com.sugirotech.healthHub.entities.InfoNutri;
import com.sugirotech.healthHub.repositories.InfoNutriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoNutriService {

    @Autowired
    private InfoNutriRepository nutriRepository;

    public InfoNutriDTO create (InfoNutriDTO data){
        InfoNutri nutri = new InfoNutri(data);

        this.nutriRepository.save(nutri);

        return new InfoNutriDTO(nutri);
    }
}
