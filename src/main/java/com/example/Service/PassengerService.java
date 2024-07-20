package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Repository.PassengerRepository;
import com.example.entity.Passenger;

import jakarta.transaction.Transactional;
@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository)
    {
        this.passengerRepository=passengerRepository;
    }

    @Transactional
    public Passenger savePasseger(Passenger passenger)
    {
       return passengerRepository.save(passenger);
    }

    @Transactional
    public List<Passenger> getAllPassenger()
    {
        return passengerRepository.findAll();
    }

    @Transactional
    public Optional<Passenger> getpassengerById(Long id)
    {  
        return passengerRepository.findById(id);
    }

    @Transactional
    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Optional<Passenger> passenger = passengerRepository.findById(id);
        if (passenger.isPresent()) {
            Passenger passenger1 = passenger.get();
            passenger1.setFirstname(passengerDetails.getFirstname());
            passenger1.setLastname(passengerDetails.getLastname());
            return passengerRepository.save(passenger1);
            }
            return null;
            }
            
    @Transactional
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}

