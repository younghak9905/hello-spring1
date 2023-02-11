
    $(document).ready(function() {
    $(".top").append(`
    <nav class="navbar navbar-expand-lg bg-light" style="background-color: #20c997">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">K.Knock</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/members/new">회원가입</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/members">회원목록</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/questions/questionList">질문목록</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/questions/new">질문 작성</a>
                    </li>
                </ul>
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
  `);
});
