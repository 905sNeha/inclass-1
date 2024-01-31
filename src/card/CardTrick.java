package card;

import java.util.Scanner;

/*
 * @Modified by: Sneha
 * Student Number: 9917110729
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(generateRandomValue());
            c.setSuit(Card.SUITS[generateRandomNumber(0, 3)]);
            magicHand[i] = c;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Pick the  card value: ");
        int userValue = scanner.nextInt();
        System.out.print("Pick the card suit (0-3): ");
        int userSuit = scanner.nextInt();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit]);

        boolean isCardInMagicHand = false;
        for (Card card : magicHand) {
            if (card.equals(userCard)) {
                isCardInMagicHand = true;
                break;
            }
        }

        if (isCardInMagicHand) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }
    
    private static int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
    
    private static int generateRandomValue() {
        return generateRandomNumber(1, 13);
    }
}