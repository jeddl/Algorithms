public class LRUCache {

    private IDictionary<int, Node> _dict;
    private int _capacity;
    private Node _tail = new Node(-1, -1);
    private Node _head = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        _dict = new Dictionary<int, Node>();
        _capacity = capacity;
        _head.Next = _tail;
        _tail.Prev = _head;
    }
    
    public int Get(int key) {
        if (!_dict.ContainsKey(key))
            return -1;
        
        var currentNode = _dict[key];
        currentNode.Prev.Next = currentNode.Next;
        currentNode.Next.Prev = currentNode.Prev;
        
        MoveToTail(currentNode);
        
        return _dict[key].Value;
    }
    
    private void MoveToTail(Node node)
    {
        node.Prev = _tail.Prev;
        _tail.Prev = node;
        node.Prev.Next = node;
        node.Next = _tail;
    }
    
    public void Put(int key, int value) {
        if (Get(key) != -1)
        {
            _dict[key].Value = value;
            return;
        }
        
        if (_dict.Count == _capacity)
        {
            _dict.Remove(_head.Next.Key);
            _head.Next = _head.Next.Next;
            _head.Next.Prev = _head;
        }
        
        var newNode = new Node(key, value);
        _dict[key] = newNode;
        MoveToTail(newNode);
    }
    
    class Node
    {
        public Node Prev {get; set;}
        public Node Next {get; set;}
        public int Value {get; set;}
        public int Key {get; set;}
        
        public Node(int key, int value)
        {
            Key = key;
            Value = value;
            Prev = null;
            Next = null;
        }
    }
}
