# Tic Tac Toe Game

I wrote this for a final project in Programming Fundamentals II. It's a simple Tic Tac Toe game that plays itself using random numbers and calculates the results. Originally written and compiled using Java 8 from Oracle. Without modification it should compile and run using the latest OpenJDK and Open JavaFX packages.

## Compile and Run Instructions

### Windows

- Install [Git for Windows](https://gitforwindows.org/)
- Open **Git Bash**

```bash
git clone https://github.com/clintmint/TicTacToe.git

cd TicTacToe

curl -o openjdk-14.0.1_windows-x64_bin.zip https://download.java.net/java/GA/jdk14.0.1/664493ef4a6946b186ff29eb326336a2/7/GPL/openjdk-14.0.1_windows-x64_bin.zip
curl -o openjfx-14.0.1_windows-x64_bin-sdk.zip https://download2.gluonhq.com/openjfx/14.0.1/openjfx-14.0.1_windows-x64_bin-sdk.zip

unzip *.zip

export PATH=/c/Users/clint/jdk-14.0.1/bin/:$PATH
export PATH_TO_FX=/c/Users/clint/javafx-sdk-11.0.2/lib/
```

- Verify versions

```bash
java -version
javac -version
```

- Compile & Run

```bash
javac --module-path $PATH_TO_FX --add-modules javafx.controls TicTacToe.java
java --module-path $PATH_TO_FX --add-modules javafx.controls TicTacToe
```

### Linux

TBA

