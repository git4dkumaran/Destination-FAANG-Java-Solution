package leet.indexhash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {
			char[] sChars = s.toCharArray();
			Arrays.sort(sChars);
			String sorted = new String(sChars);
			List<String> groupList = map.get(sorted);
			if (groupList == null) {
				map.put(sorted, new ArrayList<String>());
			}
			groupList.add(s);
		}
		return new ArrayList(map.values());
	}

	public static void main(String[] args) {

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagram ga = new GroupAnagram();
		ga.groupAnagrams(strs);
	}

}
