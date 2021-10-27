package Assignment_3;

import java.util.*;

class Game {

    private final ArrayList<Floor> floors = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    void buildArena(){
        for(int i = 0 ; i  < 14; i++){

            if(i == 2){
                floors.add(new ElevatorLadderFloor(i,new EmptyFloor(10)));

            } else if(i == 5){
                floors.add(new NormalSnakeFloor(i, new EmptyFloor(1)));

            } else if(i == 8){
                floors.add(new NormalLadderFloor(i, new EmptyFloor(12)));

            }else if(i == 11){
                floors.add(new CobraSnakeFloor(i,new EmptyFloor(3)));

            }else {
                floors.add(new EmptyFloor(i));
            }
        }
    }


    void playGame(){
        System.out.println("Enter the player name and hit enter");
        String name = sc.nextLine();

        Player player = new Player(name);
        buildArena();

        System.out.println("The game setup is ready.");
        int roll;
        do {
            System.out.print("\nHit enter to roll the dice");
            sc.nextLine();
            roll = player.roll();

            if(roll != 1){
                System.out.println("Game cannot start until you get 1");
            }
        } while(roll != 1);

        player.jump(floors.get(0));

        while(player.getFloor().getLocation() != 13){
            System.out.print("\nHit enter to roll the dice");
            sc.nextLine();
            roll = player.roll();

            int new_loc = player.getFloor().getLocation() + roll;
            if(new_loc > 13){
                System.out.println("Player cannot move");
                continue;
            }
            player.jump(floors.get(new_loc));
        }

        System.out.println("\tGame Over\n");
        System.out.println(player.getName() + " accumulated " + player.getPoints() + " points.");
        System.out.println("Collected prizes by " + player.getName() + ":");
        int i = 0;
        for(Prize prize : player.getPrizes()){
            System.out.println("\t" + ++i + ". " + prize.getPrize());
        }
        System.out.println("---------------------------------------------------------------");

    }
}
