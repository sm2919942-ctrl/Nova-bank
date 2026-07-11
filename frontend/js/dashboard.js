// ==============================
// NOVA BANK DASHBOARD
// ==============================

// Welcome Message
const fullName = sessionStorage.getItem("fullName");
const balance = sessionStorage.getItem("balance");
const accountNumber = sessionStorage.getItem("accountNumber");

if (!fullName) {

    window.location.href = "login.html";

}

document.getElementById("welcomeText").innerHTML =
    "Welcome, " + fullName + " 👋";

document.getElementById("balance").innerHTML =
    "₹ " + balance;

document.getElementById("accountNumber").innerHTML = accountNumber;
window.addEventListener("load", () => {
    console.log("Welcome to Nova Bank Dashboard");
});

// Buttons
const depositBtn = document.getElementById("depositBtn");
const withdrawBtn = document.getElementById("withdrawBtn");
const transferBtn = document.getElementById("transferBtn");

// Deposit
depositBtn.addEventListener("click", () => {
    alert("Deposit feature will be connected with Spring Boot Backend.");
});

// Withdraw
withdrawBtn.addEventListener("click", () => {
    alert("Withdraw feature will be connected with Spring Boot Backend.");
});

// Transfer
transferBtn.addEventListener("click", () => {
    window.location.href = "transfer.html";
});

// Sidebar Navigation
const menuItems = document.querySelectorAll(".sidebar ul li");

menuItems.forEach(item => {

    item.addEventListener("click", () => {

        menuItems.forEach(li => li.classList.remove("active"));

        item.classList.add("active");

        const text = item.textContent.trim();

        switch (text) {

            case "Dashboard":
                window.location.href = "dashboard.html";
                break;

            case "Profile":
                window.location.href = "profile.html";
                break;

            case "Transfer":
                window.location.href = "transfer.html";
                break;

            case "Transactions":
                window.location.href = "transaction.html";
                break;

            case "Settings":
                alert("Settings page will be added later.");
                break;

            case "Logout":
                const logout = confirm("Are you sure you want to logout?");

                if (logout) {
                    sessionStorage.clear();

                    window.location.href = "login.html";
                }
                break;
        }

    });

});