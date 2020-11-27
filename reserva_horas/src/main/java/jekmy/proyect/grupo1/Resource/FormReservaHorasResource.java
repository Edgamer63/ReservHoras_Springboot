package jekmy.proyect.grupo1.Resource;

import jekmy.proyect.grupo1.DAO.FormReservaHorasDAO;
import jekmy.proyect.grupo1.DTO.FormReservaHoras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormReservaHorasResource {
    @RequestMapping(method = RequestMethod.GET, value = "/obtenerUsuariosxEmail/{email}")
    public FormReservaHoras ObtenerUsuarios(@PathVariable(name = "email") String email) throws SQLException {
        FormReservaHoras uwu = (FormReservaHoras) new FormReservaHorasDAO().ObtenerUsuarios(email);
        return uwu;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login/{email}/{pass}")
    public int login(@PathVariable(name = "email") String email,@PathVariable(name = "pass") String pass) throws SQLException {
        int log = (int) new FormReservaHorasDAO().login(email,pass);
        return log;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/checkUser/{email}")
    public int checkUser(@PathVariable(name = "email") String email) throws SQLException {
        int log = (int) new FormReservaHorasDAO().userExists(email);
        return log;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/isAdmin/{email}/{pass}")
    public int isAdmin(@PathVariable(name = "email") String email,@PathVariable(name = "pass") String pass) throws SQLException {
        int log = (int) new FormReservaHorasDAO().is_Admin(email,pass);
        return log;
    }

    @Autowired
    private EmailPort emailPort;


    @RequestMapping(method = RequestMethod.POST, value = "/RegistroUsuarios/{Nombre_Completo}/{Email}/{Telefono}/{Pass}")
    public int RegistroUsuarios(@PathVariable (name = "Nombre_Completo") String Nombre_completo,@PathVariable (name = "Email") String Email,@PathVariable (name = "Telefono") String Telefono, @PathVariable (name = "Pass") String pass) throws SQLException {

        EmailBody emailBody = new EmailBody();
        emailBody.setEmail(Email);
        emailBody.setSubject("¡Bienvenid@ al servicio de Reserva de Horas de JEKMY!");

        String emailcontent_="Hola, te damos la bienvenida, este correo es solo un recordatorio de que te has registrado exitosamente a nuestro servicio.";
        emailcontent_+="\n";
        emailcontent_+="¡Enhorabuena! .";

        emailBody.setContent(emailcontent_);
        emailPort.sendEmail(emailBody);

        new FormReservaHorasDAO().RegistroUsuarios(Nombre_completo, Email, Telefono, pass);
        return 1;
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/BorrarUsuarios/{email}/")
    public void BorrarUsuarios (@PathVariable (name = "email") String email) throws SQLException{
        new FormReservaHorasDAO().BorrarPeticion(email);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/ActualizarPass/{email}/{pass}/")
    public void ActualizarPass(@PathVariable (name = "email") String email,
                               @PathVariable (name = "pass") String pass) throws SQLException{
        new FormReservaHorasDAO().ActualizarPass(email,pass);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/ActualizarTelefono/{email}/{telefono}/")
    public void ActualizarTelefono(@PathVariable(name = "email") String email,
                                   @PathVariable(name = "telefono") String telefono) throws SQLException {
        new FormReservaHorasDAO().ActualizarTelefono(email,telefono);
    }
}
