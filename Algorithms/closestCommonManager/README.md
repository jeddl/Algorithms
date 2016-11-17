# Closest Common Manager
## Example
In a company which has a CEO and a hierarchy of employees. Employees can have a list of other employees reporting to them, which can themselves have reports, and so on. An employee with at least one report is called a manager.
Please implement the closestCommonManager method to find the closest manager (i.e. farthest from the CEO) to two employees.
```
         Bill(CEO)
        _____|_____
       /     |     \
     DOM    SAMIR  MICHAEL
    __|____
   /   \   \
  Peter Bob Porter
 ___|___
/        \
Milton  Nina
```
Now for example, closestCommonManager(Milton, Nina) = Peter , closestCommonManager(Nina, Porter) = Dom, closestCommonManager(Nina, Samir) = Bill, closestCommonManager(Peter, Nina) = Peter, etc.

## Solution
- This is a similar problem to LCA(Lowest Comman Ancestor)
- Use DFS to find all the managers of the given target employees, and compare these managers to determine the closest common one
- Always make sure the comparison starts where two employees are on the same tree level(If not, move it up) 

