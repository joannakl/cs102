---
layout: lab
title: Lab
---

## Race03

- Lines 30-32: Why is there no exception handling for out-of-bounds inputs?
- What are the benefits of using abstract classes to implement race contenders?
- What is the point if the “Largest move” constant in the abstract class if it’s never used in subclasses?
- How could we change the code so that the number of race contenders doesn’t have to be a multiple of 3?
- Why do we have to override toString and compareTo? What would these methods return if not overridden?
- What if there are multiple leaders at the same position? Does the findLeader method give priority to later race contenders because of the way it goes through the array?
- What is the keyword Thread?
- What is an advantage of having an abstract class?
- Why specify this for the number but not the position in the object RaceContender contructors
- Why not implement a comparable for Racecontender03?
- 9.  Specifics regarding abstract methods/classes?
- Why does the number of racers need to be a multiple of 3?
- Why assign “winner” as “null” and not just leave it as an empty pointer?
- Why not use a superclass or interface for the Races?
- When you implement an abstract method, do you still notate it with the comment “@Override”? Or is there a specific notation for implementing an abstract method? (e.x. Line 32 in Rabbit03.java)
- If there is no implementation for move in RaceContender03, what implementation is Race03 using? (Race03 line 57)
- What is “i=i+3”?  for (int i = 0; i < racers.length; i=i+3 )
- Why write (89)+10 instead of saying 99? racers[i] = new Rabbit03("R" + (rand.nextInt(89)+10) )
- What’s the significance of `@Override`
- Why add “abstract” to “public void move()”? (RaceContender03)
- Why is there so much repeated code?
- How using .rand works in the Rabbit03 class (why was it implemented that way?)
- Why are the first two variables in RaceContender03 protected?
- What is an abstract class?
- How does this “%s” thing work (it’s in all races)?
- Why is RaceContender03 abstract?
- Why are the RaceContender classes 3 and 4 abstract classes?
- What’s the difference b/w Race03 and the other Race programs?
- Is there an efficiency difference between using arrays to store the racecontenders like in Race03 vs just listing them out like in Race02, aside from less tedious/long code?
- Could you make the length of the array not a multiple of 3?
- Why do lines 30-33 use rand.nextInt(89)+10 instead of just rand.nextInt(99)+1?
