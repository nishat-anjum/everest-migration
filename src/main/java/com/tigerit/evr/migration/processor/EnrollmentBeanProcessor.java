package com.tigerit.evr.migration.processor;

import com.tigerit.evr.migration.model.EnrollmentBean;
import com.tigerit.evr.migration.util.SpaceUtil;
import com.tigerit.evr.migration.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by nishat on 4/23/18.
 */
@Component("enrollmentBeanProcessor")
public class EnrollmentBeanProcessor implements ItemProcessor<EnrollmentBean, EnrollmentBean> {

    private static final Logger logger = LoggerFactory.getLogger(EnrollmentBeanProcessor.class);

    @Override
    public EnrollmentBean process(EnrollmentBean enrollmentBean) throws Exception {
        enrollmentBean = (EnrollmentBean) SpaceUtil.trimReflective(enrollmentBean);
        enrollmentBean.setCreatedBy(Utils.SERVICE_USER);
        enrollmentBean.setCreateTime(Utils.currentTimestamp());
        logger.debug("Processing result: {}", enrollmentBean);
        return enrollmentBean;
    }
}
