let index= {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#btn-delete").on("click", () => {
            this.deleteByNo();
        });
        $("#btn-reply-save").on("click", () => {
            this.replySave();
        });
    },
    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
            tag: $("#tag").val()
        };
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("글쓰기가 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function () {
        let data = {
            no: $("#no").val(),
            title: $("#title").val(),
            content: $("#content").val(),
            tag: $("#tag").val()
        };
        $.ajax({
            type: "PUT",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("글수정이 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    deleteByNo: function () {
        let no = $("#no").text();
        $.ajax({
            type: "DELETE",
            url: "/api/board/" + no,
            dataType: "json"
        }).done(function (resp) {
            alert("글삭제가 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },
    replySave: function () {
        let data = {
            AskNo: $("#AskNo").val(),
            reply: $("#reply").val()
        };
        $.ajax({
            type: "POST",
            url: `/api/board/${data.AskNo}/reply`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("댓글작성이 완료되었습니다.");
            location.href = `/questions/${data.askNo}`;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}

    let markdownText = document.getElementById("wmd-input").value;

    function marked(markdownText) {
    return "";
}

    document.getElementById("wmd-input").innerHTML = marked(markdownText);
    document.getElementById("bold-button").addEventListener("click", function(){
    const editor = document.getElementById("wmd-input");
    const selectedText = editor.value.substring(editor.selectionStart, editor.selectionEnd);
    const newText = "**bold" + selectedText + "**";
    editor.value = editor.value.substring(0, editor.selectionStart) + newText + editor.value.substring(editor.selectionEnd);
});
    document.getElementById("italic-button").addEventListener("click", function(){
    const editor = document.getElementById("wmd-input");
    const selectedText = editor.value.substring(editor.selectionStart, editor.selectionEnd);
    const newText = "*italic" + selectedText + "*";
    editor.value = editor.value.substring(0, editor.selectionStart) + newText + editor.value.substring(editor.selectionEnd);
});
    document.getElementById("link-button").addEventListener("click", function(){
    let link = prompt("Enter the link here: ", "http://");
    document.execCommand("createLink", false, link);
});
    document.getElementById("quote-button").addEventListener("click", function(){
    const editor = document.getElementById("wmd-input");
    const selectedText = editor.value.substring(editor.selectionStart, editor.selectionEnd);
    const newText = ">blockquotes" + selectedText;
    editor.value = editor.value.substring(0, editor.selectionStart) + newText + editor.value.substring(editor.selectionEnd);
});
    document.getElementById("image-button").addEventListener("click", function() {
    const editor = document.getElementById("wmd-input");
    const imul = prompt("Enter the image URL: ");
    const newText = "![image](" + imul + ")";
    editor.value = editor.value.substring(0, editor.selectionStart) + newText + editor.value.substring(editor.selectionEnd);
});
    document.getElementById("code-button").addEventListener("click", function() {
    const editor = document.getElementById("wmd-input");
    const selectedText = editor.value.substring(editor.selectionStart, editor.selectionEnd);
    const newText = "` <code> " + selectedText + "`";
    editor.value = editor.value.substring(0, editor.selectionStart) + newText + editor.value.substring(editor.selectionEnd);
});

    document.getElementById("reply-submit").addEventListener("submit", function(event) {
    event.preventDefault();
    let markdownText = document.getElementById("wmd-input").value;

    function marked(markdownText) {
    return "";
}

    document.getElementById("wmd-input").innerHTML = marked(markdownText);
    // form submit
    this.submit();
});








