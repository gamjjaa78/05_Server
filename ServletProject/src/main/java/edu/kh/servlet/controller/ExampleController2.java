package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Servlet 관련 코드 작성위해서는 HttpServlet 클래스 상속받아야됨
//상속받았다고해서 바로 Servlet 등록되는 건 아님!
//방법1: web.xml 작성
//방법2: @WebServlet() 어노테이션 사용하기

//어노테이션:컴파일러가 읽는 주석
//@WebServlet 어노테이션
//->해당 클래스를 Servlet으로 등록하고 () 안에 작성된 주소와 매핑(연결)하라고 지시
//서버 실행시 자동으로 web.xml <servlet><servlet-mapping>을 작성하는 효과


@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet {
	
	//Post 요청처리메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청시 제출받은 데이터 얻어오기
		String userId=req.getParameter("inputId");
		String userPw=req.getParameter("inputPw");
		String userName=req.getParameter("inputName");
		String Intro=req.getParameter("intro");
		
		System.out.println(userId);
		System.out.println(userPw);
		System.out.println(userName);
		System.out.println(Intro);
	
		//응답화면 만들기
		//Java(Servlet)에서 응답화면 작성은 번거롭고 힘들어
		//JSP가 대신 화면을 만들어라!
		//Servlet이 JSP에게 요청/응답 위임
		//JSP가 대신 응답화면을 만들어주기 위해서는 
		//Servlet이 어떤 요청을 받았는지 알아야해(req, resp 넘김)
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result.jsp");
													//알바생만듦(주방장주소)
		//webapp(http://localhost:8080/에서 가장 끝의 /가 웹앱이며 루트폴더) 폴더 기준(외부접근방지하여 보호)
		
		//webapp 폴더는 웹애플리케이션의 루트(root) 디렉토리
		//브라우저통해 접근가능한 정,동적 리소스들이 위치하는 폴더
		//webapp 폴더가 컨텍스트 루트(/)로 설정되기 때문에
		//해당 경로가 webapp 내부 경로로 해석되는 것
		//WEB-INF 폴더에 있는 파일들은 클라가 url로 직접 접근불가한 영역, 서블릿통해서만 접근가능		
		
		dispatcher.forward(req, resp);
		//RequestDispatcher 객체사용해 현재 요청(req)와 응답(resp)을
		//지정한 JSP페이지(result.jsp)로 전달하는 작업
		//즉, 현재 서블릿(ExampleController2)에서 처리하던 요청을
		//result.jsp로 전달하고 제어권을 그곳으로 넘김(==위임)	
		
	}
}
