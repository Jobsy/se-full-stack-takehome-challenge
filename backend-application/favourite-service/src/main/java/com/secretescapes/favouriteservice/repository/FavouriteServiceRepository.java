//package com.secretescapes.favouriteservice.repository;
//
//import java.util.List;
//import java.util.Optional;
//import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.secretescapes.favouriteservice.model.Favourite;
//
//@Repository
//public interface FavouriteServiceRepository extends JpaRepository<Favourite, Integer> {
//
//    List<Favourite> findByUserId(String userId);
//
//    boolean existsByUserIdAndSaleId(String userId, String saleId);
//
//    void deleteByUserIdAndSaleId(String userId, String saleId);
//
//    Optional<Favourite> findByUserIdAndSaleId(String userId, String saleId);
//
//    void delete(Favourite existingFavourite);
//}


package com.secretescapes.favouriteservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.secretescapes.favouriteservice.model.Favourite;

@Repository
public interface FavouriteServiceRepository extends JpaRepository<Favourite, Integer> {

    List<Favourite> findByUserId(String userId);

    boolean existsByUserIdAndSaleId(String userId, String saleId);

    void deleteByUserIdAndSaleId(String userId, String saleId);

    Optional<Favourite> findByUserIdAndSaleId(String userId, String saleId);

    void delete(Favourite existingFavourite);
}
