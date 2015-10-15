# Peer Code Review: Matthew Battles and Alex Rice #

## My Code: Command objects ##

During the time we spent on this code in recitation on October 15, 2015, we discussed the class structure of the Command objects, and whether they would make more sense as subclasses. We determined that if a factory method is implemented to create the Command objects, there is no need to have these extend a superclass. If any variables are needed from a superclass, this would be the preferred method, but the only thing each Command object has in common is that it implements an execute(Drawable object) method, and this makes more sense as an interface.

We also discussed the need for constructors within each Command, and decided that simple commands did not need explicitly defined constructors.



