# Poker Hand Evaluator

## Description

This project is a poker hand evaluator written in Java using Maven for dependency management and build. The evaluator determines the best poker hand from a given list of cards.

## Poker Hand Rankings

In this application, poker hands are evaluated based on traditional poker hand rankings. Here is a brief explanation of each hand ranking from highest to lowest:

1. **Royal Flush**: A, K, Q, J, 10, all of the same suit. This is the highest possible hand in poker.
2. **Straight Flush**: Five consecutive cards of the same suit. For example, 9, 8, 7, 6, 5 of hearts.
3. **Four of a Kind**: Four cards of the same rank. For example, four 7s.
4. **Full House**: Three cards of one rank and two cards of another rank. For example, three 8s and two 4s.
5. **Flush**: Five cards of the same suit, not in sequence. For example, A, K, 5, 9, 2 of diamonds.
6. **Straight**: Five consecutive cards of different suits. For example, 8, 7, 6, 5, 4 of mixed suits.
7. **Three of a Kind**: Three cards of the same rank. For example, three 9s.
8. **Two Pair**: Two cards of one rank and two cards of another rank. For example, two 5s and two 3s.
9. **One Pair**: Two cards of the same rank. For example, two Jacks.
10. **High Card**: If no one has any of the above hands, the highest card wins. For example, a hand with K, Q, 7, 5, 3 where the King is the highest card.

### How the Evaluator Works

The application evaluates the hand of poker cards provided to it and determines the best possible hand according to the rankings listed above. The hand evaluator uses a series of strategy patterns to identify the highest-ranking hand from the given cards.


## Project Structure

The project follows the Maven standard structure:

```
── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── enums/
│ │ │ │ ├── CardValue.java
│ │ │ │ ├── Hands.java
│ │ │ │ └── Suits.java
│ │ │ ├── factory/
│ │ │ │ └── HandStrategyFactory.java
│ │ │ ├── helpers/
│ │ │ │ ├── CountNumbersHelper.java
│ │ │ │ ├── FlushHelper.java
│ │ │ │ └── SequenceHelper.java
│ │ │ ├── model/
│ │ │ │ └── Card.java
│ │ │ ├── strategy/
│ │ │ │ ├── FlushStrategy.java
│ │ │ │ ├── FourOfAKindStrategy.java
│ │ │ │ ├── FullHouseStrategy.java
│ │ │ │ ├── HandStrategy.java
│ │ │ │ ├── PairStrategy.java
│ │ │ │ ├── RoyalStraightFlushStrategy.java
│ │ │ │ ├── StraightFlushStrategy.java
│ │ │ │ ├── StraightStrategy.java
│ │ │ │ ├── ThreeOfAKindStrategy.java
│ │ │ │ └── TwoPairStrategy.java
│ │ │ └── validator/
│ │ │ └── HandEvaluator.java
│ └── test/
│ ├── java/
│ │ ├── factory/
│ │ │ └── HandStrategyFactoryTest.java
│ │ ├── helpers/
│ │ │ ├── CountNumbersHelperTest.java
│ │ │ ├── FlushHelperTest.java
│ │ │ └── SequenceHelperTest.java
│ │ ├── strategy/
│ │ │ ├── FlushStrategyTest.java
│ │ │ ├── FourOfAKindStrategyTest.java
│ │ │ ├── FullHouseStrategyTest.java
│ │ │ ├── PairStrategyTest.java
│ │ │ ├── RoyalStraightFlushStrategyTest.java
│ │ │ ├── StraightFlushStrategyTest.java
│ │ │ ├── StraightStrategyTest.java
│ │ │ ├── ThreeOfAKindStrategyTest.java
│ │ │ ├── TwoPairStrategyTest.java
│ │ └── validator/
│ │ └── HandEvaluatorTest.java
└── pom.xml
```


## Requirements

- JDK 22
- Maven 3.8.1 or higher

## Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/rodrigo-sntg/pokerhand.git
    cd pokerhand
    ```

2. **Build the project and run tests:**

    ```sh
    mvn clean install
    mvn test
    ```

## Usage

### Card Structure

- `CardValue` enum: Represents card values (TWO, THREE, ..., ACE).
- `Suits` enum: Represents card suits (HEART, SPADE, DIAMOND, CLUB).
- `Card` class: Represents a poker card with a value (`CardValue`) and a suit (`Suits`).

### Hand Evaluator

- `HandEvaluator` class: Evaluates a list of cards and returns the best poker hand.

### Hand Strategies

- Each poker hand is represented by a class implementing the `HandStrategy` interface.
- Examples include `RoyalStraightFlushStrategy`, `StraightFlushStrategy`, `FourOfAKindStrategy`, etc.

### Code Example

Here is an example of how to use the poker hand evaluator:

```java
import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import com.poker.validator.HandEvaluator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardValue.TWO, Suits.CLUB.getSuit()));
        cards.add(new Card(CardValue.TWO, Suits.DIAMOND.getSuit()));
        cards.add(new Card(CardValue.TWO, Suits.HEART.getSuit()));
        cards.add(new Card(CardValue.TWO, Suits.SPADE.getSuit()));
        cards.add(new Card(CardValue.TWO, Suits.CLUB.getSuit()));

        String hand = HandEvaluator.evaluateHand(cards);
        System.out.println(hand); // Output: "Invalid hand" (due to duplicates)
    }
}
```

## Tests

Tests are located in `src/test/java` and cover the functionality of helper classes, hand strategies, and the hand evaluator.

To run the tests, use:

```sh
mvn test
```

## Contribution

1. Fork the project.
2. Create a feature branch (`git checkout -b feature/fooBar`).
3. Commit your changes (`git commit -am 'Add some fooBar'`).
4. Push to the branch (`git push origin feature/fooBar`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
