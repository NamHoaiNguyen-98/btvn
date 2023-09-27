function displayAddress() {
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

function displayStatus() {
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

function displaySubject() {
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
    displayAddress()
    displayStatus()
    displaySubject()

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
    $.each($('input[name="sex"]:checked'), function() {
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
            let content = ' <table id="display-list" border="1"><tr>\n' +
                ' <th>Name</td>\n' +
                ' <th>Sex</td>\n' +
                ' <th>Address</td>\n' +
                ' <th>Status</td>\n' +
                ' <th>Subject</td>\n' +
                // ' <th colspan="3">Option</td>\n' +
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
                // `</td><td class="btn"><button class="deleteStudent" onclick="formAddSubject(${data[i].idStudent})">+ Subject</button></td>
                //     // <td class="btn"><button class="deleteStudent" onclick="deleteStudent(${data[i].idStudent})">Delete</button></td>` +
                    // `<td class="btn"><button class="updateStudent" onclick="findById(${data[i].idStudent})">Update</button></td>
                content+=  " </tr>";

            }
            content += "</table>"
            console.log(content)
            document.getElementById('studentList').innerHTML = content;
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

