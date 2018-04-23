package com.tigerit.evr.migration.processor;

import com.tigerit.evr.migration.model.TaxToken;
import com.tigerit.evr.migration.util.SpaceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by raqib on 26/11/15.
 */
@Component
public class TaxTokenProcessor implements ItemProcessor<TaxToken, TaxToken> {
    private static final Logger logger = LoggerFactory.getLogger(TaxTokenProcessor.class);

    @Override
    public TaxToken process(TaxToken taxToken) throws Exception {
        taxToken = (TaxToken) SpaceUtil.trimReflective(taxToken);
        logger.debug("Processing result: {}", taxToken);
        return taxToken;
    }
}
