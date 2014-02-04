package com.gmaslowski.singleton;

import com.gmaslowski.singleton.view.SingletonLocal;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class SingletonBean implements SingletonLocal {
}
