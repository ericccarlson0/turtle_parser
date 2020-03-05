# REFACTORING_DISCUSSION.md

## Disucssion

## API Changes

#### What Changes Have Been Made?
* Frontend: besides the originally planned methods to give access of the turtle's status, methods to draw lines were implemented and methods to edit the values displayed in the different text boxes were added.
* Backend: The core functionality in terms of having a parseString method that takes in a string and then returns a list of executables has not changed, although we have changed the method headers to indicate that the data type returned just needs to be an Iterable, so as to design by interface. We did add some getter methods that allow for observable properties that can be passed to the Visualizer to allow for binding to the fronten
#### Are They Major Or Minor?
* Frontend: These were all minor changes. The main API to access the turtle status remained the same.
* Backend: These were minor changes, and were more importantly additions rather than changes, which is normal in the development of an API. we were conservative in the initial outline of our API since it is better to add more features later then overpromise and then not deliver
#### Did They Make The Project Better Or Worse?
* Frontend: They made the project better because they allowed for more interaction with the frontend. They allowed more backend data to be displayed on the frontend for the user to look at.
* Backend: They make the project better since they add more functionality to the backend and add more robust binding to the frontend to allow for dynamic changing of all of the elements
#### Will Changes Be Made In The Future?
* Frontend: no.
* Backend: potentially? lol

## Refactoring

### **Longest Method Refactoring**

(1) Longest Method:
* CommandFactoryDelete is the old implementation of the CommandFactory; its case statements were replaced with reflection, which maps command names to instances of Nodes.

### **Duplication Refactoring**

(2) Inter-file Duplication:
* RightTurnNode and LeftTurnNode shared code in the execute() method due to the fact that they represented almost the same operation; this was replaced with the Template design pattern; a single method is now used by both, with the difference being a small method that is called that differs in the two.

(3) Intra-file Duplication:
* The setLeadTurtle() method in Visualizer reuses the string formatter "%s %.2f". This is trivial.

(4) Intra-file Duplication:
* In TextElement, DEFAULT_LANGUAGE is set to a value that is in the Map languageMap.

### **Code Smells; Checklist Refactoring**

(5) Throwable printStackTrace():
* e.printStackTrace() was used to test SpecialCharacters, but is now removed because it is working well.
* This class represents characters (open/close bracket, open/close parentheses); it extends the ParserNode
* class because it needs to be added to the parsing tree.

(6) Format strings should not lead to unexpected behavior at runtime:
* The formatted string, "%s%s%s%s%s", has one too many %s.

(7) Methods should not be too complex:
* In ForNode, we have the switch statement 'switch(stage)', which cycles through the five stages of a FOR statement.
* The complexity comes from the case statement, which essentially turns this one method into five different methods. There could be a design principle to help with this, but nothing comes to mind immediately... 
* CommandFactoryDelete.java was the long switch-case that was already replaced with CommandFactory.java that uses reflection. This change proved to be correct as the old class' complexity resulted in this erro appearing as the most important issue. The issue was quickly resolved by deleting the file.

(8) Methods should not be too complex:
* In getParserNode (TreeParser), we have the switch statement 'switch(tokenType)', which takes different parsing paths according to the type of the token was just parsed.
* Once more, the complexity comes from the case statement, which turns this one method into a container for all of the different 'paths' that we can take when parsing.

(9) Control flow statements should not be nested too far.
* The step() function in Controller has the sequence if { try { while { try { } catch{} } } catch{} }.

(10) Magic numbers should not be used (28 instances):
* This is not an urgent issue, so we can do it in one sweep some time near the end of the project. Most of these magic numbers are 0, 1, 2, 3, or 4.

(11) Unused 'private' fields should be removed:
* This is not an urgent issue, either; we just need to remember to use debugging tools and Design Checkup Dev when we feel that we are nearing our finished project.

(12) Too many parameters: getLocalTransition has 8 parameters.
* Created two Point2D.Double objects outside of the method and passed them in as parameters. This reduced the number of parameters taken in by 2.

(13) Wildcard import method "javafx.animation.*" in Visualizer
* Removed Wildcard import javafx.animation and added imports javafx.animation.Animation and javafx.animation.AnimationTimer.

(14) Unused imports:
* Removed unused imports from : ClearExecutable, ExecutableSuperClass, MoveExecutable, HideExecutable.

(15) Classes and enums with private members should have a constructor:
* Added a constructor to the AskWithNode and SetPaletteNode class with the default values.

### List of design issues

### Issues to fix together

### Specific fixes for 5 issues

(1) RightTurnNode and LeftTurnNode (inter-file duplication)

(2) TextElement languageMap (intra-file duplication)
* The TextElement class (which represents language-sensitive controls, and may be renamed LangSensitiveElement) uses the map languageMap to turn language names into 'tags' (for creating Locale instances). This works well enough at the moment, but there is actually a hidden duplication of data that can be removed my moving languageMap into a .properties file. At the moment, the createLanguageBox() method in Visualizer uses the names of the files in src/parserModel/languages/commands in order to fill the ComboBox (this is important because it ensures that the available languages are the same languages whose commands are supported). These same .properties files could contain a key ('languageTag') that is used to generate the tags at the same time that the available languages are generated. To support this, a new map, 'languageTagMap', will be created in and used by Visualizer. The changeLanguage(...) method will then take in tags, instead of language names.

(3) The addNode(...) method in ForNode (methods should not be too complex)
* We fixed this by creating an enum for all the different states that a Parent parser could have. We are considering implementing some sort of iterator that would cut down on the if statements and allow the parsing nodes to iterate through and validate each state.
(4) The getParserNode(...) method in TreeParser (methods should not be too complex)
* In TreeParser, we got rid of the large switch statements by adding an abstract method in the TokenType enum that renders a node based on the token type. This abstracts the case statement of rendering a Node to be based on an abstraction and makes the parsing method only around 10 lines. 

(5) The step() method in Controller (don't nest too many control statements)
* Extracted the inner level of control statements as a method to make only one level of control statements in the step method. There isn't any clear and easy way to refactor this code currently because the two levels of control statements are necessary to make sure the parser does not run into many errors when parsing.