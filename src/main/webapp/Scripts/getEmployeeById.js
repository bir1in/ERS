window.onload = () => {
	//getAllReims();
	//document.getElementById("createTodoBtn").addEventListener("click", createTodo);
	document.getElementById("getInfoButton").addEventListener("click", getEmpsById);
	//getAllReims();
	console.log("inside window.onload");
	//document.getElementById("getInfoButton").addEventListener("click", getAllEmps);

}

const getEmpsById = () => {
	//step 1 is to create an xmlhttprequest obj
	const xhr = new XMLHttpRequest();
	//step2 assign a callback fucntion to xhr.onreadystatechange
	xhr.onreadystatechange = () => {
		//step 5 handle each of the different possible outcomes from making this request
		if(xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
			populateEmpInfoTable(JSON.parse(json));
			//populateEmpTable(json);
		}
	};
	//step 3 call xhr.open passing in 2 strings for http method and url
	xhr.open("GET", "http://localhost:8081/ERS/GetEmpById");
	//step 4 call xhr.send to actually fires off your http request
	xhr.send();
}

//same as function populateTodoTable() {}
const populateEmpInfoTable = (emp) => {
	//the for...of loop is Javascripts version of the enhanced for loop; goes through all iterables
	//the for...in loop iterates over every property of a js object
	//for(let emp of listOfEmps) {
		//create a table cell for each property of our object
		const tdId = document.createElement("td");
		const tdUsername = document.createElement("td");
		const tdPassword = document.createElement("td");
		const tdFirstName = document.createElement("td");
		const tdLastName = document.createElement("td");
		const tdMgrId = document.createElement("td");
		//set value of each cell
		tdId.textContent = emp.id;
		tdUsername.textContent = emp.username;
		tdPassword.textContent = emp.password;
		tdFirstName.textContent = emp.firstName;
		tdLastName.textContent = emp.lastName;
		tdMgrId.textContent = emp.mId;
		//create a row to be appended onto our table
		const row = document.createElement("tr");
		//set the tds to the corresponding order of our table header
		row.appendChild(tdId);
		row.appendChild(tdUsername);
		row.appendChild(tdPassword);
		row.appendChild(tdFirstName);
		row.appendChild(tdLastName);
		row.appendChild(tdMgrId);
		//append our row ont our table of todos
		document.getElementById("iTable").appendChild(row);
	//}
}

const createEmps = () => {
	const xhr = new XMLHttpRequest();
	//create a helper variable for your form data
	const formData = parseInfoForm();
	xhr.onreadystatechange = () => {
		if(xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	xhr.open("POST", "http://localhost:8081/ERS/GetEmpById");
	xhr.send(JSON.stringify(formData));
}

const parseInfoForm = () => {
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

/*
const getAllEmps = () => {
	//step 1 is to create an xmlhttprequest obj
	const xhr = new XMLHttpRequest();
	//step2 assign a callback fucntion to xhr.onreadystatechange
	xhr.onreadystatechange = () => {
		//step 5 handle each of the different possible outcomes from making this request
		if(xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
			populateEmpInfoTable(JSON.parse(json));
			//populateEmpTable(json);
		}
	};
	//step 3 call xhr.open passing in 2 strings for http method and url
	xhr.open("GET", "http://localhost:8081/ERS/GetAllEmps");
	//step 4 call xhr.send to actually fires off your http request
	xhr.send();
}

//same as function populateTodoTable() {}
const populateEmpInfoTable = (listOfEmps) => {
	//the for...of loop is Javascripts version of the enhanced for loop; goes through all iterables
	//the for...in loop iterates over every property of a js object
	for(let emp of listOfEmp) {
		//create a table cell for each property of our object
		const tdId = document.createElement("td");
		const tdUsername = document.createElement("td");
		const tdPassword = document.createElement("td");
		const tdFirstName = document.createElement("td");
		const tdLastName = document.createElement("td");
		const tdMgrId = document.createElement("td");
		//set value of each cell
		tdId.textContent = emp.id;
		tdUsername.textContent = emp.username;
		tdPassword.textContent = emp.password;
		tdFirstName.textContent = emp.firstname;
		tdLastName.textContent = emp.lastname;
		tdMgrId.textContent = emp.mId;
		//create a row to be appended onto our table
		const row = document.createElement("tr");
		//set the tds to the corresponding order of our table header
		row.appendChild(tdId);
		row.appendChild(tdUsername);
		row.appendChild(tdPassword);
		row.appendChild(tdFirstName);
		row.appendChild(tdLastName);
		row.appendChild(tdMgrId);
		//append our row ont our table of todos
		document.getElementById("iTable").appendChild(row);
	}
}

const createEmps = () => {
	const xhr = new XMLHttpRequest();
	//create a helper variable for your form data
	const formData = parseInfoForm();
	xhr.onreadystatechange = () => {
		if(xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	xhr.open("POST", "http://localhost:8081/ERS/GetAllEmps");
	xhr.send(JSON.stringify(formData));
}

const parseInfoForm = () => {
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
}*/