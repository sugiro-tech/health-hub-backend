package com.example.healthHub.controllers;

import com.example.healthHub.dtos.ChartDto;
import com.example.healthHub.models.ChartModel;
import com.example.healthHub.repositories.ChartRepository;
import com.example.healthHub.repositories.InfoNutritionalRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class ChartController {
    @Autowired
    ChartRepository chartRepository;
    @Autowired
    InfoNutritionalRepository infoNutritionalRepository;
    @PostMapping("/chart")
    public ResponseEntity<Object> saveChart(@RequestBody ChartDto chartDto){
        ChartModel newChart = new ChartModel();

        newChart.setFriday(chartDto.friday());
        newChart.setMonday(chartDto.monday());
        newChart.setSaturday(chartDto.saturday());
        newChart.setSunday(chartDto.sunday());
        newChart.setThursday(chartDto.thursday());
        newChart.setTuesday(chartDto.tuesday());
        newChart.setWednesday(chartDto.wednesday());

        return ResponseEntity.status(HttpStatus.CREATED).body(chartRepository.save(newChart));
    }

    @GetMapping("/chart")
    public ResponseEntity<Object> getAllChart(){
        List<ChartModel> listCharts = chartRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listCharts);
    }

    @GetMapping("/chart/{id}")
    public ResponseEntity<Object> getOneChart(@RequestParam("id") int id){
        Optional<ChartModel> chartReturn = chartRepository.findById(id);

        if(chartReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(chartReturn.get());
    }
    @PutMapping("/chart")
    public ResponseEntity<Object> updateChart(@RequestParam("id") int id,
                                              @RequestBody ChartDto chartDto)
    {
        Optional<ChartModel> updatedChart = chartRepository.findById(id);


        if(updatedChart.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        updatedChart.get().setFriday(chartDto.friday());
        updatedChart.get().setMonday(chartDto.monday());
        updatedChart.get().setSaturday(chartDto.saturday());
        updatedChart.get().setSunday(chartDto.sunday());
        updatedChart.get().setThursday(chartDto.thursday());
        updatedChart.get().setTuesday(chartDto.tuesday());
        updatedChart.get().setWednesday(chartDto.wednesday());

        return ResponseEntity.status(HttpStatus.OK).body(updatedChart);
    }

    @DeleteMapping("/chart")
    public ResponseEntity<Object> deleteChart(@RequestParam("id") int id){
        Optional<ChartModel> deleteChart = chartRepository.findById(id);

        if(deleteChart.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        chartRepository.delete(deleteChart.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
