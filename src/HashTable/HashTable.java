package HashTable;


import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    static class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if (dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23 % dataMap.length) ;
        }

//        System.out.println(hash % dataMap.length);
         return hash % dataMap.length;
//         return hash % dataMap.length;
    }

    private void set(String key, int value) {
        int hashIndex = hash(key);
        if (dataMap[hashIndex] == null) {
            dataMap[hashIndex] = new Node(key, value);
            return;
        }

        Node temp = dataMap[hashIndex];
        while (temp != null) {
            if (temp.next == null) {
                temp.next = new Node(key, value);
                return;
            }

            temp = temp.next;
        }

//        while (temp.next != null) {
//            temp = temp.next;
//        }
//
//        temp.next = new Node(key, value);
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
//        if (temp == null) {
//            return 0;
//        }

        while (temp != null) {
            if (key.equals(temp.key)) {
                return temp.value;
            }

            temp = temp.next;
        }

        return 0;
    }

    public List<String> keys() {
        List<String> allKeys = new ArrayList<>();

        for (Node node : dataMap) {
            Node temp = node;
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }

        }
        return allKeys;
    }


    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();

//        myHashTable.printTable();


        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        myHashTable.set("luong", 123);
        myHashTable.set("123", 87770);
        myHashTable.set("bolts", 200);
        myHashTable.set("cfwert", 2020);
        myHashTable.set("boltirtyus", 1);

        System.out.println("boltirtyus:");
        System.out.println(myHashTable.get("boltirtyus"));

    }

}



