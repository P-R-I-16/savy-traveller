# CPSC535-Project-1
Savvy Traveler

Group members:
AkshayaK - AkshayaR@csu.fullerton.edu
Priyansha Singh-  priyansha@csu.fullerton.edu
Archana Tella-  Archanatella@csu.fullerton.edu

The project contains the folder GraphPathProb.jar, which can be executed by using the command java -jar GarphPathProb.jar
User has to give the input(1 or 2 or 3) to select the graph and then the code developed calculates the highest probability from source to destination. The output gives the highest probability value along with path and most reliable city to travel.

The aim of this project is to solve the Savvy Traveler problem. If the traveler journeys across the US by 
air, there are a lot of flights to various destinations across the country with one or more hops. We 
calculate (i) what route will maximize the probability to arrive on time between two given cities, and (ii) 
what city is the most reliable travel destination. The flight routes are illustrated using an undirected graph. 
The cities are represented by the vertices and the flight path represents the edges from the vertices. The 
probability values are listed across the edges. 
Given a graph and two cities, we need to compute the path with the highest probability of on-time arrival. 
If the path has a single edge, then it will be the probability of that edge. If the path has multiple edges, 
then multiply all the probabilities. When alternating paths are available, select the one with the highest 
probability.
Given a graph, for any city we measure the reliability of that city as the sum of all probabilities of on-time 
arrivals from each other city. The most reliable city is the one with the highest reliability
