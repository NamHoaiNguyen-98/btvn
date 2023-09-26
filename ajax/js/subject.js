function saveSubject() {
    //lấy dữ liệu từ form html
    let name = $("#name").val();
    let capacity = $('#capacity').val();

    let newSubject = {
        name: name,
        capacity: capacity
    };
    // gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSubject),
        //tên API
        url: "http://localhost:8080/api/subjects",
        //xử lý khi thành công
        success: successHandler
    });


    //chặn sự kiện mặc định của thẻ
    event.preventDefault();

}

function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/subjects",
        //xử lý khi thành công
        success: function (data) {
            // hiển thị danh sách ở đây
            let content = ' <table id="display-list" border="1"><tr>\n' +
                ' <th>Name</td>\n' +
                ' <th>Capacity</td>\n' +
                ' <th>Action</td>\n' +
                ' </tr>';
            for (let i = 0; i < data.length; i++) {
                // content += getSmartphone(data[i]);
                content += getSubject(data[i]);
            }
            content += "</table>"
            document.getElementById('subjectList').innerHTML = content;
            document.getElementById("subjectList").style.display = "block"
            document.getElementById("add-subject").style.display = "none";
            document.getElementById("update-form").style.display = "none";
        }
    });
}

function displayFormCreate() {
    document.getElementById("add-subject").style.display = "block";
    $('#subjectList').hide();

}

function getSubject(subject) {
    return `<tr><td >${subject.name}</td>
            <td >${subject.capacity}</td>` +
        `<td class="btn"><button class="updateSubject" onclick="updateSubject(${subject.idSubject})">Update</button></td></tr>`;
}


function updateSubject(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/subjects/${id}`,
        success: function (data) {
            $("#name1").val(data.name);
            $("#capacity1").val(data.capacity);
            $("#subjectList").hide();
            $("#submit").val(`${id}`);
            $("#add-subject").hide();
            // $("#update-form").style.display="block";
            document.getElementById("update-form").style.display = "block";
        }
    })
}

function edit(id) {
    let name = $('#name1').val();
    let capacity = $('#capacity1').val();

    let subject = {
        idCapacity: id,
        name: name,
        capacity: capacity
    };
    // gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(subject),
        //tên API
        url: `http://localhost:8080/api/subjects/${id}`,
        //xử lý khi thành công
        success: successHandler
    });
    alert("Update done!")
    event.preventDefault();
}

function formRegister() {
    document.getElementById("form-register").style.display='block'
    document.getElementById("subjectList").style.display='none'
    selectSubject()
    selectIdStudent()
}

function selectSubject() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/subjects",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                    content += `<input type="checkbox" value =${data[i].idSubject}> ${data[i].name}`;
            }
            document.getElementById("subject").innerHTML = content;
        }
    })
}

function selectIdStudent() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/students",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += `<input  type="radio" value =${data[i].idStudent}> ${data[i].name}`;
            }
            document.getElementById("idStudent").innerHTML = content;
        }
    })
}