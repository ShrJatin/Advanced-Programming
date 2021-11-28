package Assignment_4;

import java.util.*;

public class Game {

    private final Player player;
    private final Carpet <Tile<SoftToy>> carpet;
    private final Random rnd;
    private final Scanner sc;
    private final int length;
    private final String [] trialList = {"fifth", "fourth", "third", "second", "first"};
    private final String [] softToys =
            {
                "Fuzzy", "Softy", "Baby Bear", "Mr. Cuddles",
                "Peaches", "LoveBug", "Snuggles", "Honey",
                "Pebbles", "Twinkly", "Chubby", "Mr. Fluff",
                "Sprinkles", "Angel", "Sooty", "Piglet",
                "Snowball", "Angel", "Bella", "Honeypot"
            };
    private int trials;

    public Game(int length, int trials) {

        this.trials = trials;
        this.rnd = new Random();
        this.player = new Player();
        this.sc = new Scanner(System.in);
        this.carpet = new Carpet<>(length);
        this.length = length;

        try{
            buildArena();
        } catch (CarpetLengthExceedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\tGame is ready");
    }

    void buildArena() throws CarpetLengthExceedException {

        for(int i = 0; i < length; i++) {
            if(carpet.getCarpet().size() > carpet.getLength())
                throw new CarpetLengthExceedException("Carpet length Exceeded");

            Tile<SoftToy> tile;
            try{
                if(i % 2 == 0){
                    tile = new OddTile<>(new SoftToy(softToys[i]));
                } else {
                    tile = new EvenTile<>(new SoftToy(softToys[i]));
                }
            } catch (IndexOutOfBoundsException e){
                System.out.println("Limited Soft Toys add more");
                e.printStackTrace();
                break;
            }

            carpet.fillCarpet(tile);
        }
    }

     private String getChoice() throws InvalidDataTypeException{
        String choice  = sc.nextLine().toLowerCase();
        if((choice.equals("string") || choice.equals("integer")))
            return choice;
        else
            throw new InvalidDataTypeException("\tWrong input\nInput can be from: Integer or String");
    }

    void playGame() {

        while(trials -->= 1) {

            System.out.print("\nHit enter for your " + trialList[trials] + " hop");
            sc.nextLine();
            int hop = rnd.nextInt(20) + 1;

            Tile<SoftToy> tile;
            try {
                tile = carpet.getTile(hop);
            } catch (TileNotExistException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("\tYou landed on tile " + hop + "");
            boolean canAdd = false;

            if (tile instanceof EvenTile) {
                canAdd = true;

            } else if (tile instanceof OddTile) {
                System.out.println("Question answer round. Integer or String?");
                String choice;
                while (true) {
                    try {
                        choice = getChoice();
                        break;
                    } catch (InvalidDataTypeException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (choice.equals("integer")) {
                    Calculator<Integer> calculator;
                    int n1;
                    int n2;
                    while(true){
                        GenPair<Integer> intPair = new GenPair<>();
                        intPair = intPair.intPair();
                        n1 = intPair.getEl1();
                        n2 = intPair.getEl2();
                        calculator = new Calculator<>(n1, n2);
                        try {
                            calculator.operate();
                            break;
                        } catch (ZeroDivisionException | InvalidDataTypeException ignored){}
                    }

                    System.out.println("Calculate the result of " + n1 + " divided by " + n2);
                    String resP = sc.nextLine();
                    try {
                        Integer.parseInt(resP);
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nIncorrect Answer");
                        System.out.println("You did not win any soft toy");
                        continue;
                    }

                    try {
                        Integer resC = (Integer) calculator.operate();
                        try {
                            canAdd = calculator.check(resC, Integer.parseInt(resP));
                            if(canAdd) System.out.println("\tCorrect Answer");

                        } catch (TypeMismatchException | NullPointerException e) {
                            System.out.println(e.getMessage());
                        }

                    } catch (ClassCastException | InvalidDataTypeException | NullPointerException | ZeroDivisionException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (choice.equals("string")) {

                    GenPair<String> strPair = new GenPair<>();
                    strPair = strPair.strPair();
                    String s1 = strPair.getEl1();
                    String s2 = strPair.getEl2();

                    System.out.println("Calculate the concatenation of strings " + s1 + " and " + s2);
                    String resp = sc.nextLine();

                    Calculator<String> calculator = new Calculator<>(s1, s2);

                    try {
                        String resC = (String) calculator.operate();
                        try {
                            canAdd = calculator.check(resC, resp);
                            if(canAdd) System.out.println("\tCorrect Answer");
                        } catch (TypeMismatchException e) {
                            System.out.println(e.getMessage());
                        }

                    } catch (ClassCastException | NullPointerException | InvalidDataTypeException | ZeroDivisionException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            if(canAdd)
                try {
                    tile.giveGift(player);
                } catch (TypeMismatchException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            else {
                System.out.println("\nIncorrect Answer");
                System.out.println("You did not win any soft toy");
            }
        }

        System.out.println("\n\tGame Over\n");
        if(player.getBucket().getBucket().isEmpty())
            System.out.println("\nYour Bucket is Empty");
        else {
            System.out.println("Soft toys won by you are:");
            player.showBucket();
        }
    }
}
