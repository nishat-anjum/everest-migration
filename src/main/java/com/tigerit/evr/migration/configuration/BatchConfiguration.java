package com.tigerit.evr.migration.configuration;

import com.tigerit.evr.migration.model.*;
import com.tigerit.evr.migration.util.Queries;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by nishat on 24/04/18.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration extends DefaultBatchConfigurer {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private DataSource dataSourceMETA;

    @Autowired
    private Queries queries;

    @Override
    public JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSourceMETA);
        factory.setTransactionManager(new DataSourceTransactionManager(dataSourceMETA));
        factory.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @StepScope
    @Bean(name = "indivTypeEnrollReader")
    public JdbcCursorItemReader<EnrollmentBean> indivTypeEnrollReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                                      @Qualifier("indivEnrollmentRowMapper") RowMapper<EnrollmentBean> rowMapper) {
        JdbcCursorItemReader<EnrollmentBean> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql(queries.getIndivTypeEnrollSelectQuery());
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @StepScope
    @Bean(name = "indivTypeEnrollWriter")
    public JdbcBatchItemWriter<EnrollmentBean> indivTypeEnrollWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<EnrollmentBean> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<EnrollmentBean>());
        writer.setSql(queries.getIndivTypeEnrollInsertQuery());
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public JdbcCursorItemReader<Biometric> biometricReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                           RowMapper<Biometric> rowMapper) {
        JdbcCursorItemReader<Biometric> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql(queries.getBiometricSelectQuery());
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<Biometric> biometricWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<Biometric> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Biometric>());
        writer.setSql(queries.getBiometricInsertQuery());
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public JdbcCursorItemReader<VehiclePhoto> vehiclePhotoReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                                 RowMapper<VehiclePhoto> rowMapper) {
        JdbcCursorItemReader<VehiclePhoto> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql(queries.getVehiclePhotoSelectQuery());
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<VehiclePhoto> vehiclePhotoWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<VehiclePhoto> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<VehiclePhoto>());
        writer.setSql(queries.getVehiclePhotoInsertQuery());
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public JdbcCursorItemReader<OrganizationStamp> orgStampReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                                  RowMapper<OrganizationStamp> rowMapper) {
        JdbcCursorItemReader<OrganizationStamp> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql(queries.getOrgStampSelectQuery());
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<OrganizationStamp> orgStampWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<OrganizationStamp> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<OrganizationStamp>());
        writer.setSql(queries.getOrgStampInsertQuery());
        writer.setDataSource(dataSource);
        return writer;
    }

    @StepScope
    @Bean(name = "orgTypeEnrollWriter")
    public JdbcBatchItemWriter<EnrollmentBean> orgTypeEnrollWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<EnrollmentBean> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<EnrollmentBean>());
        writer.setSql(queries.getOrgTypeEnrollInsertQuery());
        writer.setDataSource(dataSource);
        return writer;
    }

    @StepScope
    @Bean(name = "orgTypeEnrollReader")
    public JdbcCursorItemReader<EnrollmentBean> orgTypeEnrollReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                                    @Qualifier("orgEnrollmentRowMapper") RowMapper<EnrollmentBean> orgEnrollmentRowMapper) {
        JdbcCursorItemReader<EnrollmentBean> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql(queries.getOrgTypeEnrollSelectQuery());
        reader.setRowMapper(orgEnrollmentRowMapper);
        return reader;
    }


    @Bean(name = "migrateIndivEnroll")
    @StepScope
    public Step migrateIndivEnroll(@Qualifier("indivTypeEnrollReader") ItemReader<EnrollmentBean> reader,
                                   @Qualifier("indivTypeEnrollWriter") ItemWriter<EnrollmentBean> writer,
                                   @Qualifier("enrollmentBeanProcessor") ItemProcessor<EnrollmentBean, EnrollmentBean> processor,
                                   StepExecutionListener listener) {
        return steps.get("migrateIndivEnroll")
                .<EnrollmentBean, EnrollmentBean>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(listener)
                .build();
    }

    @Bean(name = "migrateOrgEnroll")
    public Step migrateOrgEnroll(@Qualifier("orgTypeEnrollReader") ItemReader<EnrollmentBean> reader,
                                 @Qualifier("orgTypeEnrollWriter") ItemWriter<EnrollmentBean> writer,
                                 @Qualifier("enrollmentBeanProcessor") ItemProcessor<EnrollmentBean, EnrollmentBean> processor,
                                 StepExecutionListener listener) {
        return steps.get("migrateOrgEnroll")
                .<EnrollmentBean, EnrollmentBean>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(listener)
                .build();
    }

    @Bean(name = "migrateBiometric")
    public Step migrateBiometric(ItemReader<Biometric> biometricReader,
                                 ItemWriter<Biometric> biometricWriter,
                                 ItemProcessor<Biometric, Biometric> biometricProcessor,
                                 StepExecutionListener listener) {
        return steps.get("migrateBiometric")
                .<Biometric, Biometric>chunk(100)
                .reader(biometricReader)
                .processor(biometricProcessor)
                .writer(biometricWriter)
                .listener(listener)
                .build();
    }

    @Bean(name = "migrateOrgStamp")
    public Step migrateOrganizationStamp(ItemReader<OrganizationStamp> reader,
                                         ItemWriter<OrganizationStamp> writer,
                                         ItemProcessor<OrganizationStamp, OrganizationStamp> orgStampProcessor,
                                         StepExecutionListener listener) {
        return steps.get("migrateOrgStamp")
                .<OrganizationStamp, OrganizationStamp>chunk(50)
                .reader(reader)
                .processor(orgStampProcessor)
                .writer(writer)
                .listener(listener)
                .build();
    }

    @Bean
    public Step migrateVehiclePhoto(ItemReader<VehiclePhoto> reader,
                                    ItemWriter<VehiclePhoto> writer,
                                    ItemProcessor<VehiclePhoto, VehiclePhoto> processor,
                                    StepExecutionListener listener) {
        return steps.get("migrateVehiclePhoto")
                .<VehiclePhoto, VehiclePhoto>chunk(50)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(listener)
                .build();
    }
