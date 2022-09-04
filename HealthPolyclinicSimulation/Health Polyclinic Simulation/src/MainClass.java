/* *********** Pledge of Honor ***************************************************************************
 * I hereby certify that I have completed this programming assignment on my own
 * without any help from anyone else. The effort in the assignment thus belongs
 * completely to me. I did not search for a solution, or I did not consult to any program
 * written by other students or did not copy any program from other sources. I read and
 * followed the guidelines provided in the programming assignment.
 *
 * READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
 * SIGNATURE: <Ýsmail Ozan Kayacan, 69103>
 *
 ************************************************************************************************************/

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MainClass {

	public static void main(String[] args) {

		//Create clinics
		Clinic ophthalmology=new Clinic("Ophthalmology");
		Clinic urology=new Clinic("Urology");
		Clinic orthopedics =new Clinic("Orthopedics");
		Clinic psychiatry=new Clinic("Psychiatry");

		//Create doctors
		Doctor d1=new Doctor("Ali", 1, 7, 0.6);
		Doctor d2=new Doctor("Hakan", 2, 11, 0.4);
		Doctor d3=new Doctor("Zeynep", 3, 16, 0.5);
		Doctor d4=new Doctor("Deniz", 4, 9, 0.8);
		Doctor d5=new Doctor("Ahmet", 5, 13, 0.3);
		Doctor d6=new Doctor("Ege", 6, 17, 0.4);
		Doctor d7=new Doctor("Asli", 7, 10, 0.5);
		Doctor d8=new Doctor("Mehmet", 8, 8, 0.8);
		Doctor d9=new Doctor("Ayse", 9, 5, 0.5);
		Doctor d10=new Doctor("Fatma", 10, 15, 0.6);
		Doctor d11=new Doctor("Murat", 11, 9, 0.7);

		//All available drugs
		ArrayList<Drug> allDrugs=new ArrayList<Drug>();

		//Create drugs
		Drug drug1=new Drug("drug1",10,0.7);   allDrugs.add(drug1);
		Drug drug2=new Drug("drug2",18,0.4);   allDrugs.add(drug2);
		Drug drug3=new Drug("drug3",36,0.5);   allDrugs.add(drug3);
		Drug drug4=new Drug("drug4",7,0.5);    allDrugs.add(drug4);
		Drug drug5=new Drug("drug5",65,0.6);   allDrugs.add(drug5);
		Drug drug6=new Drug("drug6",44,0.5);   allDrugs.add(drug6);
		Drug drug7=new Drug("drug7",10,0.3);   allDrugs.add(drug7);
		Drug drug8=new Drug("drug8",15,0.4);   allDrugs.add(drug8);
		Drug drug9=new Drug("drug9",3,0.2);    allDrugs.add(drug9);
		Drug drug10=new Drug("drug10",18,0.3); allDrugs.add(drug10);

		//Conflicting drugs
		drug1.getConflictingDrugs().add(drug3);drug3.getConflictingDrugs().add(drug1);
		drug2.getConflictingDrugs().add(drug6);drug6.getConflictingDrugs().add(drug2);
		drug1.getConflictingDrugs().add(drug5);drug5.getConflictingDrugs().add(drug1);
		drug7.getConflictingDrugs().add(drug9);drug9.getConflictingDrugs().add(drug7);
		drug4.getConflictingDrugs().add(drug5);drug5.getConflictingDrugs().add(drug4);
		drug8.getConflictingDrugs().add(drug10);drug10.getConflictingDrugs().add(drug8);

		//Add doctors to clinics
		ophthalmology.addDoctor(d1);ophthalmology.addDoctor(d2);ophthalmology.addDoctor(d3);
		urology.addDoctor(d4);urology.addDoctor(d5);
		orthopedics.addDoctor(d6);
		psychiatry.addDoctor(d7);psychiatry.addDoctor(d8);psychiatry.addDoctor(d9);psychiatry.addDoctor(d10);psychiatry.addDoctor(d11);

		//////////////////////////  ABOVE WAS FOR TEST, BELOW IS MAIN CODE  //////////////////////////

		//List of old patients (patients whose information already exist in policlinic system.)
		ArrayList<Patient> oldPatients = new ArrayList<Patient>();

		//create frame
		MainFrame frame=new MainFrame("KU-Health Polyclinic");

		//components of panel
		JButton registerNewPatientButton=new JButton ("Register New Patient");
		JButton registerOldPatientButton=new JButton ("Register Old Patient");
		JButton displayPatients=new JButton ("Display Patients in A Clinic");
		JButton displayAllClinicSchedule=new JButton ("Display Schedules of All Doctors in A Clinic");
		JButton examinePatient=new JButton("Examine Patient");

		//add components to panel
		GridBagConstraints gc=new GridBagConstraints();
		gc.weightx=0.5;gc.weighty=0.5;

		gc.gridx=0;gc.gridy=0;
		frame.getPanel().add(registerNewPatientButton, gc);

		gc.gridx=0;gc.gridy=1;
		frame.getPanel().add(registerOldPatientButton, gc);

		gc.gridx=0;gc.gridy=2;
		frame.getPanel().add(displayPatients, gc);

		gc.gridx=0;gc.gridy=3;
		frame.getPanel().add(displayAllClinicSchedule, gc);

		gc.gridx=0;gc.gridy=4;
		frame.getPanel().add(examinePatient, gc);


/////////////////////////////////REGISTERING NEW PATIENT/////////////////////////////////////////////////////////////////
		registerNewPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// GETTING NECESSARY DATA ABOUT PATIENT
				String name = JOptionPane.showInputDialog("Patient Name?");
				JList genderList = new JList(new String[] {"Male", "Female"});
				JOptionPane.showMessageDialog(null, genderList, "Gender?", JOptionPane.PLAIN_MESSAGE);
				String gender=(String) genderList.getSelectedValue();
				String age= JOptionPane.showInputDialog("Age?");
				String tckn = JOptionPane.showInputDialog("TCKN?");
				String oldDrugs = JOptionPane.showInputDialog("Old drugs? (put space between each drug.)");
				String oldIllnesses = JOptionPane.showInputDialog("Old illnesses?");
				
				//CHOOSING CLINIC
				JList clinicList = new JList(new String[] {"Ophthalmology", "Urology", "Orthopedics", "Psychiatry"});
				JOptionPane.showMessageDialog(null, clinicList, "Choose clinic", JOptionPane.PLAIN_MESSAGE);

				//CHOOSING DOCTOR
				DefaultListModel<String> doctorListModel = new DefaultListModel<>();
				JList<String> doctorList = new JList<>( doctorListModel );

				if(clinicList.getSelectedIndex()==0) {   //Creating doctor list according to clinic chosen.
					for(Doctor d:ophthalmology.getDoctorList()) {
						doctorListModel.addElement(d.getName());
					}
				}
				else if(clinicList.getSelectedIndex()==1) {
					for(Doctor d:urology.getDoctorList()) {
						doctorListModel.addElement(d.getName());
					}
				}
				else if(clinicList.getSelectedIndex()==2) {
					for(Doctor d:orthopedics.getDoctorList()) {
						doctorListModel.addElement(d.getName());
					}
				}
				else if(clinicList.getSelectedIndex()==3) {
					for(Doctor d:psychiatry.getDoctorList()) {
						doctorListModel.addElement(d.getName());
					}
				}
				JOptionPane.showMessageDialog(null, doctorList, "Choose a doctor in " +clinicList.getSelectedValue(), JOptionPane.PLAIN_MESSAGE);

				//CHOOSING HOUR
				DefaultListModel<String> hourListModel = new DefaultListModel<>();
				JList<String> hourList = new JList<>( hourListModel );
				Doctor chosenDoctor;
				if(clinicList.getSelectedIndex()==0) { //Creating hour list according to doctor chosen.
					chosenDoctor=ophthalmology.getDoctorList().get(doctorList.getSelectedIndex());
					for(String s:ophthalmology.getDoctorList().get(doctorList.getSelectedIndex()).getAvailableHours()) {
						hourListModel.addElement(s);
					}
				}
				else if(clinicList.getSelectedIndex()==1) {
					chosenDoctor=urology.getDoctorList().get(doctorList.getSelectedIndex());
					for(String s:urology.getDoctorList().get(doctorList.getSelectedIndex()).getAvailableHours()) {
						hourListModel.addElement(s);
					}
				}
				else if(clinicList.getSelectedIndex()==2) {
					chosenDoctor=orthopedics.getDoctorList().get(doctorList.getSelectedIndex());
					for(String s:orthopedics.getDoctorList().get(doctorList.getSelectedIndex()).getAvailableHours()) {
						hourListModel.addElement(s);
					}
				}
				else  {
					chosenDoctor=psychiatry.getDoctorList().get(doctorList.getSelectedIndex());
					for(String s:psychiatry.getDoctorList().get(doctorList.getSelectedIndex()).getAvailableHours()) {
						hourListModel.addElement(s);
					}
				}
				JOptionPane.showMessageDialog(null, hourList, "Available hours of Dr. " +doctorList.getSelectedValue()+". Choose one:", JOptionPane.PLAIN_MESSAGE);

				try {
					//ADDING PATIENT TO DOCTOR'S SCHEDULE AND UPDATING NECESSARY DATA.
					int tcknInt = Integer.parseInt(tckn);
					int ageInt=Integer.parseInt(age);
					Patient registeredPatient= new Patient(name,gender,ageInt,tcknInt);
					registeredPatient.addOldDrugs(oldDrugs);
					registeredPatient.addOldIllnesses(oldIllnesses);
					chosenDoctor.getSchedule().put(hourList.getSelectedValue(), registeredPatient.toString()); 
					frame.getTextArea().append("\n\nREGISTERED PATIENT  -  "+ registeredPatient+ "  -  Clinic: "+ clinicList.getSelectedValue()+ "  -  Doctor: "+doctorList.getSelectedValue()+
												"  -  Hour: "+hourList.getSelectedValue());
					JOptionPane.showMessageDialog(null, "Patient is registered successfully.");
					chosenDoctor.getRegisteredPatients().put(hourList.getSelectedValue(), registeredPatient);
					oldPatients.add(registeredPatient);
				} 

				//IF WRONG INPUT IS GIVEN (LIKE NONINTEGER FOR AGE OR TCKN)
				catch(NumberFormatException e)
				{
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Wrong input, registration failed!");
				}

			}

		});

