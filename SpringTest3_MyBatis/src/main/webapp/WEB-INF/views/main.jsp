<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
Kakao.API.request({
	  url: 'https://kapi.kakao.com/v2/api/talk/memo/default/send',
	  data: {
		  template_object={
		        object_type: 'text',
		        text: '텍스트 영역입니다. 최대 200자 표시 가능합니다.',
		        link: {
		            "web_url": 'https://developers.kakao.com',
		            "mobile_web_url": 'https://developers.kakao.com'
		        },
		        button_title: "바로 확인"
		    }
	  });
</script>

<body>
	<header>
		<jsp:include page="inc/top.jsp"/>
<%-- 		<jsp:include page="<%=request.getContextPath() %>/inc/top.jsp"></jsp:include> --%>
<%-- 		<%@ include file="../inc/top.jsp" %> --%>
	</header>
	<article>
		<h1>메인 페이지</h1>
		<h3>
				<a href="${pageContext.request.contextPath }/write.bo">글쓰기</a>
				<a href="${pageContext.request.contextPath }/list.bo">글목록</a>
				<a href="send-message?recipientId='cnsdn1246@naver.com'&message=메시지보내기">메세지 보내기</a>
		</h3>
	</article>
</body>
</html>