package com.example.Controller;




import com.example.Service.TrainService;
import com.example.entity.Train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrainController {
    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }
    

    @PostMapping("/trains")
    public ResponseEntity<Train> createTrain(@RequestBody Train train) {
        Train savedTrain = trainService.saveTrain(train);
        return ResponseEntity.ok(savedTrain);
    }

    @GetMapping("/trains")
    public ResponseEntity<List<Train>> getAllTrains() {
        List<Train> trains = trainService.getAllTrains();
        return ResponseEntity.ok(trains);
    }

    @GetMapping("/trains/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
        return trainService.getTrainById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/trains/{id}")
    public ResponseEntity<Train> updateTrain(@PathVariable Long id, @RequestBody Train trainDetails) {
        Train updatedTrain = trainService.updateTrain(id, trainDetails);
        if (updatedTrain != null) {
            return ResponseEntity.ok(updatedTrain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/trains/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable Long id) {
        trainService.deleteTrain(id);
        return ResponseEntity.noContent().build();
    }
}

