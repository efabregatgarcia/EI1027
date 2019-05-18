package es.uji.ei1027.toopots;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.uji.ei1027.toopots.dao.UsuarioDao;
import es.uji.ei1027.toopots.model.Actividad;
import es.uji.ei1027.toopots.model.Cliente;
import es.uji.ei1027.toopots.model.Instructor;
import es.uji.ei1027.toopots.model.RegistroInstructor;
import es.uji.ei1027.toopots.model.Reserva;
import es.uji.ei1027.toopots.model.Usuario;
import nz.net.ultraq.thymeleaf.LayoutDialect;

import javax.sql.DataSource;

@Configuration
public class ToopotsConfiguration {
	

    // Configura l'accés a la base de dades (DataSource)
    // a partir de les propietats a src/main/resources/applications.properties
    // que comencen pel prefix spring.datasource
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
    
 
 



}
