window.onload = () => {
	//getAllReims();
	//document.getElementById("createTodoBtn").addEventListener("click", createTodo);
//	document.getElementById("getReimButton").addEventListener("click", getAllReims);
	getAllReims();
	console.log("inside window.onload");
}

const getAllReims = () => {
	//step 1 is to create an xmlhttprequest obj
	const xhr = new XMLHttpRequest();
	//step2 assign a callback fucntion to xhr.onreadystatechange
	xhr.onreadystatechange = () => {
		//step 5 handle each of the different possible outcomes from making this request
		if(xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
			populateEmpTable(JSON.parse(json));
			//populateEmpTable(json);
		}
	};
	//step 3 call xhr.open passing in 2 strings for http method and url
	xhr.open("GET", "http://localhost:8081/ERS/GetAllReims");
	//step 4 call xhr.send to actually fires off your http request
	xhr.send();
}

//same as function populateTodoTable() {}
const populateEmpTable = (listOfReims) => {
	//the for...of loop is Javascripts version of the enhanced for loop; goes through all iterables
	//the for...in loop iterates over every property of a js object
	for(let reim of listOfReims) {
		//create a table cell for each property of our object
		const tdId = document.createElement("td");
		const tdUsername = document.createElement("td");
		const tdAmt = document.createElement("td");
		const tdEmployeeId = document.createElement("td");
		const tdStatus = document.createElement("td");
		//set value of each cell
		tdId.textContent = reim.id;
		tdUsername.textContent = reim.username;
		tdAmt.textContent = reim.amt;
		tdEmployeeId.textContent = reim.eId;
		tdStatus.textContent = reim.status;
		//create a row to be appended onto our table
		const row = document.createElement("tr");
		//set the tds to the corresponding order of our table header
		row.appendChild(tdId);
		row.appendChild(tdUsername);
		row.appendChild(tdAmt);
		row.appendChild(tdEmployeeId);
		row.appendChild(tdStatus);
		//append our row ont our table of todos
		document.getElementById("rTable").appendChild(row);
	}
}

const createReims = () => {
	const xhr = new XMLHttpRequest();
	//create a helper variable for your form data
	const formData = parseForm();
	xhr.onreadystatechange = () => {
		if(xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	xhr.open("POST", "http://localhost:8081/ERS/GetAllReims");
	xhr.send(JSON.stringify(formData));
}

const parseForm = () => {
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
function get(url){
	return new Promise((resolve, reject)=>{
		
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					resolve(JSON.parse(xhr.response));
				}
				else{
					reject(Error("Looks like something went wrong!"));
				}
				}
			}
		
		xhr.open("GET", url);
		xhr.send();
	});
}

function getAllReims(){
	let url = "http://localhost:8081/ERS/GetAllReims";
	
	let table = document.getElementById("reimtable");
	
	get(url).then(data =>{
		for(let d in data){
			const tdId = document.createElement("td");
			const tdUsername = document.createElement("td");
			const tdAmt = document.createElement("td");
			const tdEmployeeId = document.createElement("td");
			const tdStatus = document.createElement("td");
			//let newOption = document.createElement("td");
			//newOption.innerHTML = data[d]["name"];
			//newOption.value = data[d]["id"];
			//select.append(newOption);
			tdId.innerHTML = data[d]["id"];
			tdUsername.innerHTML = data[d]["username"];
			tdAmt.innerHTML = data[d]["amt"];
			tdEmployeeId.innerHTML = data[d]["eId"];
			tdStatus.innerHTML = data[d]["status"];
		}
		
	}).catch(error => {
		console.log("My data is missing...");
	});
}

window.onload = function(){
	getAllReims();
}
*/