package 高频题;

import com.adam.tools.Asserts;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** https://leetcode-cn.com/problems/lru-cache/
 * _146_LRU_缓存
 * @auther adam
 * @date 2022/2/21
 * @apiNote 高频题
 */
public class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    // 虚拟头结点
    private Node first;
    // 虚拟尾结点
    private Node last;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;

    }

    public int get(int key) {
        Node v = map.get(key);
        if (v == null) return -1;
        // 缓存
        removeNode(v);
        addAfterFirst(v);
        return v.value;
    }



    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            // 缓存
            removeNode(node);
        } else  {// 添加一对新的key-value

            if (map.size() == capacity) {
                /// 淘汰最近最少使用的node
                removeNode(map.remove(last.prev.key));
            }

            map.put(key, node = new Node(key, value));
        }
        addAfterFirst(node);


    }
    // 从双向链表中插入node节点到first节点的后面
    private void addAfterFirst(Node node) {
        // node 与 first.next
        node.next = first.next;
        first.next.prev = node;
        //  first 与 node;
        first.next = node;
        node.prev = first;
    }
    // 从双向链表中删除node节点
    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private  static  class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }



        public Node() {
        }
    }

    public static void main(String[] args) {
//        输入
//                ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//        输出
//                [null, null, null, 1, null, -1, null, -1, 3, 4]
//
//        解释
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        Asserts.test(lRUCache.get(1) ==1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        Asserts.test(lRUCache.get(2) == -1);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        Asserts.test(lRUCache.get(1) == -1);    // 返回 -1 (未找到)
        Asserts.test(lRUCache.get(3) == 3);    // 返回 3
        Asserts.test(lRUCache.get(4) == 4);    // 返回 4

    }
}


