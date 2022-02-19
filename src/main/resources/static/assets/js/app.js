document.addEventListener("DOMContentLoaded", (e) => {
	//Form
	const form = document.getElementById("myForm");

	const btnAddLanguaje = document.getElementById("btnAddLanguaje");
	const btnAddSkill = document.getElementById("btnAddSkill");
    const btnAddEducation = document.getElementById("btnAddEducation");
	const btnAddCertification = document.getElementById("btnAddCertification");

	var skill = { skill: [] };
	var education = { education: [] };
	var languaje = { languaje: [] };
	var certification = { certification: [] };
	var country = { country };
	var people = { people };

	form.addEventListener("submit", async (e) => {
		e.preventDefault();
		const formData = new FormData(form);
		let dataJson = {};
		formData.forEach((value, key) => {
			dataJson = {
				...dataJson,
				...{ [key]: value },
				...people,
				...skill,
				...education,
				...languaje,
			};
		});

		console.log(dataJson);
	});

	//ACCION BOTON AGREGAR {IDIOMA}
	btnAddLanguaje.addEventListener("click", () => {
		const languajeList = document.getElementById("languajeList");
		const name = document.querySelector("input[id=nameLanguaje]");
		const level = document.querySelector("select[id=levelLanguaje]");

		const trTemplate = document.getElementById("trTemplateLaguaje");
		const clone = trTemplate.content.cloneNode(true);
		clone.querySelector(".name").textContent = name.value;
		clone.querySelector(".level").textContent = level.value;
		clone.querySelector(".editRow").addEventListener("click", (e) => {
			console.log();
			const elem = e.target.parentNode.parentNode;
			elem.querySelector(".name").innerHTML = `
          <input type="text" value="${name.value}" class="form-control" />
      `;

			elem.querySelector(".level").innerHTML = `
        <input type="select" class="form-control" value="${level.value}" />
      `;
		});

		languaje.languaje.push({
			name: name.value,
			level: level.value,
		});

		languajeList.appendChild(clone);
	});
	btnAddSkill.addEventListener("click", () => {
		const skillList = document.getElementById("skillList");
		const name = document.querySelector("input[id=nameSkill]");
		const dateFrom = document.querySelector("input[id=dateFromSkill]");
		const description = document.querySelector("input[id=descriptionSkill]");

		const trTemplate = document.getElementById("trTemplateSkill");
		const clone = trTemplate.content.cloneNode(true);
		clone.querySelector(".name").textContent = name.value;
		clone.querySelector(".dateFrom").textContent = dateFrom.value;
		clone.querySelector(".description").textContent = description.value;
		clone.querySelector(".editRow").addEventListener("click", (e) => {
			console.log();
			const elem = e.target.parentNode.parentNode;
			elem.querySelector(".name").innerHTML = `
          <input type="text" value="${name.value}" class="form-control" />
      `;

			elem.querySelector(".dateFrom").innerHTML = `
        <input type="date" class="form-control" value="${dateFrom.value}" />
      `;

			elem.querySelector(".description").innerHTML = `
        <input type="text" value="${description.value}" class="form-control" />
      `;
		});

		skill.skill.push({
			name: name.value,
			dateFrom: dateFrom.value,
			description: description.value,
		});

		skillList.appendChild(clone);
	});

	btnAddEducation.addEventListener("click", () => {
		const educationList = document.getElementById("educationList");
		const nameInstitution = document.querySelector(
			"input[id=nameInstitucionEducation]"
		);
		const description = document.querySelector(
			"input[id=descriptionEducation]"
		);
		const year = document.querySelector("input[id=yearEducation]");

		const trTemplate = document.getElementById("trTemplateEducation");
		const clone = trTemplate.content.cloneNode(true);
		clone.querySelector(".nameInstitution").textContent = nameInstitution.value;
		clone.querySelector(".description").textContent = description.value;
		clone.querySelector(".year").textContent = year.value;
		clone.querySelector(".editRow").addEventListener("click", (e) => {
			console.log();
			const elem = e.target.parentNode.parentNode;
			elem.querySelector(".nameInstitucion").innerHTML = `
        <input type="text" value="${nameInstitution.value}" class="form-control" />
    `;

			elem.querySelector(".description").innerHTML = `
      <input type="text" class="form-control" value="${description.value}" />
    `;

			elem.querySelector(".year").innerHTML = `
    <input type="date" class="form-control" value="${year.value}" />
    `;
		});

		education.education.push({
			nameInstitution: nameInstitution.value,
			description: description.value,
			year: year.value
		});

		educationList.appendChild(clone);
	});

	btnAddCertification.addEventListener("click", () => {
		const certiticationList = document.getElementById("certificationList");
		const name = document.querySelector("input[id=nameCertification]");
		const year = document.querySelector("input[id=yearCertification]");

		const trTemplate = document.getElementById("trTemplateCertification");
		const clone = trTemplate.content.cloneNode(true);
		clone.querySelector(".name").textContent = name.value;
		clone.querySelector(".year").textContent = year.value;
		clone.querySelector(".editRow").addEventListener("click", (e) => {
			console.log();
			const elem = e.target.parentNode.parentNode;
			elem.querySelector(".name").innerHTML = `
        <input type="text" value="${name.value}" class="form-control" />
    `;

			elem.querySelector(".year").innerHTML = `
      <input type="date" class="form-control" value="${year.value}" />
    `;
		});

		certification.certification.push({
			name: name.value,
			year: year.value,
		});

		certiticationList.appendChild(clone);
	});

});
