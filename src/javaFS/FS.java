Java Web Apps - Spring framework
---------------------------------------------------------
Dependencies required: Spirng web, DevTool (live reload)

Application.properties ---> change the port --> Server.port=8081
        ------------------
@Controller
public class SayHelloController{

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello how are you";
    }
}

@RequestMapping("say-hello-html")
@ResponseBody
public String sayHelloHTML(){

    StringBuffer sb=new StringBuffer();
    sb.append("<html>");
    sb.append("<head>");
    sb.append("<title>My first HTML page </title>");
    sb.append("</head>");
    ---
    return sb;
}
}

        ---------------------------------
JSP - Java Server Pages - view file

resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp

@RequestMapping("say-hello-jsp")
//@ResponseBody x - not required
public String sayHelloJSP(){
    return "sayHello";
}
}

Application.properties -> add prefix and suffix
spring.mvc.view.prefix=/WEB-INF/jsp
spring.mvc.view.suffix=.jsp
logging.level.org.springframework=debug

Note: Tomcat need to be embedded via pom.xml

----------------------------------

Login JSP


@Controller
public class LoginController{

    @RequestMapping("login")
    public String gotoLogin(){
        return "login";
    }
}

creat JSP is same folder
http://localhost:8080/login
        ---------------------------------

Login JSP with QueryParameter an show in jsp page with the help of ModelMap
http://localhost:8080/login?name=praveen

@Controller
public class LoginController{

    @RequestMapping("login")
    public String gotoLogin(@RequestParam String name, ModelMap model){
        model.put("name",name);
        return "login";
    }
}

in JSP: expression language --  ${name}

--------------------------------------

Logger:

private Logger logger=loggerFactory.getLogger(getClass());

inside method
	logger.debug("requestparam is {}", name);
	logger.info("requestparam is {}", name);
	logger.warn("requestparam is {}", name);

---------------------------------------

Model 1 - all we wrote in JSPs -- difficult to manage
Model 2 - MVC -simpler to maintain

Mode - data to generate to view
View - show data to user
Controller - control the flow

front controller - control the flow for MVC

-----------------------
<form method="post"> -- so parameter wont show in url
Name: <input type="text" name="name">
password: <input type="password" name="password">
</form>


@Controller
public class LoginController{

    @RequestMapping("login",method=RequestMethod.GET)
    public String gotoLogin(){
        return "login";
    }

    @RequestMapping("login",method=RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap map){
        map.put("name", name);
        map.put("password", password);
        return "Welcome";
    }
}

-------------------------------------
Authenticationlogic

Create separate class fo this as retun bool with name and password mathcing

@Controller
public class LoginController{

    private Authenticationlogic Authenticationlogic;

    public LoginController(Authenticationlogic Authenticationlogic){
        this.Authenticationlogic=Authenticationlogic;
    }

    @RequestMapping("login",method=RequestMethod.GET)
    public String gotoLogin(){
        return "login";
    }

    @RequestMapping("login",method=RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap map){

        if(Authenticationlogic.authenticate(name. password)){
            map.put("name", name);
            map.put("password", password);
            return "Welcome";
        }
        else
        {
            map.put("errorMessage","Invalid Login");
            return "login";
        }
    }
}

logn.jpa --> <pre>${errorMessage}</pre>

        --------------
todo.java - have all fields reuqired - schema kind

todo service - Create a list and add values to it - creation/db side

todoController - return "listToDos" amd add model map.getAttribute("todo",todo)

listToDos.jpa -- ${todo}

-------------

Here login details will not be saved and if we go to other pages then it will lost

so, we need to use @SessionAttributes("name") in all controller where n all required below @Controller

---------
Expression launguage ${} for simple single values
JSTL, glassfidh-jstl and taglib under jsp page to write more complex values

taglib with prefix and url - c is prefix here

<table>
	<thead>
		<tr>
		<th>id</td>
		<th>description<th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${todos}" var="todo"
		<tr>
<td> ${todo.id} </td>
		</tr>
	</tbody>

</table>
        ------------
use bootstrap 5 to format - dependency under pom.xml
bootstrap.min.css
bootstrap.min.js

        <head>
<link href=".css" rel="stylsheet"
        --start


--end
        <script src=".js"> </script>
<script src="jQuery.min.js"> </script>

</body>
        -----------
Entire body of the page should be under <div class="container"> for bootstrap
        <table class="table">

class="btn btn-success" - for button

redirect can be done - return "redirect:list-todos"
        -----
