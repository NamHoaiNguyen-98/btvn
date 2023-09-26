

function addNewStudent() {
    let name = $('#name').val();
    let male = $('#male').prop("checked");
    let female = $('#female').prop("checked");
    var sex
    let idAddress = $('#address').val();
    let idStatus = $('#status').val();
    if(male) {
        sex = "Male"
    } else {
        sex = "Female"
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
                ' <th>Subject</td>\n' +
                ' <th colspan="2">Option</td>\n' +
                ' </tr>';
            for(let i=0; i<data.length; i++) {
                content += `<tr>
               <td>${data[i].name}</td>
               <td>${data[i].sex}</td>
               <td>${data[i].address.name}</td>`+
                    `<td>${data[i].status.name}</td>`
                content+= "<td>"
                for (let j=0;  j<data[i].subjects.length; j++) {
                    content += `<div>  ${data[i].subjects[j].name} </div>`;
                }
                content+= `</td><td class="btn"><button class="deleteStudent" onclick="deleteStudent(${data[i].idStudent})">Delete</button></td>` +
                    `<td class="btn"><button class="updateStudent" onclick="findById(${data[i].idStudent})">Update</button></td>
               </tr>`;

            }
            content += "</table>"
            console.log(content)
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
                content += `<option value =${data[i].idStatus} > ${data[i].name} </option>`;
            }
            document.getElementById("status").innerHTML = content;
            document.getElementById("searchStatus").innerHTML = content;
        }
    })
}
function searchByStatus() {
    displayStatus()
    let id = $('#searchStatus').val();
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/students/searchByStatus/${id}`,
        success:
            function (data) {
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
function searchBySubject() {

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
    var sex;
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