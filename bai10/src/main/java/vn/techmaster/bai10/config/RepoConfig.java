package vn.techmaster.bai10.config;
import org.springframework.context.annotation.Bean;

import vn.techmaster.bai10.repository.JobDao;
import vn.techmaster.bai10.repository.PersonDao;
import org.springframework.context.annotation.Configuration;
@Configuration
public class  RepoConfig {

    @Bean
    public PersonDao personDao(){
        return new PersonDao();
       
    }
    @Bean
    public JobDao jobDao(){
        return new JobDao();
    }
    
}
