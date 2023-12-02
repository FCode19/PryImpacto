
$(document).ready(function () {  
   //cuando se escriba caracteres en la caja de texto  
    $(document).on('keyup','#txtnom',function(){ 
        let valor = $(this).val();  
             listado(valor);  
         
    });  
     
   function listado(consulta) {  
        opc = "5";  
        $.get("controlCli", {opc, consulta}, (response) => {  
            const misDatos = JSON.parse(response);//recuperar la informacion q envio el controlador  
            let template = "";  
             console.log(misDatos);  
             
           template += `  
             <table class="table table-hover">  
                                    <thead class="text-white bg-dark">  
                                        <tr>  
                                            <th>Codigo</th>  
                                            <th>Nombre</th>  
                                            <th>Direccion</th>
                                            <th>Email</th>
                                            <th>Telefono</th>
                                            <th>Eliminar</th>
                                            <th>Editar</th>
                                             <th>Ver</th>
                                           </tr>  
                                    </thead>  
                                    <tbody>`;    
            misDatos.forEach(midato => {  
                template += `  
                <tr>  
                <td>${midato.id}</td>  
                    <td>${midato.nombre}</td>  
                    <td>${midato.direcc}</td>
                    <td>${midato.email}</td>
                    <td>${midato.telef}</td>
                    <td><a href='control?opc=4&cod=${midato.id}'>Del</td>
                    <td><a href='control?opc=3&cod=${midato.id}'>Edit</td>
                    <td><a href='control?opc=6&cod=${midato.id}&nom=${midato.nombre}'>Pedidos</a></td>
                                </tr>`;              
                  
            })  
            template += `</tbody></table>`;  
            $("#tablares").html(template);  
  
        })  
    } //fin de listado 
     
}) 
    