<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="layout/basic">
<th:block layout:fragment="title">
    <title>상세 페이지</title>
</th:block>
<th:block layout:fragment="content">
    <div class="container">
        <div>
            <h1 th:text="${asks.title}"></h1>
            <p th:text="${asks.contents}"></p>
            <p th:text="${asks.tags}"></p>
        </div>
    </div>

</th:block>
<form th:action="@{/templates/11/members/members/questions/comments/${asks.no}}" method="post">
    <div id="comment-write">
        <input type="text"  id="reply" name ="reply" placeholder="내용"><br>
        <input type="hidden" name="askNo" th:value="${asks.no}">
        <button type="submit">댓글 등록</button>
    </div>
</form>
<form>
    <input type="hidden" id="AskNo" name="askNo" th:value="${asks.no}">
    <div class = "card">
        <div class = "card-body"><textarea id ="reply-content" class="form-control" rows="1"></textarea></div>
        <div class = "card-footer">
            <button id="btn-reply-save" type="submit" class="btn btn-primary">reply register</button>
        </div>
    </div>
</form>
<br />
<div class="card">
    <div class="card-header">comment list</div>
    <ul calss = "list-group">
        <li class = "list-group-item d-flex">





            <tr th:each="comment: ${comment}">
                <div th:text="${comment.commentNo}">1</div>
                <div  th:text="${comment.reply}">reply</div>
                <div class="d-flex">
                    <div> writer : gongchamcham &nbsp;</div>
                </div>

            </tr>

            <div class = "card-footer">
                <button type="button" class="btn btn-primary">modify</button>
                <button type="button" class="btn btn-primary">delete</button>
            </div>
        </li>
    </ul>

</div>
</div>
</th:block>



</html>