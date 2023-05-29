package co.edu.javeriana.ws.rest.client;


import java.util.Scanner;

import org.json.JSONObject;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestClientMain {
    public static final String MY_SERVER_URL = "http://localhost:8888/";
    public static Long username = 0L;
    public static String rol = "";

    public static void main(String args[]) {

        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            boolean loggedIn = false;
            String password = "";
            int option = 0;

            while (!exit) {
                if (!loggedIn) {
                    System.out.println("Bienvenido a ECOTURIST:");
                    System.out.println("1. Iniciar sesión");
                    System.out.println("2. Registrarse");
                    System.out.println("3. Cerrar Sesion");
                    System.out.println("4. Salir");
                    option = scanner.nextInt();
                }
                switch (option) {
                    case 1:
                        if (loggedIn) {
                            if (rol.equals("Cliente")) {
                                menuCliente();
                                loggedIn = false;
                                username = 0L;
                                System.out.println("Cierre Exitoso.");

                            } else if (rol.equals("Proveedor")) {
                                menuProveedor();
                                loggedIn = false;
                                username = 0L;
                                System.out.println("Cierre Exitoso.");
                            }
                        } else {
                            System.out.println("Inicia sesión:");
                            System.out.println("Usuario:");
                            Long inputUsername = scanner.nextLong();
                            System.out.println("Contraseña:");
                            String inputPassword = scanner.next();
                            if (authentication(inputUsername, inputPassword).equals("Cliente")) {
                                rol = "Cliente";
                                loggedIn = true;
                                username = inputUsername;
                                System.out.println("Has iniciado sesión exitosamente como cliente.");
                            } else if (authentication(inputUsername, inputPassword).equals("Proveedor")) {
                                rol = "Proveedor";
                                loggedIn = true;
                                username = inputUsername;
                                System.out.println("Has iniciado sesión exitosamente como proveedor.");
                            } else {
                                System.out.println("Nombre de usuario o contraseña incorrecta.");
                            }
                        }
                        break;
                    case 2:
                        if (loggedIn) {
                            System.out.println("Ya has iniciado sesión como " + username + ". Debes cerrar sesión para registrarte con una cuenta diferente.");
                        } else {
                            System.out.println("Cliente o provedor? 1 o 2");
                            int opt = scanner.nextInt();
                            switch (opt) {
                                case 1:
                                    registroCliente();
                                    break;
                                case 2:
                                    registroProveedor();
                                    break;
                                default:
                                    break;
                            }
                        }
                        break;
                    case 3:
                        loggedIn = false;
                        username = 0L;
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


    }

    private static void menuProveedor() {
        try (Scanner scanner = new Scanner(System.in)) {
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

    }

    private static void menuCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
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
                        try {
                            Client client = ClientBuilder.newClient();
                            WebTarget webTarget = client.target(MY_SERVER_URL);
                            WebTarget authWebTarget = webTarget.path("items");
                            WebTarget peticionWebTarget = authWebTarget.queryParam("id", username);
                            Invocation.Builder invocationBuilder = peticionWebTarget.request(MediaType.APPLICATION_JSON);
                            Response response = invocationBuilder.get();
                            //lee contenido textual
                            String lines = response.readEntity(String.class);
                            System.out.println(lines);
                        } catch (Exception e) {
                        }
                        break;
                    case 2:
                        System.out.println("ESCRIBA UN TIPO:");
                        System.out.println("-Alojamiento");
                        System.out.println("-Transporte");
                        System.out.println("-Paseo Ecológico");
                        System.out.println("-Alimentacion");
                        System.out.println("<escriba la cadena>");
                        String nombre = scanner.next();
                        try {
                            Client client = ClientBuilder.newClient();
                            WebTarget webTarget = client.target(MY_SERVER_URL);
                            WebTarget itemsWebTarget = webTarget.path("categoria");

                            // Agregar el parámetro de query "id"
                            WebTarget itemWebTarget = itemsWebTarget.queryParam("nombre", nombre);

                            Invocation.Builder invocationBuilder = itemWebTarget.request(MediaType.APPLICATION_JSON);
                            Response response = invocationBuilder.get();

                            //lee contenido textual
                            String lines = response.readEntity(String.class);
                            System.out.println(lines);
                        } catch (Exception e) {
                        }
                        break;
                    case 3:
                        System.out.println("DIGITE CADENA:");

                        String buscar = scanner.next();
                        try {
                            Client client = ClientBuilder.newClient();
                            WebTarget webTarget = client.target(MY_SERVER_URL);
                            WebTarget itemsWebTarget = webTarget.path("buqueda-items");

                            // Agregar el parámetro de query "id"
                            WebTarget itemWebTarget = itemsWebTarget.queryParam("buscar", buscar);

                            Invocation.Builder invocationBuilder = itemWebTarget.request(MediaType.APPLICATION_JSON);
                            Response response = invocationBuilder.get();

                            //lee contenido textual
                            String lines = response.readEntity(String.class);
                            System.out.println(lines);
                        } catch (Exception e) {
                        }


                        break;
                    case 4:
                        System.out.println("Digite ID del Producto:");
                        int id = scanner.nextInt();
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

    }

    private static void menuProducto(int id) {

        Client client_ = ClientBuilder.newClient();
        WebTarget webTarget_ = client_.target(MY_SERVER_URL);
        WebTarget authWebTarget_ = webTarget_.path("item").queryParam("item", id);
        //crea JSON:

        //realiza peticion
        Invocation.Builder invocationBuilder_ = authWebTarget_.request(MediaType.APPLICATION_JSON);
        Response response_ = invocationBuilder_.get();
        //lee contenido textual
        String infoProducto_ = response_.readEntity(String.class);

        System.out.println("PRODUCTO: ////////\n" + infoProducto_);


        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Opciones-ECOTURIST:");
                System.out.println("1. Publicar Pregunta");
                System.out.println("2. Agregar A Carrito");
                System.out.println("3. Comprar");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Pregunta¿?:");
                        String pregunta = scanner.next();
                        String token = "";
                        try {
                            Client client = ClientBuilder.newClient();
                            WebTarget webTarget = client.target(MY_SERVER_URL);
                            WebTarget authWebTarget = webTarget.path("item-pregunta");
                            //crea JSON:
                            JSONObject registerJson = new JSONObject();
                            registerJson.put("id", id);
                            registerJson.put("user", username);
                            registerJson.put("pregunta", pregunta);
                            String rol = "cliente";
                            registerJson.put("password", rol);
                            //realiza peticion
                            Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
                            Response response = invocationBuilder.put(Entity.entity(registerJson.toString(), MediaType.APPLICATION_JSON));
                            //lee contenido textual
                            token = response.readEntity(String.class);

                        } catch (Exception e) {
                        }
                        System.out.println(token);
                        System.out.println("Pregunta publicada exitosamente.");
                        //preguntar
                        break;
                    case 2:
                        //generar Orden
                        String responses = "";
                        try {
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
                            responses = response.readEntity(String.class);

                        } catch (Exception e) {
                        }
                        System.out.println(responses);
                        System.out.println("Producto agregado a carrito.");

                        break;
                    case 3:
                        //pagar
                        responses = "";
                        System.out.println("Digite codigo de confirmacion Tarjeta:");
                        //String code= scanner.next();
                        scanner.next();
                        System.out.println("Confirmando...");

                        try {
                            Thread.sleep(5000); // Pausa de 5 segundos
                        } catch (InterruptedException e) {
                        }
                        try {
                            Client client = ClientBuilder.newClient();
                            WebTarget webTarget = client.target(MY_SERVER_URL);
                            WebTarget rideWebTarget = webTarget.path("carrito/" + id);

                            Invocation.Builder invocationBuilder = rideWebTarget.request(MediaType.TEXT_PLAIN);
                            Response response = invocationBuilder.delete();

                            System.out.println("RESPONSE FROM SERVER code: " + response.getStatus());
                            System.out.println("Content: " + response.readEntity(String.class));

                        } catch (Exception e) {
                        }
                        System.out.println(responses);
                        System.out.println("Has pagado.");

                        return;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            }
        }


    }

    public static void registroCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
            String age, info, username, password, correo;
            System.out.println("Registro:");
            System.out.println("Nombre Usuario:");
            username = scanner.next();
            System.out.println("Correo: ");
			correo = scanner.next();
            System.out.println("Contraseña:");
            password = scanner.next();
            System.out.println("Edad:");
            age = scanner.next();
            System.out.println("Descripcion:");
            info = scanner.next();

            register(username, password, age, info, correo);
        }

    }

    public static void registroProveedor() {
        try (Scanner scanner = new Scanner(System.in)) {
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
            register(username, password, age, info, telefono, web, redSocial);
        }

    }


    private static Boolean register(String username, String password, String age, String info, String correo) {
        String token = "";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(MY_SERVER_URL);
            WebTarget authWebTarget = webTarget.path("register-cliente");
            //crea JSON:
            JSONObject registerJson = new JSONObject();
            registerJson.put("nombre", username);
            registerJson.put("password", password);
            registerJson.put("edad", age);
            registerJson.put("correo", correo);
            registerJson.put("descripcion", info);
            String rol = "Cliente";
            registerJson.put("rol", rol);
            //realiza peticion
            Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(registerJson.toString(), MediaType.APPLICATION_JSON));
            //lee contenido textual
            token = response.readEntity(String.class);
            if (token.equals("error")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        System.out.println(token);
        System.out.println("Te has registrado exitosamente.");
        return true;
    }

    private static Boolean register(String username, String password, String age, String info, String tel, String web, String social) {
        String token = "";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(MY_SERVER_URL);
            WebTarget authWebTarget = webTarget.path("register-proveedor");
            //crea JSON:
            JSONObject registerJson = new JSONObject();
            registerJson.put("nombre", username);
            registerJson.put("password", password);
            registerJson.put("edad", age);
            registerJson.put("descripcion", info);
            registerJson.put("telefono", tel);
            registerJson.put("pagina_web", web);
            //registerJson.put("social", social);
            String rol = "Proveedor";
            registerJson.put("rol", rol);

            //realiza peticion
            Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(registerJson.toString(), MediaType.APPLICATION_JSON));

            //lee contenido textual
            token = response.readEntity(String.class);
            if (token.equals("error")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        System.out.println(token);
        System.out.println("Te has registrado exitosamente.");
        return true;
    }

    public static String authentication(Long id, String password) {
        String token = "";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target(MY_SERVER_URL);
            WebTarget authWebTarget = webTarget.path("login");
            JSONObject loginJson = new JSONObject();
            loginJson.put("id", id);
            loginJson.put("password", password);
            Invocation.Builder invocationBuilder = authWebTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.entity(loginJson.toString(), MediaType.APPLICATION_JSON));
            token = response.readEntity(String.class);
        } catch (Exception e) {
        }
        System.out.println(token);
        return token;
    }

}


