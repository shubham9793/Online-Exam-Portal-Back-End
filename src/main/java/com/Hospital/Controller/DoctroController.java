package com.Hospital.Controller;

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

import com.Hospital.Entity.New.Doctor;
import com.Hospital.services.DoctorService;

@RequestMapping("/doctor")
@RestController
public class DoctroController {
	
	@Autowired 
	private DoctorService doctorService;
	
	
	// Add Doctor
	@PostMapping("/")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		return ResponseEntity.ok(this.doctorService.addDoctor(doctor));
	}
	
	
	// Get All Doctor
	@GetMapping("/")
	public ResponseEntity<?> getALlDoctors() {
		return ResponseEntity.ok(this.doctorService.getAllDoctors());
	}
	
	
	//Get Single Doctor
	@GetMapping("/{doctorId}")
	public ResponseEntity<?> getdoctor(@PathVariable("doctorId") Long doctorId) {
		return ResponseEntity.ok(this.doctorService.getDoctor(doctorId));
	}
	
	
	// Update Doctor
	@PutMapping("/")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
		return ResponseEntity.ok(this.doctorService.addDoctor(doctor)); 
	}
	
	
	
	// delete Doctor
	@DeleteMapping("/{doctorId}")
	public void deleteDoctor(@PathVariable Long doctorId ) {
		this.doctorService.deleteDoctor(doctorId);
	}
}
