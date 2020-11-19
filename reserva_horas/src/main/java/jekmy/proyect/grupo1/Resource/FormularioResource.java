package jekmy.proyect.grupo1.Resource;

import jekmy.proyect.grupo1.DAO.FormularioDAO;
import jekmy.proyect.grupo1.DTO.Formulario;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")

public class FormularioResource {

    @RequestMapping(method = RequestMethod.GET, value = "/ObtenerPeticiones/{email}")
    public Formulario obtenerPeticiones(@PathVariable(name = "email") String email)
        throws SQLException {
        Formulario form = new FormularioDAO().ObtenerPeticiones(email);
        return form;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/ingresoPeticiones/")
    public Formulario IngresarPeticiones(@RequestBody Formulario f) throws SQLException {
        new FormularioDAO().IngresoPeticion(f);
        return f;
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/ActualizarDatos/{dia}/{mes}/" +
            "{anio}/{seleccion}/{servicio_contratacion}/{servicio_actualizacion}/" +
            "{otro}/")
    public void ActualizarDatos(@PathVariable(name = "dia") int dia,
                                @PathVariable(name = "mes") int mes,
                                @PathVariable(name = "anio") int anio,
                                @PathVariable(name = "seleccion") String seleccion,
                                @PathVariable(name = "servicio_contratacion") String servicio_contratacion,
                                @PathVariable(name = "servicio_actualizacion") String servicio_actualizacion,
                                @PathVariable(name = "otro") String otro,
                                @RequestBody Formulario f) throws SQLException {
        new FormularioDAO().ActualizarDatos(dia, mes, anio, seleccion, servicio_contratacion,
                servicio_actualizacion, otro, f);
    }
}
