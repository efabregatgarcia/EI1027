package es.uji.ei1027.toopots.util;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import es.uji.ei1027.toopots.domain.*;
import es.uji.ei1027.toopots.dao.*;

public class EnviaCorreo {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	private ActividadDao actividadDao;

	public void generateAndSendEmail(Reserva reserva, Cliente cliente, String tipo) throws AddressException, MessagingException {
 
		System.out.println("\n 1st ===> setup Mail Server Properties...");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		System.out.println("\n\n 2nd ===> get Mail Session...");
		getMailSession = Session.getInstance(mailServerProperties);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(cliente.getEmail()));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("naturAdventure@gmail.com"));
		String emailBody = "";
		if(tipo.equals("A")) {
			generateMailMessage.setSubject("NaturAdventure: confirmación reserva");
			emailBody = "La administración de NatureAdventure le confirma que su reserva realizada el día "+reserva.getFechaReserva()+" ha sido aceptada. " + "<br><br>"
					+ "A continuación le facilitamos los detalles de la transacción: <br/> "
					+ "<ul>"
					+ "<li> Nombre y apellidos cliente: "+cliente.getNombre() + " "+cliente.getApellidos()+"</li>"
					+ "<li> E-mail: "+cliente.getEmail()+"</li>"
					+ "<li> Actividad: "+actividadDao.getActividad(reserva.getId_actividad()).getNombre()+"</li>"
					+ "<li> Fecha de la actividad: "+reserva.getFechaActividad()+"</li>"
					+ "<li> Cantidad personas: "+reserva.getNumParticip()+"</li>"
					+ "<li> Precio Total (con I.V.A): <strong>"+actividadDao.getActividad(reserva.getId_actividad()).getPrecioPorPersona() * reserva.getNumParticip()+"€</strong></li>"
					+ "</ul>"
					+ "Gracias por confiar en NaturAdventure. <br/> Reciba un coordial saludo, <br/> La dirección de NaturAdventure";	
		}else{
			generateMailMessage.setSubject("NaturAdventure: reserva cancelada");

			emailBody = "La administración de NatureAdventure lamenta comunicarle que la actividad no ha podido ser aceptada debido a la falta de disponibilidad de los monitores. <br/>"
							+ "Se le ha devuelto el importe íntegro de la reserva <br/>"+
					"Lamentamos que no pueda disfrutar de la actividad deseada y le invitamos a que siga comprando en nuestra plataforma.";
					
			}
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully...");

		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		
		transport.connect("smtp.gmail.com", "naturAdventure@gmail.com", "passwd");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());

		transport.close();
	}

}
