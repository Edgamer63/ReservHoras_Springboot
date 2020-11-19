package jekmy.proyect.grupo1.Resource;


import jekmy.proyect.grupo1.DAO.FormReservaHorasDAO;
import jekmy.proyect.grupo1.DTO.Correo_body;
import jekmy.proyect.grupo1.DTO.FormReservaHoras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/api")
@RestController
public class FormReservaHorasResource {
    @RequestMapping(method = RequestMethod.GET, value = "/obtenerUsuariosxEmail/{email}")
    public FormReservaHoras ObtenerUsuarios(@PathVariable(name = "email") String email) throws SQLException {
        FormReservaHoras uwu = (FormReservaHoras) new FormReservaHorasDAO().ObtenerUsuarios(email);
        return uwu;
    }

    @Autowired
    private EmailPort emailPort;


    @RequestMapping(method = RequestMethod.POST, value = "/RegistroUsuarios/")
    public FormReservaHoras RegistroUsuarios(@RequestBody FormReservaHoras FHR) throws SQLException {
        new FormReservaHorasDAO().RegistroUsuarios(FHR);

        EmailBody emailBody = new EmailBody();
        emailBody.setEmail(FHR.getEmail());
        emailBody.setSubject("¡Bienvenid@ al servicio de Reserva de Horas de JEKMY!");

        String emailcontent_="Hola, te damos la bienvenida, este correo es solo un recordatorio de que te has registrado exitosamente a nuestro servicio.";
        emailcontent_+="\n";
        emailcontent_+="¡Enhorabuena! .";

        emailBody.setContent(emailcontent_);
        emailPort.sendEmail(emailBody);

        return FHR;
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/BorrarUsuarios/{email}")
    public void BorrarUsuarios (@RequestBody Correo_body F) throws SQLException{
        new FormReservaHorasDAO().BorrarPeticion(F);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/ActualizarPass/{pass}")
    public void ActualizarPass(@PathVariable (name = "pass") String pass,
                               @RequestBody FormReservaHoras F) throws SQLException{
        new FormReservaHorasDAO().ActualizarPass(pass, F);


    }
    @RequestMapping(method = RequestMethod.PUT, value = "/ActualizarTelefono/{telefono}")
    public void ActualizarTelefono(@PathVariable(name = "telefono") String telefono,
                                   @RequestBody FormReservaHoras F) throws SQLException {
        new FormReservaHorasDAO().ActualizarTelefono(telefono, F);
    }
}
