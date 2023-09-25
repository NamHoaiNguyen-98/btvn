function searchByName() {
    let name = $('#name').val();
    let student = {name: name}
    console.log(student);
    $.ajax({
        headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        type: "POST",
        data: JSON.stringify(student),
        url: "http://localhost:8080/api/students/searchByName",
        success: display
    });
    event.preventDefault();
}