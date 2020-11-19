package jekmy.proyect.grupo1.Resource;

import jekmy.proyect.grupo1.Resource.EmailBody;

public interface EmailPort {
    public boolean sendEmail(EmailBody emailBody);
}