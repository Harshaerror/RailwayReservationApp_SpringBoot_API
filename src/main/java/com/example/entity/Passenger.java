package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Passenger implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String firstname;

private String lastname;

private String passportNumber;

private String email;

private String phone;

private String address;

private String gender;

private String nationality;

private String dateOfBirth;

private String seatNumber;





}
