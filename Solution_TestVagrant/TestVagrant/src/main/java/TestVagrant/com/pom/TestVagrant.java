package TestVagrant.com.pom;

import java.util.HashMap;

public class TestVagrant {

	public static class LRU {
		class Node {
			String key, value;
			Node prev, next;
		}

		HashMap<String, Node> cache; // For implementing LRU cache creating HashMap defining capacity and head and tail node
										
		private final int cap;
		private final Node head, tail;

		public LRU(int capacity) { // Initialize the HashMap, capacity and Head & Tail node
			cache = new HashMap<>();
			cap = capacity;
			head = new Node();
			tail = new Node();

			head.next = tail;
			tail.prev = head;
		}

		private void addNode(Node node) { // Method to add songs in the play-list(Node)

			Node nbr = head.next;

			node.next = nbr;
			node.prev = head;

			nbr.prev = node;
			head.next = node;

		}

		private void removeNode(Node node) { // Method to remove songs from the play-list(Node)

			Node prevNbr = node.prev;
			Node nxtNbr = node.next;

			prevNbr.next = nxtNbr;
			nxtNbr.prev = prevNbr;

			node.next = node.prev = null;
		}

		private void moveToFront(Node node) { // Method to maintain the queue of the play-list (Node)

			removeNode(node);
			addNode(node);
		}

		public String get(String key) { // Method to get the most recent queue in the play-list
			Node node = cache.get(key);

			String empty = " Not in the playlist";
			if (node == null) {

				return empty;
			} else {
				String v1 = node.value;
				moveToFront(node);

				Node n = head.next;

				while (n != tail) {
					System.out.print(" " + n.value + " ");
					n = n.next;
				}
				System.out.println();

				return v1;

			}
		}

		public void put(String key, String value) { // Method to add songs in the play-List

			Node node = cache.get(key);

			if (node == null) {
				Node newNode = new Node();
				newNode.key = key;
				newNode.value = value;

				if (cache.size() == cap) {
					Node LRU_Node = tail.prev;
					cache.remove(LRU_Node.key);
					removeNode(LRU_Node);

				}
				cache.put(key, newNode);
				addNode(newNode);
			} else {
				node.value = value;
				moveToFront(node);
			}
		}
	}
}