package ru.JavaPersistenceAPI;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> findAllExample() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> product = session.createQuery("select u from Product u").getResultList();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public Product findByIdExample(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void saveExample(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteExample(Long id){
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.createQuery("DELETE FROM Product product WHERE product.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }











//    @Override
//    public Product findByName(String name) {
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            Product product = session
//                    .createQuery("select product from Product product where product.title = :name", Product.class)
//                    .setParameter("name", name)
//                    .getSingleResult();
//            session.getTransaction().commit();
//            return product;
//        }
//    }
//
//    @Override
//    public void updateNameById(Long id, String newTitle) {
////            HQL Example:
////            session.createQuery("update User u set u.name = :name where u.id = :id")
////                    .setParameter("name", newName)
////                    .setParameter("id", id)
////                    .executeUpdate();
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            Product product = session.get(Product.class, id);
//            product.setTitle(newTitle);
//            session.getTransaction().commit();
//        }
//    }


}
