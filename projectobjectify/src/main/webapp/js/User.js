/**
 * Javascript file for asynchronous function
 * 
 */

//Create user

function createFunc()
	{
	var xhr = new XMLHttpRequest();

	var name = document.getElementById("nameId").value;
	var email = document.getElementById("emailId").value;
	
    xhr.open('POST','http://localhost:8080/ControllerServlet', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    
    xhr.send("name="+name+"&email="+email);


    xhr.onload = function() {
        
    	
        let responseobj = this.response;
        if (this.status == 200) {
            document.getElementById('name').innerHTML = responseobj;
        } else if (this.status == 404) {
            document.getElementById('name').innerHTML = '<h1>Not Found -- 404 Error</h1>'
        }
    }
    
	}
