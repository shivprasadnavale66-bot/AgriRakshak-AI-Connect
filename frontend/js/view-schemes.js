const BASE_URL = "https://agrirakshak-backend.onrender.com/api/schemes";

async function loadSchemes(){

    const response = await fetch(BASE_URL + "/all");

    const data = await response.json();

    const table = document.getElementById("schemeTable");

    table.innerHTML="";

    data.forEach(s=>{

        table.innerHTML += `

        <tr>

        <td>${s.schemeName}</td>

        <td>${s.state}</td>

        <td>${s.category}</td>

        <td>${s.eligibility}</td>

        <td>${s.benefits}</td>

        <td>

        <a href="${s.applyLink}" target="_blank">

        Apply

        </a>

        </td>

        </tr>

        `;

    });

}

loadSchemes();