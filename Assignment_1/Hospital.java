package Assignment_1;
import java.util.*;

class Hospital{
    private final int id;
    private final String name;
    private final String pinCode;
    private final ArrayList <Slot> slots = new ArrayList<>();

    private static int random = 111111;

    Hospital(String name, String pinCode){
        this.name = name;
        this.pinCode = pinCode;
        this.id = random;
        random++;

        System.out.println("Hospital Name: " + this.name + ", PinCode: " + this.pinCode + ", Unique ID: "+this.id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public String getPinCode() {
        return pinCode;
    }

    private void modify_slot(Citizen citizen, Slot slot){
        System.out.println(citizen.getName() + " vaccinated with " + slot.getVaccine().getName());
        slot.setQuantity();
        citizen.getStatus().setStatus(slot);
        if(slot.getQuantity() == 0){
            slots.remove(slot);
        }
    }


    void create_slot(int day, int quantity, Vaccine vaccine){

        slots.add(new Slot(day, quantity, vaccine));
        Collections.sort(slots);
        System.out.println("Slot added by Hospital " + id + " for Day: " + day + ", Available Quantity: " + quantity + " of Vaccine " + vaccine.getName());
    }

    void show_slot(){
        for(Slot slot : slots){
            System.out.println("Day: " + slot.getDay() + " Vaccine: " + slot.getVaccine().getName() + " Available Qty: " + slot.getQuantity());
        }
    }


    int show_slots1(Citizen citizen){

        int show = 0;

        if (citizen.getStatus().getStatus().equals("FULLY VACCINATED")){
            System.out.println("You are already Fully Vaccinated.\nYou don't need to book slot again hence No slots for you will be showed.");

        } else if (citizen.getStatus().getStatus().equals("Citizen REGISTERED")) {
            for(Slot slot : slots)
                System.out.println(show++ + "-> Day: " + slot.getDay()  + " Available Qty: " + slot.getQuantity() + " Vaccine: " + slot.getVaccine().getName());

        } else {
            show = getShowNum(citizen, show);
        }
        return show;
    }

    private int getShowNum(Citizen citizen, int show) {
        if (citizen.getStatus().getStatus().equals("PARTIALLY VACCINATED")) {
            for(Slot slot : slots){
                if(slot.getDay() >= citizen.getStatus().getNext_due() && citizen.getStatus().getVaccine().getName().equals(slot.getVaccine().getName())){
                    System.out.println(show++ + "-> Day: " + slot.getDay()  + " Available Qty: " + slot.getQuantity() + " Vaccine: " + slot.getVaccine().getName());
                }
            }
        }
        return show;
    }

    int show_slots2(Citizen citizen, String vacine){

        int show = 0;

        if (citizen.getStatus().getStatus().equals("FULLY VACCINATED")){
            System.out.println("You are already Fully Vaccinated.\nYou don't need to book slot again hence No slots for you will be showed.");

        } else if (citizen.getStatus().getStatus().equals("Citizen REGISTERED")) {
            for(Slot slot : slots)
                if(slot.getVaccine().getName().equals(vacine))
                    System.out.println(show++ + "-> Day: " + slot.getDay()  + " Available Qty: " + slot.getQuantity() + " Vaccine: " + slot.getVaccine().getName());

        } else show = getShowNum(citizen, show);
        return show;
    }


    private Slot book_partial(Citizen citizen, int chossen_slot){
        int show = 0;
        Slot slot = null;
        for(Slot _slot : slots){

            if(_slot.getDay() >= citizen.getStatus().getNext_due() && citizen.getStatus().getVaccine().getName().equals(_slot.getVaccine().getName())){
                if(show == chossen_slot){
                    slot = _slot;
                    break;
                }
                show++;
            }
        }
        return slot;
    }

    void book_slot1(Citizen citizen, int chossen_slot){
        Slot slot = null;
        int show=0;
        if (citizen.getStatus().getStatus().equals("Citizen REGISTERED")) {
            for(Slot _slot : slots){
                if(show == chossen_slot){
                    slot = _slot;
                    break;
                }
                show++;
            }
        } else if (citizen.getStatus().getStatus().equals("PARTIALLY VACCINATED")) {
            slot = book_partial(citizen, chossen_slot);
        }

        modify_slot(citizen, slot);
    }

    void book_slot2(Citizen citizen, int chossen_slot, String vaccine){
        Slot slot = null;
        int show=0;
        if (citizen.getStatus().getStatus().equals("Citizen REGISTERED")) {
            for(Slot _slot : slots){
                if(_slot.getVaccine().getName().equals(vaccine)){
                    if(show == chossen_slot){
                        slot = _slot;
                        break;
                    }
                    show++;
                }
            }

        } else if (citizen.getStatus().getStatus().equals("PARTIALLY VACCINATED")) {
            slot = book_partial(citizen, chossen_slot);
        }

        modify_slot(citizen, slot);
    }
}
