# Viagogo
Coding Assignment

## Problem Description
Scenario

 Your program should randomly generate seed data.

 Your program should operate in a world that ranges from -10 to +10 (Y axis), and -10
to +10 (X axis).

 Your program should assume that each co-ordinate can hold a maximum of one
event.

 Each event has a unique numeric identifier (e.g. 1, 2, 3).

 Each event has zero or more tickets.

 Each ticket has a non-zero price, expressed in USDollars.

 The distance between two points should be computed as the Manhattan distance.

Instructions

 You are required to write a program which accepts a user location as a pair of co-ordinates, and returns a list of the five closest events, along with the cheapest ticket price for each event

## Language

The code is written in `Java (1.7+)`. 

Followed  standard javadoc convention for documentation. 

`Point.java` and `Event.java` are helper classes. 

`GridSearch.java` is the driver class

## To build & run code.

To Build : `javac GridSearch.java`

To Run : `java GridSearch`

## Output

Provided co-ordinates for user location, the output  is a list of nearest five Event (ID's) , their cheapest tickets and distance from user.

If an event shows "No Tickets" , it means it's ticket capacity is 0

If the number of returned events is less than 5 (even empty), it means the total events generated are less than 5

## Assumptions
Each co-ordinate can have utmost a single event.

The number of events can range from 0 to 100

An event can have 0 to  10 tickets

The price of a ticket can go from 0.1$ to 1000$

For every run of the program, the #events, #ticketsPerEvent and #priceOfEachTicket is determined randomly obeying the above bounds

## How might you change your program if you needed to support multiple events at the same location?
The program encapsulates away the implementation of `Point` and `Event` classes from the way they are linked. So, if there can be mulitple events at the same `Point`, all one needs to change is the driver class `GridSearch`.

Specifically, the datastructure called `grid` is a `Map` betweeen `Point` and `Event`. In case of multiple Events being at the same point, we change the datastructure to being a `map`  between `Point` and `List<Event>` . Along with a minor change in logic for looking for nearest events, this would suffice.

## How would you change your program if you were working with a much larger world size?

### In terms of Memory 

We can link it to an external database (JDBC maybe) to store and retrieve the points on demand.

### In terms of Computation

We can leverage multi-threading by dividing the grid among multiple threads. As the creating of events and finding their distance from a user are inherently independent for each Event, one can effectively parallelize it using threads thereby reducing the execution time by magnitude of number of processors.
