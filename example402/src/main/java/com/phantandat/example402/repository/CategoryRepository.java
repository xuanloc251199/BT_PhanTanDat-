package com.phantandat.example402.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phantandat.example402.entity.*;

public interface CategoryRepository extends JpaRepository< Category, Long> {
}
