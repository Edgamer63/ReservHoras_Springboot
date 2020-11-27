package jekmy.proyect.grupo1.Resource;

import jekmy.proyect.grupo1.DAO.FormularioDAO;
import jekmy.proyect.grupo1.DTO.Formulario;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FormularioResource {
    @RequestMapping(method = RequestMethod.PUT, value = "/AceptarHora/{hora}/{dia}/{mes}/{anio}")
    public int aceptarHora(@PathVariable(name = "hora") int hora,
                           @PathVariable(name = "dia") int dia,
                           @PathVariable(name = "mes") int mes,
                           @PathVariable(name = "anio") int anio
    ) throws SQLException {
        int form = new FormularioDAO().aceptarHora(hora,dia,mes,anio);
        return form;
    }

    //Pasaron el test:

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerPeticiones/{email}/")
    public List<Formulario> obtenerPeticiones(@PathVariable(name = "email") String email)
        throws SQLException {
        List<Formulario> form = new FormularioDAO().ObtenerPeticiones(email);
        return form;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerTodasPeticionesNoAceptadas/")
    public List<Formulario> obtenerTodasPeticionesNoAceptadas() throws SQLException {
        List<Formulario> form = new FormularioDAO().ObtenerTodasPeticionesNoAceptadas();
        return form;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerTodasPeticionesAceptadas/")
    public List<Formulario> obtenerTodasPeticionesAceptadas() throws SQLException {
        List<Formulario> form = new FormularioDAO().ObtenerTodasPeticionesAceptadas();
        return form;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerTodasPeticiones/")
    public List<Formulario> obtenerTodasPeticiones() throws SQLException {
        List<Formulario> form = new FormularioDAO().ObtenerTodasPeticiones();
        return form;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerHora/{hora}/{dia}/{mes}/{anio}")
    public int obtenerHora(@PathVariable(name = "hora") int hora,
                           @PathVariable(name = "dia") int dia,
                           @PathVariable(name = "mes") int mes,
                           @PathVariable(name = "anio") int anio
    ) throws SQLException {
        int form = new FormularioDAO().obtenerHora(hora,dia,mes,anio);
        return form;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/IngresarPeticiones/{correo}/{dia}/{mes}/{anio}/{hora}/{seleccion}/{servicio_contratacion}/{servicio_actualizacion}")
    public int IngresarPeticiones(@PathVariable(name = "correo") String correo,
                                  @PathVariable(name = "dia") int dia,
                                  @PathVariable(name = "mes") int mes,
                                  @PathVariable(name = "anio") int anio,
                                  @PathVariable(name = "hora") int hora,
                                  @PathVariable(name = "seleccion") int seleccion,
                                  @PathVariable(name = "servicio_contratacion") int servicio_contratacion,
                                  @PathVariable(name = "servicio_actualizacion") int servicio_actualizacion) throws SQLException {
        new FormularioDAO().IngresoPeticion(correo,dia,mes,anio,hora,seleccion,servicio_contratacion,servicio_actualizacion);
        return 1;
    }
}
