import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {

    private VectorHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    public void testAdd() {
        
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        
        
        assertEquals(4, heap.size());
    }

    @Test
    public void testPoll() {
        
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        
        
        assertEquals(Integer.valueOf(1), heap.poll());
        assertEquals(3, heap.size());
    }

    @Test
    public void testIsEmpty() {
        
        assertTrue(heap.isEmpty());
        
        
        heap.add(5);
        
        
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testSize() {
        
        heap.add(5);
        heap.add(3);
        heap.add(8);
        
        
        assertEquals(3, heap.size());
    }
}
