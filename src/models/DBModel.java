package models;

import java.sql.*;
import java.util.ArrayList;

import models.users.Client;
import models.users.Employee;
import models.users.User;


public class DBModel {
    private static DBModel _instance;
    private DBModel() {
    	con =createConnection();
    }
    private Connection con;
    public static DBModel getInstance() {
        if (_instance == null) {
            _instance = new DBModel();
        }
        return _instance;
    }
    private static Connection createConnection() {
        String server = "nasser-aspiree5576g";  //replace
        String username="SA";                  //with
        String password="Ameno1234@";         //your own info
        int port = 1433;
        String database = "PcShop";
        String jdbcurl;
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        jdbcurl = "jdbc:sqlserver://" + server + ":" + port + ";user=" + username
                + ";password=" + password + ";databasename=" + database + "";
        try {

            con = DriverManager.getConnection(jdbcurl);
            System.out.println("Connected to Database");

        } catch (SQLException e) {
            System.out.println("failed to Connect to Database");
            e.printStackTrace();
        }
        return con;
    }
    public void RegisterClient(String userName,String password,String firstName,String lastName ){
        try {
            Statement statement = con.createStatement();
            String sql=String.format("insert into client values ('%s','%s','%s','%s')",userName,password,firstName,lastName);
            statement.execute(sql);
            statement.close();
            System.out.println("Successfully added Client");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void RegisterEmployee(String userName,String password,String firstName,String lastName ){
        try {
            Statement statement = con.createStatement();
            String sql=String.format("insert int employee values ('%s','%s','%s','%s')",userName,password,firstName,lastName);
            statement.execute(sql);
            statement.close();
            System.out.println("Successfully added Employee");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User SignIn(String userName,String password){//returns 1 for client, 2 for employee, 0 if no user exist
        try {
            Statement statement = con.createStatement();
            String sql=String.format("select * from client where username='%s' AND password='%s'",userName,password);
            ResultSet rs= statement.executeQuery(sql);
            if(rs.next()){
//                return 1;//client
                String fn = rs.getString("firstName");
                String ln = rs.getString("lastName");
            	statement.close();
                return new Client(userName, password, fn, ln);
            }
            else{
                sql=String.format("select * from employee where userName='%s' AND password='%s'",userName,password);
                rs=statement.executeQuery(sql);
                if(rs.next()){
//                  return 2;//employee
                    String fn = rs.getString("firstName");
                    String ln = rs.getString("lastName");
                    Boolean isAdmin = rs.getBoolean("isAdmin");
                	statement.close();
                    return new Employee(userName, password, fn, ln, isAdmin);
                    
                }
                else{
                    statement.close();
                    return null;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public Product getProductById(String type,int id){
        ProductFactory productFactory=new ProductFactory();
        Product product=null;
        try {
            Statement statement = con.createStatement();
            String sql=String.format("select * from %s where id=%d",type,id);
            ResultSet rs= statement.executeQuery(sql);
            rs.next();
            String name=rs.getString("name");
            String brand=rs.getString("brand");
            Float price=rs.getFloat("price");
            product=productFactory.GenerateProduct(type);
            product.setId(id);
            product.setName(name);
            product.setBrand(brand);
            product.setPrice(price);
            if(type.equalsIgnoreCase("cpu")){
                int coresNb=rs.getInt("coresNb");
                int freq=rs.getInt("freq");
                CPU cpu=(CPU) product;
                cpu.setCoresNb(coresNb);
                cpu.setFreq(freq);
                return cpu;
            }
            else if(type.equalsIgnoreCase("gpu")){
                int clockspeed=rs.getInt("clockspeed");
                int vram =rs.getInt("vram");
                String busType =rs.getString("busType");
                GPU gpu=(GPU) product;
                gpu.setClockSpeed(clockspeed);
                gpu.setVramSize(vram);
                gpu.setBusType(busType);
                return gpu;
            }
            else if(type.equalsIgnoreCase("ram")){
                int size =rs.getInt("size");
                boolean dram=rs.getBoolean("dram");
                Ram ram=(Ram)product;
                ram.setSize(size);
                ram.setDram(dram);
                return ram;
            }
            else if(type.equalsIgnoreCase("monitor")){
                int size=rs.getInt("size");
                int resolution =rs.getInt("resolution");
                Monitor monitor=(Monitor) product;
                monitor.setSize(size);
                monitor.setResolution(resolution);
                return  monitor;

            }
            else if(type.equalsIgnoreCase("harddisk")){
                int storage=rs.getInt("storage");
                HardDisk hardDisk=(HardDisk)product;
                hardDisk.setStorage(storage);
                return hardDisk;
            }
            else if(type.equalsIgnoreCase("pc")){
                int cpuId=rs.getInt("cpuId");
                int gpuId=rs.getInt("gpuId");
                int ramId=rs.getInt("ramId");
                int monitorId=rs.getInt("monitorId");
                int hardDiskId=rs.getInt("hardDiskId");
                PC pc=(PC)product;
                    CPU cpu= (CPU) getProductById("cpu",cpuId);
                    GPU gpu= (GPU) getProductById("gpu",gpuId);
                    Ram ram= (Ram) getProductById("ram",ramId);
                    Monitor monitor= (Monitor) getProductById("monitor",monitorId);
                    HardDisk hardDisk= (HardDisk) getProductById("Harddisk" ,hardDiskId);
                pc.setCpu(cpu);
                pc.setGpu(gpu);
                pc.setMonitor(monitor);
                pc.setRam(ram);
                pc.setStorage(hardDisk);
                return pc;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    public ArrayList<CPU> getCpuProducts(){
        ArrayList<CPU> list=new ArrayList<CPU>();
        ProductFactory f=new ProductFactory();
        try{
        Statement statement=con.createStatement();
        ResultSet rs= statement.executeQuery("select * from cpu");
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String brand=rs.getString("brand");
            Float price=rs.getFloat("price");
            int coresNb=rs.getInt("coresNb");
            int freq=rs.getInt("freq");
            CPU cpu= (CPU) f.GenerateProduct("cpu");
            cpu.setId(id);
            cpu.setName(name);
            cpu.setBrand(brand);
            cpu.setPrice(price);
            cpu.setFreq(freq);
            cpu.setCoresNb(coresNb);
            list.add(cpu);
        }
    }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<GPU> getGpuProducts(){
        ArrayList<GPU> list=new ArrayList<GPU>();
        ProductFactory f=new ProductFactory();
        try{
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery("select * from gpu");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                Float price=rs.getFloat("price");
                int clockspeed=rs.getInt("clockspeed");
                int vram =rs.getInt("vram");
                String busType =rs.getString("busType");
                GPU p= (GPU) f.GenerateProduct("gpu");

                p.setId(id);
                p.setName(name);
                p.setBrand(brand);
                p.setPrice(price);
                p.setClockSpeed(clockspeed);
                p.setVramSize(vram);
                p.setBusType(busType);
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<Ram> getRamProducts(){
        ArrayList<Ram> list=new ArrayList<Ram>();
        ProductFactory f=new ProductFactory();
        try{
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery("select * from ram");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                Float price=rs.getFloat("price");
                int size =rs.getInt("size");
                boolean dram=rs.getBoolean("dram");
                Ram p= (Ram) f.GenerateProduct("ram");

                p.setId(id);
                p.setName(name);
                p.setBrand(brand);
                p.setPrice(price);
                p.setDram(dram);
                p.setSize(size);
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<Monitor> getMonitorProducts(){
        ArrayList<Monitor> list=new ArrayList<Monitor>();
        ProductFactory f=new ProductFactory();
        try{
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery("select * from monitor");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                Float price=rs.getFloat("price");
                int size=rs.getInt("size");
                int resolution =rs.getInt("resolution");
                Monitor p= (Monitor) f.GenerateProduct("monitor");

                p.setId(id);
                p.setName(name);
                p.setBrand(brand);
                p.setPrice(price);
                p.setSize(size);
                p.setResolution(resolution);
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;

    }


    public ArrayList<HardDisk> getHardDiskProducts(){
        ArrayList<HardDisk> list=new ArrayList<HardDisk>();
        ProductFactory f=new ProductFactory();
        try{
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery("select * from hardDisk");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                Float price=rs.getFloat("price");
                int storage=rs.getInt("storage");
                HardDisk p= (HardDisk) f.GenerateProduct("harddisk");

                p.setId(id);
                p.setName(name);
                p.setBrand(brand);
                p.setPrice(price);
                p.setStorage(storage);
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<PC> getPcProducts(){
        ArrayList<PC> list=new ArrayList<PC>();
        ProductFactory f=new ProductFactory();
        try{
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery("select * from pc");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                Float price=rs.getFloat("price");
                int cpuId=rs.getInt("cpuId");
                int gpuId=rs.getInt("gpuId");
                int ramId=rs.getInt("ramId");
                int monitorId=rs.getInt("monitorId");
                int hardDiskId=rs.getInt("hardDiskId");
                PC p= (PC) f.GenerateProduct("Pc");

                p.setId(id);
                p.setName(name);
                p.setBrand(brand);
                p.setPrice(price);
                p.setCpu((CPU)getProductById("cpu",cpuId));
                p.setGpu((GPU)getProductById("gpu",gpuId));
                p.setRam((Ram) getProductById("ram",ramId));
                p.setMonitor((Monitor) getProductById("monitor",monitorId));
                p.setStorage((HardDisk)getProductById("harddisk",hardDiskId));
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> list=new ArrayList<Product>();
        list.addAll(getCpuProducts());
        list.addAll(getGpuProducts());
        list.addAll(getRamProducts());
        list.addAll(getMonitorProducts());
        list.addAll(getHardDiskProducts());
        return list;
    }
    public void addCpu(CPU cpu){
        try {
            Statement statement = con.createStatement();
            String sql=String.format("insert into cpu values ('%s','%s',%f,'%s',%d,%d)",cpu.getName(),cpu.getBrand(),cpu.getPrice(),cpu.getProductType(),cpu.getCoresNb(),cpu.getFreq());
            statement.execute(sql);
            statement.close();
            System.out.println("Successfully added CPU");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void addGpu(GPU gpu){
        try {
            Statement statement = con.createStatement();
            String sql=String.format("insert into gpu values ('%s','%s',%f,'%s',%d,%d,'%s')",gpu.getName(),gpu.getBrand(),gpu.getPrice(),gpu.getImage().getUrl(),gpu.getClockSpeed(),gpu.getVramSize(),gpu.getBusType());
            statement.execute(sql);
            statement.close();
            System.out.println("Successfully added GPU");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addRam(Ram ram){
        try {
            Statement statement = con.createStatement();
            String sql=String.format("insert into ram values ('%s','%s',%f,'%s',%d,%d)",ram.getName(),ram.getBrand(),ram.getPrice(),ram.getImage().getUrl(),ram.getSize(),ram.isDram());
            statement.execute(sql);
            statement.close();
            System.out.println("Successfully added Ram");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addMonitor(Monitor m){
        try {
            Statement statement = con.createStatement();
            String sql=String.format("insert into ram values ('%s','%s',%f,'%s',%d,%d)",m.getName(),m.getBrand(),m.getPrice(),m.getImage().getUrl(),m.getSize(),m.getResolution());
            statement.execute(sql);
            statement.close();
            System.out.println("Successfully added Monitor");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addHardDisk(HardDisk h){
        try {
            Statement statement = con.createStatement();
            String sql=String.format("insert into ram values ('%s','%s',%f,'%s',%d)",h.getName(),h.getBrand(),h.getPrice(),h.getImage().getUrl(),h.getStorage());
            statement.execute(sql);
            statement.close();
            System.out.println("Successfully added hardDisk");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
