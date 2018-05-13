package com.siperpus;
 

 
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	 
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.authorizeRequests()
				.antMatchers("/resources/**", "/login", "/js/**", "/rest/**").permitAll()
				.antMatchers("/literature/add", "/literatur/ubah/**", "/literature/hapus/**").hasRole("STAF")
				.anyRequest().authenticated()
				.and()
				.csrf().disable()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll(); 
	}
	
	
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
						"select username,password, 1 from user_account where username=?")
			.authoritiesByUsernameQuery(
					"select username, role from user_account where username=?");
	}
	 
}