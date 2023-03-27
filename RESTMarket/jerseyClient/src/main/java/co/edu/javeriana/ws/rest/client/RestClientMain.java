package co.edu.javeriana.ws.rest.client;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javassist.bytecode.stackmap.BasicBlock.Catch;

public class RestClientMain {
	public static final String MY_SERVER_URL="http://localhost:8888/";
	public static String username = "";
	public static void main(String args[]){
	
		Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean loggedIn = false;
        String password = "";

        while (!exit) {
            System.out.println("Bienvenido a ECOTURIST:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Cerrar Sesion");
			System.out.println("4. Salir");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (loggedIn) {
                        if (authentication(username, password).equals("cliente")) {
                            menuCliente();
							loggedIn=false;
							username="";
							System.out.println("Cierre Exitoso.");
                            
                        }else if (authentication(username, password).equals("proveedor")) {
                            menuProveedor();
							loggedIn=false;
							username="";
							System.out.println("Cierre Exitoso.");
                        }
                    } else {
                        System.out.println("Inicia sesión:");
                        System.out.println("Usuario:");
                        String inputUsername = scanner.next();
                        System.out.println("Contraseña:");
                        String inputPassword = scanner.next();
                        if (authentication(inputUsername, inputPassword).equals("cliente")) {
                            loggedIn = true;
							username=inputUsername;
                            System.out.println("Has iniciado sesión exitosamente como cliente.");
                        }else if (authentication(inputUsername, inputPassword).equals("proveedor")) {
                            loggedIn = true;
							username=inputUsername;
                            System.out.println("Has iniciado sesión exitosamente como proveedor.");
                        }
						else {
                            System.out.println("Nombre de usuario o contraseña incorrecta.");
                        }
                    }
                    break;
                case 2:
                    if (loggedIn) {
                        System.out.println("Ya has iniciado sesión como " + username + ". Debes cerrar sesión para registrarte con una cuenta diferente.");
                    } else {
						registroCliente();
                    }
                    break;
                case 3:
					loggedIn=false;
					username="";
                    System.out.println("Cierre Exitoso.");
                    break;
				case 4:
					exit = true;
					System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
		
		
		
		
	}

	private static void menuProveedor() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
            System.out.println("Opciones-ECOTURIST:");
            System.out.println("1. Agregar Producto");
            System.out.println("0. Cerrar Sesion");
           
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    //crear producto.
                    break;
                case 0:
					return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }

	}

	private static void menuCliente() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
            System.out.println("Opciones-ECOTURIST:");
            System.out.println("1. Ver Productos");
            System.out.println("2. Filtrar por Categoria");
			System.out.println("3. Buscar por cadena de texto");
			System.out.println("4. Ver un producto");
			System.out.println("5. Cerrar Sesion");


            int option = scanner.nextInt();

            switch (option) {
                case 1:
						try{
							Client client = ClientBuilder.newClient();
							WebTarget webTarget = client.target(MY_SERVER_URL);
							WebTarget authWebTarget = webTarget.path("items");

							Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
							Response response = invocationBuilder.get();
							//lee contenido textual
							String lines=response.readEntity(String.class);
							System.out.println(lines);
						}catch(Exception e){}
					break;
                case 2:
						System.out.println("SELECCIONE UN TIPO:");
						System.out.println("1. Alojamiento");
						System.out.println("2. Transporte");
						System.out.println("3. Paseo Turistico");
						System.out.println("4. Ver un producto");
						System.out.println("5. Ver un producto");
						int tipoItem = scanner.nextInt();
						try{
							Client client = ClientBuilder.newClient();
							WebTarget webTarget = client.target(MY_SERVER_URL);
							WebTarget itemsWebTarget = webTarget.path("items");

							// Agregar el parámetro de query "id"
							WebTarget itemWebTarget = itemsWebTarget.queryParam("id", tipoItem);

							Invocation.Builder invocationBuilder = itemWebTarget.request(MediaType.APPLICATION_JSON);
							Response response = invocationBuilder.get();

							//lee contenido textual
							String lines=response.readEntity(String.class);
							System.out.println(lines);
						}catch(Exception e){}
					break;
				case 3:
					System.out.println("DIGITE CADENA:");
						
						String buscar = scanner.next();
						try{
							Client client = ClientBuilder.newClient();
							WebTarget webTarget = client.target(MY_SERVER_URL);
							WebTarget itemsWebTarget = webTarget.path("buqueda-items");

							// Agregar el parámetro de query "id"
							WebTarget itemWebTarget = itemsWebTarget.queryParam("id", buscar);

							Invocation.Builder invocationBuilder = itemWebTarget.request(MediaType.APPLICATION_JSON);
							Response response = invocationBuilder.get();

							//lee contenido textual
							String lines=response.readEntity(String.class);
							System.out.println(lines);
						}catch(Exception e){}


					break;
				case 4:
					System.out.println("Digite ID del Producto:");
					int id=scanner.nextInt();
					menuProducto(id);//preguntar o añadir a carrito
					break;
					
				case 5:




					return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }

	}

	private static void menuProducto(int id) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
            System.out.println("Opciones-ECOTURIST:");
            System.out.println("1. Publicar Pregunta");
            System.out.println("2. Agregar A Carrito");
			System.out.println("3. Comprar");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
					System.out.println("Pregunta¿?:");
					String pregunta= scanner.next();
					String token="";
						try{
							Client client = ClientBuilder.newClient();
							WebTarget webTarget = client.target(MY_SERVER_URL);
							WebTarget authWebTarget = webTarget.path("item-pregunta");
							//crea JSON:
							JSONObject registerJson = new JSONObject();			
							registerJson.put("id", id);
							registerJson.put("user", username);
							registerJson.put("pregunta", pregunta);
							String rol="cliente";
							registerJson.put("password", rol);
							//realiza peticion
							Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
							Response response = invocationBuilder.put(Entity.entity(registerJson.toString(), MediaType.APPLICATION_JSON));
							//lee contenido textual
							token=response.readEntity(String.class);
							
						}catch(Exception e){}
						System.out.println(token);
						System.out.println("Pregunta publicada exitosamente.");
                    //preguntar
                    break;
                case 2:
					//generar Orden
					String responses="";
						try{
							Client client = ClientBuilder.newClient();
							WebTarget webTarget = client.target(MY_SERVER_URL);
							WebTarget authWebTarget = webTarget.path("orden");
							//crea JSON:
							JSONObject registerJson = new JSONObject();			
							registerJson.put("id", id);
							registerJson.put("user", username);
							//realiza peticion
							Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
							Response response = invocationBuilder.post(Entity.entity(registerJson.toString(), MediaType.APPLICATION_JSON));
							//lee contenido textual
							responses=response.readEntity(String.class);
							
						}catch(Exception e){}
						System.out.println(responses);
						System.out.println("Producto agregado a carrito.");

					break;
				case 3:
					//pagar
					responses="";
					System.out.println("Digite codigo de confirmacion Tarjeta:");
					String code= scanner.next();
					System.out.println("Confirmando...");

					try {
						Thread.sleep(5000); // Pausa de 5 segundos
					} catch (InterruptedException e) {}
						try{
							Client client = ClientBuilder.newClient();
							WebTarget webTarget = client.target(MY_SERVER_URL);
							WebTarget rideWebTarget = webTarget.path("carrito/"+id);

							Invocation.Builder invocationBuilder = rideWebTarget.request(MediaType.TEXT_PLAIN);
							Response response = invocationBuilder.delete();

							System.out.println("RESPONSE FROM SERVER code: "+response.getStatus());
							System.out.println("Content: "+response.readEntity(String.class));
							
						}catch(Exception e){}
						System.out.println(responses);
						System.out.println("Has pagado.");

					return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }


	}

	public static void registroCliente(){
		Scanner scanner = new Scanner(System.in);
		String age, info, username, password;
                        System.out.println("Registro:");
                        System.out.println("Nombre Usuario:");
                        username = scanner.next();
                        System.out.println("Contraseña:");
                        password = scanner.next();
						System.out.println("Edad:");
                        age = scanner.next();
						System.out.println("Descripcion:");
                        info = scanner.next();
                        
						register(username, password,age, info);

	}

	public static void registroProveedor(){
		Scanner scanner = new Scanner(System.in);

		String age, info, username, password, telefono, web, redSocial;
                        System.out.println("Registro: ");
                        System.out.println("Nombre Usuario: ");
                        username = scanner.next();
                        System.out.println("Contraseña: ");
                        password = scanner.next();
						System.out.println("Edad: ");
                        age = scanner.next();
						System.out.println("Descripcion: ");
                        info = scanner.next();
						System.out.println("Telefono : +57 ");
                        telefono = scanner.next();
						System.out.println("Web: ");
                        web = scanner.next();
						System.out.println("redSocial: ");
                        redSocial = scanner.next();                    
						register(username, password,age, info, telefono, web, redSocial);

	}


	private static Boolean register(String username, String password, String age, String info) {
		String token="";
		try{
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target(MY_SERVER_URL);
			WebTarget authWebTarget = webTarget.path("register-cliente");
			//crea JSON:
			JSONObject registerJson = new JSONObject();			
			registerJson.put("user", username);
			registerJson.put("password", password);
			registerJson.put("password", age);
			registerJson.put("password", info);
			String rol="cliente";
			registerJson.put("password", rol);
			//realiza peticion
			Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.post(Entity.entity(registerJson.toString(), MediaType.APPLICATION_JSON));
			//lee contenido textual
			token=response.readEntity(String.class);
			if(token.equals("error")){
				return false;
			}
		}catch(Exception e){
			return false;
		}
		System.out.println(token);
		System.out.println("Te has registrado exitosamente.");
		return true;
	}

	private static Boolean register(String username, String password, String age, String info, String tel, String web, String social) {
		String token="";
		try{
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target(MY_SERVER_URL);
			WebTarget authWebTarget = webTarget.path("register-cliente");
			//crea JSON:
			JSONObject registerJson = new JSONObject();			
			registerJson.put("user", username);
			registerJson.put("password", password);
			registerJson.put("password", age);
			registerJson.put("password", info);
			registerJson.put("password", tel);
			registerJson.put("password", web);
			registerJson.put("password", social);
			String rol="proveedor";
			registerJson.put("password", rol);

			//realiza peticion
			Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.post(Entity.entity(registerJson.toString(), MediaType.APPLICATION_JSON));

			//lee contenido textual
			token=response.readEntity(String.class);
			if(token.equals("error")){
				return false;
			}
		}catch(Exception e){
			return false;
		}
		System.out.println(token);
		System.out.println("Te has registrado exitosamente.");
		return true;
	}

	public static String authentication(String user, String password) {
		String token="";
		try{
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target(MY_SERVER_URL);
			WebTarget authWebTarget = webTarget.path("login");
			JSONObject loginJson = new JSONObject();			
			loginJson.put("user", user);
			loginJson.put("password", password);			
			Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.post(Entity.entity(loginJson.toString(), MediaType.APPLICATION_JSON));
			token=response.readEntity(String.class);
		}catch(Exception e){}
		System.out.println(token);
		return token;
	}		

}


