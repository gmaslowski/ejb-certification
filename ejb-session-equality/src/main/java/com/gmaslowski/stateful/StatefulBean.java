package com.gmaslowski.stateful;

import com.gmaslowski.stateful.view.StatefulLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class StatefulBean implements StatefulLocal {

    private static final Logger log = LoggerFactory.getLogger(StatefulBean.class);
}
