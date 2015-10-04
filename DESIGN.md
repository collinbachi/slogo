#Design#

##Introduction##

##Overview##

##User Interface##

##Design Details##

##API Example Code##

##Design Considerations##

One major issue our group discussed at length was the issue of where the state of our turtle object should be held. We first considered the turtle to belong entirely to the front end. However, we encountered complications when determining the best way to handle error handling. If the turtle and its state are contained within the front end, the back end must poll the front end for updates on the turtles position and orientation and then throw exceptions in response to this. On the other hand, if the turtle and its state are contained entirely within the back end then the front end must be continuously polling the backend for its current position/orientation state. This would, however, simplify our issue of handling exceptions. 

Another factor we considered was the two different types of exceptions to be thrown by the parser in the backend. One type of exception deals with syntax errors and the other for the user trying to access a position that is outside the bounds of the current pane. We ultimately decided to pursue an architecture that reflects the Model-View-Controller design paradigm. We now consider all objects that implement the Drawable interface to be part of the model. All state is thus contained within the model as well. Our design is now further modularized with three independent entities that have minimal knowledge of implementation details within other entities. The model is nothing more than a representation of an arbitrary drawable object whose state is contained within model and the controller is just a tool to return a queue of Command objects based on code input from the user. 

Another consideration we debated was our use of Command objects. Our current design consists of a back-end parsing class creating and sending Command objects to a Turtle object, where the turtle would then pass in a reference to itself to the Command object and the respective action would be applied to the Turtle. For example, 'fd 50' would be interpreted and a MoveForward object would be passed to the turtle and the action would then be applied to the turtle object. We debated whether or not this was considered to be within the bounds of this project becausethe actual interface between the Controller and Model is just a queue of command object. However, we determined that the actual API itself lies within the method calls called by each Command object.

Furthermore, we also discussed the possibility for future extension of our project to support user-defined variables, such as assigning the current X or Y coordinate of the turtle to an arbitrarily named variable. A functionality such as this would inherently require the parser class to have access to the coordinate state that is contained within the model. We decided to initialize our parser class with a reference to the turtle passed into its constructor such that in the event of the user assigning the current X or Y coordinate to a variable, the parser may call a public getterMethod() defined within the turtle class to retrieve this information. This is less than ideal because we would like our parser to operate entirely on its own without any references to Drawable objects. However, we concluded that this design decision would be acceptable as long as there are not any other public setter methods other than what is modifiable via adding Command objects to the turtles command queue. 

One final consideration we discussed is the implementation of animation for drawing our turtle. To animate our turtle executing commands and illustrating this via our View, we need to keep our internal data structures in sync with what is being shown on the screen. The problem is that a computer can pop off Command objects from the turtles command queue very quickly, much quicker than we would like our animation to occur on screen. To account for this, we are implementing a lock on the turtles command queue. When a command is popped off the queue, the lock is enabled. The next Command object will not be popped off the queue until this lock is released, which occurs when the animation is complete. This lock will ensure consistency between our back-end datastructures and front-end animations.

##Team Responsibilities##
