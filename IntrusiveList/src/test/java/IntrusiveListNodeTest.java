/**
 * Created by nelson on 11/16/14.
 */
import junit.framework.TestCase;

public class IntrusiveListNodeTest extends TestCase {
  public void testEmpty() throws Exception {
    IntrusiveListNode<Integer> node = new IntrusiveListNode<Integer>();
    assertTrue(node.isEmpty());
  }

  public void testLink() throws Exception {
    IntrusiveListNode<Integer> node1 = new IntrusiveListNode<Integer>();
    node1.linkNext(node1);
    assertTrue(node1.isEmpty());

    IntrusiveListNode<Integer> node2 = new IntrusiveListNode<Integer>();
    node2.linkNext(node1);
    assertEquals(node1.next, node2);
    assertEquals(node1.prev, node2);
    assertEquals(node2.next, node1);
    assertEquals(node2.prev, node1);
  }
}
