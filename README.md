# ProgAssignment1

in my ProgAssign1.java file, line 38 holds the n value that we are searching for 1 to n

To compile : 
run command javac ProgAssign1.java
java ProgAssign1

output should print to primes.txt (:

Documentation:
implemented a Sieve of Eratosthenes algorithm in order to find primes (https://www.geeksforgeeks.org/sieve-of-eratosthenes/)
a prime boolean array of all true values is initialized 
starting at the value 2, if that indexed value is True then every factor of that indexed value thereafter is false and set as such
this continues all the way up until n.
Using threads, a current value is taken to find if it is prime and uses the sieve to update the prime array if so 
each thread takes the updated and synchronized current value to do the task at hand

in attempt to optimize, the upper bound of the while loop for the spawned threads were be set to Math.sqrt(n) since Every composite number has at least one prime factor that's smaller than its square root but this caused incorrect answers to be outputted and was opted out of this source code

n values 1 to 100000 run in under 5 seconds with high accuracy
10^6 and more run a bit slower 
