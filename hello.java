class BinaryHeap {
 
 private int nodes[];
 private int size;
 private int capacity;
  
 
 public BinaryHeap(int capacity) {
  this.size = 0;
  this.capacity = capacity;
  this.nodes = new int[capacity + 1];
 }
 
 public int size() {
  return size;
 }
 
 public int findMin() {
  if (size <= 0) {
   throw new RuntimeException("Empty Heap is empty.");
  }
  return nodes[1];
 }
 
 public void insert(int e) {
  if (size >= capacity) {
   throw new RuntimeException("Heap overflow.");
  }
 
  size++;
  nodes[size] = e;
  percolateUp();
 }
 
 public int deleteMin() {
  if (size <= 0) {
   throw new RuntimeException("Empty Heap is empty.");
  }
  int min = findMin();
  nodes[1] = nodes[size];
  size--;
  percolateDown();
  return min;
 }
 
 private void percolateDown() {
  int index = 1;
  while (true) {
   int child = index * 2;
   if (child > size)
    break;
   if (child + 1 <= size) {
    // if there are two children -> take the smallest or
    // if they are equal take the left one
    child = findMin(child, child + 1);
   }
   if (nodes[index] <= nodes[child])
    break;
   swap(index, child);
   index = child;
  }
 }
 
 private void percolateUp() {
  int index = size();
  while (index > 1) {
   int parent = index / 2;
   if (nodes[index] >= nodes[parent])
    break;
   swap(index, parent);
   index = parent;
  }
 }
 
 private void swap(int i, int j) {
  int temp = nodes[i];
  nodes[i] = nodes[j];
  nodes[j] = temp;
 }
 
 private int findMin(int leftChild, int rightChild) {
  if (nodes[leftChild] <= nodes[rightChild]) {
   return leftChild;
  } else {
   return rightChild;
  }
 }
  
 public static void main(String[] args) {
  BinaryHeap bh = new BinaryHeap(10);
  bh.insert(7);
  bh.insert(5);
  bh.insert(9);
  bh.insert(6);
  bh.insert(4);
  bh.insert(8);
  bh.insert(10);
  bh.insert(1);
  bh.insert(3);
  bh.insert(2);
   
  System.out.println("Size of Binary Heap is : " + bh.size());
 
  System.out.println("Delete min from Binary Heap : " + bh.deleteMin());
  System.out.println("Size of Binary Heap is : " + bh.size());
 
  System.out.println("Delete min from Binary Heap : " + bh.deleteMin());
  System.out.println("Size of Binary Heap is : " + bh.size());
 }
  
}
