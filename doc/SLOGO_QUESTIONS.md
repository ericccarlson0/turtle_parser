1. When does parsing need to take place and what does it need to start properly?
    - Parsing needs to take place when an instruction is entered into the front-end, a key has been pressed to indicate that the instruction has terminated, and the instruction has been passed from the frontend. The parser needs to check if the instruction is a valid.
3. What is the result of parsing and who receives it?
    - The result of parsing is either a sequence of movements to be taken by the turtle (which should be passed and displayed by the frontend), or a parsing error that is caught and displayed according the nature of the error, so that the user can correct their actions. 
5. When are errors detected and how are they reported?
    - Errors are detected by the backend when an invalid command is typed by the user. These are passed to the front end in the form of an error message that the frontend is to display.
    - Errors are reported by one of the external backend APIs when a particular modification (such as trying to uplaod an image to the turtle) is invalid. These are reported to the GUI, too, in the form of some sort of error message.
6. What do commands know, when do they know it, and how do they get it?
    - Commands know their type (movement, change in internal state, etc.), the Object (and type of Object) that they operate on, and the specifications of their task (i.e. parameters). Commands know their type and their Object type once the parser has registered the name of the command, and they know their specifications once the parser has then registered their parameters.
7. How is the GUI updated once a command has completed execution?
    - The GUI is updated through its API, likely through some sort of moveTurtle method that is called by the backend at the conclusion of processing the command.