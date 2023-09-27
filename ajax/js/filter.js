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
    event.preventDefault();

}

    // $(document).ready(function () {
    //     $("#getDataButton").click(function () {
    //
    //         let selectedStatus = [];
    //
    //         // Tạo một mảng để lưu trữ dữ liệu từ các checkbox đã được chọn
    //         // Lặp qua tất cả các ô checkbox và kiểm tra xem chúng có được chọn hay không
    //         $(".status").each(function () {
    //             if ($(this).is(":checked")) {
    //                 selectedStatus.push($(this).val());
    //             }
    //         });
    //
    //         let selectedAddress = [];
    //         // Lặp qua tất cả các ô checkbox và kiểm tra xem chúng có được chọn hay không
    //         $(".address").each(function () {
    //             if ($(this).is(":checked")) {
    //                 selectedAddress.push($(this).val());
    //             }
    //         });
    //         let selectedSex = [];
    //         // Lặp qua tất cả các ô checkbox và kiểm tra xem chúng có được chọn hay không
    //         $(".sex").each(function () {
    //             if ($(this).is(":checked")) {
    //                 selectedSex.push($(this).val());
    //             }
    //         });
    //
    //         let selectedSubject = [];
    //         $(".subject").each(function () {
    //             if ($(this).is(":checked")) {
    //                 selectedSubject.push($(this).val());
    //             }
    //         });
    //
    //         let newFilter = {
    //             status: selectedStatus,
    //             subject: selectedSubject,
    //             sex: selectedSex,
    //             address: selectedAddress
    //         }
    //         $.ajax({
    //             headers: {
    //                 'Accept': 'application/json',
    //                 'Content-Type': 'application/json'
    //             },
    //             type: "GET",
    //             data: JSON.stringify(newFilter),
    //             url: "http://localhost:8080/api/students/filter",
    //             success: function (data) {
    //                 console.log(data)
    //                 let content = ' <table id="display-list" border="1"><tr>\n' +
    //                     ' <th>Name</td>\n' +
    //                     ' <th>Sex</td>\n' +
    //                     ' <th>Address</td>\n' +
    //                     ' <th>Status</td>\n' +
    //                     ' </tr>';
    //                 for (let i = 0; i < data.length; i++) {
    //                     content += getStudent(data[i])
    //                 }
    //                 content += "</table>"
    //                 document.getElementById('studentList').innerHTML = content;
    //                 console.log(content)
    //             }
    //
    //         });
    //     });
    //
    // });

function  takeFilter () {

    let selectedStatus = [];

    // Tạo một mảng để lưu trữ dữ liệu từ các checkbox đã được chọn
    // Lặp qua tất cả các ô checkbox và kiểm tra xem chúng có được chọn hay không
    $.each($('input[name="status"]:checked'), function() {
        var value = $(this).val()
        selectedStatus.push(value)
    });
    let selectedAddress = [];
    // Lặp qua tất cả các ô checkbox và kiểm tra xem chúng có được chọn hay không
    $.each($('input[name="address"]:checked'), function() {
        var value = $(this).val()
        selectedAddress.push(value)
    });

    let selectedSex = [];
    // Lặp qua tất cả các ô checkbox và kiểm tra xem chúng có được chọn hay không
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
    var settings = {
        "url": "http://localhost:8080/api/students/filter",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json"
        },
        "data": JSON.stringify(newFilter),
    };

    $.ajax(settings).done(function (data) {
        console.log(data)
        let content = ' <table id="display-list" border="1"><tr>\n' +
            ' <th>Name</td>\n' +
            ' <th>Sex</td>\n' +
            ' <th>Address</td>\n' +
            ' <th>Status</td>\n' +
            ' </tr>';
        for (let i = 0; i < data.length; i++) {
            content += getStudent(data[i])
        }
        content += "</table>"
        document.getElementById('studentList').innerHTML = content;
        console.log(content)
    });
    // $.ajax({
    //     headers: {
    //         'Accept': 'application/json',
    //         'Content-Type': 'application/json'
    //     },
    //     type: "GET",
    //     data: JSON.stringify(newFilter),
    //     url: "http://localhost:8080/api/students/filter",
    //     success: function (data) {
    //         console.log(data)
    //         let content = ' <table id="display-list" border="1"><tr>\n' +
    //             ' <th>Name</td>\n' +
    //             ' <th>Sex</td>\n' +
    //             ' <th>Address</td>\n' +
    //             ' <th>Status</td>\n' +
    //             ' </tr>';
    //         for (let i = 0; i < data.length; i++) {
    //             content += getStudent(data[i])
    //         }
    //         content += "</table>"
    //         document.getElementById('studentList').innerHTML = content;
    //         console.log(content)
    //     }
    //
    // });
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


// jQuery(document).ready(function( ){
//     jQuery("input[name='checkbox[]']").click(function(){
//         var stringV = '';
// // su dung vong lap de them gia tri checkbox vao chuoi....
//         jQuery("input[name='checkbox[]']:checked").each(function(){
//             stringV = stringV + ',' + jQuery(this).val();});
//         if(stringV.length&gt;1){
//             stringV = stringV.substring(1);
//         }
// //ket thuc lap-----------&gt; su dung ajax gui den server.
// //alert(stringV);
//         jQuery.ajax({
//             url:"xuly.php",
//             type:"post",
//             data:"id="+ stringV,
//             async: true,
//             success: function(result){
//                 jQuery(".results").html(result);
//             }
//         })
//     })
// });
