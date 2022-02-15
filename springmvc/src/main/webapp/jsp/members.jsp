<%@ page import="seungsoo.springmvc.domain.MemberRepository" %>
<%@ page import="seungsoo.springmvc.domain.Member" %>
<%@ page import="java.util.List" %>

<!-- jsp 파일임을 명시 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> memberList = memberRepository.findAll();

%>

<html>
<head>
 <meta charset="UTF-8">
 <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
 <thead>
 <th>id</th>
 <th>username</th>
 <th>age</th>
 </thead>
 <tbody>
<%
    for (Member member : memberList) {
        out.write(" <tr>\n");
        out.write(" <td>" + member.getId() + "</td>\n");
        out.write(" <td>" + member.getUsername() + "</td>\n");
        out.write(" <td>" + member.getAge() + "</td>\n");
        out.write(" </tr>\n");
    }
%>
 </tbody>
</table>
</body>
</html>