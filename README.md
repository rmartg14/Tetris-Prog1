# Tetris – Programming I

A command-line implementation of the classic **Tetris** game, developed as the final group assignment for the **Programming I** course at the University of León.

The project applies the fundamental programming concepts introduced during the course, including object-oriented design, inheritance, polymorphism, exception handling, collections/arrays, unit testing, build automation, logging, and basic software documentation.

> This repository is kept as an academic project and represents an early practical application of Java and object-oriented programming principles.

## Overview

The application implements the core mechanics of Tetris in a text-based interface:

- A board where pieces are placed.
- The seven standard tetromino shapes: `I`, `J`, `L`, `S`, `T`, and `Z`.
- Piece movement, rotation, collision detection, and placement.
- Row detection and clearing.
- A keyboard-driven terminal interface.
- Optional ANSI colour rendering for a more readable terminal experience.
- Error handling through a custom exception type.
- Logging support for monitoring runtime events.

The project is organised around the package:

```text
es.unileon.prg1.tetris
```

## Project Structure

```text
.
├── build.xml                         # Apache Ant build configuration
├── etc/
│   ├── log4j2.xml                   # Log4j 2 configuration
│   └── umlTetris.jpg                # UML class diagram
├── lib/
│   ├── jacocoant.jar                # JaCoCo code-coverage task for Ant
│   ├── junit-4.8.2.jar              # Unit-testing framework
│   ├── log4j-api-2.5.jar            # Log4j API
│   └── log4j-core-2.5.jar           # Log4j implementation
├── src/
│   └── es/unileon/prg1/tetris/
│       ├── MainTetris.java          # Application entry point
│       ├── Tetris.java              # Main game logic and coordination
│       ├── TetrisTextUI.java        # Text-based user interface
│       ├── Board.java               # Game board representation and operations
│       ├── Piece.java               # Generic piece abstraction
│       ├── Block.java               # Base class for tetromino blocks
│       ├── BlockI.java              # I-shaped tetromino
│       ├── BlockJ.java              # J-shaped tetromino
│       ├── BlockL.java              # L-shaped tetromino
│       ├── BlockS.java              # S-shaped tetromino
│       ├── BlockT.java              # T-shaped tetromino
│       ├── BlockZ.java              # Z-shaped tetromino
│       ├── ArrayMxN.java            # Generic M × N array abstraction
│       ├── ArrayNxN.java            # Square-array abstraction
│       ├── Coordenadas.java         # Coordinate value object
│       ├── Color.java               # Colour-related model
│       ├── Keyboard.java            # Keyboard input handling
│       ├── TetrisException.java     # Custom application exception
│       └── strategy/
│           ├── ColorStrategy.java          # Colour-rendering strategy contract
│           ├── ANSIColorStrategy.java      # ANSI terminal colour rendering
│           ├── NoColorStrategy.java        # Plain-text rendering
│           └── ColorStrategySingleton.java # Strategy access/management
└── test/
    └── es/unileon/prg1/tetris/
        ├── AllTests.java            # Main test suite
        ├── ArrayMxNTest.java
        ├── ArrayNxNTest.java
        ├── BlockTest.java
        ├── BlockITest.java
        ├── BlockJTest.java
        ├── BlockLTest.java
        ├── BlockSTest.java
        ├── BlockTTest.java
        ├── BlockZTest.java
        ├── BoardTest.java
        ├── TetrisTest.java
        └── strategy/
            ├── AllTests.java        # Strategy-specific test suite
            ├── PieceColorTest.java
            └── PieceTextTest.java
```

## Design and Class Responsibilities

The codebase is divided into several responsibilities to keep the game logic separate from input/output concerns.

### Core Game Layer

- `MainTetris` is the application entry point.
- `Tetris` coordinates the game lifecycle and core behaviour.
- `Board` represents the playing field and manages operations related to occupied cells, piece placement, collisions, and board updates.
- `TetrisTextUI` presents the game state in the terminal and manages interaction with the player.
- `Keyboard` encapsulates keyboard input handling.
- `TetrisException` provides a domain-specific mechanism for reporting invalid game operations or application errors.

### Tetromino Model

The tetromino hierarchy models the playable pieces:

