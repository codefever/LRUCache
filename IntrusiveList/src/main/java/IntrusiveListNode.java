/**
 * Created by nelson on 11/15/14.
 */
public class IntrusiveListNode<T> {
  public T value;
  public IntrusiveListNode<T> next;
  public IntrusiveListNode<T> prev;

  public IntrusiveListNode(T value) {
    this.next = this;
    this.prev = this;
    this.value = value;
  }

  public IntrusiveListNode() {
    this.next = this;
    this.prev = this;
  }

  public boolean isEmpty() {
    return this.next == this && this.prev == this;
  }

  public void unlink() {
    this.prev.next = this.next;
    this.next.prev = this.prev;
  }

  public void linkNext(IntrusiveListNode<T> other) {
    other.unlink();
    other.next = this.next;
    other.prev = this;
    this.next.prev = other;
    this.next = other;
  }

  public void linkPrev(IntrusiveListNode<T> other) {
    other.unlink();
    other.next = this;
    other.prev = this.prev;
    this.prev.next = other;
    this.prev = other;
  }
}
