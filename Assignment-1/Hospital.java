import java.util.*;

class Hospital{
    int id;
    String name;
    String pinCode;
    ArrayList<Slot> slots = new ArrayList<>();

    private static int random = 111111;

    Hospital(String name, String pinCode){
        this.name = name;
        this.pinCode = pinCode;
        this.id = random;
        random++;

        System.out.println("Hospital Name: " + this.name + ", PinCode: " + this.pinCode + ", Unique ID: "+this.id);
    }


    private Slot book_partial(Citizen citizen, int chossen_slot){
        int show = 0;
        Slot slot = null;
        for(Slot _slot : slots){
            if(_slot.day == citizen.status.next_due && citizen.status.vaccine.name.equals(_slot.vaccine.name)){
                if(show == chossen_slot){
                    slot = _slot;
                    break;
                }
                show++;
            }
        }
        return slot;
    }


    private void modify_slot(Citizen citizen, Slot slot){
        System.out.println(citizen.name + " vaccinated with " + slot.vaccine.name);
        slot.quantity--;
        citizen.set_status(slot);
        if(slot.quantity == 0){
            slots.remove(slot);
        }
    }


    void create_slot(int day, int quantity, Vaccine vaccine){
        
        slots.add(new Slot(day, quantity, vaccine));
        Collections.sort(slots);
        System.out.println("Slot added by Hospital " + id + " for Day: " + day + ", Available Quantity: " + quantity + " of Vaccine " + vaccine.name);
    }

    void show_slot(){
        for(Slot slot : slots){
            System.out.println("Day: " + slot.day + " Vaccine: " + slot.vaccine.name + " Availabe Qty: " + slot.quantity);
        }
    }

    
    int show_slots1(Citizen citizen){

        int show = 0;

        if (citizen.status.status.equals("FULLY VACCINATED")){
            System.out.println("You are already Fully Vaccinated.\nYou don't need to book slot again hence No slots for you will be showed.");

        } else if (citizen.status.status.equals("Citizen REGISTERED")) {
            for(Slot slot : slots)
                System.out.println(show++ + "-> Day: " + slot.day  + " Availabe Qty: " + slot.quantity + " Vaccine: " + slot.vaccine.name);
            
        } else if (citizen.status.status.equals("PARTIALLY VACCINATED")) {
            for(Slot slot : slots){
                if(slot.day == citizen.status.next_due && citizen.status.vaccine.name.equals(slot.vaccine.name)){
                    System.out.println(show++ + "-> Day: " + slot.day  + " Availabe Qty: " + slot.quantity + " Vaccine: " + slot.vaccine.name);
                }
            }
        }
        return show;
    }


    int show_slots2(Citizen citizen, String vacine){

        int show = 0;

        if (citizen.status.status.equals("FULLY VACCINATED")){
            System.out.println("You are already Fully Vaccinated.\nYou don't need to book slot again hence No slots for you will be showed.");

        } else if (citizen.status.status.equals("Citizen REGISTERED")) {
            for(Slot slot : slots)
                if(slot.vaccine.name.equals(vacine))
                    System.out.println(show++ + "-> Day: " + slot.day  + " Availabe Qty: " + slot.quantity + " Vaccine: " + slot.vaccine.name);
            
        } else if (citizen.status.status.equals("PARTIALLY VACCINATED")) {
            for(Slot slot : slots){
                if(slot.day == citizen.status.next_due && citizen.status.vaccine.name.equals(slot.vaccine.name)){
                    System.out.println(show++ + "-> Day: " + slot.day  + " Availabe Qty: " + slot.quantity + " Vaccine: " + slot.vaccine.name);
                }
            }
        }
        return show;
    }
    

    void book_slot1(Citizen citizen, int chossen_slot){
        Slot slot = null;
        int show=0;
        if (citizen.status.status.equals("Citizen REGISTERED")) {
            for(Slot _slot : slots){
                if(show == chossen_slot){
                    slot = _slot;
                    break;
                }
                show++;
            }          
        } else if (citizen.status.status.equals("PARTIALLY VACCINATED")) {
            slot = book_partial(citizen, chossen_slot);
        }

        modify_slot(citizen, slot);
    }

    void book_slot2(Citizen citizen, int chossen_slot, String vaccine){
        Slot slot = null;
        int show=0;
        if (citizen.status.status.equals("Citizen REGISTERED")) {
            for(Slot _slot : slots){
                if(_slot.vaccine.name.equals(vaccine)){
                    if(show == chossen_slot){
                        slot = _slot;
                        break;
                    }
                    show++;
                }
            }  

        } else if (citizen.status.status.equals("PARTIALLY VACCINATED")) {
            slot = book_partial(citizen, chossen_slot);
        }

        modify_slot(citizen, slot);
    }
}
