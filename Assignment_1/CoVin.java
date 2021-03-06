package Assignment_1;

import java.util.*;

class CoVin{

    private final ArrayList<Hospital> hospitals = new ArrayList<>();
    private final ArrayList<Citizen> citizens = new ArrayList<>();
    private final ArrayList<Vaccine> vaccines = new ArrayList<>();

    private boolean valid(String s, int size){

        if(s.length() == 0) return false;

        if(size >= 0)
            if(s.length() != size) return false;

        for(int i = 0; i < s.length(); i++){
            int ch = (int)s.charAt(i) - 48;
            if(ch > 9 || ch < 0) return false;
        }
        return true;
    }


    void coVin() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nCoWin Portal initialized....\n");
        while(true){

            System.out.println(" ---------------------------------");
            System.out.println("1. Add Vaccine\n2. Register Hospital\n3. Register Citizen\n4. Add Slot for Vaccination\n5. Book Slot for Vaccination\n6. List all slots for a hospital\n7. Check Vaccination Status\n8. Exit");
            System.out.println("---------------------------------");

            System.out.print("Menu Options: ");
            String choice = sc.nextLine();

            if(choice.equals("8")){
                System.out.println("Thank You for visiting the CoVin Portal. :)\n");
                System.out.println(" ---------------------------------\n");

                break;

            } else if(choice.equals("1")){

                int dose_count, dose_gap = 0;
                System.out.print("Vaccine Name: ");
                String name = sc.nextLine();
                boolean is_name = true;
                for(Vaccine vaccine: vaccines){
                    if(vaccine.getName().equals(name)){
                        is_name = false;
                        break;
                    }
                }
                if(!is_name){
                    System.out.println("Vaccine with the same name already exits");
                    continue;
                }

                System.out.print("Number of Doses: ");
                String _dose_count= sc.nextLine();
                if (valid(_dose_count, -1) && Integer.parseInt(_dose_count) > 0) dose_count = Integer.parseInt(_dose_count);
                else{
                    System.out.println("Invalid Input for Number of dose(Can be a greater than 0 Integer only!!)");
                    continue;
                }

                if(dose_count > 1){
                    System.out.print("Gap between Doses: ");
                    String _dose_gap = sc.nextLine();
                    if (valid(_dose_gap, -1)) dose_gap = Integer.parseInt(_dose_gap);
                    else{
                        System.out.println("Invalid Input for Gap between dose(Can be Integer only!)");
                        continue;
                    }
                    if(dose_gap < 1){
                        System.out.println("Invalid Input for Gap between dose(Can be a greater than 1Integer only!)");
                        continue;
                    }
                }

                vaccines.add(new Vaccine(name, dose_count, dose_gap));


            } else if(choice.equals("2")){

                System.out.print("Hospital Name: ");
                String name = sc.nextLine();

                System.out.print("PinCode: ");
                String pinCode = sc.nextLine();
                if(valid(pinCode, 6)){
                    hospitals.add(new Hospital(name, pinCode));

                } else {
                    System.out.println("Invalid Input for PinCode(Can be a 6 digit Integer only!)");
                }


            } else if(choice.equals("3")){
                int age;

                System.out.print("Citizen Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                String _age = sc.nextLine();
                if (valid(_age, -1))  age = Integer.parseInt(_age);
                else{
                    System.out.println("Invalid Input for Age(Can be Integer only!)");
                    continue;
                }

                System.out.print("Unique ID: ");
                String id = sc.nextLine();
                if(!valid(id, 12)){
                    System.out.println("Invalid Input for Unique ID(Can be 12 digit Integer only!)");
                    continue;
                }

                if(age > 18){
                    Citizen el = new Citizen(name, age, id);
                    boolean is_name = true;
                    for(Citizen citizen: citizens){
                        if(el.getId().equals(citizen.getId())){
                            is_name = false;
                            break;
                        }
                    }
                    if(!is_name){
                        System.out.println("Citizen with the same ID already exits");
                        continue;
                    }
                    citizens.add(el);
                } else {
                    System.out.println("Citizen Name: " + name + ", Age: " + age + ", Unique ID: "+ id);
                    System.out.println("Only above 18 are allowed");
                }


            } else if(choice.equals("4")){
                int hospital_id, slots_count, day, quantity, vaccine;
                String temp;

                if(vaccines.size() == 0){
                    System.out.println("Let the vaccine come first.");
                    continue;
                }

                System.out.print("Enter Hospital ID: ");
                temp = sc.nextLine();
                if (valid(temp, 6))  hospital_id = Integer.parseInt(temp);
                else{
                    System.out.println("Invalid Input for Hospital ID(Can be 6 digit Integer only!)");
                    continue;
                }
                boolean is_id = false;
                for(Hospital hospital: hospitals){
                    if (hospital.getId() == hospital_id) {
                        is_id = true;
                        break;
                    }
                }
                if(!is_id){
                    System.out.println("Invalid Input for Hospital ID(No Hospital with such ID)");
                    continue;
                }


                System.out.print("Enter number of Slots to be added: ");
                temp = sc.nextLine();
                if (valid(temp, -1))  slots_count = Integer.parseInt(temp);
                else{
                    System.out.println("Invalid Input for Slots Count(Can be Integer only!)");
                    continue;
                }

                while(slots_count-->0){
                    System.out.print("Enter Day Number: ");
                    temp = sc.nextLine();
                    if(temp.equals("0")){
                        System.out.println("day can not be zero");
                        continue;
                    }
                    if (valid(temp, -1))  day = Integer.parseInt(temp);
                    else{
                        System.out.println("Invalid Input for Day(Can be Integer only!)");
                        continue;
                    }


                    System.out.print("Enter Quantity: ");
                    temp = sc.nextLine();
                    if (valid(temp, -1))  quantity = Integer.parseInt(temp);
                    else{
                        System.out.println("Invalid Input for Quantity(Can be Integer only!)");
                        continue;
                    }


                    System.out.println("Select Vaccine");
                    for(int i = 0; i < vaccines.size(); i++){
                        System.out.println(" " + i + ". " + vaccines.get(i).getName());
                    }

                    temp = sc.nextLine();
                    if (valid(temp, -1) && Integer.parseInt(temp) >= 0 && Integer.parseInt(temp) < vaccines.size())  vaccine = Integer.parseInt(temp);
                    else{
                        System.out.println("Invalid Input for Vaccine(Only Can be a Integer and belong to the provided options!)");
                        continue;
                    }


                    boolean is_name = true;
                    for(Slot slot : hospitals.get(hospital_id-111111).getSlots()){
                        if(slot.getDay() == day && slot.getVaccine().getName().equals(vaccines.get(vaccine).getName())){
                            is_name = false;
                            break;
                        }
                    }
                    if(!is_name){
                        System.out.println("Slot of vaccine " + vaccines.get(vaccine).getName() + " had already been added for this day " + day);
                        continue;
                    }


                    hospitals.get(hospital_id -111111).create_slot(day, quantity, vaccines.get(vaccine));
                }


            } else if(choice.equals("5")){
                Hospital hospital;
                Citizen citizen = null;
                String temp;

                System.out.print("Enter patient Unique ID: ");
                String unique_id = sc.nextLine();

                if (valid(unique_id, 12)){
                    boolean is_citi = false;
                    for(Citizen citi: citizens) {
                        if(citi.getId().equals(unique_id)) {
                            is_citi = true;
                            citizen = citi;
                            break;
                        }
                    }

                    if(!is_citi){
                        System.out.println("Invalid Input for Unique ID(Should be valid citizens)");
                        continue;
                    }

                } else {
                    System.out.println("Invalid Input for Unique ID(Can be 12 digit Integer only!");
                    continue;
                }

                System.out.print(" 1. Search by area\n 2. Search by Vaccine\n 3. Exit\nEnter Option: ");
                String option = sc.nextLine();

                if(option.equals("1")) {

                    int hospital_id, chossen_slot;

                    System.out.print("Enter PinCode: ");
                    String pinCode = sc.nextLine();
                    if (!valid(pinCode, 6)) {
                        System.out.println("Invalid Input for Unique ID(Can be 12 digit Integer only!)");
                        continue;
                    }
                    boolean is_pinCode = false;
                    for(Hospital hosp: hospitals){
                        if(hosp.getPinCode().equals(pinCode)) {
                            is_pinCode = true;
                            System.out.println(hosp.getId() + ", " + hosp.getName());
                        }
                    }
                    if (!is_pinCode) {
                        System.out.println("(No Hospital Registered for given Location)");
                        continue;
                    }

                    System.out.print("Enter Hospital Id: ");
                    temp = sc.nextLine();
                    if (valid(temp, 6)){
                        hospital_id = Integer.parseInt(temp);

                        boolean is_hosp = false;
                        for(Hospital hosp: hospitals) {
                            if(hosp.getId() == hospital_id) {
                                is_hosp = true;
                                break;
                            }
                        }
                        if(!is_hosp){
                            System.out.println("Invalid Input for Hospital ID(Can be 6 digit Integer and from above options only!)");
                            continue;
                        }
                    } else {
                        System.out.println("Invalid Input for Hospital ID(Can be 6 digit Integer only!)");
                        continue;
                    }

                    hospital = hospitals.get(hospital_id-111111);
                    int show = hospital.show_slots1(citizen);

                    if(show == 0){
                        System.out.println("No slots available");
                        continue;
                    }

                    System.out.print("Choose Slot: ");
                    temp = sc.nextLine();
                    if (valid(temp, -1) && Integer.parseInt(temp) >= 0 && Integer.parseInt(temp) < show) chossen_slot = Integer.parseInt(temp);
                    else{
                        System.out.println("Invalid Input for Choosen Slot(Can be a Integer from above options only!)");
                        continue;
                    }

                    hospital.book_slot1(citizen, chossen_slot);


                } else if(option.equals("2")) {

                    int hospital_id, chossen_slot;

                    System.out.print("Enter Vaccine name: ");
                    String vaccine = sc.nextLine();

                    if(citizen.getStatus().getStatus().equals("PARTIALLY VACCINATED") && !vaccine.equals(citizen.getStatus().getVaccine().getName())){
                        System.out.println("(Can not take two different vaccines)");
                        continue;
                    }

                    boolean is_vaccine = false;
                    String prev_name = null;
                    for(Hospital hosp: hospitals){
                        for(Slot slot : hosp.getSlots()) {

                            if(slot.getVaccine().getName().equals(vaccine) && !hosp.getName().equals(prev_name)){
                                is_vaccine = true;
                                System.out.println(hosp.getId() + ", " + hosp.getName());
                                prev_name = hosp.getName();
                            }
                        }
                    }

                    if (!is_vaccine) {
                        System.out.println("(No Vaccine slot in any Hospital exists with the given name)");
                        continue;
                    }

                    System.out.print("Enter Hospital Id: ");
                    temp = sc.nextLine();
                    if (valid(temp, 6)){
                        hospital_id = Integer.parseInt(temp);

                        boolean is_hosp = false;
                        for(Hospital hosp: hospitals) {
                            if(hosp.getId() == hospital_id) {
                                is_hosp = true;
                                break;
                            }
                        }
                        if(!is_hosp){
                            System.out.println("Invalid Input for Hospital ID(Can be 6 digit Integer and from above options only!)");
                            continue;
                        }
                    } else {
                        System.out.println("Invalid Input for Hospital ID(Can be 6 digit Integer only!)");
                        continue;
                    }

                    hospital = hospitals.get(hospital_id-111111);

                    int show = hospital.show_slots2(citizen, vaccine);

                    if(show == 0){
                        System.out.println("No slots available");
                        continue;
                    }

                    System.out.print("Choose Slot: ");
                    temp = sc.nextLine();
                    if (valid(temp, -1) && Integer.parseInt(temp) >= 0 && Integer.parseInt(temp) < show) chossen_slot = Integer.parseInt(temp);
                    else{
                        System.out.println("Invalid Input for Chosen Slot(Can be a Integer from above options only!)");
                        continue;
                    }

                    hospital.book_slot2(citizen, chossen_slot, vaccine);

                } else if(option.equals("3")) {

                } else {
                    System.out.println("Invalid Input for Options(Can be 1, 2, 3)");
                }

            } else if(choice.equals("6")){
                int hospital_id;
                System.out.print("Enter Hospital Id: ");
                String temp = sc.nextLine();
                if(valid(temp, 6)) hospital_id = Integer.parseInt(temp);
                else {
                    System.out.println("Invalid Input for Hospital ID(Can be 6 digit Integer only!)");
                    continue;
                }
                boolean is_id = false;
                for(Hospital hospital: hospitals){
                    if (hospital.getId() == hospital_id) {
                        is_id = true;
                        break;
                    }
                }

                if(!is_id){
                    System.out.println("Invalid Input for Hospital ID(No Hospital with such ID)");
                    continue;
                }
                if(hospitals.get(hospital_id-111111).getSlots().size() == 0){
                    System.err.println("No Slots been added Yet.");
                } else {
                    hospitals.get(hospital_id-111111).show_slot();
                }

            } else if(choice.equals("7")){

                if(citizens.size() == 0){
                    System.out.println("There is no Patient who did register at present");
                    continue;
                }

                System.out.print("Enter Patient ID: ");
                String id = sc.nextLine();
                if(!valid(id, 12)){
                    System.out.println("Invalid Input for Unique ID(Can be 12 digit Integer only!)");
                    continue;
                }

                for(Citizen citizen: citizens){
                    if (citizen.getId().equals(id)){
                        System.out.println(citizen.getStatus().getStatus());
                        if(citizen.getStatus().getStatus().equals("FULLY VACCINATED")) {
                            System.out.println("Vaccine Given: " + citizen.getStatus().getVaccine().getName());
                            System.out.println("Number of Doses given: " + citizen.getStatus().getDose_count());
                        }
                        if (citizen.getStatus().getStatus().equals("PARTIALLY VACCINATED")) {
                            System.out.println("Vaccine Given: " + citizen.getStatus().getVaccine().getName());
                            System.out.println("Number of Doses given: " + citizen.getStatus().getDose_count());
                            System.out.println("Next Dose due date: " + citizen.getStatus().getNext_due());
                        }
                    }
                }

            } else {
                System.out.println("Whoops!! Invalid {Menu Option}\nPlease select out of {1, 2, 3, 4, 5, 6, 7, 8}.");
            }
        }
        sc.close();
    }

}
