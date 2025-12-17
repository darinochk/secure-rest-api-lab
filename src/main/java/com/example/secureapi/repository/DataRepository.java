
package com.example.secureapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.secureapi.model.DataItem;

public interface DataRepository extends JpaRepository<DataItem, Long> {}
