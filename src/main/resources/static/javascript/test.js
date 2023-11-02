document.getElementById("bt1").addEventListener("click",function (){
    let name=document.getElementById("username").value;
    let email=document.getElementById("email").value;
    let gender=document.getElementById("gender").value;
    let score=document.getElementById("score").value;



    alert(name);
    alert(email);
    alert(gender);
    alert(score);


    let data={
        name:name,
        email:email,
        gender:gender,
        score:score
    }
    fetch('http://localhost:8080/stu/add',{
        method:'POST',
        headers:{
            'content-type':'application/json'
        },
        body:JSON.stringify(data)
    }).then(response=>response.json()).then(data=>{
        window.alert(data);
    })
})