# Tic Tac Toe Game

I wrote this for a final project in Programming Fundamentals II. It's a simple Tic Tac Toe game that plays itself using random numbers and calculates the results. Originally written and compiled using Java 8 from Oracle. Without modification it should compile and run using the latest OpenJDK + OpenJFK packages.

## Install OpenJDK

1. Download latest "Ready for use" JDK here: http://jdk.java.net/
2. Extract
3. Append full path of **jdk-14.0.1/bin** to your PATH environment variable. Note that this may override any Java binaries currently installed.
4. Set JAVA\_HOME environment variable to full path of **jdk-14.0.1**

## Install Open JavaFX

1. Download "Latest Release" JavaFX SDK here: https://gluonhq.com/products/javafx/
2. Extract
3. Set PATH\_TO\_FX envrionment variable using full path of **javafx-sdk-14.0.1/lib**

## Download TicTacToe, compile and run (Windows)

1. `git clone https://github.com/clintmint/TicTacToe.git`
2. `javac --module-path %PATH_TO_FX% --add-modules javafx.controls TicTacToe.java`
3. `java --module-path %PATH_TO_FX% --add-modules javafx.controls TicTacToe`

