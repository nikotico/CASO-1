
package qr2;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class qr2Pool {
 
    /*Resumen al final */
 public static void main(String[] args) throws InterruptedException {
        
        Thread hilo0 = new Hilos("hilo 0");
        Thread hilo1 = new Hilos("hilo 1");
        Thread hilo2 = new Hilos("hilo 2");
        Thread hilo3 = new Hilos("hilo 3");
        Thread hilo4 = new Hilos("hilo 4");
        Thread hilo5 = new Hilos("hilo 5");
        Thread hilo6 = new Hilos("hilo 6");
        Thread hilo7 = new Hilos("hilo 7");
        Thread hilo8 = new Hilos("hilo 8");
        Thread hilo9 = new Hilos("hilo 9");

        
        //El hilo 9 hace un sleep 2 de segundos para dale tiempo al procedor de ejecutar/crear todos los hilos
        
        long startTime = System.nanoTime();
        
        hilo0.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();
        hilo9.start();
        
        long endTime = System.nanoTime();
        
        float duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        
        System.out.printf("Duracion de los 10 hilos : %.2f \n", (duration / 1000000));
 }
 
 public void consulta(){
   try {
   // Obtenemos el pool de conexiones
   PoolC3P0 pool = PoolC3P0.getInstance();
   
    // Solicitamos una conexion al pool
    Connection cx = pool.getConnection();
    // Creamos nuestro objecto de consulta
    Statement consulta = cx.createStatement();
    // La consulta que ejecutaremos
        String sql =                 
                "use aseni declare "
        + "	@total int"
        + "            set @total = (select count(Party.id) as id from Party)"
        + "        begin"
        + "            Select c.name as 'Canton',COUNT( DISTINCT dc.id) as 'Entregables'"
        + "            FROM DelivPerCant as dc"
        + "            INNER JOIN Canton as c ON dc.canton_id = c.id"
        + "            INNER JOIN Deliverable as d ON dc.deli_id = d.id"
        + "            group by c.name"
        + "            Having @total*0.25 = COUNT( DISTINCT dc.id)"
        + "        end";
    // Obtenemos los datos
    ResultSet data = consulta.executeQuery(sql);
    //data.next();
    while(data.next()){
    Integer puerto = data.getInt("Entregables");
    String impresora = data.getString("Canton");
 
    // Los presentamos en pantalla
    System.out.println("id " + puerto);
    System.out.println("nombre " + impresora);
    System.out.println("");
    System.out.println("");
    }
    // Cerramos la conexion, esto es vital, de no hacerlo el pool creara una nueva conexion
    // pero al cerrar liberamos esa conexion para que el pool la reuse
    cx.close();
 
  } catch (IOException ex) {
   System.out.println("Error de entrada salida");
  } catch (SQLException ex) {
   System.out.println("Error de conexion a base de datos");
  } catch (PropertyVetoException ex) {
   System.out.println("Error de propiedades");
  }
 }
 
 /*
 Salida del documento
 Duracion de los 10 hilos : 0,51
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.log.MLog 
INFO: MLog clients using java 1.4+ standard logging.
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.C3P0Registry 
INFO: Initializing c3p0-0.9.5.5 [built 11-December-2019 22:07:46 -0800; debug? true; trace: 10]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
id 1
id 1
nombre Grecia                                                                                                                                                                                                                                                         


id 1
nombre Grecia                                                                                                                                                                                                                                                         


nombre Grecia                                                                                                                                                                                                                                                         


INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|48016cb6, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|48016cb6, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
id 1
nombre Grecia                                                                                                                                                                                                                                                         


INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|43201e6d, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|43201e6d, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
id 1
nombre Grecia                                                                                                                                                                                                                                                         


INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|3e8051db, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|3e8051db, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
id 1
nombre Grecia                                                                                                                                                                                                                                                         


INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|515b10ae, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|515b10ae, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
id 1
nombre Grecia                                                                                                                                                                                                                                                         


INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|608c01c4, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|608c01c4, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
id 1
nombre Grecia                                                                                                                                                                                                                                                         


INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|7cac8f2, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|7cac8f2, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
id 1
nombre Grecia                                                                                                                                                                                                                                                         


INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|4643cb82, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|4643cb82, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
id 1
nombre Grecia                                                                                                                                                                                                                                                         


INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|1b248446, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|1b248446, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|6f3b1be0, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|6f3b1be0, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]
mar. 01, 2022 4:06:01 P. M. com.mchange.v2.c3p0.impl.AbstractPoolBackedDataSource 
INFO: Initializing c3p0 pool... com.mchange.v2.c3p0.ComboPooledDataSource [ acquireIncrement -> 1, acquireRetryAttempts -> 2, acquireRetryDelay -> 1000, autoCommitOnClose -> false, automaticTestTable -> null, breakAfterAcquireFailure -> true, checkoutTimeout -> 0, connectionCustomizerClassName -> null, connectionTesterClassName -> com.mchange.v2.c3p0.impl.DefaultConnectionTester, contextClassLoaderSource -> caller, dataSourceName -> 1hgekoxanjudqlj1tr1hmu|6f1dfaa5, debugUnreturnedConnectionStackTraces -> false, description -> null, driverClass -> com.microsoft.sqlserver.jdbc.SQLServerDriver, extensions -> {}, factoryClassLocation -> null, forceIgnoreUnresolvedTransactions -> false, forceSynchronousCheckins -> false, forceUseNamedDriverClass -> false, identityToken -> 1hgekoxanjudqlj1tr1hmu|6f1dfaa5, idleConnectionTestPeriod -> 0, initialPoolSize -> 2, jdbcUrl -> jdbc:sqlserver://NIKOF:1433;databaseName=aseni, maxAdministrativeTaskTime -> 0, maxConnectionAge -> 0, maxIdleTime -> 0, maxIdleTimeExcessConnections -> 0, maxPoolSize -> 20, maxStatements -> 180, maxStatementsPerConnection -> 0, minPoolSize -> 2, numHelperThreads -> 3, preferredTestQuery -> null, privilegeSpawnedThreads -> false, properties -> {password=******, user=******}, propertyCycle -> 0, statementCacheNumDeferredCloseThreads -> 0, testConnectionOnCheckin -> false, testConnectionOnCheckout -> false, unreturnedConnectionTimeout -> 0, userOverrides -> {}, usesTraditionalReflectiveProxies -> false ]

 */
}