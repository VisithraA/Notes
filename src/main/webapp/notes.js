document.addEventListener("DOMContentLoaded", function() {
    // Initialize the state of the buttons when the page loads
    updateButtonStates();

    // Add a keyup event listener to the contenteditable element
    document.querySelector('.content').addEventListener('keyup', function() {
        updateButtonStates();
    });

    // AJAX call to load notes
    $.ajax({
        url: "getNotes",
        method: "GET",
        dataType: "json", // Specify the data type expected from the server
        success: function(data) {
            console.log(data); // Debugging line
            var notesList = data;
            var savedNotesDiv = $('#savednotes');
            savedNotesDiv.empty();
            if (notesList.length > 0) {
                var ul = $('<ul></ul>');
                notesList.forEach(function(note) {
                    var li = $('<li class="noteBox"></li>');
                    var h4 = $('<h4></h4>').text(note.title);
                    var p = $('<p></p>').text(note.content);
                    li.append(h4).append(p);
                    ul.append(li);
                });
                savedNotesDiv.append(ul);
            }
        },
        error: function(xhr, status, error) {
            console.error("AJAX Error: " + status + ": " + error); // Debugging line
        }
    });
});

function formatText(command) {
    document.execCommand(command, false, null);
    updateButtonStates();
}

function updateButtonStates() {
    ['bold', 'italic', 'underline', 'strikethrough'].forEach(command => {
        var button = document.getElementById(command);
        var isActive = document.queryCommandState(command);
        if (isActive) {
            button.classList.add('active');
        } else {
            button.classList.remove('active');
        }
    });
}

function toggleFormat(command) {
    formatText(command);
}

function syncContent() {
    var contentDiv = document.querySelector('.content');
    var hiddenTextarea = document.querySelector('.hidden-content');
    hiddenTextarea.value = contentDiv.innerHTML;
}

function validateForm() {
    syncContent();
    var title = document.querySelector('.title').value;
    if (title.trim() === "" || title === null) {
        alert("Title is required.");
        return false;
    }
    return true;
}

function focusTitle() {
    document.querySelector('.title').focus();
}
