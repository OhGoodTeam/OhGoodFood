package kr.co.ohgoodfood.config;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "kr.co.ohgoodfood")
@MapperScan(basePackages = "kr.co.ohgoodfood", annotationClass = Mapper.class)
public class MvcConfig implements WebMvcConfigurer {

	// db.properties에 있는 속성
	@Value("${db.driver}")
	private String driver;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// configureDefaultServletHandling
	// 스프링이 아닌 톰켓이 정적 리소스를 처리하도록 설정
	// img,css,js 등
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer config) {
		config.enable();
	}

	// 비지니스 로직이 없는 페이지의 경우
	// addViewController의 url로 진입 시 setViewName으로 포워딩
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}

	// HikariCP
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setJdbcUrl(url); // ip는 바뀌어야함
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.addDataSourceProperty("useUnicode", "true");
		dataSource.addDataSourceProperty("characterEncoding", "UTF-8");
		dataSource.addDataSourceProperty("serverTimezone", "Asia/Seoul");

		// 한글 인코딩 설정
		return dataSource;
	}

	// MyBatis
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource()); // 의존성 주입
		
		// MyBatis 설정
		// org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
		// config.setMapUnderscoreToCamelCase(true);
		// config.setCallSettersOnNulls(true);
		// ssf.setConfiguration(config);
		
		return ssf.getObject();
	}

	// 트랜잭션 선언
	@Bean
	public TransactionManager tm() {
		TransactionManager tm = new DataSourceTransactionManager(dataSource());
		return tm;
	}

//	// interceptor
//	@Bean
//	public LoginInterceptor li() {
//		return new LoginInterceptor();
//	}

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(li()).addPathPatterns("/student/mypage");
//		/*
//		 * /student/** 모든 페이지
//		 * 
//		 * 관리자의 경우 모둔 url에 체크가 필요하기에 전부로 걸고 로그인만 제외 .excludePathPatterns("경로") <-- 제외
//		 */
//	}

	// file Upload
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setMaxUploadSize(1024 * 1024 * 5);
		cmr.setDefaultEncoding("UTF-8");
		return cmr;
	}

	// swagger
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
				.resourceChain(false);
	}

	// properties 설정
	@Bean
	public static PropertyPlaceholderConfigurer propreties() {
		PropertyPlaceholderConfigurer config = new PropertyPlaceholderConfigurer();
		config.setLocations(new ClassPathResource("db.properties"));
		return config;
	}
}
