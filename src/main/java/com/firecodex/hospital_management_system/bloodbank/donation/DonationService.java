package com.firecodex.hospital_management_system.bloodbank.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepository;

	public Donation saveDonation(Donation donation) {
		return donationRepository.save(donation);
	}

	public List<Donation> getAllDonations() {
		return donationRepository.findAll();
	}

	public Donation getDonationById(Long id) {
		return donationRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Donation not found with id: " + id));
	}

	public Donation updateDonation(Long id, Donation donationDetails) {
		Donation donation = donationRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Donation not found with id: " + id));

		donation.setDonorName(donationDetails.getDonorName());
		donation.setBloodType(donationDetails.getBloodType());
		donation.setDonationDate(donationDetails.getDonationDate());

		return donationRepository.save(donation);
	}

	public void deleteDonation(Long id) {
		donationRepository.deleteById(id);
	}
}
