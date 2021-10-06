
#Arraylist

You are given lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in position of line. Take your input from System.in.

Input Format
The first line has an integer. In each of the next lines there will be an integer denoting number of integers on that line and then there will be space-separated integers. In the next line there will be an integer denoting number of queries. Each query will consist of two integers and.

Constraints
Each number will fit in signed integer.
Total number of integers in lines will not cross.

Output Format
In each line, output the number located in position of line. If there is no such position, just print "ERROR!"

Sample Input
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

Sample Output
74
52
37
ERROR!
ERROR!


#Array1D

Let's play a game on an array! You're standing at index of an -element array named . From some index (where), you can perform one of the following moves:
Move Backward: If cell exists and contains a , you can walk back to cell.
Move Forward: If cell contains a zero, you can walk to cell.
If cell contains a zero, you can jump to cell .
If you're standing in cell or the value of, you can walk or jump off the end of the array and win the game.
In other words, you can move from index to index , , or as long as the destination index is a cell containing a . If the destination index is greater than, you win the game.

Function Description
Complete the canWin function in the editor below. canWin has the following parameters:

int leap: the size of the leap
int game[n]: the array to traverse

Returns boolean: true if the game can be won, otherwise false

Input Format
The first line contains an integer, denoting the number of queries (i.e., function calls).
The subsequent lines describe each query over two lines:
The first line contains two space-separated integers describing the respective values of and. The second line contains space-separated binary integers (i.e., zeroes and ones) describing the respective values of.

Constraints
It is guaranteed that the value of is always.

Sample Input
STDIN           Function
-----           --------
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)
0 0 0 1 1 1     . . .
6 3
0 0 1 1 1 0
3 1
0 1 0

Sample Output
YES
YES
NO
NO

Explanation
We perform the following queries:
For and , we can walk and/or jump to the end of the array because every cell contains a. Because we can win, we return true.
For and , we can walk to index and then jump units to the end of the array. Because we can win, we return true.
For and, there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
For and , there is no way for us to get past the one at index . Because we cannot win, we return false.

#listInsertDelete

For this problem, we have types of queries you can perform on a List:
Insert at index: Insert x y
Delete the element at index: Delete x

Given a list, of integers, perform queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers.

Input Format
The first line contains an integer, (the initial number of elements in).
The second line contains space-separated integers describing.
The third line contains an integer, (the number of queries).
The subsequent lines describe the queries, and each query is described over two lines: If the first line of a query contains the String Insert, then the second line contains two space separated integers, and the value must be inserted into at index. If the first line of a query contains the String Delete, then the second line contains index, whose element must be deleted from.

Constraints
Each element in is a 32-bit integer.

Output Format
Print the updated list as a single line of space-separated integers.

Sample Input
5
12 0 1 78 12
2
Insert
5 23
Delete
0

Sample Output
0 1 78 12 23
