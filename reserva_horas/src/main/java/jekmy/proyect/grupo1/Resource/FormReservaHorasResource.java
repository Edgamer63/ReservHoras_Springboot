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

        String emailcontent_="<body>\n" +
                "    <table style=\"max-width: 600px; padding: 10px; margin: 0 auto; border-collapse: collapse;\">\n" +
                "\n" +
                "        <tr>\n" +
                "            <td style=\"padding: 0\">\n" +
                "\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"background-color: #ecf0f1\">\n" +
                "                <div style=\"color: cornflowerblue; margin: 4% 10% 2%; text-align: justify;font-family: sans-serif\">\n" +
                "                    <h2 style=\"color: blue; margin: 0 0 7px\">¡Bienvenid@ a JEKMY!</h2>\n" +
                "                    <p style=\"margin: 2px; font-size: 15px\">\n" +
                "                        Hola, te damos la bienvenida, este correo es solo un recordatorio de que te has registrado\n" +
                "                        exitosamente en nuestra plataforma. <br>\n" +
                "                        ¡Enhorabuena! <br>\n" +
                "                        Nuestra plataforma cuenta con un sistema de reserva de horas para una mejor atención y cuidado\n" +
                "                        de nuestros clientes. <br>\n" +
                "                        Contamos con los siguientes servicios para usted:\n" +
                "                    </p>\n" +
                "                    <ul style=\"font-size: 15px;  margin: 10px 0\">\n" +
                "                        <li>Reparación, recuperación de datos y cambio de discos duros.</li>\n" +
                "                        <li>Instalación de programas y formateo de equipos.</li>\n" +
                "                        <li>Armado de equipos y cotizaciones.</li>\n" +
                "                        <li>Inclusión de nuevos elementos de hardware.</li>\n" +
                "                        <li>¡Entre muchos otros servicios informáticos!.</li>\n" +
                "                    </ul>\n" +
                "                    <div style=\"width: 100%;margin:20px 0; display: inline-block;text-align: center\">\n" +

                "                    </div>\n" +
                "                 \n" +
                "                    <p style=\"color: #b3b3b3; font-size: 12px; text-align: center;margin: 30px 0 0\">JEKMY 2020</p>\n" +
                "                </div>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "\n" +
                "\n" +
                "    </table>";
        emailcontent_+="\n";


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