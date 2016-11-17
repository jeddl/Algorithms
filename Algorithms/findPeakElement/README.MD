# Find Peak Element

Find a peak in an array which has following features:
 - The numbers in adjacent positions are different
 - A[0] < A[1] && A[A.length - 2] > A[A.length - 1]

If A[peak] is the peak:

	A[peak] > A[peak - 1] && A[peak] > A[peak + 1]

Find the peak in this array. Return the index of the peak.