//
//    @Bean
//    public Step migrateVehicleHistory(ItemReader<VehicleHistory> reader,
//                                      @Qualifier("vehicleHistoryCompositeWriter") ItemWriter<VehicleHistory> writer,
//                                      ItemProcessor<VehicleHistory, VehicleHistory> processor,
//                                      StepExecutionListener listener) {
//        return steps.get("migrateVehicleHistory")
//                .<VehicleHistory, VehicleHistory>chunk(100)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .listener(listener)
//                .build();
//    }

    @Bean
    public Job migrateJob(@Qualifier("jobListener") JobExecutionListener listener,
                          @Qualifier("migrateIndivEnroll") Step migrateIndivEnroll,
                          @Qualifier("migrateOrgEnroll") Step migrateOrgEnroll,
                          @Qualifier("migrateBiometric") Step migrateBiometric,
                          @Qualifier("migrateOrgStamp") Step migrateOrgStamp,
                          @Qualifier("migrateVehiclePhoto") Step migrateVehiclePhoto) {

        SimpleJobBuilder builder = jobs.get("EverestMigration").incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(migrateVehiclePhoto)
                .next(migrateOrgStamp)
                .next(migrateBiometric)
                .next(migrateIndivEnroll)
                .next(migrateOrgEnroll);

//        FlowJobBuilder builder = jobs.get("migration")
//                .listener(listener)
//                .start(migrateFitness)
//                .split(new SimpleAsyncTaskExecutor()).add(
//                        new FlowBuilder<Flow>("taxToken").from(migrateBiometric).end(),
//                        new FlowBuilder<Flow>("lRegistrationEvent").from(migrateLRegistrationEvent).end(),
//                        new FlowBuilder<Flow>("vehicleHistory").from(migrateVehicleHistory).end()
//                ).end();

        return builder.build();
    }
}
