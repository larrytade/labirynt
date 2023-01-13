package com.company.Exe.Mitko.DataStructure;

class Node<E> {
        E data;
        Node next;


        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList<E> {

        Node<E> head;

        private int length = 0;

        LinkedList() {
            this.head = null;
        }



        void add(E data) {
            Node<E> temp = new Node<>(data);

            if (this.head == null) {
                head = temp;
            } else {
                Node<E> X = head;
                while (X.next != null) {
                    X = X.next;
                }
                X.next = temp;
            }
            length++;
        }

        /*
        void add(int position, E data) {
            if (position > length + 1) {

                System.out.println("Position Unavailable in LinkedList");
                return;
            }
            if (position == 1) {

                Node<E> temp = head;

                head = new Node<E>(data);

                head.next = temp;

                return;
            }

            Node<E> temp = head;

            Node<E> prev = new Node<E>(null);

            while (position - 1 > 0) {

                prev = temp;

                temp = temp.next;

                position--;
            }

            prev.next = new Node<E>(data);

            prev.next.next = temp;
        }
*/
        void remove(E key) {

            if (isEmpty()) {
                System.out.print("Linked List is Empty!");
                return;
            }

            Node<E> prev = new Node<>(null);

            prev.next = head;

            Node<E> next = head.next;

            Node<E> temp = head;

            boolean exists = false;

            if (head.data == key) {
                head = head.next;

                exists = true;
            }

            while (temp.next != null) {

                if (String.valueOf(temp.data).equals(String.valueOf(key))) {

                    prev.next = next;
                    exists = true;
                    break;
                }
                prev = temp;
                temp = temp.next;
                next = temp.next;
            }
            if (exists == false && String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = null;
                exists = true;
            }
            if (exists) {
                length--;
            } else {
                System.out.println("Given Value is not present in linked list");
            }
        }

        void removeOnPosition(Integer position) {
            if (isEmpty()) {
                System.out.print("Linked List is Empty!");
            }

            Node temp = head;

            if (position == 0) {
                head = temp.next;
                return;
            }

            for (int i = 0; temp != null && i < position - 1;
                 i++)
                temp = temp.next;


            if (temp == null || temp.next == null)
                return;

            Node next = temp.next.next;

            temp.next = next;

        }

        public E get(Integer position) {
            Node<E> curr = head;
            int currPosition = 0;
            while (curr != null) {
                if (currPosition == position) {
                    return curr.data;
                } else {
                    curr = curr.next;
                    currPosition++;
                }
            }
            return curr.data;
        }

        public int sizeOf() {
            return this.length;
        }

        public boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        public Integer find(E element) {
            Node cur = head;
            int position = 0;
            while (cur != null) {
                if (element.equals(cur.data)) {
                    return position;
                } else {
                    cur = cur.next;
                    position++;
                }
            }
            return -1;
        }

        void print() {
            Node cur = head;
            while (cur != null) {
                System.out.print(cur.data + ", ");
                cur = cur.next;
            }
        }
    }


