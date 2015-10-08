Our API design is intended to be flexible enough to allow extensions to the original program requirements. To accomplish this, we encapsulate the results of backend parsing into Command objects, that are passed to the front end and contain instructions for the front-end to execute. This allows us to introduce a wide number of possible new commands and behaviors for the turtle. We have simple API calls with well defined use cases for passing back and forth user input text, user input history, and library functions. We maintain the Turtle's state in the front end, but allow the back end to access it in a read-only fashion if necessary. This makes for easier animation, since the frontend can choose how and when to implement its queue of Commands from the back end.

The front-end does not need to know anything about the implementation of the backend. It simply passes it text and receives Commands in return. The back end must know what commands the front end supports, but does not need to worry about when or how the front end will execute them.

Since I'm working on the parser, I need to be prepared for syntax and lexical errors from the user, as well as illegal combinations of commands and arguments.

Our API design minimizes the knowledge that the back-end and front-end teams need to know about each other's implementation details. It is flexible and supports a variety of possible extensions.

