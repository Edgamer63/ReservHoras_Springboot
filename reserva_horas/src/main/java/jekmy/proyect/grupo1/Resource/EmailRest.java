package jekmy.proyect.grupo1.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/email")
@CrossOrigin(origins = "http://localhost:4200")
public class EmailRest {

    @Autowired
    private EmailPort emailPort;

    @PostMapping(value = "/send")
    @ResponseBody
    public boolean SendEmail(@RequestBody EmailBody emailBody)  {
        return emailPort.sendEmail(emailBody);
    }

    @PostMapping(value = "/send_test1/{email}/")
    @ResponseBody
    public boolean Test1(@PathVariable (name = "email") String email)  {

        EmailBody emailBody = new EmailBody();
        emailBody.setEmail(email);
        emailBody.setSubject("¡Bienvenid@ al servicio de Reserva de Horas de JEKMY!");
        String emailcontent_="Hola, te damos la bienvenida, este correo es solo un recordatorio de que te has registrado exitosamente a nuestro servicio.";
        emailcontent_+="\n";
        emailcontent_+="¡Enhorabuena! .";

        emailBody.setContent(emailcontent_);
        return emailPort.sendEmail(emailBody);
    }

    @PostMapping(value = "/send_test2/{email}/")
    @ResponseBody
    public boolean Test2(@PathVariable (name = "email") String email)  {

        EmailBody emailBody = new EmailBody();
        emailBody.setEmail(email);
        emailBody.setSubject("._.xD");
        String emailcontent_="._.xD";

        emailBody.setContent(emailcontent_);
        return emailPort.sendEmail(emailBody);
    }


}