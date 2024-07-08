<%@page import="com.visithraa23.notes.dto.Note"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Notes</title>
<link href="notes.css" rel="stylesheet" >
<script src="https://kit.fontawesome.com/3800e5bff1.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="notes.js"></script>
</head>
<body>
    <header>Notes</header>
    
    <div class="container">
        <div class="sidebar">
            <div class="searchbox">
                <input type="text" class="searchbar" placeholder="search" >
            </div>
            
             <span class="addnote" onclick="focusTitle()">+Add Note</span>
            
            <div class="savednotes" id="savednotes"></div>   
        </div>
        
        <div class="mainbar">
            <div class="notetext" >
                <form action="saveNote" method="post" onsubmit="return validateForm()">
                    <input type="text" class="title" name="title" placeholder="Enter Title" required>
                    <div contenteditable="true" class="content"  ></div>
                    <textarea name="content" class="hidden-content"  placeholder="Enter your Content here.." style="display:none;"></textarea>
                    <input type="submit" value="SAVE">
                </form>
            </div>
            
            <% String saveMessage = (String) session.getAttribute("saveMessage"); %>
            <% if (saveMessage != null) { %>
                <script>
                    alert("<%= saveMessage %>");
                </script>
                <% session.removeAttribute("saveMessage"); %>
            <% } %>
    		
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
                    <button onclick="toggleFormat('bold')" id="bold"><b>B</b></button>
                    <button onclick="toggleFormat('italic')" id="italic"><i>I</i></button>
                    <button onclick="toggleFormat('underline')" id="underline"><u>U</u></button>
                    <button onclick="toggleFormat('strikethrough')" id="strikethrough"><del>S</del></button>
                    <button id="delete"><i class="fa-solid fa-trash"></i></button>
                </div>
            </div>
        </div>
        
    </div>
</body>
</html>
