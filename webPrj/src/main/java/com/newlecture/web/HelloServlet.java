package com.newlecture.web;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	
	@Override
	public void service(ServletRequest request,
			ServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		response.setContentType("text/html;charset=utf-8;");
			//캐릭터셋은 응답헤더...??
		
//		response.getOutputStream() //바이너리 경우
		
		PrintWriter out = response.getWriter(); //문자열의 경우
//		PrintStream out = new PrintStream(response.getOutputStream()); //위와 어느정도 같음
		//같은데 두개 차이가있다. writer는 다국어 모드이다.
		//스트림은 유니코드가 아니다. 과거 다국어 어려움 그래서 새로운 프린트객체가 프린트 라이터계열
		
		String c = request.getParameter("c");
		//왜 문자열로?
		//모든 사용자의 request는 문자열로 받기 때문이다.
		
		
		int count = 10; 
		//사용자가 값을 전달하면 바꾸게 끔
		//쿼리로 c로 전달할수있다.
		//이경우 전달안하면 기본값이 필요한데, 
		//이러한 초기 10값이 기본값 세팅이다.
		
		if(c != null)
			count = Integer.parseInt(c);
		
		for(int i = 0 ; i < count ; i++)
			out.println("안녕하다. Servlet");
				//한글로 쳐도 멀티바이트로 정상적으로 온것이다
				//네모로가 아니라 중국어 같은것은 정상적 2byte인데
				//utf읽어야하는데 euc등으로 읽은경우 문제이다.
				//서버 쪽에서 인코딩을 설정할 필요가있다.
				
	
	}
	
	
	
	
}
