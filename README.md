# ProgAssignment1

in my ProgAssign1.java file, line 36 holds the n value that we are searching for 1 to n

To compile : 
run command javac ProgAssign1.java
java ProgAssign1

output should print to primes.txt (:

Documentation:
implemented a Sieve of Eratosthenes algorithm in order to find primes (https://www.geeksforgeeks.org/sieve-of-eratosthenes/)
a boolean array of all true values is initialized 
starting at the value 2, if that indexed value is True then every factor of that indexed value thereafter is false and set as such
this continues all the way up until n.

n values 1 to 100000 run in under 5 seconds with high accuracy
10^6 and more run a bit slower 
