package com.firecodex.hospital_management_system.bloodbank.consumption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-consumptions")
public class BloodConsumptionController {

	@Autowired
	private BloodConsumptionService bloodConsumptionService;

	@GetMapping
	public ResponseEntity<List<BloodConsumption>> getAllBloodConsumptions() {
		List<BloodConsumption> bloodConsumptions = bloodConsumptionService.getAllBloodConsumptions();
		return new ResponseEntity<>(bloodConsumptions, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BloodConsumption> getBloodConsumptionById(@PathVariable Long id) {
		BloodConsumption bloodConsumption = bloodConsumptionService.getBloodConsumptionById(id);
		if (bloodConsumption != null) {
			return new ResponseEntity<>(bloodConsumption, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<BloodConsumption> createBloodConsumption(@RequestBody BloodConsumption bloodConsumption) {
		try {
			BloodConsumption createdBloodConsumption = bloodConsumptionService.createBloodConsumption(bloodConsumption);
			return new ResponseEntity<>(createdBloodConsumption, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<BloodConsumption> updateBloodConsumption(@PathVariable Long id,
			@RequestBody BloodConsumption bloodConsumptionDetails) {
		BloodConsumption updatedBloodConsumption = bloodConsumptionService.updateBloodConsumption(id,
				bloodConsumptionDetails);
		if (updatedBloodConsumption != null) {
			return new ResponseEntity<>(updatedBloodConsumption, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBloodConsumption(@PathVariable Long id) {
		bloodConsumptionService.deleteBloodConsumption(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
