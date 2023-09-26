4
function addNewStudent() {
    let name = $('#name').val();
    let male = $('#male').val();
    let female = $('#female').val();
    let sex;
    let idAddress = $('#address').val();
    let idStatus = $('#status').val();
    if(male.checked) {
        sex = male;
    } else {
        sex = female
    }
    let newStudent = {
        name : name,
        sex : sex,
        address : {
            id : idAddress
        },
        status : {
            idStatus: idStatus
        }
    };

    $.ajax( {
        headers: {
            'Accept' : 'application/json',
            'Content-Type': 'application/json'
        },
        type : "POST",
        data : JSON.stringify(newStudent),
        url : "http://localhost:8080/api/students",
        success: display

    });
}

function display() {
    displayAddress();
    displayStatus();
    $.ajax({
        type: "GET",
        url:"http://localhost:8080/api/students",
        success: function (data) {
            let content = ' <table id="display-list" border="1"><tr>\n' +
                ' <th>Name</td>\n' +
                ' <th>Sex</td>\n' +
                ' <th>Address</td>\n' +
                ' <th>Status</td>\n' +
                ' <th colspan="2">Option</td>\n' +
                ' </tr>';
            for(let i=0; i<data.length; i++) {
                content += getStudent(data[i])
            }
            content += "</table>"
            document.getElementById('studentList').innerHTML = content;
        }
    });
}

function getStudent(student) {
    return`<tr>
               <td>${student.name}</td>
               <td>${student.sex}</td>
               <td>${student.address.name}</td>
               <td>${student.status.name}</td>` +
        `<td class="btn"><button class="deleteStudent" onclick="deleteStudent(${student.idStudent})">Delete</button></td>` +
        `<td class="btn"><button class="updateStudent" onclick="findById(${student.idStudent})">Update</button></td>
               </tr>`;
}

function displayStatus() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/status",
        success: function (data) {
            let content = "";
            for (let i=0;  i<data.length; i++) {
                content += `<option value =${data[i].idStatus}> ${data[i].name} </option>`;
            }
            document.getElementById("status").innerHTML = content;
        }
    })
}
function displayAddress() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/addresses",
        success: function (data) {
            let content = "";
            for (let i=0;  i<data.length; i++) {
                content += `<option value =${data[i].id}> ${data[i].name} </option>`;
            }
            document.getElementById("address").innerHTML = content;
        }
    })
}
function deleteStudent(idStudent) {
    $.ajax({
        type: "DELETE",
        //tên API
        url: `http://localhost:8080/api/students/${idStudent}`,
        //xử lý khi thành công
        success: display
    });
}
function findById(idStudent) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/students/${idStudent}`,
        success : function (student) {
            $("#name").val(`${student.name}`);
            $("#sex").val(`${student.sex}`);
            $("#address").val(`${student.address}`);
            $("#status").val(`${student.status}`);
            $("#idStudent").val(`${student.idStudent}`);
        }
    })
}
function updateStudent() {
    let idStudent = $('#idStudent').val();
    let name = $('#name').val();
    let male = $('#male').val();
    let female = $('#female').val();
    let sex;
    let idAddress = $('#address').val();
    let idStatus = $('#status').val();
    if(male.checked) {
        sex = male
    } else {
        sex = female
    }
    let updateStudent = {
        idStudent : idStudent,
        name : name,
        sex : sex,
        address : {
            id: idAddress
        },
        status : {
            idStatus: idStatus
        }
    };

    $.ajax( {
        headers: {
            'Accept' : 'application/json',
            'Content-Type': 'application/json'
        },
        type : "PUT",
        data : JSON.stringify(updateStudent),
        url : `http://localhost:8080/api/students/${idStudent}`,
        success: display

    });
    event.preventDefault();
}
function searchByName() {
    let name = $('#name1').val();
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/students/searchByName/${name}`,
        success: function (data) {
            let content = ' <table id="display-list" border="1"><tr>\n' +
                ' <th>Name</td>\n' +
                ' <th>Sex</td>\n' +
                ' <th>Address</td>\n' +
                ' <th>Status</td>\n' +
                ' <th colspan="2">Option</td>\n' +
                ' </tr>';
            for(let i=0; i<data.length; i++) {
                content += getStudent(data[i])
            }
            content += "</table>"
            document.getElementById('studentList').innerHTML = content;
        }
    });
    event.preventDefault();
}