import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        System.out.println(new Solution().solution(user_id, banned_id));
    }
}
class Solution {
    private Set<Set<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());
        return result.size();
    }
    
    private void dfs(String[] user_id, String[] banned_id, Set<String> set) {
        if (set.size() == banned_id.length) {
            if (isCandidate(set, banned_id)) result.add(new HashSet<>(set));
            return;
        }
        
        for (String user : user_id) {
            if (!set.contains(user)) {
                set.add(user);
                dfs(user_id, banned_id, set);
                set.remove(user);
            }
        }
    }
    
    private boolean isCandidate(Set<String> set, String[] banned_id) {
        int i = 0;
        for (String user : set) {
            if (!isBanned(user, banned_id[i++])) return false;
        }
        return true;
    }
    
    private boolean isBanned(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*') continue;
            
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}
// class Solution {
//     public int solution(String[] user_id, String[] banned_id) {
//         ArrayList<Ban> candidates = new ArrayList<>();
//         for(String user: user_id) {
//             for(int i=0; i<banned_id.length; i++) {
//                 if(banned_id[i].length() == user.length()) {
//                     int count = banned_id[i].length();
//                     for(int j=0; j<banned_id[i].length(); j++) {
//                         if(banned_id[i].charAt(j) == user.charAt(j)) count--;
//                         else {
//                             if(banned_id[i].charAt(j) == '*') count--;
//                             else break;
//                         }
//                     }
//                     if(count == 0) {
//                         candidates.add(new Ban(i, banned_id[i], user));
//                     }
//                 }
//             }
//         }
//         int[] temp = new int[banned_id.length];
//         for(Ban item: candidates) {
//             if(candidates.contains(item))
//             temp[item.index]++;
//         }
//         return candidates.size();
//     }
// }
// class Ban {
//     int index;
//     String ban, user;
//     public Ban(int index, String ban, String user) {
//         this.index = index;
//         this.ban = ban;
//         this.user = user;
//     }
//     @Override
//     public boolean equals(Object obj) {
//         Ban ban = (Ban) obj;
//         return this.index == ban.index ? true : false;
//     }
// }