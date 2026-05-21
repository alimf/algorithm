# Algorithm Practice

A Java project containing implementations of various algorithms and data structure problems, primarily from HackerRank challenges.

## Project Overview

This project includes solutions for algorithm problems across multiple categories:
- **HackerRank Problems**: String similarity, matrix rotation, mars exploration, hackerland transmitter
- **Search Algorithms**: Binary search implementation
- **Sorting Algorithms**: Quick sort implementation

## Project Structure

```
src/
├── Main.java                          # Main entry point
└── practice/
    ├── hackerrank/                    # HackerRank problem solutions
    │   ├── StringSimilarity.java      # Z-algorithm for string similarity
    │   ├── MatrixLayerRotation.java   # Matrix layer rotation
    │   ├── MarsExploration.java
    │   ├── HackerLandTransmitter.java
    │   ├── TwoPlus.java
    │   └── Practice.java
    ├── search/
    │   └── BinarySearch.java
    └── sort/
        └── QuickSort.java

src/test/
└── java/practice/hackerrank/
    └── StringSimilarityTest.java      # JUnit 5 unit tests
```

## Testing

This project uses **JUnit 5** for unit testing.

### Running All Tests

```bash
./gradlew test
```

### Running Specific Test Class

```bash
./gradlew test --tests StringSimilarityTest
```

### Running a Specific Test Method

```bash
./gradlew test --tests StringSimilarityTest.testAabaabaab
```

### View Test Reports

After running tests, view the detailed HTML report at:
```
build/reports/tests/test/index.html
```

## Building the Project

To compile the project:

```bash
./gradlew build
```

To build without running tests:

```bash
./gradlew build -x test
```

## Running the Application

After building, run the main class or specific implementations:

```bash
./gradlew run
```

Or run specific classes directly:

```bash
java -cp build/classes/java/main practice.hackerrank.StringSimilarity
java -cp build/classes/java/main practice.hackerrank.MatrixLayerRotation
```

## Dependencies

- **Java 8+**
- **JUnit 5.10.0** (for testing)
- **Gradle** (build tool)