- `Block` is the base abstraction for a Tetris block.
- `BlockI`, `BlockJ`, `BlockL`, `BlockS`, `BlockT`, and `BlockZ` provide the concrete shapes.
- `Piece` represents a game piece and its behaviour.
- `Coordenadas` represents positions on the board.
- `Color` models the colour associated with a piece or block.

This structure uses inheritance and polymorphism so that each block shape can define its own geometry while preserving a common interface for the rest of the game.

### Matrix Abstractions

The board and shapes rely on reusable matrix-oriented classes:

- `ArrayMxN` provides an abstraction for rectangular arrays.
- `ArrayNxN` extends the concept for square arrays and supports operations needed by piece representation and transformations.

Separating these abstractions from the game-specific classes improves reuse and keeps the board/piece logic more manageable.

### Colour Strategy

Terminal output supports different rendering behaviours through the Strategy pattern:

- `ColorStrategy` defines the contract for formatting pieces.
- `ANSIColorStrategy` renders coloured output using ANSI escape codes.
- `NoColorStrategy` provides output without terminal colours.
- `ColorStrategySingleton` centralises access to the selected rendering strategy.

This approach allows the user interface to switch rendering behaviour without coupling the rest of the game logic to a specific terminal-colour implementation.

## Testing

The project includes automated unit tests written with **JUnit 4**.

Tests are organised following the same package structure as the production code and cover the main functional areas of the application:

- Matrix abstractions: `ArrayMxNTest` and `ArrayNxNTest`.
- Base tetromino behaviour: `BlockTest`.
- Individual tetromino implementations: `BlockITest`, `BlockJTest`, `BlockLTest`, `BlockSTest`, `BlockTTest`, and `BlockZTest`.
- Board behaviour: `BoardTest`.
- Main game logic: `TetrisTest`.
- Text and colour rendering strategies: `PieceTextTest` and `PieceColorTest`.

Two aggregate suites are included:

- `test/es/unileon/prg1/tetris/AllTests.java` groups the main application tests.
- `test/es/unileon/prg1/tetris/strategy/AllTests.java` groups the strategy-related tests.

The project also includes the **JaCoCo Ant task**, which enables test coverage reporting as part of the build process.

## Build System

The project uses **Apache Ant** for build automation. The `build.xml` file defines the project build configuration and integrates the following concerns:

- Java source compilation.
- Test compilation and execution.
- JUnit integration.
- JaCoCo code coverage support.
- External dependency management through the `lib/` directory.
- Packaging and/or generated build outputs, depending on the configured Ant targets.

### Dependencies

The required libraries are included in `lib/`:

| Library | Purpose |
|---|---|
| JUnit 4.8.2 | Automated unit testing |
| JaCoCo Ant | Test coverage integration |
| Log4j API 2.5 | Logging facade |
| Log4j Core 2.5 | Logging implementation |

### Build Commands

Make sure Apache Ant and a compatible JDK are installed. From the repository root, run:

```bash
ant
```

To inspect all available build targets:

```bash
ant -p
```

Depending on the targets configured in `build.xml`, typical tasks include compilation, running tests, generating coverage information, packaging the application, and cleaning generated files.

## Logging

Runtime logging is configured through:

```text
etc/log4j2.xml
```

The project uses **Log4j 2** to support traceability and debugging during development and execution. The logging configuration is intentionally stored outside the source package so that it can be adjusted without changing the application code.

## Documentation

The `etc/` directory contains supporting project documentation:

- `umlTetris.jpg`: UML class diagram of the Tetris design.
- `log4j2.xml`: logging configuration used by the application.

The UML diagram provides an overview of the relationships between the board, pieces, blocks, utility classes, user interface, and rendering strategies.

## Educational Objectives

This project was developed to practise and consolidate:

- Java syntax and program structure.
- Object-oriented programming.
- Class decomposition and responsibility separation.
- Inheritance and polymorphism.
- Composition and collaboration between objects.
- Custom exception handling.
- Terminal-based user interaction.
- Design patterns, particularly the Strategy pattern.
- Automated unit testing with JUnit.
- Code coverage tooling with JaCoCo.
- Build automation with Apache Ant.
- Logging with Log4j 2.
- UML-based software documentation.

## License

This repository is an academic project. No explicit licence has been defined.
