package cals.quintet.crm.configuration.datasource.conts;

import lombok.Getter;

/**
 * @author sycha
 * @since 1.0
 */
@Getter
public class TenantDataSourceBeanName {

    private static final String TENANT = "tenant";
    private static final String LOYCORE_DB = "loycore";
    private static final String CRM_DB = "crm";
    private static final String TENANT_DATASOURCE = TENANT + "DataSource";
    public static final String TENANT_JDBCTEMPLATE = TENANT + "JdbcTemplate";
    private static final String ENTITY_MANAGER = "EntityManager";
    private static final String QUERY_FACTORY = "QueryFactory";

    public static final String LOY_CORE_TRANSACTION_MANAGER_FACTORY = LOYCORE_DB + "TransactionManagerFactory";
    public static final String CRM_TRANSACTION_MANAGER_FACTORY = CRM_DB + "TransactionManagerFactory";



    /* datasource */
    public static final String CRM_TENANT_DATASOURCE = CRM_DB+ TENANT_DATASOURCE;
    public static final String LOYCORE_TENANT_DATASOURCE = LOYCORE_DB+ TENANT_DATASOURCE;

    public static final String DATASOURCE_LOY_CORE_TRANSACTION_MANAGER_FACTORY = "datasource" + LOY_CORE_TRANSACTION_MANAGER_FACTORY;
    public static final String DATASOURCE_CRM_TRANSACTION_MANAGER_FACTORY = "datasource" + CRM_TRANSACTION_MANAGER_FACTORY;


    /* jdbcTemlate */


    /* Jpa */
    public static final String LOY_COORE_ENTITY_MANAGER_FACTORY = TENANT + LOYCORE_DB + "EntityManagerFactory";
    public static final String CRM_ENTITY_MANAGER_FACTORY = TENANT + CRM_DB + "EntityManagerFactory";

    public static final String JPA_LOY_CORE_TRANSACTION_MANAGER_FACTORY = "jpa" + LOY_CORE_TRANSACTION_MANAGER_FACTORY;
    public static final String JPA_CRM_TRANSACTION_MANAGER_FACTORY = "jpa" + CRM_TRANSACTION_MANAGER_FACTORY;

    public static final String CRM_ENTITY_MANAGER = CRM_DB + ENTITY_MANAGER;
    public static final String LOYCORE_ENTITY_MANAGER = LOYCORE_DB + ENTITY_MANAGER;

    public static final String CRM_QUERY_FACTORY = CRM_DB+QUERY_FACTORY;

    public static final String LOYCORE_QUERY_FACTORY = LOYCORE_DB+QUERY_FACTORY;


}
