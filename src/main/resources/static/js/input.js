


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
    const newText = "``` <code> " + selectedText + "  ```";
    editor.value = editor.value.substring(0, editor.selectionStart) + newText + editor.value.substring(editor.selectionEnd);
});
    //엔터 인식
    document.getElementById("replySubmit").addEventListener("submit", function(event) {
    event.preventDefault();
    let markdownText = document.getElementById("wmd-input").value;

    /*let str = document.getElementById("wmd-input").value;
     console.log("hello");
     str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
     document.getElementById("wmd-input").value = str;
     console.log(str);
*/

    function marked(markdownText) {
    return "";
}

    document.getElementById("wmd-input").innerHTML = marked(markdownText);
    // form submit
    this.submit();

});