////////////////////////////////REGISTERING OLD PATIENT//////////////////////////////////////////////////////////////////7
		registerOldPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					//CHOOSING OLD PATIENT
					DefaultListModel<String> modelOldPatients = new DefaultListModel<>();
					JList<String> listOldPatients = new JList<>( modelOldPatients );
					for(Patient oldP : oldPatients) {
						modelOldPatients.addElement(oldP.getName()+"(TCKN: "+oldP.getTckn()+")");
					}
					JOptionPane.showMessageDialog(null, listOldPatients, "Choose Patient", JOptionPane.PLAIN_MESSAGE);

					Patient chosenPatient = oldPatients.get(listOldPatients.getSelectedIndex());
					
					//CHOOSING CLINIC
					JList clinicList = new JList(new String[] {"Ophthalmology", "Urology", "Orthopedics", "Psychiatry"});
					JOptionPane.showMessageDialog(null, clinicList, "Choose clinic", JOptionPane.PLAIN_MESSAGE);

					//CHOOSING DOCTOR
					DefaultListModel<String> doctorModel = new DefaultListModel<>();
					JList<String> doctorList = new JList<>(doctorModel);

					if(clinicList.getSelectedIndex()==0) { //Creating doctor list according to clinic chosen.
						for(Doctor d:ophthalmology.getDoctorList()) {
							doctorModel.addElement(d.getName());
						}
					}
					else if(clinicList.getSelectedIndex()==1) {
						for(Doctor d:urology.getDoctorList()) {
							doctorModel.addElement(d.getName());
						}
					}
					else if(clinicList.getSelectedIndex()==2) {
						for(Doctor d:orthopedics.getDoctorList()) {
							doctorModel.addElement(d.getName());
						}
					}
					else if(clinicList.getSelectedIndex()==3) {
						for(Doctor d:psychiatry.getDoctorList()) {
							doctorModel.addElement(d.getName());
						}
					}
					JOptionPane.showMessageDialog(null, doctorList, "Choose a doctor in " +clinicList.getSelectedValue(), JOptionPane.PLAIN_MESSAGE);

					//CHOOSING HOUR
					DefaultListModel<String> hourModel = new DefaultListModel<>();
					JList<String> hourList = new JList<>(hourModel);
					Doctor chosenDoctor;
					if(clinicList.getSelectedIndex()==0) { //Creating hour list according to doctor chosen.
						chosenDoctor=ophthalmology.getDoctorList().get(doctorList.getSelectedIndex());
						for(String s:ophthalmology.getDoctorList().get(doctorList.getSelectedIndex()).getAvailableHours()) {
							hourModel.addElement(s);
						}
					}
					else if(clinicList.getSelectedIndex()==1) {
						chosenDoctor=urology.getDoctorList().get(doctorList.getSelectedIndex());
						for(String s:urology.getDoctorList().get(doctorList.getSelectedIndex()).getAvailableHours()) {
							hourModel.addElement(s);
						}
					}
					else if(clinicList.getSelectedIndex()==2) {
						chosenDoctor=orthopedics.getDoctorList().get(doctorList.getSelectedIndex());
						for(String s:orthopedics.getDoctorList().get(doctorList.getSelectedIndex()).getAvailableHours()) {
							hourModel.addElement(s);
						}
					}
					else  {
						chosenDoctor=psychiatry.getDoctorList().get(doctorList.getSelectedIndex());
						for(String s:psychiatry.getDoctorList().get(doctorList.getSelectedIndex()).getAvailableHours()) {
							hourModel.addElement(s);
						}
					}
					JOptionPane.showMessageDialog(null, hourList, "Available hours of Dr. " +doctorList.getSelectedValue()+". Choose one:", JOptionPane.PLAIN_MESSAGE);

					try {
						//ADDING PATIENT TO DOCTOR'S SCHEDULE AND UPDATING NECESSARY DATA.
						chosenDoctor.getSchedule().put(hourList.getSelectedValue(), chosenPatient.toString()); 
						frame.getTextArea().append("\n\nREGISTERED PATIENT  -  "+chosenPatient.toString()+ "  -  Clinic: "+ clinicList.getSelectedValue()+"  -  Doctor: "+doctorList.getSelectedValue()+
								"  -  Hour: "+hourList.getSelectedValue());
						JOptionPane.showMessageDialog(null, "Patient is registered successfully.");
						chosenDoctor.getRegisteredPatients().put(hourList.getSelectedValue(), chosenPatient);

					} 
					//IF WRONG INPUT IS GIVEN (LIKE NONINTEGER FOR AGE OR TCKN)
					catch(NumberFormatException e)
					{
						System.out.println(e.getMessage());
						JOptionPane.showMessageDialog(null, "Wrong input, registration failed!");
					}
				}catch(IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "No old patient");
				}


			}


		});

