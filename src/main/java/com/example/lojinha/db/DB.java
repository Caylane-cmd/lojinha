
package com.example.lojinha.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {


        private static final String URL =
                "jdbc:postgresql://localhost:5432/lojinha";
        private static final String USER = "postgres";
        private static final String PASSWORD = "novo2";

        public static Connection conectar() {
            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao conectar no PostgreSQL", e);
            }
        }



    /** private static Connection conn = null;

     public static Connection getConnection() {
         if (conn == null) {
             try {
                 Properties props = loadProperties();
                 String url = props.getProperty("dburl");
                 conn = DriverManager.getConnection(url, props);
             } catch (SQLException e) {
                 throw new DbException(e.getMessage());
             }

         }
         return conn;
     }

     public static void closeConnection() {
         if (conn != null) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 throw new DbException(e.getMessage());
             }

         }
     }

     private static Properties loadProperties() {
         try (FileInputStream fs = new FileInputStream("db.properties")) {
             Properties props = new Properties();
             props.load(fs);
             return props;
         } catch (IOException e) {
             throw new DbException(e.getMessage());
         }
     }

     public static void closeStatement(Statement st) {
         if(st!=null) {
             try {
                 st.close();
             } catch (SQLException e) {
                 throw new DbException(e.getMessage());
             }
         }
     }

     public static void closeResultSet(ResultSet rs) {
         if(rs!=null) {
             try {
                 rs.close();
             } catch (SQLException e) {
                 throw new DbException(e.getMessage());
             }
         }
     }**/
}

