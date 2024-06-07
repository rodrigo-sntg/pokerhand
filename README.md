# Poker Hand Evaluator

## Description

This project is a poker hand evaluator written in Java using Maven for dependency management and build. The evaluator determines the best poker hand from a given list of cards.

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
    git clone https://github.com/your-username/poker-hand-evaluator.git
    cd poker-hand-evaluator
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
