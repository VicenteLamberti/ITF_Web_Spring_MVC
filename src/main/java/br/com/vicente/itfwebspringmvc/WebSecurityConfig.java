//package br.com.vicente.itfwebspringmvc;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http
//		.authorizeRequests()
//			.anyRequest().authenticated()
//		.and()
//			.httpBasic();
//	}
//	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		UserDetails user =
//					User.withDefaultPasswordEncoder()
//					.username("vicente")
//					.password("vicente")
//					.roles("ADM")
//					.build();
//		return new InMemoryUserDetailsManager(user);
//	}
//}








package br.com.vicente.itfwebspringmvc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
			.anyRequest().authenticated()
		.and()
			.formLogin(form -> form
							.loginPage("/login")
//							.defaultSuccessUrl("/lancamento/cadastrar",true)
							.defaultSuccessUrl("/home",true)
							.permitAll()
							)
							.logout(logout -> logout.logoutUrl("/logout"));
	}
	
//	Assim é pra usar em memória
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		UserDetails user =
//					User.withDefaultPasswordEncoder()
//					.username("vicente")
//					.password("vicente")
//					.roles("ADM")
//					.build();
//		return new InMemoryUserDetailsManager(user);
//	}
	
	
	
	
//	Assim é criando usuário no banco, isso é antes de criar a entidade
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
// 		comentei aqui porque estava tentando criar novamente
//		UserDetails user =
//				User.builder()
//				.username("laise")
//				.password(encoder.encode("laise"))
//				.roles("ADM")
//				.build();
//		
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder);
//		.withUser(user); // comentei aqui  porque estava tentando criar novamente
		
	}
	
	
}

