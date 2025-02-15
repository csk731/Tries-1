// TC: O(N⋅L + M + W⋅K)
// SC: O(N⋅L + M)
// where N is the number of words in the dictionary, L is the maximum length of a word, M is the length of the sentence, W is the number of words in the sentence, and K is the maximum length of a word in the sentence.

import java.util.List;

public class LC648 {
    class Trie{
        Trie childs[];
        boolean isEnd;
        public Trie(){
            childs = new Trie[26];
        }
    }
    private void insert(Trie root, String word){
        for(int i=0;i<word.length();i++){
            int val = word.charAt(i)-97;
            if(root.childs[val]==null){
                root.childs[val] = new Trie();
            }
            root = root.childs[val];
        }
        root.isEnd = true;
    }

    private String getRoot(Trie root, String word){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<word.length();i++){
            int val = word.charAt(i)-97;
            if(root.childs[val]==null || root.isEnd) break;
            sb.append(word.charAt(i));
            root = root.childs[val];
        }
        if(root.isEnd) return sb.toString();
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if(sentence==null || sentence.length()==0) return "";
        int dictLen = dictionary.size();
        Trie root = new Trie();
        for(int i=0;i<dictLen;i++){
            String str = dictionary.get(i);
            insert(root, str);
        }

        String[] words = sentence.split(" ");
        int wordsLen = words.length;
        StringBuffer ans = new StringBuffer();
        for(int i=0;i<wordsLen;i++){
            String str = words[i];
            String r = getRoot(root, str);
            ans.append(r);
            if(i<wordsLen-1) ans.append(" ");
        }
        return ans.toString();
    }
}