//////////////////////////DISPLAYING ALL DOCTOR'S SCHEDULE IN A CLINIC.//////////////////////////////////////////////7
		displayAllClinicSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CHOOSING CLINIC
				JList clinicList = new JList(new String[] {"Ophthalmology", "Urology", "Orthopedics", "Psychiatry"});
				JOptionPane.showMessageDialog(null, clinicList, "Choose clinic", JOptionPane.PLAIN_MESSAGE);
				frame.getTextArea().append("\n\nSchedule Of Doctors In "+clinicList.getSelectedValue()+" Clinic: ");
				if(clinicList.getSelectedIndex()==0) {  //Preparing doctors list according to clinic chosen
					for(Doctor d:ophthalmology.getDoctorList()) {
						frame.getTextArea().append("\n\n"+d.getName()+": ");
						for(Entry<String, String> entry : d.getSchedule().entrySet()) {
							frame.getTextArea().append("\n"+entry.getKey()+" : "+entry.getValue());
						}
					}
				}
				else if(clinicList.getSelectedIndex()==1) {
					for(Doctor d:urology.getDoctorList()) {
						frame.getTextArea().append("\n\n"+d.getName()+": ");
						for(Entry<String, String> entry : d.getSchedule().entrySet()) {
							frame.getTextArea().append("\n"+entry.getKey()+" : "+entry.getValue());
						}
					}
				}
				else if(clinicList.getSelectedIndex()==2) {
					for(Doctor d:orthopedics.getDoctorList()) {
						frame.getTextArea().append("\n\n"+d.getName()+": ");
						for(Entry<String, String> entry : d.getSchedule().entrySet()) {
							frame.getTextArea().append("\n"+entry.getKey()+" : "+entry.getValue());
						}
					}
				}
				else if(clinicList.getSelectedIndex()==3) {
					for(Doctor d:psychiatry.getDoctorList()) {
						frame.getTextArea().append("\n\n"+d.getName()+": ");
						for(Entry<String, String> entry : d.getSchedule().entrySet()) {
							frame.getTextArea().append("\n"+entry.getKey()+" : "+entry.getValue());
						}
					}
				}
			}

		});


