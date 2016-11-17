class Solution {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> list = new ArrayList<Integer> ();
        Collections.sort(S); // It is important to sort array
        subHelper(result, list, S, 0);
        return result;
    }
    public void subHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S, int pos) {
        result.add(new ArrayList<Integer> (list));
        for (int i = pos; i < S.size(); i++) {
            if (i != pos && S.get(i) == S.get(i - 1)) {
                continue;
            }
            list.add(S.get(i));
            subHelper(result, list, S, i + 1);
            list.remove(list.size() - 1); 
        }
    }

}