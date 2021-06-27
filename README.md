# Othello_game
othello game implemention AI
         Othello (Reversi)
Supervisor: Prof. Alireza Salimi Badr
Project by Alireza Amini and Seyed Alireza Yaghoubi
Autumn Semester of 2020
    
    Introduction:
Reversi is a strategy board game
uncheckered board. It was invented in 1883.
the board's initial setup, was patented in 1971.
for two players, played on an 8×8
 Othello
(often spelled "discs"), which are light on one side and
, a variant with a change to
  There are sixty-four identical
  game pieces called
disks
  dark on the other. Players take turns placing disks on the board with their
 assigned color facing up. During a play, any disks of the opponent's color that are
 in a straight line and bounded by the disk just placed and another disk of the
 current player's color are turned over to the current player's color. The object of
 the game is to have the majority of disks turned to display your color when the
 last playable empty square is filled.
 So, in this project we’re going to implement Othello Game as our autumn semester project and in this project report we will explain our logic, policies and algorithms. Our project has three different phases that we will explain them separately.

    Phase one:
Phase one’s goal is writing a program that two individuals can play the Othello game together. Our logic for this phase is so basic.
At first, because we just want to write a game that 2 players can play it we can use java frame as a graphic so we have the nice visual game and because of the functions and abilities of JFrame we don’t need to implement a 2D integer array so that we just use 2D JLabel as our main board and we calculate and work just with parameters in every cell in JLable.
After coding the base platform, we go deep into rules and game logic and implement them as basic rules. For example, for helping players to choose places for putting disks we show the available places for placing disks as red disks.
On the other hand, for keeping updated scores, we implement another graphic page for showing live scores and turns, that keep track of the game for us and show it to us.
For this phase, we implement a class for live scores, a class for mainboard that extends Jframe, and some sub-classes for mouse actions. In this phase, our most important part is to run the mouse clicked function.
Below is a picture from our phase one.

<img style="text-allign:right" width="399" alt="Screen Shot 1400-04-06 at 5 16 00 PM" src="https://user-images.githubusercontent.com/50865713/123545033-5c99fc00-d76b-11eb-8064-668889c3b75a.png">     
    

         Phase two:
In phase two we improve our code so that a player can play with an AI as an opponent. So, in this phase we need a tree that keeps track of the game and keeps available choices for AI, also we should concern about the width of our three and the time that making these three takes, and other hardware limitations such as RAM capacity. For this reason, we use Min-Max three as our three and, for pruning our three we use Alpha-Beta pruning and, beside Alpha- Beta pruning we limit the choices of every node. Also, we know that if we want to make our three for every possible choice from start to end of the game, we encounter to RAM limit because we know that the depth of the three is definitely going to be very high, so for solving this problem in at the start of running our code we just make our three with depth 6 and every time we rich that depth we make another 6 levels for our current node as a parent of our new three.
To implement this logic, we need a class for three that just have a node as the parent of three. Also, we need a class for nodes. Our tree node class contains multiple parameters such as a 2D integer some parameters that tracks some scores and, grades, a node that shows the parent node and an array list for keeping child nodes.
For making our tree we have a function named fillTree that use Min-Max algorithm and Alpha-Beta pruning and use a parameter named fit that a combination of some parameters. These parameters are finding to help us find the best way to put our disks, some of them is calculate already scores and fillip count of every move. Also, for making children for each node we use an alternate function that find possible ways to place disk and every possible way became a node in childs array list. But because we want to improve our code after finding all of childs we sort the array list because we always want AI choose best action.
So now our AI three is ready and sorted by heuristic parameters to do best actions. So, when the real player choose disk place AI continues in our three and act the best way for us and the games go on.

    Phase three:
So far we have seen that we had a number of heuristic parameters to measure that had a random coefficient
Now in this section, in order to find the best coefficients for our parameters, we have to let two AIs play together to understand what are the best coefficients for our heuristic criteria. To do this, we first need to produce an initial population. To do this, we have a class that has three parameters in itself because we have three heuristic criteria. Then, according to our logic, we produce an initial population of 100, each of which has three numbers between zero and one, and store it in a vector.
We consider a vector for our population that has a member from the same class of three and a number for the score of each game, which is initially zero.
Then we consider two super parameters as criteria for crossover and mutation.
Then we enter a circle to continue working because we want to find the best heuristic coefficients by playing artificial intelligence versus artificial intelligence several times.
But since we do not want this to take too long, we limit this loop, which does not cause much error in the final answer and calculates numbers for us to a good extent
To limit this circle of logic, we have made three conditions. The first condition was that the loop should not be done more than a hundred times. The second condition was that whenever our population reached number one, it would leave the circle because it is definitely the best-case scenario. The last condition was that if we reach a state where the final coefficients give us a score greater than fifty, it is good enough and there is no need to continue.
But inside the circle, we first act to improve our population by always choosing two parents for the crossover, and the way to choose is by choosing the first parent from the beginning of the population and the second parent from the middle of the population, and each series of both We move a house forward for the next parent.
Now that the two parents have been identified, we generate a random number between zero and one. First, each parent is multiplied by a number between zero and one and put together to form the first number of their new child. Similarly, for the second and third numbers of each parent and at the end of the crossover, this new child is added to the end of the community.
Next, we generate another random number that if the jump parameter is smaller than the cloud, we mutate the generated child, which is why there are many ways to jump, and our logic is to randomly add two of the three numbers. We move together
Now we have a community to play with, and in each series in this circle, we select two members of this community and place each one as the heuristic coefficient of one white disk and the other as the heuristic coefficient of one black, and these plays together. And we keep the winning coefficients and we change the score of this house from the population and we eliminate the coefficients that they lost.
Now, after this game, before our society returns to the top of the circle, we arrange the society based on the points earned so that we always have the best choice at the beginning of the society. Then the loop is repeated again until we reach one of the conditions
As a final point, the issue we addressed was that we always evenly matched the number of communities for the convenience and simplification of the code, and if something went wrong, we removed the last member of the community who was the worst choice after sorting.
   
