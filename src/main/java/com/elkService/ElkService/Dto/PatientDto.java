package com.elkService.ElkService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class Patient
 * 
 * 
 * @author dines
 * @Created Date 23/12
 * @description used to add the patient details into Db
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
	
	/**
	 * Id of the Patient
	 */

	private int id;
	
	/**
	 * Name of the Patient
	 */
	private String patientName;
	
	/**
	 * Adress of the Patient
	 */
	private String adress;
	
	/**
	 * Mobile no of the Patient
	 */
	private String mobile;
	
	

}