package com.tigerit.evr.migration.configuration;

import com.tigerit.evr.migration.model.Fitness;
import com.tigerit.evr.migration.model.LRegistrationEvent;
import com.tigerit.evr.migration.model.TaxToken;
import com.tigerit.evr.migration.model.VehicleHistory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.flow.Flow;
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

    @Override
    public JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSourceMETA);
        factory.setTransactionManager(new DataSourceTransactionManager(dataSourceMETA));
        factory.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    // tag::ReaderWriterProcessor[Fitness]
    @Bean
    @StepScope
    public JdbcCursorItemReader<Fitness> fitnessReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                       RowMapper<Fitness> rowMapper) {
        JdbcCursorItemReader<Fitness> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("select FITNESS_ID, REGISTRATION_NO, REGISTRATION_ID, EXPIRY_DATE from FITNESS order by FITNESS_ID");
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<Fitness> fitnessWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<Fitness> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Fitness>());
        writer.setSql("insert into FITNESS(FITNESS_ID, REGISTRATION_NO, REGISTRATION_ID, EXPIRY_DATE)" +
                " values (:fitnessId, :registrationNo, :registrationId, :expiryDate)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<Fitness> fitnessActivityWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<Fitness> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Fitness>());
        writer.setSql("insert into ACTIVITY_FITNESS(FITNESS_ID, REGISTRATION_NO, REGISTRATION_ID, EXPIRY_DATE, ACTIVITY_ID, ACTIVITY_ACTION, ACTIVITY_USER, ACTIVITY_TIME)" +
                " values (:fitnessId, :registrationNo, :registrationId, :expiryDate, ACTIVITY_FITNESS_SEQ.nextval, 0, 'service', systimestamp)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public CompositeItemWriter<Fitness> fitnessCompositeWriter(@Qualifier("fitnessWriter") final ItemWriter<Fitness> writer,
                                                               @Qualifier("fitnessActivityWriter") final ItemWriter<Fitness> activityWriter) {
        CompositeItemWriter<Fitness> compositeItemWriter = new CompositeItemWriter<>();
        compositeItemWriter.setDelegates(new ArrayList<ItemWriter<? super Fitness>>() {
            {
                add(writer);
                add(activityWriter);
            }
        });
        return compositeItemWriter;
    }
    // tag::ReaderWriterProcessor[Fitness]

    // tag::ReaderWriterProcessor[TaxToken]
    @Bean
    @StepScope
    public JdbcCursorItemReader<TaxToken> taxTokenReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                         RowMapper<TaxToken> rowMapper) {
        JdbcCursorItemReader<TaxToken> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("select TAX_TOKEN_ID, REGISTRATION_NO, REGISTRATION_ID, EXPIRY_DATE from TAX_TOKEN order by TAX_TOKEN_ID");
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<TaxToken> taxTokenWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<TaxToken> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TaxToken>());
        writer.setSql("insert into TAX_TOKEN(TAX_TOKEN_ID, REGISTRATION_NO, REGISTRATION_ID, EXPIRY_DATE)" +
                " values (:taxTokenId, :registrationNo, :registrationId, :expiryDate)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<TaxToken> taxTokenActivityWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<TaxToken> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TaxToken>());
        writer.setSql("insert into ACTIVITY_TAX_TOKEN(TAX_TOKEN_ID, REGISTRATION_NO, REGISTRATION_ID, EXPIRY_DATE, ACTIVITY_ID, ACTIVITY_ACTION, ACTIVITY_USER, ACTIVITY_TIME)" +
                " values (:taxTokenId, :registrationNo, :registrationId, :expiryDate, ACTIVITY_TAX_TOKEN_SEQ.nextval, 0, 'service', systimestamp)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public CompositeItemWriter<TaxToken> taxTokenCompositeWriter(@Qualifier("taxTokenWriter") final ItemWriter<TaxToken> writer,
                                                                 @Qualifier("taxTokenActivityWriter") final ItemWriter<TaxToken> activityWriter) {
        CompositeItemWriter<TaxToken> compositeItemWriter = new CompositeItemWriter<>();
        compositeItemWriter.setDelegates(new ArrayList<ItemWriter<? super TaxToken>>() {
            {
                add(writer);
                add(activityWriter);
            }
        });
        return compositeItemWriter;
    }
    // tag::ReaderWriterProcessor[TaxToken]

    // tag::ReaderWriterProcessor[LRegistrationEvent]
    @Bean
    @StepScope
    public JdbcCursorItemReader<LRegistrationEvent> lRegistrationEventReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                                             RowMapper<LRegistrationEvent> rowMapper) {
        JdbcCursorItemReader<LRegistrationEvent> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("select EVENT_ID, EVENT_CODE, EVENT_NAME from L_REGISTRATION_EVENT order by EVENT_ID");
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<LRegistrationEvent> lRegistrationEventWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<LRegistrationEvent> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<LRegistrationEvent>());
        writer.setSql("insert into L_REGISTRATION_EVENT(EVENT_ID, EVENT_CODE, EVENT_NAME)" +
                " values (:eventId, :eventCode, :eventName)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<LRegistrationEvent> lRegistrationEventActivityWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<LRegistrationEvent> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<LRegistrationEvent>());
        writer.setSql("insert into ACTIVITY_L_REG_EVENT(EVENT_ID, EVENT_CODE, EVENT_NAME, ACTIVITY_ID, ACTIVITY_ACTION, ACTIVITY_USER, ACTIVITY_TIME)" +
                " values (:eventId, :eventCode, :eventName, ACTIVITY_L_REG_EVENT_SEQ.nextval, 0, 'service', systimestamp)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public CompositeItemWriter<LRegistrationEvent> lRegistrationEventCompositeWriter(@Qualifier("lRegistrationEventWriter") final ItemWriter<LRegistrationEvent> writer,
                                                                                     @Qualifier("lRegistrationEventActivityWriter") final ItemWriter<LRegistrationEvent> activityWriter) {
        CompositeItemWriter<LRegistrationEvent> compositeItemWriter = new CompositeItemWriter<>();
        compositeItemWriter.setDelegates(new ArrayList<ItemWriter<? super LRegistrationEvent>>() {
            {
                add(writer);
                add(activityWriter);
            }
        });
        return compositeItemWriter;
    }
    // tag::ReaderWriterProcessor[LRegistrationEvent]

    // tag::ReaderWriterProcessor[VehicleHistory]
    @Bean
    @StepScope
    public JdbcCursorItemReader<VehicleHistory> vehicleHistoryReader(@Qualifier("dataSourceIN") DataSource dataSource,
                                                                     RowMapper<VehicleHistory> rowMapper) {
        JdbcCursorItemReader<VehicleHistory> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT r.registration_id as registration_id, r.registration_no as registration_no, r.previous_registration_no as previous_registration_no," +
                " v.vehicle_id as vehicle_id, v.chassis_no as chassis_no," +
                " e.event_id as l_reg_event_id, e.event_name as l_reg_event_name," +
                " to_char(o.update_date, 'DD-MON-YYYY') as update_date, o.sequence_no as sequence_no," +
                " ot.type_id as l_ownership_type_id, ot.type_name as l_ownership_type_name," +
                " p.person_id as person_id, p.person_name as person_name," +
                " vt.type_id as l_vehicle_type_id, vt.type_name as l_vehicle_type_name" +
                " FROM vehicle v" +
                " JOIN registration r on (r.registration_id = v.registration_id)"
                + " LEFT JOIN L_VEHICLE_TYPE vt ON (vt.type_id = v.vehicle_type_id)"
                + " JOIN owner o on (o.registration_id = r.registration_id)"
                + " JOIN l_ownership_type ot ON (ot.type_id = r.ownership_type)"
                + " JOIN person p on (p.person_id = o.person_id)"
                + " JOIN l_registration_event e on (e.event_id = r.registration_event)"
                + " order by o.registration_id, o.person_id, o.sequence_no");
        reader.setRowMapper(rowMapper);
        return reader;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<VehicleHistory> vehicleHistoryWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<VehicleHistory> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<VehicleHistory>());
        writer.setSql("insert into VEHICLE_HISTORY(REGISTRATION_ID, REGISTRATION_NO, PREVIOUS_REGISTRATION_NO," +
                " VEHICLE_ID, CHASSIS_NO, PERSON_ID, PERSON_NAME, OWNER_SEQUENCE_NO, OWNER_UPDATE_DATE," +
                " L_REG_EVENT_ID, L_REG_EVENT_NAME, L_OWNERSHIP_TYPE_ID, L_OWNERSHIP_TYPE_NAME, L_VEHICLE_TYPE_ID, L_VEHICLE_TYPE_NAME)" +
                " values (:registrationId, :registrationNo, :previousRegistrationNo," +
                " :vehicleId, :chassisNo, :personId, :personName, :sequenceNo, :updateDate," +
                " :lRegEventId, :lRegEventName, :lOwnershipTypeId, :lOwnershipTypeName, :lVehicleTypeId, :lVehicleTypeName)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public JdbcBatchItemWriter<VehicleHistory> vehicleHistoryActivityWriter(@Qualifier("dataSourceOUT") DataSource dataSource) {
        JdbcBatchItemWriter<VehicleHistory> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<VehicleHistory>());
        writer.setSql("insert into ACTIVITY_VEHICLE_HISTORY(ACTIVITY_ID, ACTIVITY_ACTION, ACTIVITY_USER, ACTIVITY_TIME," +
                " REGISTRATION_ID, REGISTRATION_NO, PREVIOUS_REGISTRATION_NO," +
                " VEHICLE_ID, CHASSIS_NO, PERSON_ID, PERSON_NAME, OWNER_SEQUENCE_NO, OWNER_UPDATE_DATE," +
                " L_REG_EVENT_ID, L_REG_EVENT_NAME, L_OWNERSHIP_TYPE_ID, L_OWNERSHIP_TYPE_NAME, L_VEHICLE_TYPE_ID, L_VEHICLE_TYPE_NAME)" +
                " values (ACTIVITY_VEHICLE_HISTORY_SEQ.nextval, 0, 'service', systimestamp," +
                " :registrationId, :registrationNo, :previousRegistrationNo," +
                " :vehicleId, :chassisNo, :personId, :personName, :sequenceNo, :updateDate," +
                " :lRegEventId, :lRegEventName, :lOwnershipTypeId, :lOwnershipTypeName, :lVehicleTypeId, :lVehicleTypeName)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    @StepScope
    public CompositeItemWriter<VehicleHistory> vehicleHistoryCompositeWriter(@Qualifier("vehicleHistoryWriter") final ItemWriter<VehicleHistory> writer,
                                                                             @Qualifier("vehicleHistoryActivityWriter") final ItemWriter<VehicleHistory> activityWriter) {
        CompositeItemWriter<VehicleHistory> compositeItemWriter = new CompositeItemWriter<>();
        compositeItemWriter.setDelegates(new ArrayList<ItemWriter<? super VehicleHistory>>() {
            {
                add(writer);
                add(activityWriter);
            }
        });
        return compositeItemWriter;
    }
    // tag::ReaderWriterProcessor[VehicleHistory]

    @Bean
    public Step migrateFitness(ItemReader<Fitness> reader,
                               @Qualifier("fitnessCompositeWriter") ItemWriter<Fitness> writer,
                               ItemProcessor<Fitness, Fitness> processor,
                               StepExecutionListener listener) {
        return steps.get("migrateFitness")
                .<Fitness, Fitness>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(listener)
                .build();
    }

    @Bean
    public Step migrateTaxToken(ItemReader<TaxToken> reader,
                                @Qualifier("taxTokenCompositeWriter") ItemWriter<TaxToken> writer,
                                ItemProcessor<TaxToken, TaxToken> processor,
                                StepExecutionListener listener) {
        return steps.get("migrateTaxToken")
                .<TaxToken, TaxToken>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(listener)
                .build();
    }

    @Bean
    public Step migrateLRegistrationEvent(ItemReader<LRegistrationEvent> reader,
                                          @Qualifier("lRegistrationEventCompositeWriter") ItemWriter<LRegistrationEvent> writer,
                                          ItemProcessor<LRegistrationEvent, LRegistrationEvent> processor,
                                          StepExecutionListener listener) {
        return steps.get("migrateLRegistrationEvent")
                .<LRegistrationEvent, LRegistrationEvent>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(listener)
                .build();
    }

    @Bean
    public Step migrateVehicleHistory(ItemReader<VehicleHistory> reader,
                                      @Qualifier("vehicleHistoryCompositeWriter") ItemWriter<VehicleHistory> writer,
                                      ItemProcessor<VehicleHistory, VehicleHistory> processor,
                                      StepExecutionListener listener) {
        return steps.get("migrateVehicleHistory")
                .<VehicleHistory, VehicleHistory>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(listener)
                .build();
    }

    @Bean
    public Job migrateJob(@Qualifier("jobListener") JobExecutionListener listener,
                          Step migrateFitness,
                          Step migrateTaxToken,
                          Step migrateLRegistrationEvent,
                          Step migrateVehicleHistory) {

        FlowJobBuilder builder = jobs.get("migration")
                .listener(listener)
                .start(migrateFitness)
                .split(new SimpleAsyncTaskExecutor()).add(
                        new FlowBuilder<Flow>("taxToken").from(migrateTaxToken).end(),
                        new FlowBuilder<Flow>("lRegistrationEvent").from(migrateLRegistrationEvent).end(),
                        new FlowBuilder<Flow>("vehicleHistory").from(migrateVehicleHistory).end()
                ).end();

        return builder.build();
    }
}
