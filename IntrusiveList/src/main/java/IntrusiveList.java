/**
 * Created by nelson on 11/15/14.
 */
//import main.java.IntrusiveListNode;

public class IntrusiveList<T> {
  // head of list
  IntrusiveListNode<T> head;

  public IntrusiveList() {
    head = new IntrusiveListNode<T>();
  }

  public boolean isEmpty() {
    return head.isEmpty();
  }

  public void addFirst(IntrusiveListNode<T> node) {
   head.linkNext(node);
  }

  public void addLast(IntrusiveListNode<T> node) {
    head.linkPrev(node);
  }

  public IntrusiveListNode<T> removeLast() {
    if (isEmpty()) {
      return null;
    }
    IntrusiveListNode<T> last = head.prev;
    last.unlink();
    return last;
  }

  public IntrusiveListNode<T> removeFirst() {
    if (isEmpty()) {
      return null;
    }
    IntrusiveListNode<T> first = head.next;
    first.unlink();
    return first;
  }
}
