document.addEventListener("DOMContentLoaded", (e) => {
    const form = document.getElementById("serviceForm");
    const btnAddQuestion = document.getElementById("btnAddQuestion");
    var questions = { questions: [] };

    const btnAddImage = document.getElementById("btnAddImage");
    var images = { images: [] };

    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        const formData = new FormData(form);
        let dataJson = {};
        formData.forEach((value, key) => {
            dataJson = {
                ...dataJson,
                ...{ [key]: value },
                ...questions
            };
        });

        console.log(dataJson);
    });

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

        clone.querySelector(".deleteRowService").addEventListener("click", (e) => {
            console.log();

        });

        questions.questions.push({
            question: question.value,
            answer: answer.value
        });

        questionsList.appendChild(clone);
    });

    btnAddImage.addEventListener("click", (e) => {
        const imageList = document.getElementById("imageList");
        const pathImage = document.querySelector("input[id=pathImage]");

        const tmImage = document.getElementById("tmImage");
        const clone = tmImage.content.cloneNode(true);
        clone.querySelector(".pathImage").textContent = pathImage.value;

        clone.querySelector(".deleteRowImage").addEventListener("click", (e) => {
            console.log();
            const elem = e.target.parentNode.parentNode;
            elem.querySelector(".pathImage").innerHTML = `
                <input class="form-control form-control-sm" type="file" value="${pathImage.value}" class="form-control" />
            `;
        });

        images.images.push({
            pathImage: pathImage.value,
        });

        imageList.appendChild(clone);
    });

});