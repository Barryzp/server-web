package xyz.barry.leetcode;

// 前缀树
// 不需要存具体的值，因为都是小写字母，每个结点有26个指针，也就对应了26个字母，我们不需要知道具体指的是谁，只需要知道索引具体指向的是哪一个就行
// 另外，我们不知道当前对应的字母是否是单词的结尾，所以还需要加一个flag字段来区分
public class Hot8_208 {

    public static class Trie {
        public Trie[] children;
        public boolean isEnd;

        public Trie() {
            // 只是26个引用变量，并不是实例化了26个对象
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            int len = word.length();
            Trie tempNode = this;
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (tempNode.children[idx] == null) {
                    tempNode.children[idx] = new Trie();
                    tempNode = tempNode.children[idx];
                }else {
                    tempNode = tempNode.children[idx];
                }

                if (!tempNode.isEnd) tempNode.isEnd = i == len - 1;
            }
        }

        public boolean search(String word) {
            int len = word.length();
            Trie tempNode = this;
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (tempNode.children[idx] == null) {
                    // 如果不包含对应的字母
                    flag = false;
                    break;
                }

                tempNode = tempNode.children[idx];
            }

            // 如果前缀树包含所有字母，但是还得判断最后那一个字符是不是最终的一个
            if (flag) flag = tempNode.isEnd;

            return flag;
        }

        public boolean startsWith(String prefix) {
            int len = prefix.length();
            Trie tempNode = this;
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                char ch = prefix.charAt(i);
                int idx = ch - 'a';
                if (tempNode.children[idx] == null) {
                    // 如果不包含对应的字母
                    flag = false;
                    break;
                }
                tempNode = tempNode.children[idx];
            }

            return flag;
        }

    }


}
