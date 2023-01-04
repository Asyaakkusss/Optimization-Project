# Optimization-Project
Inspired by a situation at work. We had a bunch of spare wires to connect different server chasses together but were not able to use all of them. Although the number of wires we were dealing with was small enough to do the process manually, I decided to create an optimization program that automates the elimination process to some extent in the event that we were dealing with a larger sample size. 

The program uses two arrays, a need and a have array. They both store a series unique types that represent 1) how many wires there are in the array and 2) whether or not the index has been traversed yet. Starting from the back of the two arrays, each of them are traversed simultaneously and three scenarios are considered:

1. What we have and what we need are equal (easiest one)
2. We have more than we need
3. We need more than we have

From there, specific steps for optimization take place. 
