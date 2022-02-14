$(document).ready(function () {
    $("#PreguntasServicios").dynamicTable({
        //definimos las columnas iniciales    
        columns: [{
            text: "Pregunta",
            key: "question"
        },
        {
            text: "Respuesta",
            key: "answer"
        },
        ],

        //carga de datos
        data: [{
            question: '¿Cuándo estará listo el servicio?',
            answer: 'El servicio estará cuando esté terminado',
        },
        {
            question: '¿Hace reembolso?',
            answer: 'No se hace reembolso',
        },
        ],

        //definición de botones
        buttons: {

            addButton: '<input type="button" value="Nuevo" class="btn btn-outline-success" />',
            cancelButton: '<input type="button" value="Cancelar" class="btn btn-outline-primary" />',
            deleteButton: '<input type="button" value="Borrar" class="btn btn-outline-danger" />',
            editButton: '<input type="button" value="Editar" class="btn btn-outline-warning" />',
            saveButton: '<input type="button" value="Guardar" class="btn btn-outline-success" />',
        },
        showActionColumn: true,

    });
});    