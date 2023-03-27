// package puj.proyecto.ms.usuarios.database;

// import java.math.BigDecimal;
// import java.util.Date;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Profile;

// import jakarta.transaction.Transactional;
// import puj.proyecto.ms.usuarios.model.Cliente;
// import puj.proyecto.ms.usuarios.model.ClienteMetodoPago;
// import puj.proyecto.ms.usuarios.model.MetodoPago;
// import puj.proyecto.ms.usuarios.repository.ClienteMetodoPagoRepository;
// import puj.proyecto.ms.usuarios.repository.ClienteRepository;
// import puj.proyecto.ms.usuarios.repository.MetodoPagoRepository;

// @Configuration
// @Profile("default")
// public class DataInit implements CommandLineRunner {
//     @Autowired
//     private ClienteRepository clienteRepository;

//     @Autowired
//     private MetodoPagoRepository metodoPagoRepository; 

//     @Autowired
//     private ClienteMetodoPagoRepository clienteMetodoPagoRepository; 

    
//     @Override
//     @Transactional
//     public void run(String... args) throws Exception {
//         Date fecha = new Date(2022-23-12);
//         Date fecha2 = new Date(2002-23-12);

//         Cliente cliente = clienteRepository.save(new Cliente("Juan", "juanito@gmail.com", "juanrap", 13, "myselft", "no sé subir fotos"));
//         MetodoPago metodo = metodoPagoRepository.save(new MetodoPago("Efectivo"));
//         clienteMetodoPagoRepository.save(new ClienteMetodoPago(metodo, cliente));

//         // Libro libro2 = libroRepository.save(new Libro("El sargento", "POEIRE2323"));
//         // Persona autor2 = autorRepository.save(new Persona("Olga Rocío"));
//         // libroAutorRepository.save(new LibroAutor(libro2, autor2));

//         // Persona persona1 = personaRepository.save(new Persona("Juanito"));

//         // LibroFisico libFis = libroFisicoRepository.save(new LibroFisico(BigDecimal.valueOf(200), "Un bueno libro"));

//         // prestamoRepository.save(new Prestamo(fecha, fecha2, persona1, libFis));
//     }

// }