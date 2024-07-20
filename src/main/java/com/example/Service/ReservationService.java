package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.ReservationRepository;
import com.example.entity.Reservation;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {

private final ReservationRepository reservationRepository;

@Autowired
public ReservationService(ReservationRepository reservationRepository){
    this.reservationRepository = reservationRepository;
}

@Transactional
public Reservation saveReservation(Reservation reservation){
    return reservationRepository.save(reservation);
}

@Transactional
public List<Reservation> getAllReservations(){
    return reservationRepository.findAll();
}

@Transactional
public Optional<Reservation> getReservationById(Long id){
    return reservationRepository.findById(id);
}

@Transactional
public Reservation updateReservation(Long id, Reservation reservationDetails){
    Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setTrain(reservationDetails.getTrain());
            reservation.setPassenger(reservationDetails.getPassenger());
            reservation.setReservationTime(reservationDetails.getReservationTime());
            reservation.setSeatNumber(reservationDetails.getSeatNumber());
            return reservationRepository.save(reservation);
        }
        return null;
    }


    @Transactional
    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

}



