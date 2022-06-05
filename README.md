Carol, a female penguin who lives in the middle of Antarctica in a world where there is only water and blocks of ice. In this world, Carol can move and move blocks of ice back and forth in order to shape or explore the surroundings according to her own preferences.

In order to plan her endeavors, Carol would like a program with which the adventures can be simulated and planned in advance. The instructions experimentally developed in this way can then be used in the real world for orientation and facilitate navigation. Apart from that, Carol also wants to be able to practice with the program in order to be able to cope better with difficult situations in the future.

We have now been commissioned to implement Carol's simulation program and we are rewarded with a lot of fish.

The simulation concept developed during the first meetings looks like this:

Enter the playing field dimensions
When you start the program, the game field of the simulation must first be generated. For this, Carol is asked about the dimensions of this playing field, first about the width:
"Enter the playing field width:"
and then according to the height:
"Enter pitch height:"
Width and height are each whole numbers that are greater than or equal to one.

If after the two inputs at least one of the values is less than or equal to zero, the program should start with the output

"The width and height of the playing field must be greater than zero." break up.

Generation of the playing field
As soon as both numbers have been entered, the playing field is generated randomly. The playing field is a two-dimensional world, which consists of width times height of many individual fields. Each of these fields has its own height:

-1 stands for water
0 to 9 is the height of the floor that protrudes from the water. On these fields there is a stack of ice blocks that is one larger than the height.
It can look like this (we represent -1 or water as "~" and 0 as " "):

┏━━━┯━━━┯━━━┯━━━┓
┃   │ ~ │   │ ~ ┃
┠───┼───┼───┼───┨
┃ 1 │ 4 │ 2 │ ~ ┃
┠───┼───┼───┼───┨
┃ ~ │ 9 │ 1 │ 1 ┃
┠───┼───┼───┼───┨
┃ ~ │   │ ~ │   ┃
┗━━━┷━━━┷━━━┷━━━┛
We denote the fields with (x, y) coordinates, where the origin of the coordinate system, field (0, 0), always located at the bottom left. As an illustration:

koordinates.png

The playing field width is the number of fields in the x direction, the playing field height is they direction. Save the playing field as a two-dimensional int arrayint [width] [height]and First set the starting height for each field using the MiniJava method randomInt (int, int). Make sure that the values are generated column by column in ascending x coordinate. The fields of a column should be filled in ascending y coordinate.

For example, the order in which the fields are placed is the following for a playing field with width three and height two: (0.0) (0.1) (1.0) (1.1) (2.0) (2.1).

 A test of whether the generated playing field fits 1 of 1 tests passing


Output of the field of play
Once the playing field has been generated, it should be given out so that Carol can orientate herself. Use the MiniJava method printPlayground (int [] []) to output the playing field on the console.

Enter the desired initial situation
Then Carol enters what the starting situation of the simulation should be. She will be asked for four entries one after the other:

"Starting position x:"
between 0 (included) and the width (exclusive)
"Starting position y:"
between 0 (included) and the height (exclusive)
"Direction of view at the beginning:"
0 for positivex direction (right)
1 for positivey direction (above)
2 for negativex direction (left)
3 for negative y direction (below)
"Ice blocks at the beginning:"
Carol can carry up to ten blocks of ice in the simulation. Therefore a number between 0 (inclusive) and 10 (inclusive) is required here.
If at least one of the values is not valid after the four entries, the program should deal with the output
"Invalid start values." break up.

Simulation
In the part that now follows, Carol can simulate various actions as long as until it finishes the simulation. This part of the simulation has the following sequence:

Carol is asked to enter an instruction. Instructions are always single characters. Appropriate methods have been added to MiniJava for reading in a char. Ask Carol for input with "Enter instruction:".

Depending on the instruction that has been read in, different actions are carried out in the simulation.

For some actions there are special cases that have to be intercepted. For each of them, write out the appropriate message on the console and make sure that in these cases not to change the simulation status.

The possible instructions:

'e' like End
Ends the simulation without any further action or output.

'a' like Output
The playing field should be displayed here, including the current position, viewing direction and ice blocks carried. You will also find a suitable printPlayground MiniJava-Methode for this purpose..

'r' like Right
Carol turns 90 degrees to the right from her own perspective.

'l' like Left
Carol turns 90 degrees to the left from her own perspective.

's' like Step
Carol goes to the next space that is in her line of sight.

Special cases:

If there is no such field (because Carol is standing in front of the edge of the field):
"Carol cannot leave the field."
If the absolute height difference between the field Carol is on and the one in front of her is greater than one:
"Carol cannot go to the next field because the difference in height is too great."
'n' like To take
Carol takes exactly one block of ice from the field in front of her.

Special cases:

Carol is currently carrying ten blocks of ice (Carol cannot carry more than ten):
"Carol can't take a block of ice, she's already carrying ten."
Carol is currently in the water, Carol cannot work properly here:
"Carol cannot take blocks of ice in the water."
If there is no such field (because Carol is standing in front of the edge of the field):
"Carol cannot take blocks of ice off the field."
The field in front of her is already water (height -1), she cannot take a block of ice from there:
"Carol can't take a block of ice, there aren't any left."
'p' wie Place
Carol places exactly one block of ice in the field in front of her.

Special cases:

Carol is currently not wearing any ice blocks:
"Carol can't lay a block of ice because she isn't carrying one."
Carol is currently in the water, Carol cannot work properly here:
"Carol cannot lay blocks of ice in the water."
If there is no such field (because Carol is standing in front of the edge of the field):
"Carol cannot put blocks of ice off the field of play."
The field in front of her has reached the maximum height (height 9), another block of ice would be too unstable:
"Carol can't lay a block of ice, there are already ten blocks of ice on the field."
If the character entered is not a valid instruction, should
"Unknown instruction!" are issued.

If the simulation has not ended, it will start again at step 1..

The program only accepts instructions with correct upper and lower case.

Example:
A complete, small example on the 2x2 field

┏━━━┯━━━┓
┃ 3 │ 4 ┃
┠───┼───┨
┃ 6 │ 7 ┃
┗━━━┷━━━┛
With the starting values x: 0, y: 0, viewing direction: 0, ice blocks: 1 and the instructions 's', 'r', 'r', 'p', 'a', 'e'.
 Test for the small example 1 of 1 tests passing


Note: the two tests shown above only test a small portion of the program. Therefore test your program extensively yourself!



FAQ
Q: What should happen if several error messages can be issued in the situation?
A: It doesn't matter as long as you output at least one error message and the output matches the current situation.
