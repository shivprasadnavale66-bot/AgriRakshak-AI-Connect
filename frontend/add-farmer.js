document.getElementById("farmerForm").addEventListener("submit", async function(e){

    e.preventDefault();

    const farmer={

        fullName:document.getElementById("fullName").value,
        mobileNumber:document.getElementById("mobileNumber").value,
        village:document.getElementById("village").value,
        district:document.getElementById("district").value,
        state:document.getElementById("state").value,
        landArea:parseFloat(document.getElementById("landArea").value),
        soilType:document.getElementById("soilType").value,
        waterSource:document.getElementById("waterSource").value

    };

    try{

        const response=await fetch("http://localhost:8080/api/farmer",{

            method:"POST",

            headers:{
                "Content-Type":"application/json"
            },

            body:JSON.stringify(farmer)

        });

        const message=await response.text();

        document.getElementById("message").style.color="green";
        document.getElementById("message").innerHTML=message;

        document.getElementById("farmerForm").reset();

    }
    catch(error){

        document.getElementById("message").style.color="red";
        document.getElementById("message").innerHTML="Cannot connect to Backend";

    }

});