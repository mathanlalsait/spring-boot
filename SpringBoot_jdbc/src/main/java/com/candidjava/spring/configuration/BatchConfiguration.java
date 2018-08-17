package com.candidjava.spring.configuration;




import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.candidjava.spring.model.Person;



@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	    
	  @Bean
	  public ItemReader<Person> reader() {
		  FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();

			reader.setResource(new ClassPathResource("PersonDetail.csv"));
			reader.setLineMapper(new DefaultLineMapper<Person>() {
				{
					setLineTokenizer(new DelimitedLineTokenizer() {
						{
							setNames(new String[] { "first_name", "last_name",  });
						}
					});
					setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {
						{
							setTargetType(Person.class);
						}
					});
				}
			});
			return reader;
	  }
	  
	
	  
	  @Bean
	  public ItemWriter<Person> writer(DataSource dataSource, NamedParameterJdbcTemplate jdbcTemplate ) {
		  JdbcBatchItemWriter<Person> databaseItemWriter = new JdbcBatchItemWriter<>();
	        databaseItemWriter.setDataSource(dataSource);
	        databaseItemWriter.setJdbcTemplate(jdbcTemplate);
	        databaseItemWriter.setSql("INSERT INTO Person (first_name, last_name) VALUES (:firstName, :lastName)");
	        ItemSqlParameterSourceProvider<Person> sqlParameterSourceProvider = studentSqlParameterSourceProvider();
	        databaseItemWriter.setItemSqlParameterSourceProvider(sqlParameterSourceProvider);
        return databaseItemWriter;
	  }
	  private ItemSqlParameterSourceProvider<Person> studentSqlParameterSourceProvider() {
	        return new BeanPropertyItemSqlParameterSourceProvider<>();
	    }
	    // end::readerwriterprocessor[]

	    // tag::jobstep[]
	  @Bean
	  public Job importUserJob(JobBuilderFactory jobs, Step step1) {
	        return jobs.get("importUserJob")
	            .incrementer(new RunIdIncrementer())
	            .flow(step1)
	            .end()
	            .build();
	  }

	  @Bean
	  public Step step1(StepBuilderFactory stepBuilderFactory,ItemWriter<Person> writer, ItemReader<Person> reader) {
	        return stepBuilderFactory.get("step1")
	            .<Person, Person> chunk(10)
	            .reader(reader)
	            .writer(writer)
	            .build();
	  }
	
   
    
    

}