/////////////////////DISPLAYING ALL REGISTERED PATIENTS IN A CLINIC.//////////////////////////////////////////////////
		displayPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Choosing clinic
				JList clinicList = new JList(new String[] {"Ophthalmology", "Urology", "Orthopedics", "Psychiatry"});
				JOptionPane.showMessageDialog(null, clinicList, "Choose clinic", JOptionPane.PLAIN_MESSAGE);

				ArrayList<Patient> allPatients=new ArrayList<Patient>();
				if(clinicList.getSelectedIndex()==0) {  //Getting patients of each doctor according to chosen clinic. 
					for(Doctor d:ophthalmology.getDoctorList()) {
						for(Entry<String, Patient> entry : d.getRegisteredPatients().entrySet()) {
							allPatients.add(entry.getValue());
						}
					}
				}
				else if(clinicList.getSelectedIndex()==1) {
					for(Doctor d:urology.getDoctorList()) {
						for(Entry<String, Patient> entry : d.getRegisteredPatients().entrySet()) {
							allPatients.add(entry.getValue());
						}
					}
				}
				else if(clinicList.getSelectedIndex()==2) {
					for(Doctor d:orthopedics.getDoctorList()) {
						for(Entry<String, Patient> entry : d.getRegisteredPatients().entrySet()) {
							allPatients.add(entry.getValue());
						}
					}
				}
				else if(clinicList.getSelectedIndex()==3) {
					for(Doctor d:psychiatry.getDoctorList()) {
						for(Entry<String, Patient> entry : d.getRegisteredPatients().entrySet()) {
							allPatients.add(entry.getValue());
						}
					}
				}
				
				//Sorting patients and appending them to text area
				Collections.sort(allPatients);
				frame.getTextArea().append("\n\nPatients Registered In "+ clinicList.getSelectedValue()+":");
				for(Patient p:allPatients) {
					frame.getTextArea().append("\n"+p.toString());
				}
			}

		});


