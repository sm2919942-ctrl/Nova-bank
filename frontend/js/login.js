const loginForm = document.getElementById("loginForm");

loginForm.addEventListener("submit", async function (e) {

    e.preventDefault();

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;

    if (email === "" || password === "") {
        alert("Please fill all fields.");
        return;
    }

    try {

        const response = await fetch("http://localhost:8080/api/users/login", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                email: email,
                password: password
            })

        });

        const data = await response.json();

        if (data.success) {

            sessionStorage.setItem("userId", data.id);
            sessionStorage.setItem("fullName", data.fullName);
            sessionStorage.setItem("email", data.email);
            sessionStorage.setItem("balance", data.balance);
            sessionStorage.setItem("accountNumber", data.accountNumber);

            alert(data.message);

            window.location.href = "dashboard.html";

        } else {

            alert(data.message);

        }

    } catch (error) {

        console.error(error);

        alert("Server Error");

    }

});