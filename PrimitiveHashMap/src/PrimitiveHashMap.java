public class PrimitiveHashMap<K, V> {
    class InnerLinkedList<K, V> {
        K key;
        V value;
        InnerLinkedList<K, V> next;

        InnerLinkedList(K key, V value, InnerLinkedList<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        V search(K key) {
            InnerLinkedList<K, V> current = this;
            for (; null != current; current = current.next) {
                if (key == current.key) {
                    return current.value;
                }
            }

            return null;
        }

    }

    InnerLinkedList<K, V> list;

    public V get(K key) {
        return list.search(key);
    }

    public void put(K key, V value) {
        list = new InnerLinkedList<K, V>(key, value, list);
    }

    // Test codes
    public static void main(String[] args) {
        PrimitiveHashMap<String, String> map = new PrimitiveHashMap<>();
        map.put("first", "World");
        map.put("second", "Hello");
        System.out.println(map.get("second") + " " + map.get("first"));
    }
}
