package com.gmaslowski.timer.schedule;

import java.io.Serializable;

import static com.google.common.base.Objects.toStringHelper;

public class ProgrammaticTimerInfo implements Serializable {

    private ProgrammaticTimerInfo() {
    }

    private String info;
    private String name;

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return toStringHelper(ProgrammaticTimerInfo.class)
                .add("info", info)
                .add("name", name)
                .toString();
    }


    public static class ProgrammaticTimerInfoBuilder {
        private ProgrammaticTimerInfo timerInfo;

        private ProgrammaticTimerInfoBuilder(ProgrammaticTimerInfo timerInfo) {
            this.timerInfo = timerInfo;
        }

        public static final ProgrammaticTimerInfoBuilder programmaticTimerInfo() {
            return new ProgrammaticTimerInfoBuilder(new ProgrammaticTimerInfo());
        }

        public ProgrammaticTimerInfoBuilder info(String info) {
            this.timerInfo.info = info;
            return this;
        }

        public ProgrammaticTimerInfoBuilder name(String name) {
            this.timerInfo.name = name;
            return this;
        }


        public ProgrammaticTimerInfo build() {
            return timerInfo;
        }
    }
}
