class UnionFind
{
    private int[] parent;
    private int count;

    public UnionFind(int n)
    {
        parent = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            parent[i] = i;
        }
    }

    private int Find(int x)
    {
        if (parent[x] == x) return x;
        parent[x] = Find(parent[x]);
        return parent[x];
    }

    public void Connect(int a, int b)
    {
        int rootA = Find(a);
        int rootB = Find(b);
        if (rootA != rootB)
        {
            parent[rootA] = rootB;
            count--;
        }
    }

    public int Query()
    {
        return count;
    }

    public void SetCount(int total)
    {
        count = total;
    }
}


class UnionFind
{
    private IDictionary<int, int> parent;
    private _count;

    public UnionFind(HashSet<int> set)
    {
        parent = new Dictionary<int, int>();
        foreach(var s in set)
        {
            parent[s] = s;
            _count++;
        }
    }

    private int Find(int x)
    {
        if (parent[x] == x) return x;

        parent[x] = Find(parent[x]);
        return parent[x];
    }

    public void Connect(int a, int b)
    {
        var rootA = Find(a);
        var rootB = Find(b);
        if (rootA != rootB)
        {
            parent[rootA] = rootB;
            count--;
        }

    }

    public int QueryCount()
    {
        return _count;
    }
}
