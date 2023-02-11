$(document).ready(function() {
    $('#summernote').summernote({
        height: 300,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'italic', 'underline', 'clear']],
            ['fontname', ['fontname']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
            ['codeBlock', ['codeblock']],
        ],
        buttons: {
            codeblock: function() {
                var ui = $.summernote.ui;
                var button = ui.button({
                    contents: '<i class="fa fa-code"/> Codeblock',
                    tooltip: 'Insert Codeblock',
                    click: function() {
                        var pre = $('<pre><code></code></pre>');
                        $('#summernote').summernote('insertNode', pre[0]);
                    }
                });
                return button.render();
            }
        }
    });
    $('.summernote').summernote({
        height: 300,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'italic', 'underline', 'clear']],
            ['fontname', ['fontname']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
            ['codeBlock', ['codeblock']],
        ],
        buttons: {
            codeblock: function() {
                var ui = $.summernote.ui;
                var button = ui.button({
                    contents: '<i class="fa fa-code"/> Codeblock',
                    tooltip: 'Insert Codeblock',
                    click: function() {
                        var pre = $('<pre><code></code></pre>');
                        $('.summernote').summernote('insertNode', pre[0]);
                    }
                });
                return button.render();
            }
        }
    });




});