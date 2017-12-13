import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
	public static void main(String[] args) {
		staticFileLocation("/public");
		String layout ="templates/layout.vtl";
		System.out.println("we are ready to start");

		    ProcessBuilder process = new ProcessBuilder();
		     Integer port;
		     if (process.environment().get("PORT") != null) {
		         port = Integer.parseInt(process.environment().get("PORT"));
		     } else {
		         port = 4567;
		     }
		    setPort(port);

		    //somethings to do with port issues

		    get("/",(request,response)->{
		    	Map<String,Object> model= new HashMap<String,Object>();
		    	model.put("template","templates/insertnewhero.vtl");
		    	return new ModelAndView(model,layout);
		    }, new VelocityTemplateEngine());


		    //handling post requests

		    post("/newhero",(request,response)->{
		    	Map <String,Object> model = new HashMap<String,Object>();
		    	String name =request.queryParams("name");
		    	int age = Integer.parseInt(request.queryParams("age"));
		    	String specialpowers =request.queryParams("specialpowers");
		    	String weakness =request.queryParams("weakness");

		    	Hero newHero = new Hero(name,age,specialpowers,weakness);

		    	// System.out.println(newHero.getSpecialpowers());
		    	// System.out.println(newHero.getSpecialpowers());

		    	model.put("template","templates/success.vtl");

		    	return new ModelAndView(model,layout);
		    },new VelocityTemplateEngine());

		    //end  of handling post requests


		    //retrieving all heroes

		    get("/heros",(request,response)->{
		    	Map <String,Object> model = new HashMap<String,Object>();
		    	model.put("heros",Hero.all());
		    	model.put("template","templates/heros.vtl");
		    	return new ModelAndView(model,layout);
		    },new VelocityTemplateEngine());
	}
}