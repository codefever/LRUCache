/**
 * Created by nelson on 11/16/14.
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
  final int capacity;
  Map<K, Node> map = new HashMap<K, Node>();
  IntrusiveList<Node> list = new IntrusiveList<Node>();

  public class Node extends IntrusiveListNode<Node> {
    public K key;
    public V value;
    public double expired_time;
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }

  public int size() {
    return map.size();
  }

  public boolean set(K key, V value, double expire_seconds) {
    Node node = map.get(key);
    if (node != null) {
      // already exists
      return false;
    }

    // create new node
    node = new Node();
    node.key = key;
    node.value = value;
    if (expire_seconds > 0) {
      node.expired_time = System.currentTimeMillis() + expire_seconds * 1000;
    }

    // add first
    map.put(key, node);
    list.addFirst(node);

    // remove sth
    while (map.size() > capacity) {
      Node remove_node = (Node)list.removeLast();
      map.remove(remove_node.key);
    }

    return true;
  }

  public V get(K key) {
    Node node = map.get(key);
    if (node == null) {
      return null;
    }

    // expired
    if (node.expired_time < System.currentTimeMillis()) {
      return null;
    }

    // move first
    node.unlink();
    list.addFirst(node);

    return node.value;
  }

  public void remove(K key) {
    Node node = map.remove(key);
    if (node != null) {
      node.unlink();
    }
  }
}
