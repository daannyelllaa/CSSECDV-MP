package Controller;

import Model.History;
import Model.Logs;
import Model.Product;
import Model.User;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLite {
    
    public int DEBUG_MODE = 0;
    String driverURL = "jdbc:sqlite:" + "database.db";
    
    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Database database.db created.");
            }
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
    
    public void createHistoryTable() {
        String sql = "CREATE TABLE IF NOT EXISTS history (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL,\n"
            + " name TEXT NOT NULL,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table history in database.db created.");
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
    
    public void createLogsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS logs (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " event TEXT NOT NULL,\n"
            + " username TEXT NOT NULL,\n"
            + " desc TEXT NOT NULL,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db created.");
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
     
    public void createProductTable() {
        String sql = "CREATE TABLE IF NOT EXISTS product (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " name TEXT NOT NULL UNIQUE,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " price REAL DEFAULT 0.00\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table product in database.db created.");
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
     
    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL UNIQUE,\n"
            + " password TEXT NOT NULL,\n"
            + " role INTEGER DEFAULT 2,\n"
            + " locked INTEGER DEFAULT 0\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db created.");
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
    
    public void dropHistoryTable() {
        String sql = "DROP TABLE IF EXISTS history;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table history in database.db dropped.");
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
    
    public void dropLogsTable() {
        String sql = "DROP TABLE IF EXISTS logs;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db dropped.");
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
    
    public void dropProductTable() {
        String sql = "DROP TABLE IF EXISTS product;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table product in database.db dropped.");
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
    
    public void dropUserTable() {
        String sql = "DROP TABLE IF EXISTS users;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db dropped.");
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }
    
    public void addHistory(String username, String name, int stock, String timestamp) {
        String sql = "INSERT INTO history(username,name,stock,timestamp) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setInt(3, stock);
            pstmt.setString(4, timestamp);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
    }

    public void addLogs(String event, String username, String desc, String timestamp) {
        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES(?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, event);
            pstmt.setString(2, username);
            pstmt.setString(3, desc);
            pstmt.setString(4, timestamp);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }

    public void addProduct(String name, int stock, double price) {
        String sql = "INSERT INTO product(name,stock,price) VALUES(?,?,?)";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, stock);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }

    /**
     * Register a new user.  Password must already be a BCrypt hash.
     * Role is always set to 2 (Client) for self-registration.
     */
    public void addUser(String username, String hashedPassword) {
        String sql = "INSERT INTO users(username,password,role,locked,failed_attempts,last_login) VALUES(?,?,2,0,0,'')";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }
    
    public void updateUserRole(String username, int newRole) {
        String sql = "UPDATE users SET role=? WHERE username=?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newRole);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }
    
    public void toggleUserLock(String username, int lockedState, int roleCode) {
        String sql = "UPDATE users SET locked=?, role=? WHERE username=?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, lockedState);
            pstmt.setInt(2, roleCode);
            pstmt.setString(3, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }
    
    public void updateUserPassword(String username, String hashedPassword) {
        String sql = "UPDATE users SET password=? WHERE username=?";
        try (Connection conn = DriverManager.getConnection(driverURL);
              PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, hashedPassword);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }
    
    
    public ArrayList<History> getHistory(){
        String sql = "SELECT id, username, name, stock, timestamp FROM history";
        ArrayList<History> histories = new ArrayList<History>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                histories.add(new History(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
        return histories;
    }
    
    public ArrayList<Logs> getLogs(){
        String sql = "SELECT id, event, username, desc, timestamp FROM logs";
        ArrayList<Logs> logs = new ArrayList<Logs>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                logs.add(new Logs(rs.getInt("id"),
                                   rs.getString("event"),
                                   rs.getString("username"),
                                   rs.getString("desc"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            // Generic error suppression — do not expose stack trace
        }
        return logs;
    }
    
    public ArrayList<Product> getProduct(){
        String sql = "SELECT id, name, stock, price FROM product";
        ArrayList<Product> products = new ArrayList<Product>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price")));
            }
        } catch (Exception ex) {
            // Generic error suppression — do not expose internals
        }
        return products;
    }
    
    public ArrayList<User> getUsers(){
        String sql = "SELECT id, username, password, role, locked FROM users";
        ArrayList<User> users = new ArrayList<User>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("password"),
                                   rs.getInt("role"),
                                   rs.getInt("locked")));
            }
        } catch (Exception ex) {
            // Generic error suppression
        }
        return users;
    }
    
    public void removeUser(String username) {
        String sql = "DELETE FROM users WHERE username=?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }

    public Product getProduct(String name) {
        String sql = "SELECT name, stock, price FROM product WHERE name=?";
        Product product = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = new Product(rs.getString("name"),
                                          rs.getInt("stock"),
                                          rs.getFloat("price"));
                }
            }
        } catch (Exception ex) {
            // Generic error suppression
        }
        return product;
    }

    // =========================================================
    // DATABASE HEALTH CHECK
    // =========================================================

    /**
     * Returns true if the database is accessible and the users table is intact.
     * Returns false if the database is missing, corrupt, or unreadable.
     */
    public boolean isDatabaseValid() {
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users")) {
            return rs.next();
        } catch (Exception ex) {
            System.out.println("[DB] Validation failed: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Drops and recreates all tables with the correct schema, then seeds
     * the default users with plaintext passwords (migrate() will hash them).
     */
    public void initializeDatabase() {
        System.out.println("[DB] Initializing fresh database...");

        // Drop existing tables
        String[] drops = {
            "DROP TABLE IF EXISTS history",
            "DROP TABLE IF EXISTS logs",
            "DROP TABLE IF EXISTS product",
            "DROP TABLE IF EXISTS users"
        };
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement()) {
            for (String sql : drops) stmt.execute(sql);
            System.out.println("[DB] Old tables dropped.");
        } catch (Exception ex) {
            System.out.println("[DB] Drop error: " + ex.getMessage());
        }

        // Create users table with full schema
        String createUsers = "CREATE TABLE IF NOT EXISTS users ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " username TEXT NOT NULL UNIQUE,"
                + " password TEXT NOT NULL,"
                + " role INTEGER DEFAULT 2,"
                + " locked INTEGER DEFAULT 0,"
                + " failed_attempts INTEGER DEFAULT 0,"
                + " last_login TEXT DEFAULT ''"
                + ")";

        String createHistory = "CREATE TABLE IF NOT EXISTS history ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " username TEXT NOT NULL,"
                + " name TEXT NOT NULL,"
                + " stock INTEGER DEFAULT 0,"
                + " timestamp TEXT NOT NULL"
                + ")";

        String createLogs = "CREATE TABLE IF NOT EXISTS logs ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " event TEXT NOT NULL,"
                + " username TEXT NOT NULL,"
                + " desc TEXT NOT NULL,"
                + " timestamp TEXT NOT NULL"
                + ")";

        String createProduct = "CREATE TABLE IF NOT EXISTS product ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT NOT NULL UNIQUE,"
                + " stock INTEGER DEFAULT 0,"
                + " price REAL DEFAULT 0.00"
                + ")";

        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createUsers);
            stmt.execute(createHistory);
            stmt.execute(createLogs);
            stmt.execute(createProduct);
            System.out.println("[DB] Tables created.");
        } catch (Exception ex) {
            System.out.println("[DB] Create tables error: " + ex.getMessage());
        }

        // Seed default users — plaintext passwords, migrate() will hash them
        String[][] users = {
            {"admin",   "qwerty1234", "5"},
            {"manager", "qwerty1234", "4"},
            {"staff",   "qwerty1234", "3"},
            {"client1", "qwerty1234", "2"},
            {"client2", "qwerty1234", "2"}
        };
        String insertUser = "INSERT INTO users(username,password,role,locked,failed_attempts,last_login) VALUES(?,?,?,0,0,'')";
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            for (String[] u : users) {
                try (PreparedStatement pstmt = conn.prepareStatement(insertUser)) {
                    pstmt.setString(1, u[0]);
                    pstmt.setString(2, u[1]);
                    pstmt.setInt(3, Integer.parseInt(u[2]));
                    pstmt.executeUpdate();
                    System.out.println("[DB] Seeded user: " + u[0]);
                }
            }
        } catch (Exception ex) {
            System.out.println("[DB] Seed users error: " + ex.getMessage());
        }

        // Seed sample products
        String[][] products = {
            {"Antivirus", "5",  "500.0"},
            {"Firewall",  "3", "1000.0"},
            {"Scanner",   "10", "100.0"}
        };
        String insertProduct = "INSERT INTO product(name,stock,price) VALUES(?,?,?)";
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            for (String[] p : products) {
                try (PreparedStatement pstmt = conn.prepareStatement(insertProduct)) {
                    pstmt.setString(1, p[0]);
                    pstmt.setInt(2, Integer.parseInt(p[1]));
                    pstmt.setDouble(3, Double.parseDouble(p[2]));
                    pstmt.executeUpdate();
                }
            }
            System.out.println("[DB] Seeded products.");
        } catch (Exception ex) {
            System.out.println("[DB] Seed products error: " + ex.getMessage());
        }

        System.out.println("[DB] Initialization complete.");
    }

    // =========================================================
    // DATABASE MIGRATION — run once on startup
    // =========================================================

    /**
     * Ensures the database schema is up to date and all passwords are hashed.
     * Safe to call every time the application starts.
     */
    public void migrate() {
        System.out.println("[MIGRATE] Working dir: " + System.getProperty("user.dir"));
        System.out.println("[MIGRATE] DB URL: " + driverURL);

        // 1. Add failed_attempts column if it does not exist yet
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("ALTER TABLE users ADD COLUMN failed_attempts INTEGER DEFAULT 0");
            System.out.println("[MIGRATE] Added failed_attempts column.");
        } catch (Exception ex) {
            System.out.println("[MIGRATE] failed_attempts column: " + ex.getMessage());
        }

        // 2. Add last_login column if it does not exist yet
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("ALTER TABLE users ADD COLUMN last_login TEXT DEFAULT ''");
            System.out.println("[MIGRATE] Added last_login column.");
        } catch (Exception ex) {
            System.out.println("[MIGRATE] last_login column: " + ex.getMessage());
        }

        // 3. Collect users with unhashed passwords
        ArrayList<String[]> toRehash = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(driverURL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT username, password FROM users")) {
            while (rs.next()) {
                String username = rs.getString("username");
                String storedPw = rs.getString("password");
                System.out.println("[MIGRATE] User: " + username + " | hashed=" + PasswordUtil.isHashed(storedPw));
                if (!PasswordUtil.isHashed(storedPw)) {
                    toRehash.add(new String[]{username, storedPw});
                }
            }
        } catch (Exception ex) {
            System.out.println("[MIGRATE] Error reading users: " + ex.getMessage());
        }

        System.out.println("[MIGRATE] Passwords to rehash: " + toRehash.size());

        // 4. Hash and update each plaintext password
        for (String[] entry : toRehash) {
            String username = entry[0];
            String plaintext = entry[1];
            try {
                String hashed = PasswordUtil.hashPassword(plaintext);
                try (Connection conn = DriverManager.getConnection(driverURL);
                     PreparedStatement pstmt = conn.prepareStatement(
                             "UPDATE users SET password=? WHERE username=?")) {
                    pstmt.setString(1, hashed);
                    pstmt.setString(2, username);
                    pstmt.executeUpdate();
                    System.out.println("[MIGRATE] Rehashed password for: " + username);
                }
            } catch (Exception ex) {
                System.out.println("[MIGRATE] Error hashing " + username + ": " + ex.getMessage());
            }
        }
        System.out.println("[MIGRATE] Done.");
    }

    // =========================================================
    // AUTHENTICATION METHODS
    // =========================================================

    /**
     * Retrieve a single user by username.
     * Returns null if the username does not exist.
     */
    public User getUser(String username) {
        String sql = "SELECT id, username, password, role, locked, failed_attempts, last_login FROM users WHERE username=?";
        User user = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getInt("locked")
                    );
                    user.setFailedAttempts(rs.getInt("failed_attempts"));
                    user.setLastLogin(rs.getString("last_login"));
                    System.out.println("[getUser] Found: " + username + " role=" + user.getRole() + " hashed=" + PasswordUtil.isHashed(user.getPassword()));
                } else {
                    System.out.println("[getUser] No row found for: " + username);
                }
            }
        } catch (Exception ex) {
            System.out.println("[getUser] Exception for " + username + ": " + ex.getMessage());
        }
        return user;
    }

    /**
     * Increment the failed login counter for a user.
     */
    public void incrementFailedAttempts(String username) {
        String sql = "UPDATE users SET failed_attempts = failed_attempts + 1 WHERE username=?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }

    /**
     * Lock a user account by setting their role to 1 (Disabled).
     */
    public void lockUser(String username) {
        String sql = "UPDATE users SET role=1, locked=1 WHERE username=?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }

    /**
     * Reset the failed attempts counter after a successful login.
     */
    public void resetFailedAttempts(String username) {
        String sql = "UPDATE users SET failed_attempts=0 WHERE username=?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }

    /**
     * Record the timestamp of a successful login.
     */
    public void updateLastLogin(String username, String timestamp) {
        String sql = "UPDATE users SET last_login=? WHERE username=?";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, timestamp);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }

    // =========================================================
    // ADMIN: addUser with explicit role (for Main.java seeding only)
    // =========================================================
    public void addUser(String username, String hashedPassword, int role) {
        String sql = "INSERT INTO users(username,password,role,locked,failed_attempts,last_login) VALUES(?,?,?,0,0,'')";
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, hashedPassword);
            pstmt.setInt(3, role);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            // Generic error suppression
        }
    }
}