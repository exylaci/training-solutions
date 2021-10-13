
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
```
5
john tom
john mary
john tom
mary anna
mary anna
```

Sample Output:
```
1
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
```
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
```

Sample Output:
```
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
```

#Students order

You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order. If two student have the same CGPA, then arrange them according to their first name in alphabetical order. If those two students also have the same first name, then order them according to their ID. No two students have the same ID.

Hint: You can use comparators to sort a list of objects. See the oracle docs to learn about comparators.

Input Format:
The first line of input contains an integer N, representing the total number of students.
The next N lines contains a list of student information in the following structure:
ID Name CGPA

Constraints:
2<=N<=1000
0<=ID<=100000
5<=|Name|<=30
0<=cpga<=4.00

The name contains only lowercase English letters.
The ID contains only integer numbers without leading zeros.
The CGPA will contain, at most, 2 digits after the decimal point.

Output Format:
After rearranging the students according to the above rules, print the first name of each student on a separate line.

Sample Input:
```
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
```
Sample Output:
```
Ashis
Fahim
Samara
Samiha
Rumpa
```

#Deque

In this problem, you are given N integers.
You need to find the maximum number of unique integers among all the possible contiguous subarrays of size M.

Note: Time limit is 3 second for this problem.

Input Format:
The first line of input contains two integers N and M: representing the total number of integers and the size
of the subarray, respectively. The next line contains N space separated integers.

Constraints:
- 1<=N<=100000
- 1<=M<=100000
- M<N
- The numbers in the array will range between [0,10000000].

Output Format:
Print the maximum number of unique integers among all possible contiguous subarrays of size M.

Sample Input:
```
6 3
5 3 5 2 3 2
```
Sample Output:
```
3
```
Explanation:

In the sample testcase, there are 4 subarrays of contiguous numbers.
- s1 = (5,3,5) - Has 2 unique numbers.
- s2 = (3,5,2) - Has 3 unique numbers.
- s3 = (5,2,3) - Has 3 unique numbers.
- s4 = (2,3,2) - Has 2 unique numbers. 
  
In these subarrays, there are 2,3,3,2 unique numbers, respectively.
The maximum amount of unique numbers among all possible contiguous subarrays is 3.

#BitSet

Java's BitSet class implements a vector of bit values (i.e.: false(0) or true()) that grows as needed,
allowing us to easily manipulate bits while optimizing space (when compared to other collections).
Any element having a bit value of 1 is called a set bit.
Given 2 BitSets, B1 and B2, of N size where all bits in both BitSets are initialized to 0, perform a series
of M operations. After each operation, print the number of set bits in the respective BitSets as two 
space-separated integers on a new line.

Input Format:
The first line contains 2 space-separated integers, N (the length of both BitSets B1 and B2) 
and M (the number of operations to perform), respectively.
The M subsequent lines each contain an operation in one of the following forms:
- AND <set> <set>
- OR <set> <set>
- XOR <set> <set>
- FLIP <set> <index>
- SET <set> <index>

In the list above, <set> is the integer 1 or 2, where 1 denotes B1 and 2 denotes B2.
<index> is an integer denoting a bit's index in the BitSet corresponding to <set>.

For the binary operations AND, OR and XOR, operands are read from left to right and the BitSet resulting
from the operation replaces the contents of the first operand. For example:

AND 2 1

B2 is the left operand, and B1 is the right operand. This operation should assign the result of 
B2 and B1 to B2. (ie. B2 = B2 & B1)

Constraints:
1<=N<=1000
1<=M<=10000

Output Format:
After each operation, print the respective number of set bits in BitSet B1 and BitSet B2 as 2 pieces
space-separated integers on a new line.

Sample Input
```
5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1
```
Sample Output
```
0 0
1 0
1 1
1 2
```

#Priority Queue

There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED,
can take place which are described below.
- ENTER: A student with some priority enters the queue to be served.
- SERVED: The student with the highest priority is served (removed) from the queue.

A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):
- The student having the highest Cumulative Grade Point Average (CGPA) is served first.
- Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
- Any students having the same CGPA and name will be served in ascending order of the id.

Input Format:
The first line contains an integer, N, describing the total number of events.
Each of the N subsequent lines will be of the following two forms:
- ENTER name CGPA id: The student to be inserted into the priority queue.
- SERVED: The highest priority student in the queue was served.
The locked stub code in the editor reads the input and tests the correctness of the Student and Priorities classes implementation.

Constraints:
2<=n<=1000
0<=cgpa<=4.00
1<=id<=10^5
2<=|name|<=30

Output Format:
The locked stub code prints the names of the students yet to be served in the priority order.
If there are no such student, then the code prints EMPTY.

Sample Input:
```
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
```
Sample Output 0
```
Dan
Ashley
Shafaet
Maria
```

#order substrings

We define the following terms:
- Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:

  A<B<...<Z<a<...<y<z
 
  For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.

- A substring of a string is a contiguous block of characters in the string.
 
  For example, the substrings of abc are a, b, c, ab, bc, and abc.

Given a string, s, and an integer, k, 
complete the function so that it finds the lexicographically smallest and largest substrings of length k.

Function Description:
Complete the getSmallestAndLargest function in the editor below.
getSmallestAndLargest has the following parameters:
- string s: a string
- int k: the length of the substrings to find

Returns:
- string: the string ' + "\n" + ' where and are the two substrings

Input Format:
The first line contains a string denoting s.
The second line contains an integer denoting k.

Constraints:
- 1<=|k|<=1000
- s consists of English alphabetic letters only (i.e., [a-zA-Z]).

Sample Input:
```
welcometojava
3
```
Sample Output:
```
ava
wel
```

#palindrome

A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string a, print Yes if it is a palindrome, print No otherwise.

Constraints:
- A will consist at most 50 lower case english letters.

Sample Input:
```
madam
```

Sample Output:
```
Yes
```

#Anagrams

Two strings, a and b, are called anagrams if they contain all the same characters in the same frequencies.
For this challenge, the test is not case-sensitive. 
For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.

Function Description:
Complete the isAnagram function in the editor.

isAnagram has the following parameters:
- string a: the first string
- string b: the second string

Returns
- boolean: If a and b are case-insensitive anagrams, return true. Otherwise, return false.

Input Format:
The first line contains a string a.
The second line contains a string b.

Constraints:
- 1<=length(a),length(b)<=50
- Strings a and b consist of English alphabetic characters.
- The comparison should NOT be case sensitive.

Sample Input:
```
anagram
margana
```
Sample Output:
```
Anagrams
```
Explanation:
```
Character 	Frequency: anagram 	Frequency: margana
A or a          3        	3
G or g        	1        	1
N or n        	1        	1
M or m        	1        	1
R or r        	1        	1
```
The two strings contain all the same letters in the same frequencies, so we print "Anagrams".

Sample Input:
```
anagramm
marganaa
```
Sample Output:
```
Not Anagrams
```
Explanation:
```
Character 	Frequency: anagramm 	Frequency: marganaa
A or a        	3        	4
G or g        	1        	1
N or n        	1        	1
M or m        	2        	1
R or r        	1        	1
```
The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".

Sample Input:
```
Hello
hello
```
Sample Output:
```
Anagrams
```
Explanation:
```
Character 	Frequency: Hello 	Frequency: hello
E or e        	1        	1
H or h        	1        	1
L or l        	2        	2
O or o        	1        	1
```
The two strings contain all the same letters in the same frequencies, so we print "Anagrams".

#String token

Given a string, s, matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens.
We define a token to be one or more consecutive English alphabetic letters.
Then, print the number of tokens, followed by each token on a new line.
Note: You may find the String.split method helpful in completing this challenge.

Input Format:
A single string, s.

Constraints:
- 1<= length(s) <= 4*10^5
- s is composed of any of the following: English alphabetic letters, blank spaces, exclamation points (!), 
  commas (,), question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).

Output Format:
On the first line, print an integer, n, denoting the number of tokens in string s (they do not need to be unique).
Next, print each of the n tokens on a new line in the same order as they appear in input string s.

Sample Input:
```
He is a very very good boy, isn't he?
```
Sample Output:
```
10
He
is
a
very
very
good
boy
isn
t
he
```
Explanation:
We consider a token to be a contiguous segment of alphabetic characters. There are a total of 10
such tokens in string s, and each token is printed in the same order in which it appears in string s.

#Regex pattern syntax checker

Using Regex, we can easily match or search for patterns in a text. Before searching for a pattern,
we have to specify one using some well-defined syntax.
In this problem, you are given a pattern. You have to check whether the syntax of the given pattern is valid.

Note: In this problem, a regex is only valid if you can compile it using the Pattern.compile method.

Input Format:
The first line of input contains an integer N, denoting the number of test cases.
The next N lines contain a string of any printable characters representing the pattern of a regex.

Output Format:
For each test case, print Valid if the syntax of the given pattern is correct. Otherwise, print Invalid.
Do not print the quotes.

Sample Input:
```
3
([A-Z])(.+)
[AZ[a-z](a-z)
batcatpat(nat
```
Sample Output:
```
Valid
Invalid
Invalid
```

#Regex ip address checker

Write a class called MyRegex which will contain a string pattern.
You need to write a regular expression and assign it to the pattern such that it can be used to validate an IP address.
Use the following definition of an IP address:
IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.

Some valid IP address:
```
000.12.12.034
121.234.12.12
23.45.12.56
```
Some invalid IP address:
```
000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip
```
In this problem you will be provided strings containing any combination of ASCII characters.
You have to write a regular expression to find the valid IPs.
Just write the MyRegex class which contains a String pattern.
The string should contain the correct regular expression.

Sample Input:
```
000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
122.23
Hello.IP
```
Sample Output:
```
true
true
true
false
false
false
```

#Remove duplications by Regex

In this challenge, we use regular expressions (RegEx) to remove instances of words that are repeated more than once, 
but retain the first occurrence of any case-insensitive repeated word. For example, the words love and to are repeated
in the sentence I love Love to To tO code. 
Can you complete the code in the editor so it will turn I love Love to To tO code into I love to code?

To solve this challenge, complete the following three lines:
1. Write a RegEx that will match any repeated word.
2. Complete the second compile argument so that the compiled RegEx is case-insensitive.
3. Write the two necessary arguments for replaceAll such that each repeated word is replaced with the very first 
   instance the word found in the sentence. It must be the exact first occurrence of the word, as the expected 
   output is case-sensitive.

Note: This challenge uses a custom checker; you will fail the challenge if you modify anything other than the three 
locations that the comments direct you to complete. To restore the editor's original stub code, create a new buffer by 
clicking on the branch icon in the top left of the editor.

Input Format:
The following input is handled for you the given stub code:
- The first line contains an integer N, denoting the number of sentences.
- Each of the N subsequent lines contains a single sentence consisting of English alphabetic letters and whitespace characters.

Constraints:
- Each sentence consists of at most 10^4 English alphabetic letters and whitespaces.
- 1<=N<=100

Output Format:
tub code in the editor prints the sentence modified by the replaceAll line to stdout. The modified string must be a 
modified version of the initial sentence where all repeat occurrences of each word are removed.

Sample Input:
```
5
Goodbye bye bye world world world
Sam went went to to to his business
Reya is is the the best player in eye eye game
in inthe
Hello hello Ab aB
```

Sample Output:
```
Goodbye bye world
Sam went to his business
Reya is the best player in eye game
in inthe
Hello Ab
```
Explanation:
1. We remove the second occurrence of bye and the second and third occurrences of world from Goodbye bye bye world world world to get Goodbye bye world.
2. We remove the second occurrence of went and the second and third occurrences of to from Sam went went to to to his business to get Sam went to his business.
3. We remove the second occurrence of is, the second occurrence of the, and the second occurrence of eye from Reya is is the the best player in eye eye game to get Reya is the best player in eye game.
4. The sentence in inthe has no repeated words, so we do not modify it.
5. We remove the second occurrence of ab from Hello hello Ab aB to get Hello Ab. It's important to note that our matching is case-insensitive, and we specifically retained the first occurrence of the matched word in our final string.

#Validate user name by Regex

You are updating the username policy on your company's internal networking platform. According to the policy, a username
is considered valid if all the following constraints are satisfied:
- The username consists of 8 to 30 characters inclusive. If the username consists of less than 8 or greater than 30
  characters, then it is an invalid username.
- The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the 
  character set consisting of lowercase characters [a-z], uppercase characters [A-Z], and digits [0-1].
- The first character of the username must be an alphabetic character, i.e., either lowercase character [a-z] or
  uppercase character [A-Z].

For example:
```
Username 	    Validity
Julia           INVALID;     Username length < 8 characters
Samantha        VALID
Samatha_21      VALID
1Samantha       INVALID;     Username begins with non-alphabetic character
Samantha?10_2A  INVALID;     '?' character not allowed
```
Update the value of regularExpression field in the UsernameValidator class so that the regular expression only matches 
with valid usernames.

Input Format:
The first line of input contains an integer N, describing the total number of usernames. Each of the next N lines 
contains a string describing the username. The locked stub code reads the inputs and validates the username.

Constraints:
- 1<=N<=100
- The username consists of any printable characters.

Output Format:
For each of the usernames, the locked stub code prints Valid if the username is valid; otherwise Invalid each on a new line.

Sample Input:
```
8
Julia
Samantha
Samantha_21
1Samantha
Samantha?10_2A
JuliaZ007
Julia@007
_Julia007
```
Sample Output:
```
Invalid
Valid
Valid
Invalid
Invalid
Valid
Invalid
Invalid
```

#Tag Content Extractor

In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag like
<tag>contents</tag>. Note that the corresponding end tag starts with a /.
Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences
of well-organized tags meeting the following criterion:
1. The name of the start and end tags must be same. The HTML code `<h1>Hello World</h2>` is not valid, because the text 
   starts with an h1 tag and ends with a non-matching h2 tag.
2. Tags can be nested, but content between nested tags is considered not valid. For example, in 
   `<h1><a>contents</a>invalid</h1>`, contents is valid but invalid is not valid.
3. Tags can consist of any printable characters.

Input Format:
The first line of input contains a single integer, N (the number of lines).
The N subsequent lines each contain a line of text.

Constraints:
- 1<=N<=100
- Each line contains a maximum of 10^4 printable characters.
- The total number of characters in all test cases will not exceed 10^6.

Output Format
For each line, print the content enclosed within valid tags.
If a line contains multiple instances of valid content, print out each instance of valid content on a new line; 
if no valid content is found, print None.

Sample Input:
```
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>
```
Sample Output:
```
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush
```
