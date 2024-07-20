package com.example.Service;


import com.example.Repository.TrainRepository;
import com.example.entity.Train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    private TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Transactional
    public Train saveTrain(Train train) {
        return trainRepository.save(train);
    }

    @Transactional
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }


    @Transactional
    public Optional<Train> getTrainById(Long id) {
        return trainRepository.findById(id);
    }


    @Transactional
    public Train updateTrain(Long id, Train trainDetails) {
        Train train = trainRepository.findById(id).orElseThrow(() -> new RuntimeException("Train not found"));
        train.setTrainNumber(trainDetails.getTrainNumber());
        train.setName(trainDetails.getName());
        train.setSource(trainDetails.getSource());
        train.setDestination(trainDetails.getDestination());
        train.setSchedule(trainDetails.getSchedule());
        return trainRepository.save(train);
    }

    public void deleteTrain(Long id) {
        trainRepository.deleteById(id);
    }
}
