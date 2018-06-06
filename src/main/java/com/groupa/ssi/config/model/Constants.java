package com.groupa.ssi.config.model;

/**
 * @author Miguel Rojas
 */
public final class Constants {

    private Constants() {
    }

    public static class SsiPersistence {

        public static final String PU_NAME = "SsiPU";

        public static final String BASE_ENTITIES_PACKAGE = "com.groupa.ssi.model.domain";

        public static final String BASE_REPOSITORIES_PACKAGE = "com.groupa.ssi.model.repository";
    }

    public static class SsiDataWarehousePersistence {

        public static final String PU_NAME = "SsiDataWarehousePU";

        public static final String BASE_ENTITIES_PACKAGE = "com.groupa.ssi.modeldw";   //todo: update this to real path

        public static final String BASE_REPOSITORIES_PACKAGE = "com.groupa.ssi.modeldw";  //todo: update this to real path
    }
}
