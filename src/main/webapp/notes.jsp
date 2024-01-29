<%@page import="com.visithraa23.notes.dto.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="notes.css" rel="stylesheet" >
<script src="https://kit.fontawesome.com/28c9b452c3.js" crossorigin="anonymous"></script>
</head>
<body>
	<header>Notes</header>
	
	<div class="container">
		<div class="sidebar">
			<div class="searchbox">
				<input type="text" class="searchbar" placeholder="search" >
			</div>
			<div class="savednotes">
				<%List<Note> notesList=(List<Note>)request.getAttribute("NotesList");%>
				<%if(notesList!=null&&!notesList.isEmpty()){ %>
					<%for(Note note:notesList){ %>
					<div class="savednote">
						<h4><%= note.getTitle()%></h4>
						<p><%=note.getContent() %></p>
					</div>
					<%} %>
				<%}else{  %>
					<span class="addnote">+Add Note</span>
				<%} %>
			</div>		
		</div>
		
		<div class="mainbar">
				<div class="notetext" method="get">
					<input type="text" class="title" placeholder="Enter Title">
					<pre class="content" contenteditable="true"></pre>
				</div>
			
			
			<div class="rightsidebar">
                <div><button class="share">Share <i class="fa-solid fa-share-nodes"></i></button></div>
				<div class="infobar">
                    <h3>Info</h3>
                    <div class="details">
                        <div>File Name:<span id="filename"></span></div>
                        <div>Word Count:<span id="wordcount"></span></div>
                        <div>Last Edited:<span id="lastedited"></span></div>
                    </div>
                </div>
                <div class="format">
					<button id="bold"><b>B</b></button>
					<button id="italic"><i>I</i></button>
					<button id="underline"><u>U</u></button>
					<button id="strikethrough"><del>S</del></button>
					<button id="save"><i class="fa-solid fa-floppy-disk"></i></button>
					<button id="delete"><i class="fa-solid fa-trash"></i></button>
				</div>
			</div>
		</div>
		
	</div>
	
</body>
</html>