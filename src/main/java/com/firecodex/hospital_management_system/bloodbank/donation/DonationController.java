package com.firecodex.hospital_management_system.bloodbank.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

	@Autowired
	private DonationService donationService;

	@PostMapping
	public ResponseEntity<Donation> createDonation(@RequestBody Donation donation) {
		Donation savedDonation = donationService.saveDonation(donation);
		return new ResponseEntity<>(savedDonation, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Donation>> getAllDonations() {
		List<Donation> donations = donationService.getAllDonations();
		return new ResponseEntity<>(donations, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Donation> getDonationById(@PathVariable Long id) {
		Donation donation = donationService.getDonationById(id);
		if (donation != null) {
			return new ResponseEntity<>(donation, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Donation> updateDonation(@PathVariable Long id, @RequestBody Donation donationDetails) {
		Donation updatedDonation = donationService.updateDonation(id, donationDetails);
		if (updatedDonation != null) {
			return new ResponseEntity<>(updatedDonation, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDonation(@PathVariable Long id) {
		donationService.deleteDonation(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
