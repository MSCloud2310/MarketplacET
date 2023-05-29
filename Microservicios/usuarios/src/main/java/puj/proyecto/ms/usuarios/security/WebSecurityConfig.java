// package puj.proyecto.ms.usuarios.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
// import
// org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {
// // @Autowired
// // public void configureGlobal(AuthenticationManagerBuilder auth) throws
// // Exception {
// // auth.inMemoryAuthentication()
// // .withUser("user")
// // .password("{noop}password")
// // .roles("USER")
// // .and()
// // .withUser("admin")
// // .password("{noop}password")
// // .roles("USER", "ADMIN");
// // }
// //@Bean
// //public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// // http.csrf().disable()
// // .authorizeRequests()
// // .requestMatchers(HttpMethod.POST, "/usuario").permitAll()
// // .requestMatchers(HttpMethod.GET, "/usuario").permitAll()
// // .requestMatchers(HttpMethod.POST, "/usuario").hasRole("CLIENTE")
// // .requestMatchers(HttpMethod.GET, "/usuario").hasRole("CLIENTE")
// // .requestMatchers(HttpMethod.POST, "/usuario").hasRole("PROVEEDOR")
// // .requestMatchers(HttpMethod.GET, "/usuario").hasRole("PROVEEDOR")
// // .anyRequest().authenticated()
// // .and()
// //
// .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// // return http.build();
// // http
// // .securityMatcher("/usuario/**")
// // .authorizeHttpRequests(authorize -> authorize
// // .anyRequest().hasRole("CLIENTE")
// // )
// // .httpBasic(withDefaults());
// // return http.build();
// //}
// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// http
// .authorizeRequests(authorize -> authorize
// .anyRequest().authenticated()
// ).formLogin(defaults())
// .httpBasic(withDefaults());
// return http.build();
// }
// private Customizer<HttpBasicConfigurer<HttpSecurity>> withDefaults() {
// return Customizer.withDefaults();
// }

// private Customizer<FormLoginConfigurer<HttpSecurity>> defaults() {
// return Customizer.withDefaults();
// }

// UserDetailsService userDetailsService() {
// InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
// manager.createUser(User.withUsername("cliente")
// .password("cliente123")
// .roles("CLIENTE")
// .build());
// return manager;
// }

// @Bean
// PasswordEncoder passwordEncoder() {
// return NoOpPasswordEncoder.getInstance();
// }
// }