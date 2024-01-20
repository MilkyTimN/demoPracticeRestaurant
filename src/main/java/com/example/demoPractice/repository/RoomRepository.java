package com.example.demoPractice.repository;

import com.example.demoPractice.model.entity.Room;
import com.example.demoPractice.repository.projections.MainPageResponseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT tr.id as roomId, tres.name as resName, tr.capacity as capacity, tr.price as price, ta.city as city" +
            " FROM tb_room tr " +
            "inner join tb_restaurant tres ON tr.restaurant_id = tres.id " +
            "inner join tb_address ta ON ta.restaurant_id = tres.id " +
            "where ta.city = :city", nativeQuery = true)
    List<MainPageResponseProjection> findRoomsByCity(String city);


    @Query(value = "SELECT COUNT(*) FROM tb_room WHERE restaurant_id = :restaurantId", nativeQuery = true)
    Integer countOfRoomsByRestaurant(Long restaurantId);


    @Query(value = "SELECT AVG(r.price) FROM tb_room r WHERE r.restaurant_id = :restaurantId", nativeQuery = true)
    Integer avgPriceOfRoomsByRestaurant(Long restaurantId);

    @Query(value = "SELECT AVG(r.capacity) FROM tb_room r WHERE r.restaurant_id = :restaurantId", nativeQuery = true)
    Integer avgCapacityOfRoomsByRestaurant(Long restaurantId);

}
