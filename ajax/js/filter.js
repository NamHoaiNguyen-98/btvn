function displayAddressFt() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/addresses",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += ` <input type="checkbox" class="address" name="address" value=${data[i].id} > ${data[i].name}`;

            }
            document.getElementById("FTAddress").innerHTML = content;
        }
    })
}

function displayStatusFt() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/status",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += ` <input type="checkbox" class="status" name="status" value =${data[i].idStatus} > ${data[i].name}`;
            }
            document.getElementById("FTStatus").innerHTML = content;
        }
    })
}

function displaySubjectFt() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/subjects",
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += ` <input type="checkbox" class="subject" name="subject" value =${data[i].idSubject} > ${data[i].name}`;
            }
            document.getElementById("FTSubjects").innerHTML = content;
        }
    })
}

function displayFilter() {
    displayAddressFt()
    displayStatusFt()
    displaySubjectFt()

}



function  takeFilter () {

    let selectedStatus = [];
    $.each($('input[name="status"]:checked'), function() {
        var value = $(this).val()
        selectedStatus.push(value)
    });
    let selectedAddress = [];
    $.each($('input[name="address"]:checked'), function() {
        var value = $(this).val()
        selectedAddress.push(value)
    });

    let selectedSex = [];
    $.each($('input[name="sexft"]:checked'), function() {
        var value = $(this).val()
        selectedSex.push(value)
    });

    let selectedSubject = [];
    $.each($('input[name="subject"]:checked'), function() {
        var value = $(this).val()
        selectedSubject.push(value)
    });


    let newFilter = {
        status: selectedStatus,
        subject: selectedSubject,
        sex: selectedSex,
        address: selectedAddress
    }




    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newFilter),
        url: "http://localhost:8080/api/students/filter",
        success: function (data) {
            let content = ' <table id="display-list" class="table table-striped"><tr>\n' +
                ' <th scope="col">ID</th></td>\n' +
                ' <th scope="col">Name</td>\n' +
                ' <th scope="col">Sex</td>\n' +
                ' <th scope="col">Address</td>\n' +
                ' <th scope="col">Status</td>\n' +
                ' <th scope="col">Count Subject</td>\n' +
                ' <th scope="col">Subject</td>\n' +
                ' <th colspan="3"   >Option</td>\n' +
                ' </tr>';
            for (let i = 0; i < data.length; i++) {
                content += `<tr>
               <td scope="row"> ${data[i].idStudent}</td>
               <td scope="row">${data[i].name}</td>
               <td scope="row">${data[i].sex}</td>
               <td scope="row"> ${data[i].address.name}</td>` +
                    `<td>${data[i].status.name}</td>`+
                    `<td>${data[i].subjects.length}</td>`
                    +"<td scope=\"row\">"
                for (let j = 0; j < data[i].subjects.length; j++) {
                    content += `<div>  ${data[i].subjects[j].name} </div>`;
                }
                content += `<td  ><button class="btn btn-danger" class="deleteStudent" onclick="deleteStudent(${data[i].idStudent})">Delete</button></td>` +
                    `<td  class="btn"><button class="btn btn-warning" class="updateStudent" onclick="findById(${data[i].idStudent})">Update</button></td>
               </tr>`;

            }
            content += "</table>"
            document.getElementById('studentList').innerHTML = content;
            document.getElementById("filter").style.display = "none";
        }

    });
    event.preventDefault();
}
function getStudent(student) {
    return `<tr>
               <td>${student.name}</td>
               <td>${student.sex}</td>
               <td>${student.address.name}</td>
               <td>${student.status.name}</td>
               </tr>`;
}
function displayFt () {
    let content = '' ;
    content += ` <form >
        <label for="">Status: </label>
        <label id="FTStatus">
         
        </label>
        <br>
            <label for="">Subjects: </label>
            <label id="FTSubjects">
            
            </label>
            <br>
            <label for="">Address</label>
                <label id="FTAddress">Address: 
                </label>
                <br>
                <label for="">Sex: </label>
                    <label id="FTSex">
                        <input type="checkbox" className="sex" name="sexft" value="Nam"> Nam
                            <input type="checkbox" className="sex"  name="sexft" value="Nữ"> Nữ
                    </label>
                    <br>
                        <button id="getDataButton"  onclick="takeFilter()">Lấy dữ liệu</button>
        <!--            onclick="filter()"-->


    </form> `
    displayFilter()
    document.getElementById("filter").innerHTML = content ;
    document.getElementById("filter").style.display = "block";

}

