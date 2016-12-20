/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null || nuts.length != bolts.length) {
            return;
        }
        
        quickSelect(nuts, bolts, compare, 0, bolts.length - 1);
    }
    
    private void quickSelect(String[] nuts, String[] bolts, NBComparator compare, int l, int r) {
        if (l >= r) {
            return;
        }
        
        // Bolts partition using pivot in nuts (using left as the pivot)
        int pos = partition(bolts, nuts[l], compare, l, r);
        // Nuts partition using pivot in bolts
        partition(nuts, bolts[pos], compare, l, r);
        
        quickSelect(nuts, bolts, compare, l, pos - 1);
        quickSelect(nuts, bolts, compare, pos + 1, r);
    }
    
    private int partition(String[] sortStr, String pivot, NBComparator compare, int l, int r) {
        for (int i = l; i <= r; ++i) {
            if (compare.cmp(sortStr[i], pivot) == 0 || compare.cmp(pivot, sortStr[i]) == 0) {
                // left because left has been used as the pivot(could be any random position)
                swap(sortStr, i, l);
                break;
            }
        }
        // corresponding pivot in current string
        String currPivot = sortStr[l];
        int left = l, right = r;
            
        while (left < right) {
                                            // if pivot in nuts
            while (left < right && (compare.cmp(pivot, sortStr[right]) == -1 ||
                                            // if pivot in bolts
                                   compare.cmp(sortStr[right], pivot) == 1)) {
                right--;
            }
                
            sortStr[left] = sortStr[right];
                
            while (left < right && (compare.cmp(pivot, sortStr[left]) == 1 ||
                                   compare.cmp(sortStr[left], pivot) == -1)) {
                left++;                           
            }
                
            sortStr[right] = sortStr[left];
        }
            
        sortStr[left] = currPivot;
            
        return left;
    }
    
    private void swap(String[] sortStr, int currPos, int tarPos) {
        String temp = sortStr[currPos];
        sortStr[currPos] = sortStr[tarPos];
        sortStr[tarPos] = temp;
    }
};