package com.firecodex.hospital_management_system.bloodbank.consumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodConsumptionService {

	@Autowired
	private BloodConsumptionRepository bloodConsumptionRepository;

	public List<BloodConsumption> getAllBloodConsumptions() {
		return bloodConsumptionRepository.findAll();
	}

	public BloodConsumption getBloodConsumptionById(Long id) {
		Optional<BloodConsumption> optionalBloodConsumption = bloodConsumptionRepository.findById(id);
		return optionalBloodConsumption.orElse(null);
	}

	public BloodConsumption createBloodConsumption(BloodConsumption bloodConsumption) {
		return bloodConsumptionRepository.save(bloodConsumption);
	}

	public BloodConsumption updateBloodConsumption(Long id, BloodConsumption bloodConsumptionDetails) {
		Optional<BloodConsumption> optionalBloodConsumption = bloodConsumptionRepository.findById(id);
		if (optionalBloodConsumption.isPresent()) {
			BloodConsumption bloodConsumption = optionalBloodConsumption.get();
			bloodConsumption.setBloodType(bloodConsumptionDetails.getBloodType());
			bloodConsumption.setConsumptionDate(bloodConsumptionDetails.getConsumptionDate());
			bloodConsumption.setPatientName(bloodConsumptionDetails.getPatientName());
			bloodConsumption.setStatus(bloodConsumptionDetails.getStatus());
			bloodConsumption.setBloodUnit(bloodConsumptionDetails.getBloodUnit());
			bloodConsumption.setDoctorName(bloodConsumptionDetails.getDoctorName());
			bloodConsumption.setAge(bloodConsumptionDetails.getAge());
			bloodConsumption.setGender(bloodConsumptionDetails.getGender());
			bloodConsumption.setState(bloodConsumptionDetails.getState());
			bloodConsumption.setCity(bloodConsumptionDetails.getCity());
			return bloodConsumptionRepository.save(bloodConsumption);
		} else {
			return null;
		}
	}

	public void deleteBloodConsumption(Long id) {
		bloodConsumptionRepository.deleteById(id);
	}
}
