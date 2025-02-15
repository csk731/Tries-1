// TC: O(N * L)
// SC: O(N * L)
// where N is the number of words and L is the average length of the words

public class LC720 {

    String ans = "";

    class Trie {
        Trie[] childs;
        boolean isEnd;
        public Trie(){
            childs = new Trie[26];
        }
    }

    private void addToTrie(Trie trie, String word){
        int len = word.length();
        Trie ptr = trie;
        for(int i=0;i<len;i++){
            int idx = word.charAt(i) - 'a';
            if(ptr.childs[idx] == null){
                ptr.childs[idx] = new Trie();
            }
            ptr = ptr.childs[idx];
        }
        ptr.isEnd = true;
    }

    private void recurse(Trie trie, StringBuffer sb){
        // BC
        if(trie.isEnd) {
            if(sb.length() >= ans.length()) {
                ans = sb.toString();
            }
        }
        // Logic
        for(int i=25;i>=0;i--){
            if(trie.childs[i]==null) continue;
            if(!trie.childs[i].isEnd) continue;
            sb.append((char)(i+97));
            recurse(trie.childs[i], sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String longestWord(String[] words) {
        int n = words.length;
        Trie trie = new Trie();
        for(int i=0;i<n;i++){
            addToTrie(trie, words[i]);
        }
        recurse(trie, new StringBuffer());
        return ans;
    }
}