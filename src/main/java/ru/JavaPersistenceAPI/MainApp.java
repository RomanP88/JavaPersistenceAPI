package ru.JavaPersistenceAPI;

public class MainApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            productDao.findAllExample();
            productDao.findByIdExample(2L);
            productDao.deleteExample(3L);
            productDao.saveExample(new Product("Bread", 50));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
