import java.util.*;

public class blackjack
{
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Hello, would you like to play blackjack?"+"\n\nY for yes N for no");
        String plyrin = scnr.nextLine();
        
        if (!plyrin.contains("y") && !plyrin.contains("Y")) {
            System.out.println("okay, see ya later alligator!");
            System.exit(0);
        } 
        System.out.println("Great lets play!"+"\n\n\nDealing...");
        
        // create shuffled deck and initialize necessary vars
        ArrayList deckObj = new ArrayList();
        deckObj = newDeck();
        ArrayList playerHand = new ArrayList();
        ArrayList dealerHand = new ArrayList();
        int dealerTotal = 0;
        int playerTotal = 0;
        boolean dealerTurn = false;
        //deal 2 cards to player and dealer
        playerHand.add(deckObj.get(0));
        deckObj.remove(0);
        playerHand.add(deckObj.get(0));
        deckObj.remove(0);
        dealerHand.add(deckObj.get(0));
        deckObj.remove(0);
        dealerHand.add(deckObj.get(0));
        deckObj.remove(0);
        boolean plyrTurn = true;
        
        while (plyrTurn = true) {
            playerTotal = checkTotal(playerHand);
            dealerTotal = checkTotal(dealerHand);
            if (playerTotal > 21 & playerHand.contains("a")) {
                playerHand.add("1");
                playerHand.remove("a");
                playerTotal = checkTotal(playerHand);
            }
            if (playerTotal > 21) {
                System.out.println("you went over 21 dealer wins, better luck next time.");
                System.exit(0);
            }
            updateBoard(playerHand, playerTotal, dealerHand);
            System.out.println("what will you do? \n S:stand H:hit");
            plyrin = scnr.nextLine();
            switch (plyrin) {
                case ("h"):
                case ("H"):
                    playerHand.add(deckObj.get(0));
                    deckObj.remove(0);
                    break;
                case ("s"):
                case ("S"):
                    dealerTurn = true;
                    break;
            }
            while (dealerTurn) {
            dealerTotal = checkTotal(dealerHand);
             fullBoard(playerHand, playerTotal, dealerHand, dealerTotal);
             if (dealerTotal < 17) {
                 dealerHand.add(deckObj.get(0));
                 deckObj.remove(0);
             } else if (dealerTotal == 17 & dealerHand.contains("a")) {
                 dealerHand.add(deckObj.get(0));
                 deckObj.remove(0);
                 System.exit(0);
             }
             if (dealerTotal > 21 & dealerHand.contains("a")) {
                dealerHand.add("1");
                dealerHand.remove("a");
                dealerTotal = checkTotal(dealerHand);
            } 
            if (dealerTotal >17) {
                checkWin(playerTotal, dealerTotal);
                
                
            }
            if (dealerTotal == 17 & !dealerHand.contains("a")) {
                checkWin(playerTotal, dealerTotal);
                
                
            }
            
        }
             

    }
}
        
    public static ArrayList newDeck() {
        Random rndm = new Random();
        ArrayList deckVals = new ArrayList();
        Object pointer = new Object();
        ArrayList deck = new ArrayList();
        
        for (int i = 0; i < 4; i++) {
            deckVals.add("a");
            deckVals.add("2");
            deckVals.add("3");
            deckVals.add("4");
            deckVals.add("5");
            deckVals.add("6");
            deckVals.add("7");
            deckVals.add("8");
            deckVals.add("9");
            deckVals.add("10");
            deckVals.add("j");
            deckVals.add("q");
            deckVals.add("k");
        }
        
        for (int i = 0; i < 52; i++) {
            int length = deckVals.size();
            pointer = deckVals.get(rndm.nextInt(length));
            deck.add(pointer);
            deckVals.remove(pointer);
        }
        return deck;
    }
    
    public static void updateBoard (ArrayList playerHand, int playerTotal, ArrayList dealerHand) {
        System.out.println("Dealer:  " + dealerHand.get(0) + ",#");
         System.out.println("Total = ?\n\n\n");
          System.out.println("Player:  " + playerHand);
           System.out.println("Total = " + playerTotal);
         
        
        
    }
    
    public static int checkTotal(ArrayList hand) {
        int total = 0;
        for (Object card:hand) {
            if (card instanceof String) {
                String cardString = (String) card;
                switch (cardString){
                    case "j":
                        total += 10;
                        break;
                    case "q":
                        total += 10;
                        break;
                    case "k":
                        total += 10;
                        break;
                    case "a":
                        total += 11;
                        break;
                    default: 
                        total += Integer.parseInt(cardString);
                }
            }
                
        }
        return total;
    }
    public static void fullBoard (ArrayList playerHand, int playerTotal, ArrayList dealerHand, int dealerTotal) {
        System.out.println("Dealer:  " + dealerHand);
         System.out.println("Total = "+dealerTotal+"\n\n\n");
          System.out.println("Player:  " + playerHand);
           System.out.println("Total = " + playerTotal);
         
        
        
    }
    public static void checkWin(int plyrtotal, int dealertotal) {
        if (dealertotal > 21) {
            System.out.println("dealer went over 21, you win!");
            System.exit(0);
        } else if (dealertotal > plyrtotal) {
            System.out.println("you lose, better luck next time!");
            System.exit(0);
        } else if (dealertotal == plyrtotal) {
            System.out.println("its a tie!");
            System.exit(0);
        } else {
            System.out.println("congratulations, you win!");
            System.exit(0);
        }
    }
   
}
