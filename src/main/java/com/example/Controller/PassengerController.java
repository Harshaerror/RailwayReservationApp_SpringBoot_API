package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.PassengerService;
import com.example.entity.Passenger;

@RestController
@RequestMapping("/api")
public class PassengerController {


    private final PassengerService passengerService;

@Autowired
public PassengerController(PassengerService passengerService){
    this.passengerService=passengerService;
}

@PostMapping("/passengers")
public ResponseEntity<Passenger> createPassenger (@RequestBody Passenger passenger){
    Passenger savePassenger = passengerService.savePasseger(passenger);
    return ResponseEntity.ok(savePassenger);
}

@GetMapping("/passengers")
public ResponseEntity<List<Passenger>> getAllPassenger()
    {
    List<Passenger> passengers = passengerService.getAllPassenger();
    return ResponseEntity.ok(passengers);
    }

@GetMapping("/passengers/{id}")
public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id)
{
    return passengerService.getpassengerById(id)
       .map(ResponseEntity::ok)
       .orElseGet(() -> ResponseEntity.notFound().build());

}

@PutMapping("passenger/{id}")
public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id,@RequestBody Passenger passenegrDetail)
{
    Passenger updatePassenger = passengerService.updatePassenger(id, passenegrDetail);
    if(updatePassenger!=null){
     return ResponseEntity.ok(updatePassenger);
    }
    else{
        return ResponseEntity.notFound().build();
    }

 
}
@DeleteMapping("passenger/{id}")
 public ResponseEntity<Void> deletePassenger(@PathVariable Long id){
    passengerService.deletePassenger(id);
    return ResponseEntity.noContent().build();


    
 }
}
