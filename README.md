# mapping-robot
mapping robot coding challenge

TO RUN PROGRAM FROM WINDOWS COMMAND PROMPT:

1. Be sure the latest version of Java Development Kit is installed.
2. Point PATH variable at JDK to ensure compiling.
3. Navigate to `/mapping-robot/src`.
4. Compile the program using `javac robot.java`.
5. Run the program using `java robot.java`.
6. Follow prompt by typing robot directions according to input format.

Sample input:
* 2017-01-01; Coffee Shop; L2, L5, L5, R5, L2
* 2017-01-02; Advertising Agency; R3, R3, R3, L2
* 2019-04-22; Rightpoint; L3, L2, R4, R2, L2, L4, R2, L4, L1, R2, R3

Sample output:
* 2017-01-01; Coffee Shop; R5 R10
* 2017-01-02; Advertising Agency; R0, R5
* 2019-04-22; Rightpoint; L13, L10
