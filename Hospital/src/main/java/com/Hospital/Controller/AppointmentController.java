package com.Hospital.Controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.Hospital.Entity.New.Appointment;
import com.Hospital.Entity.New.Doctor;
import com.Hospital.services.AppointmentService;
import com.Hospital.services.DoctorService;



@RequestMapping("/appointment")
@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService doctorService;
	
	//Book Appointment
	@PostMapping("/")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
		return ResponseEntity.ok(this.appointmentService.bookAppintment(appointment));
		
	}
	
	
	
	// Get Single Appointment
	@GetMapping("/{appointmentId}")
	public Appointment getSingleAppointment(@PathVariable Long appointmentId) {
		return this.appointmentService.getSingleAppointment(appointmentId);
	}
	
	
	// Get All Appointment
	@GetMapping("/")
	public ResponseEntity<?> getAllAppointment(){
		return ResponseEntity.ok(this.appointmentService.getAllAppointment());
	}
	
	
	
	// Get Appointment of any Doctor
	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<?> getAppointmentofDoctor(@PathVariable("doctorId") Long doctorId) {
		
		Doctor doctor = this.doctorService.getDoctor(doctorId);
		Set<Appointment> appointments = doctor.getAppointment();
		
		List<Appointment> list = new ArrayList<>(appointments);
		
		if(list.size()>Integer.parseInt(doctor.getNumberOfAppointment())) {
			list = list.subList(0, Integer.parseInt(doctor.getNumberOfAppointment()+1));
			
		}
		
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	
	
	// Update Appointment
	@PutMapping("/")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
		return ResponseEntity.ok(this.appointmentService.bookAppintment(appointment));
	}
	
	// Delete Appointment
	@DeleteMapping("/{appointmentId}") 
	public void deleteAppointment(@PathVariable("appointmentId") Long appointmentId) {
		this.appointmentService.deleteAppointment(appointmentId);
	}
	
}
