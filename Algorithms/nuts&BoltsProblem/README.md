# Nuts & Bolts Problem
## Example
Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and bolts. Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

We will give you a compare function to compare nut with bolt.

Given `nuts = ['ab','bc','dd','gg']`, `bolts = ['AB','GG', 'DD', 'BC']`.
Your code should find the matching bolts and nuts.
one of the possible return:

`nuts = ['ab','bc','dd','gg']`, `bolts = ['AB','BC','DD','GG']`.

we will tell you the match compare function. If we give you another compare function, the possible return is the following:

`nuts = ['ab','bc','dd','gg']`, `bolts = ['BC','AA','DD','GG']`.

So you must use the compare function that we give to do the sorting.

## Solution
- Quick Select (Partition)
- Before partitioning, keep the corresponding nuts/bolts at the same position

 ```java
        for (int i = l; i <= r; ++i) {
            if (compare.cmp(sortStr[i], pivot) == 0 || compare.cmp(pivot, sortStr[i]) == 0) {
                swap(sortStr, i, l);
                break;
            }
        }
 ```
