package org.example.model;

import java.util.Iterator;

public class LinkedList <T>{


    private Node head;
    private int size;


    public LinkedList() {
    }



    private class Node implements Iterator<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void print() {
            System.out.println(data);
            if (next != null) {
                next.print();
            }
        }

        public void add(Node newNode, int index, int i) {
            if (i == index - 1) {
                newNode.setNext(this.getNext());
                this.setNext(newNode);
            } else {
                this.getNext().add(newNode, index, i + 1);
            }
        }

        public T isEqual(int index, int i) {

            if (i == index) return this.getData();
            return this.getNext().isEqual(index, i + 1);

        }

        public Node isEqualNode(int index, int i) {

            if (i == index) return this;
            return this.getNext().isEqualNode(index, i + 1);

        }

        public int isEqualNode(Node node, int i) {
            if (this.getData().equals(node.getData())) return i;
            return this.getNext().isEqualNode(node, i + 1);
        }

        public void removeLast() {
            if (this.getNext().getNext() == null) {
                this.setNext(null);
            } else {
                this.getNext().removeLast();
            }
        }

        public void remove(int index, int i) {
            if (i == index - 1) {
                this.setNext(this.getNext().getNext());
            } else {
                this.getNext().remove(index, i + 1);
            }
        }



        @Override
        public String toString() {
            return  data.toString();
        }

        public void sort() {
            if (this.getNext() != null) {
                if (this.getData().toString().compareTo(this.getNext().getData().toString()) > 0) {
                    T temp = this.getData();
                    this.setData(this.getNext().getData());
                    this.getNext().setData(temp);
                }
                this.getNext().sort();
            }

        }

        @Override
        public boolean hasNext() {
            return this.getNext() != null;
        }

        @Override
        public T next() {
            return this.getNext().getData();
        }
    }

    /*
    * Remove all nodes from the list
     */

    public void clear() {
        head = null;
        size = 0;
    }


    /*
        * update a node given a specific index
     */

    public void update(T data, int index) {
        if (index >= 0 && index < size) {
            Node temp = head;
            temp.isEqualNode(index, 0).setData(data);
        }
    }

    /*
        * sort the list
     */
    public void sort() {
       while (!listSort(head)) {
           Node temp = head;
           temp.sort();
       }

    }
    /*
        * method that checks if the list is sorted
     */
    private boolean listSort(Node head) {

        if (head.getNext() == null) return true;
        if (head.getData().toString().compareTo(head.getNext().getData().toString()) > 0) return false;
        return listSort(head.getNext());


    }





    /*
        * remove a node given a specific index
     */

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else if (index > 0 && index < size - 1) {
            Node temp = head;
            temp.remove(index, 0);
        }
    }




    /*
        * get a position of given node
    */

    public int getPosition(Node node) {
        if (head != null) {
            Node temp = head;
            int i = 0;
           return temp.isEqualNode(node, i);
        }
        return -1;

    }

    /*
        * add a node at the end of the list
    */


    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }

        size++;
    }

    /*
        * Add a node given a specific index
    */

    public void add(T data, int index) {
        if (index == 0) {
            add(data);
        } else if (index == size) {
            addLast(data);
        } else if (index > 0 && index < size) {
            Node newNode = new Node(data);
            head.add(newNode, index, 0);
        }
    }

    /*
        * get a node given a specific index
    */

    public Node getNode(int index) {
        if (index >= 0 && index < size) {
            Node temp = head;
            return temp.isEqualNode(index, 0);
        }
        return null;
    }



    /*
        * get value of a node given a specific index
    */

    public T get(int index) {
        if (index >= 0 && index < size) {
            Node temp = head;
            return temp.isEqual(index, 0);
        }
        return null;
    }

    /*
        * verify if a index is valid
     */

    public boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    /*
        *verify if the list is empty
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /*
        * remove the first node
     */

    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
            size--;
        }
    }

    /*
        * remove the last node
     */

    public void removeLast() {
        if (head != null) {
            if (head.getNext() == null) {
                head = null;
            } else {
                Node temp = head;
                temp.removeLast();

            }
            size--;
        }
    }

    /*
        * add a node at the beginning of the list
     */

    public void add(T data) {
        Node newNode = new Node(data);
        if (head != null) {
            Node temp = head;
            newNode.setNext(temp);
        }
        head = newNode;
        size++;
    }

    /*
        * remove a node given a specific data
     */

    public void remove(T data) {
        if (head != null) {
            Node temp = head;
            Node prev = null;
            while (temp != null) {
                if (temp.getData().equals(data)) {
                    if (prev != null) {
                        prev.setNext(temp.getNext());
                    } else {
                        head = temp.getNext();
                    }
                    size--;
                    break;
                }
                prev = temp;
                temp = temp.getNext();
            }
        }
    }

    public void print() {
        if (head != null) {
            head.print();
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
