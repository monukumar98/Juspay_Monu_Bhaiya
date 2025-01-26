1st Round 
Given a maze with N cells. Each cell may have multiple entry points but not more than one exit (i.e entry/exit points are unidirectional doors like valves).
You are given an array Edge[] of N integers, where Edge[i] contains the cell index that can be reached from cell i in one step. Edge[i] is -1 if the ith cell doesn't have an exit.

Problem : 1 Maximum Weight Node (Easy)

The task is to find the cell with maximum weight (The weight of a cell is the sum of cell indexes of all cells pointing to that cell). If there are multiple cells with the maximum weight return the cell with highest index.
Note: The cells are indexed with an integer value from 0 to N-1. If there is no cell pointing to the ith cell then the weight of the i'th cell is zero.
INPUT FORMAT :
The first line contains the number of cells N.
The second line has a list of N values of the edge[ ] array, where edge[i] conatins the cell number that can be reached from cell 'i' in one step. edge[i] is -1 if the ith doesn't have ans exit.
OUTPUT FORMAT :
First line denotes the node number with maximum weight node.
Sample Input :
23
4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21 

Sample Output :
22
7
4 4 -1 2 2 3 4
output 4
5
4 4 -1 2 2
output 
2

Problem: 2 Largest Sum Cycle (Medium-Hard)

The task is to find the largest sum of a cycle in the maze(The sum of a cycle is the sum of the cell indexes of all cells present in that cycle).
Note: The cells are named with an integer value from 0 to N-1. If there is no cycle in the graph then return -1.
Example 1:
Input:
23
4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21
Output:
45
Example 2:
Input:
N = 4
Edge[] = {2, 0, -1, 2}
Output:
-1
Explanation:
1 -> 0 -> 2 <- 3
There is no cycle in the graph.

Problem : 3 Nearest Meeting Cell (Hard)

The task is to find: the nearest meeting cell: Given any two cells - C1, C2, find the closest cell Cm that can be reached from both C1 and C2.
Note:- The cells are named with an integer value from 0 to N-1. If there is no node pointing to the ith node then weight of the ith node is zero.
INPUT FORMAT :-
The first line contains the number of cells N.
The second line has a list of N values of the edge[ ] array, where edge[i] conatins the cell number that can be reached from cell 'i' in one step. edge[i] is -1 if the ith doesn't have an exit.
Third line for each testcase contains two cell numbers whose nearest meeting cell needs to be found. (return -1 if there is no meeting cell.
OUTPUT FORMAT :
Output a single line that denotes the nearest meeting cell (NMC). 

Sample Input :

23
4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21
9 2
Sample Output :
4
6
1 2 3 4 5 -1
0 4
Output  4 




