const BASE_URL = "https://agrirakshak-backend-gosk.onrender.com/api/schemes";

document.getElementById("schemeForm")
.addEventListener("submit", async function(e){

    e.preventDefault();

    const scheme = {

        schemeName: document.getElementById("schemeName").value,
        state: document.getElementById("state").value,
        category: document.getElementById("category").value,
        eligibility: document.getElementById("eligibility").value,
        benefits: document.getElementById("benefits").value,
        applyLink: document.getElementById("applyLink").value

    };

    const response = await fetch(BASE_URL + "/add",{

        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify(scheme)

    });

    if(response.ok){

        alert("Scheme Added Successfully");

        document.getElementById("schemeForm").reset();

    }else{

        alert("Error Saving Scheme");

    }

});


