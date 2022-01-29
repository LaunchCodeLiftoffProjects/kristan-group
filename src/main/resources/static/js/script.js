<html>
   <head>
      <title>Launch Status</title>
      <script>
         window.addEventListener("load", function() {
            fetch("https://www.growstuff.org/api/v1/seeds.json").then( function(response) {
               response.json().then( function(json) {
                  const div = document.getElementById("seeds");
                  // Add HTML that includes the JSON data
                  div.innerHTML = `
                     <ul>
                        <li>Title ${json.title}</li>
                        <li>Detail ${json.detail}</li>
                        <li>Code ${json.code}</li>
                        <li>Status ${json.status}</li>
                     </ul>
                  `;
               });
            });
         });
      </script>
   </head>
   <body>
      <h1>Launch Status</h1>
      <h3>Planting Information</h3>
      <div id="seeds">
         <!-- Seed data is added here dynamically. -->
      </div>
   </body>
</html>