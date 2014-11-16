/**
 * Created by nelson on 11/16/14.
 */

import junit.framework.TestCase;

public class LRUCacheTest extends TestCase {
  public void testSetAndGet() throws Exception {
    LRUCache<Integer, String> cache = new LRUCache<Integer, String>(3);

    // set
    assertTrue(cache.set(1, "hello", 1));
    assertTrue(cache.set(2, "gg", 1));
    assertTrue(cache.set(3, "luck", 1));
    // get
    assertEquals("hello", cache.get(1));
    assertEquals("gg", cache.get(2));
    assertEquals("luck", cache.get(3));

    // capacity
    assertTrue(cache.set(4, "bye", 10));
    assertEquals(null, cache.get(1));
    assertEquals("gg", cache.get(2));
    assertEquals("luck", cache.get(3));
    assertEquals("bye", cache.get(4));

    // remove
    cache.remove(3);
    assertEquals(null, cache.get(1));
    assertEquals("gg", cache.get(2));
    assertEquals(null, cache.get(3));
    assertEquals("bye", cache.get(4));

    // timeout
    Thread.sleep(2000);  // 2 secs
    assertEquals(null, cache.get(1));
    assertEquals(null, cache.get(2));
    assertEquals(null, cache.get(3));
    assertEquals("bye", cache.get(4));
  }
}
