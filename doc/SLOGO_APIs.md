### SLOGO_APIs.md

#### External Frontend API

* We want the user to be able to interact with the agent (whether it be a turtle or not) in intuitive but powerful ways. The external frontend API should include simple commands such as *move forward (amount)* or *turn counter-clockwise (amount)*. The API should include commands to edit the agent's internal state, too, such as *pen (up/down)* or *set (color)*.

#### External Backend API
* The External Backend will be used by the frontend of this program -- or, in the most optimistic case, any program sufficiently similar to it. It should allow the frontend to...
* *store/access* an agent in a collection of agents
* *update/access* the internal state of agent(s)
* *access/update* the state of the screen
* *access/update* the state of the objects on the screen

#### Internal Frontend API
* The internal frontend API would allow the producers and team members to edit aspects of the frontend display that the user does not need to know or edit. This could take form in methods to edit the images used within the frontend (turtle image), to edit the screen size and background color, to open the window in full screen, add certai features such as scrolling or additional text input boxes. These methods would be useful for the producer and team members, but not necessarily useful for the user or consumer of the product to use and edit game function.

#### Internal Backend API
* The internal backend API should allow for implementation of new commands. This would be implemente by first defining an interface *Move* that supports the following set of behavior:
    * protected interface Move
        * protected List\<Action\> execute(String[] params)
        * protected int numberOfArguments
* From here, flexibility in the types of moves would be dependent upon what classes implement the Move interface. right off the bat we can define two different types of Moves: one that consists of a single move and one that is a function, or a collection of basic moves
    * protected abstract class SingleMove implements Move
    * protected abstract class Function implements Move

## Use Cases
#### The user types 'fd 50' in the command window, sees the turtle move in the display window, and has the command added to the environment's history.
* EventHandler recognizes that the command has been entered (a key (ENTER) is pressed or a button is clicked)
* The text 'fd 50' is loaded from the TextField
* The text from the TextField is sent to be parsed 
* parseCommand() (automatically calls addHistory(String)) in back-end to divide the string into string "fd" for forward and integer 50 for the magnitude of the movement. Then calls move(fd,50) to move the turtle to the new direction (backend). The front end calls update() and receives the new position of the turtle and updates the visual. 

#### The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.
* EventHandler recognizes that the command has been entered (a key (ENTER) is pressed or a button is clicked)
* The text '50 fd' is loaded from the TextField
* The text from the TextField is sent to be parsed 
* parseCommand's error checking detects the inputs are of wrong type and throws Exception to front end with the message ("Wrong command format.")


#### The user types 'pu fd 50 pd fd 50' in the command window and sees the turtle move twice (once without a trail and once with a trail).
* EventHandler recognizes that the command has been entered (a key (ENTER) is pressed or a button is clicked)
* The text 'pu fd 50 pd fd 50' is loaded from the TextField
* The text from the TextField is sent to be parsed 
* textHandler takes the String input and recognizes more than one command, divides the string into individual commands and calls parseCommand on each command.

* parseCommand() handles both command and update() method in frontend calls doesTrailExist() boolean method to check whether it should draw a trail.

#### The user changes the color of the environment's background.

* In front end setBackGroundColor(String HexCode) is called. 