package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
	public static void main(String[] args) {
for (String string : args) {
	System.out.println(string);
}
		int start = 30;

		int stop = 100;

		int num = 7;

		if (!(stop - start >= num * 2)) {
			String x = "无法正常分组";
			System.out.println(x);
			System.exit(1);
			
		}
		Map<String, Object> name = new HashMap<String, Object>();
		
		int c = (stop - start) / num;

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= num; i++) {

			Map<String, Object> map = new HashMap<String, Object>();
			if (i == 1) {
				map.put("start", start);
			} else {
				map.put("start", (i - 1) * c + start + 1);
			}

			if (i == num) {
				map.put("stop", stop);
			} else {
				map.put("stop", i * c + start);
			}

			list.add(map);
		}

		System.out.println(list);

	}
}
