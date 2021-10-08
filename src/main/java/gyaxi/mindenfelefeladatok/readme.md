
#Arraylist

You are given lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in position of line. Take your input from System.in.

Input Format
The first line has an integer. In each of the next lines there will be an integer denoting number of integers on that line and then there will be space-separated integers. In the next line there will be an integer denoting number of queries. Each query will consist of two integers and.

Constraints:
Each number will fit in signed integer.
Total number of integers in lines will not cross.

Output Format:
In each line, output the number located in position of line. If there is no such position, just print "ERROR!"

Sample Input:
```
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
```
Sample Output:
```
74
52
37
ERROR!
ERROR!
```

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

Input Format:
The first line contains an integer, denoting the number of queries (i.e., function calls).
The subsequent lines describe each query over two lines:
The first line contains two space-separated integers describing the respective values of and. The second line contains space-separated binary integers (i.e., zeroes and ones) describing the respective values of.

Constraints:
It is guaranteed that the value of is always.

Sample Input:
```
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
```
Sample Output:
```
YES
YES
NO
NO
```
Explanation:
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

Input Format:
The first line contains an integer, (the initial number of elements in).
The second line contains space-separated integers describing.
The third line contains an integer, (the number of queries).
The subsequent lines describe the queries, and each query is described over two lines: If the first line of a query contains the String Insert, then the second line contains two space separated integers, and the value must be inserted into at index. If the first line of a query contains the String Delete, then the second line contains index, whose element must be deleted from.

Constraints:
Each element in is a 32-bit integer.

Output Format:
Print the updated list as a single line of space-separated integers.

Sample Input:
```
5
12 0 1 78 12
2
Insert
5 23
Delete
0
```
Sample Output:
```
0 1 78 12 23
```

#Map

You are given a phone book that consists of people's names and their phone number. After that you will be given some person's name as query. For each query, print the phone number of that person.

Input Format:
The first line will have an integer denoting the number of entries in the phone book. Each entry consists of two lines: a name and the corresponding phone number.
After these, there will be some queries. Each query will contain a person's name. Read the queries until end-of-file.

Constraints:
A person's name consists of only lower-case English letters and it may be in the format 'first-name last-name' or in the format 'first-name'. Each phone number has exactly 8 digits without any leading zeros.

Output Format:
For each case, print "Not found" if the person has no entry in the phone book. 
Otherwise, print the person's name and phone number. See sample output for the exact format. 
To make the problem easier, we provided a portion of the code in the editor. 
You can either complete that code or write completely on your own.

Sample Input:
```
3
uncle sam
99912222
tom
11122222
harry
12299933
uncle sam
uncle tom
harry
```

Sample Output:
```
uncle sam=99912222
Not found
harry=12299933
```

#Balanced string

A string containing only parentheses is balanced if the following is true: 
1. if it is an empty string
2. if A and B are correct, AB is correct,
3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format:
There will be multiple lines in the input file, each having a single non-empty string.
You should read input till end-of-file.

Output Format:
For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input:
```
{}()
({()})
{}(
[]
```
Sample Output:
```
true
true
false
true
```

#Pairs

You are given N pairs of strings. Two pairs (a,b) and (c,d) are identical if a==c and b==d.
That also implies (a,b) is not same as (b,a).
After taking each pair as input, you need to print number of unique pairs you currently have.

Input Format

In the first line, there will be an integer T denoting number of pairs.
Each of the next T lines will contain two strings seperated by a single space.

Constraints:
- 1<=T<=10000
- Length of each string is atmost 5 and will consist lower case letters only.

Output Format:
Print T lines. In the ith line, print number of unique pairs you have after taking ith pair as input.

Sample Input:
```5
john tom
john mary
john tom
mary anna
mary anna
```

Sample Output:
```1
2
2
3
3
```

Explanation:
- After taking the first input, you have only one pair: (john,tom)
- After taking the second input, you have two pairs: (john, tom) and (john, mary)
- After taking the third input, you still have two unique pairs.
- After taking the fourth input, you have three unique pairs: (john,tom), (john, mary) and (mary, anna)
- After taking the fifth input, you still have three unique pairs.

#Players order

The Player class is provided for you in your editor. It has 2 fields: a name String and a score integer.
Given an array of n Player objects, write a comparator that sorts them in order of decreasing score;
if 2 or more players have the same score, sort those players alphabetically by name.
To do this, you must create a Checker class that implements the Comparator interface,
then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.

Input Format:
Input from stdin is handled by the locked stub code in the Solution class.
The first line contains an integer, N denoting the number of players.
Each of the N subsequent lines contains a player's name and score, respectively.

Constraints:
- 0<=score<=1000
- 2 players can have the same name.
- Player names consist of lowercase English letters.

Output Format:
You are not responsible for printing any output to stdout.
The locked stub code in Solution will create a Checker object, use it to sort the Player array,
and print each sorted element.

Sample Input:
```5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
```

Sample Output:
```aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
```
