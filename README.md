# in1010_vaar_2023_innlevering_7
Program lagd i Intellij IDEA Ultimate.
Innlevering 7 (siste innlevering) i faget in1010, ved våren 2023.
Programmet skal ta inn en fil og lage en labyrint (to-dimensjonell array). 
Deretter programmet finne en utvei av labyrinten ved å prøve å bevege seg rundt i labyrinten, helt til den finner en utvei.

Eng. 
Program created in Intellij IDEA Ultimate.
Submission 7 (last submission) in the subject in1010, by spring 2023.
The program should take in a file and create a maze (two-dimensional array).
Then the program finds a way out of the maze by trying to move around the maze until it finds a way out.

The files that ends with ".in" is the files I used to test the program. These are the mazes, where "." is the path and "#" is a wall.

The program runs in terminal where "Oblig6.java" is the main method. 
1. Compile java files:                                                                       % Javac Oblig6.java
1. Run the code like this after compile (Choosing labyrint from file 5.in):                  % Java Oblig6 5.in
2. Then choose coordinates for where to start in the labyrint (Choosing coordinates (15,33): % 15 13
3. Then type "-1" in terminal and press enter on keyboard to end the program:                % -1

After running these 3 commands, the program will use recursion to find any openings and return if found.
