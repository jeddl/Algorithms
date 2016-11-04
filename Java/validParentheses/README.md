# Valid Parentheses
## Example
Given a string containing just the characters `'(', ')', '{', '}', '[' and ']'`, determine if the input string is valid.

e.g.
`"(){}([])"` is valid; 
`"([})"` is not valid

## Solution
- Put matched `'(', '[' and '{'` in a stack
- Check if every character in the rest string matching the peek element in the stack
