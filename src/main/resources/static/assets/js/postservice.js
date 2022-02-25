document.addEventListener("DOMContentLoaded", (e) => {

    const form = document.getElementById("serviceForm");
    const btnAddQuestion = document.getElementById("btnAddQuestion");
    const btnAddImage = document.getElementById("btnAddImage");
    const btnAddPlan = document.getElementById("btnAddPlan");

    var status = false;
    var status = { status };
    //var doc = document.getElementById("doc").files[0].name;
    //doc = { doc };
    var subCategory = document.getElementById("subCategory").value;

    var qualification = { qualification: [] };

    subCategory = {
        "idSubCategory": subCategory,
        "name": "string"
    };

    var loadProfessional = {
        "idProfessional": 2,
        "urlSitioWeb": "string",
        "urlLinkedin": "string",
        "description": "string",
        "people": {
            "idPeople": 0,
            "name": "string",
            "phone": "string",
            "profilePic": "string",
            "password": "string",
            "dni": "string",
            "email": "string",
            "country": {
                "idCountry": 0,
                "name": "string"
            }
        }
    };

    var professional = { professional };
    professional.professional = loadProfessional;

    var plans = { plans: [] };
    var questions = { questions: [] };
    var images = { images: [] };

    //creación del JSON
    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const formData = new FormData(form);
        let dataJson = {};
        formData.forEach((value, key) => {
            dataJson = {
                ...dataJson,
                ...{ [key]: value },
                ...status,
                ...professional,
                ...plans,
                ...questions,
                ...publicationDate,
                ...subCategory,
                ...doc,
                ...qualification,
                ...images
            };
        });

        console.log(dataJson);
    });


    //ACCION BOTON AGREGAR {PLAN}
    btnAddPlan.addEventListener("click", () => {
        const plansList = document.getElementById("plansList");
        const type = document.querySelector("select[id=type]");
        const name = document.querySelector("input[id=name]");
        const description = document.querySelector("input[id=description]");
        const deliveryDay = document.querySelector("input[id=deliveryDay]");
        const price = document.querySelector("input[id=price]");

        const tmPlans = document.getElementById("tmPlans");
        const clone = tmPlans.content.cloneNode(true);
        clone.querySelector(".type").textContent = type.value;
        clone.querySelector(".name").textContent = name.value;
        clone.querySelector(".description").textContent = description.value;
        clone.querySelector(".deliveryDay").textContent = deliveryDay.value;
        clone.querySelector(".price").textContent = price.value;

        clone.querySelector(".editRowPlan").addEventListener("click", (e) => {
            console.log();
            const elem = e.target.parentNode.parentNode;

            elem.querySelector(".type").innerHTML = `
            <input type="select" class="form-control" value="${type.value}" />
        `;
            elem.querySelector(".name").innerHTML = `
            <input type="text" class="form-control" value="${name.value}" />
        `;
            elem.querySelector(".description").innerHTML = `
            <input type="text" class="form-control" value="${description.value}" />
        `;
            elem.querySelector(".deliveryDay").innerHTML = `
            <input type="text" class="form-control" value="${deliveryDay.value}" />
        `;
            elem.querySelector(".price").innerHTML = `
            <input type="text" class="form-control" value="${price.value}" />
        `;
        });

        /*clone.querySelector(".deleteRowService").addEventListener("click", (e) => {
            console.log();

        });*/
        plans.plans.push({
            type: type.value,
            name: name.value,
            description: description.value,
            deliveryDay: deliveryDay.value,
            description: description.value,
            price: price.value
        });


        plansList.appendChild(clone);
    });

    //ACCION BOTON AGREGAR {QUESTION}
    btnAddQuestion.addEventListener("click", () => {
        const questionsList = document.getElementById("questionsList");
        const question = document.querySelector("input[id=question]");
        const answer = document.querySelector("input[id=answer]");

        const tmQuestions = document.getElementById("tmQuestions");
        const clone = tmQuestions.content.cloneNode(true);
        clone.querySelector(".question").textContent = question.value;
        clone.querySelector(".answer").textContent = answer.value;

        clone.querySelector(".editRowService").addEventListener("click", (e) => {
            console.log();
            const elem = e.target.parentNode.parentNode;
            elem.querySelector(".question").innerHTML = `
            <input type="text" value="${question.value}" class="form-control" />
        `;
            elem.querySelector(".answer").innerHTML = `
          <input type="text" class="form-control" value="${answer.value}" />
        `;
        });

        /*clone.querySelector(".deleteRowService").addEventListener("click", (e) => {
            console.log();

        });*/
        questions.questions.push({
            question: question.value,
            answer: answer.value,
        });

        questionsList.appendChild(clone);
    });

    //ACCION BOTON AGREGAR {IMAGE}
    btnAddImage.addEventListener("click", (e) => {
        const imageList = document.getElementById("imageList");
        const image = document.querySelector("input[id=image]");

        const tmImage = document.getElementById("tmImage");
        const clone = tmImage.content.cloneNode(true);
        clone.querySelector(".image").textContent = image.value;
        //clone.querySelector(".image").textContent = document.getElementById("image").files[0].name;

        clone.querySelector(".deleteRowImage").addEventListener("click", (e) => {
            console.log();
            const elem = e.target.parentNode.parentNode;
            elem.querySelector(".image").innerHTML = `
            <input class="form-control form-control-sm" type="text" value="${image.value}" class="form-control" />
            `;
        });

        images.images.push({
            image: document.getElementById("image").files[0].name,
        });

        imageList.appendChild(clone);
    });

});