///////////////////////////////////////////EXAMINING PATIENT////////////////////////////////////////////////////
		examinePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//CHOOSING CLINIC
				JList clinicList = new JList(new String[] {"Ophthalmology", "Urology", "Orthopedics", "Psychiatry"});
				JOptionPane.showMessageDialog(null, clinicList, "Which Clinic?", JOptionPane.PLAIN_MESSAGE);

				//CHOOSING DOCTOR
				DefaultListModel<String> model = new DefaultListModel<>();
				JList<String> list2 = new JList<>( model );
				Clinic chosenClinic;
				if(clinicList.getSelectedIndex()==0) { //Creating doctors list according to chosen clinic
					chosenClinic=ophthalmology;
					for(Doctor d:ophthalmology.getDoctorList()) {
						model.addElement(d.getName());
					}
				}
				else if(clinicList.getSelectedIndex()==1) {
					chosenClinic=urology;
					for(Doctor d:urology.getDoctorList()) {
						model.addElement(d.getName());
					}
				}
				else if(clinicList.getSelectedIndex()==2) {
					chosenClinic=orthopedics;
					for(Doctor d:orthopedics.getDoctorList()) {
						model.addElement(d.getName());
					}
				}
				else  {
					chosenClinic=psychiatry;
					for(Doctor d:psychiatry.getDoctorList()) {
						model.addElement(d.getName());
					}
				}
				JOptionPane.showMessageDialog(null, list2, "Which Doctor?", JOptionPane.PLAIN_MESSAGE);

				//CHOOSING PATIENT TO EXAMINE
				Doctor chosenDoctor=chosenClinic.getDoctorList().get(list2.getSelectedIndex());


				DefaultListModel<String> modelPatients = new DefaultListModel<>();
				JList<String> listPatients = new JList<>(modelPatients);

				//Creating patients list according to doctor chosen.
				ArrayList<Patient> patientArrayList=new ArrayList<Patient>();
				for(Entry<String, Patient> entry : chosenDoctor.getRegisteredPatients().entrySet()) {
					modelPatients.addElement("Hour: "+entry.getKey()+" Patient: "+entry.getValue().getName());
					patientArrayList.add(entry.getValue());
				}

				JOptionPane.showMessageDialog(null, listPatients, "Which Patient?", JOptionPane.PLAIN_MESSAGE);

				try {
					Patient chosenPatient=patientArrayList.get(listPatients.getSelectedIndex());
					
					//Showing information of chosen patient.
					JOptionPane.showMessageDialog(null, "INFORMATION OF PATIENT  -  "+chosenPatient);
					frame.getTextArea().append("\n\nDoctor "+chosenDoctor.getName()+" Examining a Patient.\nINFORMATION OF PATIENT  -  "+chosenPatient);
					
					//EXAMINATION
					String diognastedIllness=JOptionPane.showInputDialog("Diagnosed Illness: ");
					chosenPatient.addOldIllnesses(diognastedIllness);
					String suggestedDrugs=JOptionPane.showInputDialog("Suggested Drugs: (Put space between drugs.)");
					String[] suggestedDrugsArray=suggestedDrugs.split(" ");
					String[] oldDrugsArray=chosenPatient.getOldDrugs().split(" ");
					String examinationResult="\n\nEXAMINATION FINISHED. RESULTS:\n";

					Drug currentDrug;
					String conflictedDrugName="";
					double totalCostForPatient=0;

					double totalDrugCost=0;
					double clinicsProfit=0;
					double doctorsIncome=chosenDoctor.getVisitCost()*chosenDoctor.getDoctorsProfitPercentage();
					double drugFirmsIncome=0;
					
					//CHECKING EACH SUGGESTED DRUG
					for(int i=0; i<suggestedDrugsArray.length; i++) {
						for(Drug d:allDrugs) {
							if(d.getName().equals(suggestedDrugsArray[i])) {
								currentDrug=d;
								boolean conflicts=false;
								for(Drug drug:currentDrug.getConflictingDrugs()) {
									for(int j=0; j<oldDrugsArray.length;j++) {
										if(drug.getName().equals(oldDrugsArray[j])) {
											conflicts=true;
											conflictedDrugName=drug.getName();
										}
									}
								}

								if(conflicts) {
									examinationResult+="\n" + d.getName()+" CANNOT be given because it conflicts with patients old drug: "+conflictedDrugName;
								} else {
									examinationResult+="\n" + d.getName()+" is given to patient.";
									chosenPatient.addOldDrugs(d.getName());
									//UPDATING INCOMES AND COST
									totalDrugCost+=d.getPrice();
									clinicsProfit+=d.getPrice()*d.getClinicsProfitPercentage();
									drugFirmsIncome+=d.getPrice()*(1-d.getClinicsProfitPercentage());
								}
							}
						}
					}
					clinicsProfit+=chosenDoctor.getVisitCost()*(1-chosenDoctor.getDoctorsProfitPercentage());
					totalCostForPatient=chosenDoctor.getVisitCost()+totalDrugCost;
					examinationResult+="\n\nTOTAL EXAMINATION COST: "+totalCostForPatient+" (Visit Cost: "+chosenDoctor.getVisitCost()+", Drugs cost:"+totalDrugCost+")"
							+"\nClinic's Profit:"+clinicsProfit
							+"\nDoctor's Income:"+doctorsIncome
							+"\nDrug Firms' Income:"+drugFirmsIncome;

					frame.getTextArea().append(examinationResult);
				} 

				//IF THERE DOES NOT EXIST ANY PATIENT IN CHOSEN DOCTOR.
				catch(IndexOutOfBoundsException e)
				{
					JOptionPane.showMessageDialog(null, "There is no patient.");
				}

			}

		});
	}
}

