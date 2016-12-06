# Number of Airplanes in The Sky
## Example
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?
```
If landing and flying happens at the same time, we consider landing should happen at first.
```

For interval list
```
[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
```
Return `3`

## Solution
- Sweeping Line
- New class to track each flight's takeoff/landing time and status
