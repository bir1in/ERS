window.onload = () => {
	//getAllReims();
	//document.getElementById("createTodoBtn").addEventListener("click", createTodo);
	//document.getElementById("getInfoButton").addEventListener("click", getEmpsById);
	//getAllReims();
	//getEmpForMgrById();
	console.log("inside window.onload");
	//document.getElementById("getInfoButton").addEventListener("click", getAllEmps);
}

const getEmpForMgrById = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
			populateEmpForMgrInfoTable(JSON.parse(json));
			//populateEmpTable(json);
		}
	};
	xhr.open("GET", "http://localhost:8081/ERS/GetEmpForMgrById");
	xhr.send();
}

//same as function populateTodoTable() {}
const populateEmpForMgrInfoTable = (listOfEmps) => {
	for(let emp of listOfEmps) {
		const tdId = document.createElement("td");
		const tdUsername = document.createElement("td");
		const tdPassword = document.createElement("td");
		const tdFirstName = document.createElement("td");
		const tdLastName = document.createElement("td");
		const tdMgrId = document.createElement("td");
		tdId.textContent = emp.id;
		tdUsername.textContent = emp.username;
		tdPassword.textContent = emp.password;
		tdFirstName.textContent = emp.firstName;
		tdLastName.textContent = emp.lastName;
		tdMgrId.textContent = emp.mId;
		const row = document.createElement("tr");
		row.appendChild(tdId);
		row.appendChild(tdUsername);
		row.appendChild(tdPassword);
		row.appendChild(tdFirstName);
		row.appendChild(tdLastName);
		row.appendChild(tdMgrId);
		document.getElementById("ifmTable").appendChild(row);
	}
}

const createEmpsForMgr = (value) => {
	const xhr = new XMLHttpRequest();
	//create a helper variable for your form data
	const formData = parseInfoForMgrForm(value);
	xhr.onreadystatechange = () => {
		if(xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	xhr.open("GET", "http://localhost:8081/ERS/GetEmpForMgrById");
	xhr.send(JSON.stringify(formData));
}

const parseInfoForMgrForm = (value) => {
	const idText = document.getElementById("listId").value;
	const usernameText = document.getElementById("listUname").value;
	const amtText = document.getElementById("listAmount").value;
	const eidText = document.getElementById("listeId").value;
	const statusText = document.getElementById("listStatus").value;
	return {
		id: idText,
		username: usernameText,
		amt: amtText,
		eId: eidText,
		status: statusText
	}
}
