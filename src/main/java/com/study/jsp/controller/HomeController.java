package com.study.jsp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.jsp.vo.ActorVO;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String loadHomePage(ModelMap map) {
		
		// 왼쪽 : key , 오른쪽 : value
		map.addAttribute("name" , "손흥민");// name은 key, 손흥민은 value
		map.addAttribute("backNumber" , 7);// backNumber은 key, 7은 value
		map.addAttribute("size", 150);
		
		List<String> list = new ArrayList<String>();
		list.add("씨야");
		list.add("쏠");
		list.add("윤은혜");
		map.addAttribute("wsgList", list);
		
		
		List<ActorVO> actorList = new ArrayList<ActorVO>();
		ActorVO a1 = new ActorVO();
		a1.name = "이병헌";
		a1.age = 51;
		
		ActorVO a2 = new ActorVO();
		a2.name = "차승원";
		a2.age = 52;
		
		actorList.add(a1);
		actorList.add(a2);
		
		map.addAttribute("actorList", actorList);
		
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("no", 300);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("no", 100);
		
		mapList.add(map1);
		mapList.add(map2);
		
		map.addAttribute("mapList", mapList);
		
				
		return "index";// jsp파일명 리턴
	}
	
	
	@GetMapping("/board")
	public String loadBoardPage(ModelMap map) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Company", "Alfreds Futterkiste");
		map1.put("Contact", "Maria Anders");
		map1.put("Country", "Germany");
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("Company", "Centro comercial Moctezuma");
		map2.put("Contact", "Francisco Chang");
		map2.put("Country", "Mexico");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("Company", "Ernst Handel");
		map3.put("Contact", "Roland Mendel");
		map3.put("Country", "Austria");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		data.put("list", list);
		System.out.println(map1.get("Company"));
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		map.addAttribute("data", data);
		
		return "board";
	}
	
}
