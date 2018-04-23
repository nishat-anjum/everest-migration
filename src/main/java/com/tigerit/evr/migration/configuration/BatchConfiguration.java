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
 * Created by raqib on 24/11/15.
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
        reader.setSql(Queries.INDIV_TYPE_ENROLL_SELECT);
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @StepScope
    @Bean(name = "indivTypeEnrollWriter")
    public JdbcBatchItemWriter<EnrollmentBean> indivTypeEnrollWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<EnrollmentBean> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<EnrollmentBean>());
        writer.setSql(Queries.INDIV_TYPE_ENROLL_INSERT);
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public JdbcCursorItemReader<Biometric> biometricReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                           RowMapper<Biometric> rowMapper) {
        JdbcCursorItemReader<Biometric> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql(Queries.BIOMETRIC_SELECT);
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<Biometric> biometricWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<Biometric> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Biometric>());
        writer.setSql(Queries.BIOMETRIC_INSERT);
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


//
//    @Bean
//    @StepScope
//    public JdbcBatchItemWriter<LRegistrationEvent> lRegistrationEventActivityWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
//        JdbcBatchItemWriter<LRegistrationEvent> writer = new JdbcBatchItemWriter<>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<LRegistrationEvent>());
//        writer.setSql("insert into ACTIVITY_L_REG_EVENT(EVENT_ID, EVENT_CODE, EVENT_NAME, ACTIVITY_ID, ACTIVITY_ACTION, ACTIVITY_USER, ACTIVITY_TIME)" +
//                " values (:eventId, :eventCode, :eventName, ACTIVITY_L_REG_EVENT_SEQ.nextval, 0, 'service', systimestamp)");
//        writer.setDataSource(dataSource);
//        return writer;
//    }
//
//    @Bean
//    @StepScope
//    public CompositeItemWriter<LRegistrationEvent> lRegistrationEventCompositeWriter(@Qualifier("lRegistrationEventWriter") final ItemWriter<LRegistrationEvent> writer,
//                                                                                     @Qualifier("lRegistrationEventActivityWriter") final ItemWriter<LRegistrationEvent> activityWriter) {
//        CompositeItemWriter<LRegistrationEvent> compositeItemWriter = new CompositeItemWriter<>();
//        compositeItemWriter.setDelegates(new ArrayList<ItemWriter<? super LRegistrationEvent>>() {
//            {
//                add(writer);
//                add(activityWriter);
//            }
//        });
//        return compositeItemWriter;
//    }
//    // tag::ReaderWriterProcessor[LRegistrationEvent]
//
//    // tag::ReaderWriterProcessor[VehicleHistory]
//    @Bean
//    @StepScope
//    public JdbcCursorItemReader<VehicleHistory> vehicleHistoryReader(@Qualifier("dataSourceIN") DataSource dataSource,
//                                                                     RowMapper<VehicleHistory> rowMapper) {
//        JdbcCursorItemReader<VehicleHistory> reader = new JdbcCursorItemReader<>();
//        reader.setDataSource(dataSource);
//        reader.setSql("SELECT r.registration_id as registration_id, r.registration_no as registration_no, r.previous_registration_no as previous_registration_no," +
//                " v.vehicle_id as vehicle_id, v.chassis_no as chassis_no," +
//                " e.event_id as l_reg_event_id, e.event_name as l_reg_event_name," +
//                " to_char(o.update_date, 'DD-MON-YYYY') as update_date, o.sequence_no as sequence_no," +
//                " ot.type_id as l_ownership_type_id, ot.type_name as l_ownership_type_name," +
//                " p.person_id as person_id, p.person_name as person_name," +
//                " vt.type_id as l_vehicle_type_id, vt.type_name as l_vehicle_type_name" +
//                " FROM vehicle v" +
//                " JOIN registration r on (r.registration_id = v.registration_id)"
//                + " LEFT JOIN L_VEHICLE_TYPE vt ON (vt.type_id = v.vehicle_type_id)"
//                + " JOIN owner o on (o.registration_id = r.registration_id)"
//                + " JOIN l_ownership_type ot ON (ot.type_id = r.ownership_type)"
//                + " JOIN person p on (p.person_id = o.person_id)"
//                + " JOIN l_registration_event e on (e.event_id = r.registration_event)"
//                + " order by o.registration_id, o.person_id, o.sequence_no");
//        reader.setRowMapper(rowMapper);
//        return reader;
//    }
//
//    @Bean
//    @StepScope
//    public JdbcBatchItemWriter<VehicleHistory> vehicleHistoryWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
//        JdbcBatchItemWriter<VehicleHistory> writer = new JdbcBatchItemWriter<>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<VehicleHistory>());
//        writer.setSql("insert into VEHICLE_HISTORY(REGISTRATION_ID, REGISTRATION_NO, PREVIOUS_REGISTRATION_NO," +
//                " VEHICLE_ID, CHASSIS_NO, PERSON_ID, PERSON_NAME, OWNER_SEQUENCE_NO, OWNER_UPDATE_DATE," +
//                " L_REG_EVENT_ID, L_REG_EVENT_NAME, L_OWNERSHIP_TYPE_ID, L_OWNERSHIP_TYPE_NAME, L_VEHICLE_TYPE_ID, L_VEHICLE_TYPE_NAME)" +
//                " values (:registrationId, :registrationNo, :previousRegistrationNo," +
//                " :vehicleId, :chassisNo, :personId, :personName, :sequenceNo, :updateDate," +
//                " :lRegEventId, :lRegEventName, :lOwnershipTypeId, :lOwnershipTypeName, :lVehicleTypeId, :lVehicleTypeName)");
//        writer.setDataSource(dataSource);
//        return writer;
//    }
//
//    @Bean
//    @StepScope
//    public JdbcBatchItemWriter<VehicleHistory> vehicleHistoryActivityWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
//        JdbcBatchItemWriter<VehicleHistory> writer = new JdbcBatchItemWriter<>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<VehicleHistory>());
//        writer.setSql("insert into ACTIVITY_VEHICLE_HISTORY(ACTIVITY_ID, ACTIVITY_ACTION, ACTIVITY_USER, ACTIVITY_TIME," +
//                " REGISTRATION_ID, REGISTRATION_NO, PREVIOUS_REGISTRATION_NO," +
//                " VEHICLE_ID, CHASSIS_NO, PERSON_ID, PERSON_NAME, OWNER_SEQUENCE_NO, OWNER_UPDATE_DATE," +
//                " L_REG_EVENT_ID, L_REG_EVENT_NAME, L_OWNERSHIP_TYPE_ID, L_OWNERSHIP_TYPE_NAME, L_VEHICLE_TYPE_ID, L_VEHICLE_TYPE_NAME)" +
//                " values (ACTIVITY_VEHICLE_HISTORY_SEQ.nextval, 0, 'service', systimestamp," +
//                " :registrationId, :registrationNo, :previousRegistrationNo," +
//                " :vehicleId, :chassisNo, :personId, :personName, :sequenceNo, :updateDate," +
//                " :lRegEventId, :lRegEventName, :lOwnershipTypeId, :lOwnershipTypeName, :lVehicleTypeId, :lVehicleTypeName)");
//        writer.setDataSource(dataSource);
//        return writer;
//    }
//
//    @Bean
//    @StepScope
//    public CompositeItemWriter<VehicleHistory> vehicleHistoryCompositeWriter(@Qualifier("vehicleHistoryWriter") final ItemWriter<VehicleHistory> writer,
//                                                                             @Qualifier("vehicleHistoryActivityWriter") final ItemWriter<VehicleHistory> activityWriter) {
//        CompositeItemWriter<VehicleHistory> compositeItemWriter = new CompositeItemWriter<>();
//        compositeItemWriter.setDelegates(new ArrayList<ItemWriter<? super VehicleHistory>>() {
//            {
//                add(writer);
//                add(activityWriter);
//            }
//        });
//        return compositeItemWriter;
//    }
//    // tag::ReaderWriterProcessor[VehicleHistory]

    @Bean(name = "migrateIndivEnroll")
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
                          @Qualifier("migrateBiometric") Step migrateBiometric,
                          @Qualifier("migrateOrgStamp") Step migrateOrgStamp,
                          @Qualifier("migrateVehiclePhoto") Step migrateVehiclePhoto) {

        SimpleJobBuilder builder = jobs.get("EverestMigration").incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(migrateVehiclePhoto).next(migrateOrgStamp);

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
