package com.gmaslowski.data;

import java.io.Serializable;

import static com.google.common.base.Objects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

public class EchoData implements Serializable {

    private transient String name;
    private String information;

    @Override
    public String toString() {
        return toStringHelper(EchoData.class)
                .add("(transient) name", name)
                .add("(serialized) information", information)
                .toString();
    }

    public static class EchoDataBuilder {
        private EchoData echoData;

        private EchoDataBuilder() {
            echoData = new EchoData();
        }

        public static EchoDataBuilder echoData() {
            return new EchoDataBuilder();
        }

        public EchoDataBuilder name(String name) {
            echoData.name = name;
            return this;
        }

        public EchoDataBuilder information(String information) {
            echoData.information = information;
            return this;
        }

        public EchoData build() {
            checkNotNull(echoData.information);
            checkNotNull(echoData.name);

            return echoData;
        }

    }
}
