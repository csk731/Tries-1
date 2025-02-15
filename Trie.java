// Time Complexity:
// Insert : O(n) where n is the length of the word
// Search : O(n) where n is the length of the word
// StartsWith : O(n) where n is the length of the word

// Space Complexity :
// Trie : O(N * L) where N is the number of words and L is the average length of the words
// Insert : O(n) where n is the length of the word
// Search : O(1)
// StartsWith : O(1)

public class Trie {

    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
    }
    
    public void insert(String word) {
        int len = word.length();
        Trie pos = this;
        for(int i=0;i<len;i++){
            int asciiVal = word.charAt(i)-97;
            if(pos.children[asciiVal]==null){
                pos.children[asciiVal] = new Trie();
            }
            pos = pos.children[asciiVal];
        }
        pos.isEnd = true;
    }
    
    public boolean search(String word) {
        int len = word.length();
        Trie pos = this;
        for(int i=0;i<len;i++){
            int asciiVal = word.charAt(i)-97;
            if(pos.children[asciiVal]==null){
                return false;
            }
            pos = pos.children[asciiVal];
        }
        return pos.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Trie pos = this;
        for(int i=0;i<len;i++){
            int asciiVal = prefix.charAt(i)-97;
            if(pos.children[asciiVal]==null){
                return false;
            }
            pos = pos.children[asciiVal];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
