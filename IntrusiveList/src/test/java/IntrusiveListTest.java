/**
 * Created by nelson on 11/16/14.
 */

import junit.framework.TestCase;

public class IntrusiveListTest extends TestCase {
  public void testEmpty() throws Exception {
    IntrusiveList<Integer> list = new IntrusiveList<Integer>();
    assertTrue(list.isEmpty());
  }

  public void testAddRemove() throws Exception {
    IntrusiveList<Integer> list = new IntrusiveList<Integer>();
    IntrusiveListNode<Integer> current = null;

    IntrusiveListNode<Integer> node1 = new IntrusiveListNode<Integer>(1);
    IntrusiveListNode<Integer> node2 = new IntrusiveListNode<Integer>(2);
    IntrusiveListNode<Integer> node3 = new IntrusiveListNode<Integer>(3);

    list.addLast(node2);
    list.addFirst(node1);
    list.addLast(node3);

    current = list.head.next;
    assertEquals(current, node1);
    current = current.next;
    assertEquals(current, node2);
    current = current.next;
    assertEquals(current, node3);
    current = current.next;
    assertEquals(list.head, current);

    node1.unlink();

    current = list.head.next;
    assertEquals(current, node2);
    current = current.next;
    assertEquals(current, node3);
    current = current.next;
    assertEquals(list.head, current);

    list.removeLast();

    current = list.head.next;
    assertEquals(current, node2);
    current = current.next;
    assertEquals(list.head, current);
  }
}
