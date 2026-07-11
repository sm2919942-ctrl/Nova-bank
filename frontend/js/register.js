const registerForm = document.getElementById("registerForm");

registerForm.addEventListener("submit", async function (e) {

    e.preventDefault();

    const user = {

        fullName: document.getElementById("fullName").value.trim(),

        email: document.getElementById("email").value.trim(),

        mobile: document.getElementById("mobile").value.trim(),

        dob: document.getElementById("dob").value,

        gender: document.getElementById("gender").value,

        accountType: document.getElementById("accountType").value,

        address: document.getElementById("address").value.trim(),

        aadhaar: document.getElementById("aadhaar").value.trim(),

        pan: document.getElementById("pan").value.trim().toUpperCase(),

        password: document.getElementById("password").value,

        confirmPassword: document.getElementById("confirmPassword").value

    };

    // Validation

    if(user.fullName.length < 3){
        alert("Full Name must be at least 3 characters.");
        return;
    }

    if(!user.email.includes("@")){
        alert("Enter a valid email.");
        return;
    }

    if(!/^[0-9]{10}$/.test(user.mobile)){
        alert("Enter valid mobile number.");
        return;
    }

    if(!/^[0-9]{12}$/.test(user.aadhaar)){
        alert("Enter valid Aadhaar.");
        return;
    }

    if(!/^[A-Z]{5}[0-9]{4}[A-Z]$/.test(user.pan)){
        alert("Invalid PAN.");
        return;
    }

    if(user.password.length < 8){
        alert("Password must be at least 8 characters.");
        return;
    }

    if(user.password !== user.confirmPassword){
        alert("Passwords do not match.");
        return;
    }

    delete user.confirmPassword;

    try{

        const response = await fetch("http://localhost:8080/api/users/register",{

            method:"POST",

            headers:{
                "Content-Type":"application/json"
            },

            body:JSON.stringify(user)

        });

        const data = await response.json();

        alert(data.message);

        if(data.success){

            window.location.href="login.html";

        }

    }catch(error){

        console.error(error);

        alert("Server Error.");

    }

});