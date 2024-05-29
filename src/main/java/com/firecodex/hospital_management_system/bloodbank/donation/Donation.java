package com.firecodex.hospital_management_system.bloodbank.donation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String donorName;
	private String bloodType;
	private LocalDateTime donationDate;
	private int bloodUnit;
	private int donorAge;
	private String donorGender;
	private String donorAddress;
	private String donorContact;
	private double donorWeight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public LocalDateTime getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(LocalDateTime donationDate) {
		this.donationDate = donationDate;
	}

	public int getBloodUnit() {
		return bloodUnit;
	}

	public void setBloodUnit(int bloodUnit) {
		this.bloodUnit = bloodUnit;
	}

	public int getDonorAge() {
		return donorAge;
	}

	public void setDonorAge(int donorAge) {
		this.donorAge = donorAge;
	}

	public String getDonorGender() {
		return donorGender;
	}

	public void setDonorGender(String donorGender) {
		this.donorGender = donorGender;
	}

	public String getDonorAddress() {
		return donorAddress;
	}

	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}

	public String getDonorContact() {
		return donorContact;
	}

	public void setDonorContact(String donorContact) {
		this.donorContact = donorContact;
	}

	public double getDonorWeight() {
		return donorWeight;
	}

	public void setDonorWeight(double donorWeight) {
		this.donorWeight = donorWeight;
	}
}
