package com.study.jsp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		List<ActorVO> list1 = new ArrayList<ActorVO>();
		ActorVO a3 = new ActorVO();
		a3.name = "류근환";
		a3.age = 28;
		a3.setAddr("대전광역시");
		a3.setJob("액션배우");
		
		ActorVO a4 = new ActorVO();
		a4.name = "손석구";
		a4.age = 37;
		a4.setAddr("대전광역시");
		a4.setJob("범죄도시2,나의 해방일지");
		
		list1.add(a3);
		list1.add(a4);
		map.addAttribute("list1", list1);
		
		
				
		return "index";// jsp파일명 리턴
	}
	
	
	@GetMapping("/board")
	public String loadBoardPage(ModelMap map, HttpSession httpSession) {
		
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
		data.put("size", 3);
		
		map.addAttribute("data", data);
		
		
		// 모든 메소드에 Session을 확인하고 싶을 때는 데이터 요청을 받기 전 Interceptor에서 미리 받아서 확인한다.
		// "/login"에서 SET한 Session데이터 가져오기
		String userId = (String)httpSession.getAttribute("userId");
		String userPassword = (String)httpSession.getAttribute("userPassword");
		
		System.out.println("Session에서 가져온 데이터 "+userId);
		
		// 해석 : userId가 null이라는것은 login을 하지 않았다는 의미.
		// redirect(재요청, 다시 돌아가라)
		if(userId == null) { 
			// if가 실행되면 "/login"으로 return
			return "redirect:/login";
		}
		map.addAttribute("userNo", 255);
		map.addAttribute("userId", userId);
		
		return "board";
	}
	
	//  / : ROOT경로 
	// ex) /board/boardId/12
	@GetMapping("/")
	public String loadMainPage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loadLoginPage() {
		return "login";
	}
	
	
	// 로그인
	@PostMapping("/login")
	// 메소드에 @ResponseBody를 입력하면 return을 json으로 요청하겠다는 의미.
	// @RestController가 아닌 @Controller일 경우 return은 페이지 이름으로 해야함.
	// 페이지 이름이 아니라 json으로 return하고 싶을 경우 @ResponseBody 사용
	// 단, controller가 @RestController가 아닐경우!
	// 요점 : controller가 @Controller일 경우 json으로 return할 때는 메소드에 @ResponseBody를 사용
	public @ResponseBody boolean callLogin(@RequestBody Map<String, Object> data, HttpSession httpSession) {
		String userId = (String) data.get("userId");
		String userPassword = (String) data.get("userPassword");
		
		System.out.println(userId);
		System.out.println(userPassword);
		
		// Session에 데이터 SET(로그인할 경우 세션에 데이터 SET)
		httpSession.setAttribute("userId", userId);
		httpSession.setAttribute("userPassword", userPassword);
		
		return true;
	}
	
	
	// 로그아웃
	@GetMapping("/logout")
	public String goLoginpage(HttpSession httpSession) {
		// Session을 지움.
		httpSession.removeAttribute("userId");
		httpSession.removeAttribute("userPassword");
		
		return "login";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
