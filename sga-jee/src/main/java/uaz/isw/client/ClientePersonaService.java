package uaz.isw.client;

import java.util.List;
import javax.naming.*;
import uaz.isw.domain.Persona;
import uaz.isw.service.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente...");
        try {
            Context jndi = new InitialContext();
            //Buscamos nuestro componente EJB del lado del servidor
            PersonaServiceRemote personaService =(PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!uaz.isw.service.PersonaServiceRemote");
            //Obtenemos la lista de personas por medio del metodo listarPeronas de la interfaz remota
            List<Persona>personas=personaService.listarPersonas();
            for(Persona persona:personas){
                System.out.println(persona);
            }
            System.out.println("\nFin de la llamada al EJB desde el cliente...");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
