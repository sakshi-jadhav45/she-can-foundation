
const reasonSelect = document.getElementById("reasonSelect");
const otherReason = document.getElementById("otherReason");

reasonSelect.addEventListener("change", function () {

    if (this.value === "Other") {
        otherReason.style.display = "block";
    } else {
        otherReason.style.display = "none";
    }

});



const joinForm = document.getElementById("joinForm");

joinForm.addEventListener("submit", async function(event){

    event.preventDefault();

    const formData = {

        name: document.getElementById("name").value,

        email: document.getElementById("email").value,

        phone: document.getElementById("phone").value,

        reason: document.getElementById("reasonSelect").value,

        otherReason: document.getElementById("otherReason").value,

        message: document.getElementById("message").value
    };

    try {

        const response = await fetch(
            "http://localhost:8080/api/form/submit",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(formData)
            }
        );

        if(response.ok){

            alert("Form Submitted Successfully!");

            joinForm.reset();

            otherReason.style.display = "none";

        } else {

            alert("Failed To Submit Form");
        }

    } catch(error){

        console.error(error);

        alert("Something went wrong!");
    }

});

