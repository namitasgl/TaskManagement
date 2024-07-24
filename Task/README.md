# Table of Contents
- Introduction
- Simple CRUD(Create, Read, Update, Delete)
- Authorisation & Authentication
  
    
# Introduction
An API sample showing how to create a basic Rest API and implement the CRUD operations
using Spring Security OAuth2 with JWT. First you have to obtain a JWT, you can go either to /oauth/token
or to /auth/login, providing client_username:client_password form for http basic authentication as well as post body with username and
password.
Example: POST client1:password@localhost:8080/taskManagement/auth/login
With client1:password as the client credentials. And {"username": "admin": "password":"password"} in the post Body.
For more details and other examples look at the postman_collection.json file attached with this repo

# CRUD Operation
<ol>
	<li> Create Operation : 
		<ul>
		<li>Request : Post Request</li>
		<li>url : http://localhost:8080/taskManagement/api/tasks</li>
		<li>body : 
			{
    		"title": "testing",
    		"description" :"Book an appointment for doctor at 5:30 PM on 23rd JUly 2024"}
    	</li>
    </ul>
    </li>
    <li>Read Operation :
    <ul>
    <li>Request : Get Request</li>
    	<li>url : http://localhost:8080/taskManagement/api/tasks/1</li>
    </ul>
    </li>
    <li>Update Operations :
    <ul>
    <li>Request : Put Request</li>
    	<li>url : http://localhost:8080/taskManagement/api/tasks/1 </li>
    	<li>body :
			{
    		"title": "testing title updated",
    		"description" :"Book an appointment for doctor at 5:30 PM on 23rd JUly 2024"}
    	</li>
    </ul>
    </li>
    <li>Delete Operations :
    <ul>
    <li>Request : Delete Request</li>
    	<li>url : http://localhost:8080/taskManagement/api/tasks/1</li>
    </ul>  
    </li>  
</ol>


# Other Operations 
<ol>
	<li> Get Pending tasks
		<ul>
			<li>Request : Get Request
			</li>
			<li>url :http://localhost:8080/taskManagement/api/tasks/pending
			</li>
		</ul>
	</li>
	<li> Get Completed tasks
		<ul>
			<li>Request : Get Request
			</li>
			<li>url :http://localhost:8080/taskManagement/api/tasks/completed
			</li>
		</ul>
	</li>
	<li> List Of clients for authentication
		<ul>
			<li> Request : Get Request
			</li>
			<li> url :http://localhost:8080/taskManagement/clients
			</li>
		</ul>
	</li> 
	<li> Create User
		<ul>
			<li> Request : Post Request
			</li>
			<li> url :http://localhost:8080/taskManagement/users
			</li>
			<li> Body :{
	"name": "user",
	"password": "password"
}
			</li>
		</ul>
	</li> 
	<li> List Of users for login
		<ul>
			<li> Request : Get Request
			</li>
			<li> url :http://localhost:8080/taskManagement/users
			</li>
		</ul>
	</li>
	<li> Login with Client and User details
		<ul>
			<li> Request : Post Request
			</li>
			<li> url :client1:password@localhost:8080/taskManagement/auth/login
			</li>
			<li> body: {
	"name": "user",
	"password": "password"
}
			</li>
		</ul>
	</li>
</ol>